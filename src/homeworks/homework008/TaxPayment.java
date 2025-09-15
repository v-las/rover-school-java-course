package homeworks.homework008;

/**
 * Represents the tax payment of an employee.
 * Stores the employee's name and the amount of personal income tax they must pay.
 *
 * The class provides a static method to calculate taxes for an array of employees
 * according to the following rules:
 * - Salary above 10,000: tax rate is 23%
 * - Salary between 5,000 and 10,000: tax rate is 18%
 * - Salary below 5,000: tax rate is 13%
 * - For each child, 1,000 is deducted from the salary before calculating the tax.
 *
 * Example usage:
 * TaxPayment[] payments = TaxPayment.calculateTaxes(employees);
 */
public class TaxPayment {
    TaxPayment(String name, int personalIncomeTaxSum) {
        this.name = name;
        this.personalIncomeTaxSum = personalIncomeTaxSum;
    }

    String name;
    int personalIncomeTaxSum;

    static TaxPayment[] calculateTaxes(Employee[] employees) {
        TaxPayment[] taxableIncomes = new TaxPayment[employees.length];

        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            int salaryAfterChildDeduction = e.salary - (1000 * e.childrenCount);

            int taxableIncome;
            if (i < 5000) {
                taxableIncome = salaryAfterChildDeduction * 13 / 100;
            } else if (i < 10000) {
                taxableIncome = salaryAfterChildDeduction * 18 / 100;
            } else {
                taxableIncome = salaryAfterChildDeduction * 23 / 100;
            }

            taxableIncomes[i] = new TaxPayment(e.lastName, taxableIncome);
        }

        return taxableIncomes;
    }
}
