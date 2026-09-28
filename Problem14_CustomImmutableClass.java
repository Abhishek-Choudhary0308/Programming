import java.time.LocalDate;
import java.util.*;

public class Problem14_CustomImmutableClass {
    static final class EmployeeProfile {
        private final String department;

        EmployeeProfile(String department) {
            this.department = department;
        }

        EmployeeProfile(EmployeeProfile other) {
            this(other.department);
        }

        String getDepartment() {
            return department;
        }
    }

    static final class Employee {
        private final int id;
        private final String name;
        private final Date joiningDate;
        private final List<String> skills;
        private final EmployeeProfile profile;

        Employee(int id, String name, Date joiningDate,
                 List<String> skills, EmployeeProfile profile) {
            this.id = id;
            this.name = name;
            this.joiningDate = new Date(joiningDate.getTime());
            this.skills = Collections.unmodifiableList(new ArrayList<>(skills));
            this.profile = new EmployeeProfile(profile);
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public Date getJoiningDate() { return new Date(joiningDate.getTime()); }
        public List<String> getSkills() { return skills; }
        public EmployeeProfile getProfile() { return new EmployeeProfile(profile); }
    }

    public static void main(String[] args) {
        Employee employee = new Employee(
                101, "Amit", new Date(),
                Arrays.asList("Java", "Spring"),
                new EmployeeProfile("IT"));

        System.out.println(employee.getName());
        System.out.println(employee.getSkills());
        System.out.println(employee.getProfile().getDepartment());
    }
}