package homeworks.homework009;

import java.util.Arrays;

public class SalaryHelper {
    public static int getSum(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToInt(Employee::getSalary)
                .sum();
    }
}
