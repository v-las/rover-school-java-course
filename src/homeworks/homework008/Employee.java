package homeworks.homework008;

/**
 * Represents an employee of a company.
 *
 * Stores basic information about the employee:
 * - name: the employee's full name
 * - salary: the employee's monthly salary
 * - childrenCount: the number of children the employee has
 *
 * This class can be used in payroll and tax calculations.
 */
public class Employee extends Person {
    int salary;
    int childrenCount;

    public Employee(String firstName, String lastName, int age, String gender, int salary, int childrenCount) {
        super(firstName, lastName, age, gender);
        this.salary = salary;
        this.childrenCount = childrenCount;
    }

    public Employee(String lastName, int salary, int childrenCount) {
        super(lastName);
        this.salary = salary;
        this.childrenCount = childrenCount;
        this.gender = "male";
    }

    public boolean isSameName(Employee employee) {
        return employee.lastName.equals(this.lastName);
    }

    public String getName() {
        // переопределение метода из Person
        if (gender.equals("male")) {
            return "Employee Mr." + lastName;
        } else if (gender.equals("female")) {
            return "Employee Mrs." + lastName;
        } else {
            return "Can be 'male' or 'female'";
        }
    }
}
