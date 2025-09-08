package homeworks.homework008;

import java.util.Arrays;

/**
 * Utility class for salary-related operations.
 *
 * Provides a single static method to calculate the total salary
 * of all employees in a given array.
 *
 * Example usage:
 * int total = Salary.getSum(employeeArray);
 */
public class Salary {
    /**
     * Calculates the sum of salaries for the given array of employees.
     *
     * @param employees an array of Employee objects
     * @return the total sum of salaries
     */
    static int getSum(Employee[] employees) {
        int[] salaries = new int[employees.length];

        for (int i = 0; i < employees.length; i++) {
            salaries[i] = employees[i].salary;
        }

        return Arrays.stream(salaries).sum();
    }
}
