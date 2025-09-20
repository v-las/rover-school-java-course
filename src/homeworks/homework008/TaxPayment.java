package homeworks.homework008;

/**
 * Represents the tax payment of an employee.
 * Stores the employee's name and the amount of personal income tax they must pay.
 * <p>
 * The class provides a static method to calculate taxes for an array of employees
 * according to the following rules:
 * - Salary above 10,000: tax rate is 23%
 * - Salary between 5,000 and 10,000: tax rate is 18%
 * - Salary below 5,000: tax rate is 13%
 * - For each child, 1,000 is deducted from the salary before calculating the tax.
 * <p>
 * Example usage:
 * TaxPayment[] payments = TaxPayment.calculateTaxes(employees);
 */
public class TaxPayment {
    String name;
    int personalIncomeTaxSum;

    TaxPayment(String name, int personalIncomeTaxSum) {
        this.name = name;
        this.personalIncomeTaxSum = personalIncomeTaxSum;
    }

    public static TaxPayment[] calculateTaxes(Employee[] employees) {
        TaxPayment[] taxableIncomes = new TaxPayment[employees.length];

        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            taxableIncomes[i] = TaxPayment.calculateTax(e);
        }

        return taxableIncomes;
    }

    public static TaxPayment calculateTax(Employee e) {
        int salaryAfterChildDeduction = e.salary - (1000 * e.childrenCount);
        int taxPercent;

        if (salaryAfterChildDeduction < 5000) {
            taxPercent = 13;

        } else if (salaryAfterChildDeduction < 10000) {
            taxPercent = 18;

        } else {
            taxPercent = 23;
        }

        return new TaxPayment(e.lastName, salaryAfterChildDeduction * taxPercent / 100);
    }
}
