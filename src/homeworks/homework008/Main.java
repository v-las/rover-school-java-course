package homeworks.homework008;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // task01
        Person[] people = new Person[10];

        people[0] = new Person("John","Smith", 30, "male");
        people[1] = new Person("John","Smith", 25, "female");
        people[2] = new Person("Michael","Brown", 40, "male");
        people[3] = new Person("Sarah","Davis", 35, "female");
        people[4] = new Person("James","Miller", 28, "male");
        people[5] = new Person("Olivia","Wilson", 32, "female");
        people[6] = new Person("David","Moore", 45, "male");
        people[7] = new Person("Sophia","Taylor", 27, "female");
        people[8] = new Person("Robert","Anderson", 50, "male");
        people[9] = new Person("Isabella","Thomas", 29, "female");

        for (Person p : people) {
            System.out.println(p.getName() + " | age: " + p.age + " | gender: " + p.gender);
        }
        System.out.println();

        // task02
        Employee[] employees = new Employee[10];

        employees[0] = new Employee(people[0].lastName, 50000, 2);
        employees[1] = new Employee(people[1].lastName, 60000, 1);
        employees[2] = new Employee(people[2].lastName, 45000, 3);
        employees[3] = new Employee(people[3].lastName, 70000, 0);
        employees[4] = new Employee(people[4].lastName, 55000, 2);
        employees[5] = new Employee(people[5].lastName, 48000, 1);
        employees[6] = new Employee(people[6].lastName, 65000, 2);
        employees[7] = new Employee(people[7].lastName, 53000, 0);
        employees[8] = new Employee(people[8].lastName, 59000, 4);
        employees[9] = new Employee(people[9].lastName, 62000, 1);

        for (Employee e : employees) {
            System.out.println(e.lastName + " | salary: " + e.salary + " | children: " + e.childrenCount);
        }
        System.out.println();

        // task03
        TaxPayment[] payments = TaxPayment.calculateTaxes(employees);

        for (TaxPayment tp : payments) {
            System.out.println(tp.name + " must pay tax: " + tp.personalIncomeTaxSum);
        }
        System.out.println();

        // task04
        int totalSalary = Salary.getSum(employees);

        System.out.println("Total salary of all employees: " + totalSalary);
        System.out.println();

        Employee john1 = employees[0];
        Employee john2 = employees[1];
        System.out.println("employees = " + john1.isSameName(john2));

        System.out.println( "\uD83D\uDE0D " + john1.getName());
        System.out.println( "\uD83D\uDE0D " + john2.getName());

        // task04
        System.out.println(task04(20365093503942869L));
    }

    /**
     * Converts a positive integer into a string of digit names.
     * For example: 643 -> "six four three".
     *
     * @param number the positive integer to convert
     * @return a string with digit names separated by spaces
     */
    private static String task04(long number) {
        final String[] NUMBER_NAMES = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        String[] digits = String.valueOf(number)
                .split("");

        return Arrays.stream(digits)
                .mapToInt(Integer::valueOf)
                .mapToObj(digit -> NUMBER_NAMES[digit])
                .collect(Collectors.joining(" "));
    }
}
