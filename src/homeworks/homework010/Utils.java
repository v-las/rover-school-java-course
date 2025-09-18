package homeworks.homework010;

import java.util.Arrays;

public class Utils {

    public static Employee findByName(String name, Employee[] employees) {
        return Arrays.stream(employees)
                .filter(e -> e.getName()
                        .equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public static Employee findByNameChunk(String nameChunk, Employee[] employees) {
        return Arrays.stream(employees)
                .filter(e -> e.getName()
                        .toLowerCase()
                        .contains(nameChunk
                                .toLowerCase()))
                .findFirst().orElse(null);
    }

    public static double sumSalary(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public static double getMinSalary(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToDouble(Employee::getSalary)
                .min().orElse(0.0);
    }

    public static double getMaxSalary(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToDouble(Employee::getSalary)
                .max().orElse(0.0);
    }

    // findManagerWithMinSubordinates
    public static int getMinSubordinates(Manager[] managers) {
        return Arrays.stream(managers)
                .mapToInt(Manager::getNumberOfSubordinates)
                .min().orElse(0);
    }

    public static int getMaxSubordinates(Manager[] managers) {
        return Arrays.stream(managers)
                .mapToInt(Manager::getNumberOfSubordinates)
                .max().orElse(0);
    }

    public static double getMinBonus(Manager[] managers) {
        return Arrays.stream(managers)
                .mapToDouble(Manager::getBonus)
                .min().orElse(0.0);
    }

    public static double getMaxBonus(Manager[] managers) {
        return Arrays.stream(managers)
                .mapToDouble(Manager::getBonus)
                .max().orElse(0.0);
    }
}
