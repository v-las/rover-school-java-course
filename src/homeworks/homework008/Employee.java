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
public class Employee {
    String name;
    int salary;
    int childrenCount;

    Employee(String name, int salary, int childrenCount) {
        this.name = name;
        this.salary = salary;
        this.childrenCount = childrenCount;
    }
}
