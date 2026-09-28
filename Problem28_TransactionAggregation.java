import java.util.*;
import java.util.stream.Collectors;

public class Problem28_TransactionAggregation {
    enum Type { CREDIT, DEBIT }
    enum Status { SUCCESS, FAILED }

    static class Transaction {
        String account;
        Type type;
        Status status;
        Double amount;

        Transaction(String account, Type type, Status status, Double amount) {
            this.account = account;
            this.type = type;
            this.status = status;
            this.amount = amount;
        }
    }

    static class Summary {
        double credits;
        double debits;

        void add(Transaction t) {
            if (t.type == Type.CREDIT) credits += t.amount;
            else debits += t.amount;
        }

        @Override
        public String toString() {
            return "credits=" + credits + ", debits=" + debits;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("A100", Type.CREDIT, Status.SUCCESS, 1000.0),
                new Transaction("A100", Type.DEBIT, Status.SUCCESS, 250.0),
                new Transaction("A200", Type.CREDIT, Status.SUCCESS, 500.0),
                new Transaction("A100", Type.CREDIT, Status.FAILED, 999.0),
                null,
                new Transaction("A200", Type.DEBIT, Status.SUCCESS, 100.0)
        );

        Map<String, Summary> result = transactions.stream()
                .filter(Objects::nonNull)
                .filter(t -> t.account != null)
                .filter(t -> t.status == Status.SUCCESS)
                .filter(t -> t.type != null && t.amount != null)
                .collect(Collectors.toMap(
                        t -> t.account,
                        t -> {
                            Summary s = new Summary();
                            s.add(t);
                            return s;
                        },
                        (s1, s2) -> {
                            s1.credits += s2.credits;
                            s1.debits += s2.debits;
                            return s1;
                        },
                        LinkedHashMap::new
                ));

        System.out.println(result);
    }
}