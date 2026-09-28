import java.util.*;
import java.util.stream.Collectors;

public class Problem11_EmployeeGrouping {
    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        String getDepartment() { return department; }
        double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + "(" + department + ", " + salary + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 70000),
                new Employee(2, "Ravi", "IT", 90000),
                new Employee(3, "Neha", "HR", 60000),
                new Employee(4, "Priya", "HR", 80000),
                new Employee(5, "Karan", "Finance", 95000)
        );

        Map<String, List<Employee>> grouped =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> averages = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        String highestAverageDepartment = averages.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Grouped: " + grouped);
        System.out.println("Average salary: " + averages);
        System.out.println("Highest average salary department: " + highestAverageDepartment);
    }
}