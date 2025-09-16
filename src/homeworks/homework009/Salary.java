package homeworks.homework009;

import java.util.Arrays;

public class Salary {
    static int getSum(Employee[] employees) {
        return Arrays.stream(employees).mapToInt(Employee::getSalary).sum();
    }
}
