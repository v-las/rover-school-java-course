package homeworks.homework010and012;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DayRateUtils {

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

    public static double sumDayRates(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToDouble(Employee::getDayRate)
                .sum();
    }

    public static double    calculateTotalSalaryForPeriod(Employee[] employees, Month[] months) {
        double dayRateTotal = sumDayRates(employees);
        int workDaysTotal = Arrays.stream(months)
                .mapToInt(Month::getWorkDaysCount)
                .sum();

        return workDaysTotal * dayRateTotal;
    }

    public static double getMinDayRate(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToDouble(Employee::getDayRate)
                .min().orElse(0.0);
    }

    public static double getMaxDayRate(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToDouble(Employee::getDayRate)
                .max().orElse(0.0);
    }

    public static Manager findManagerWithMinSubordinates(Manager[] managers) {
        return Arrays.stream(managers)
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(Manager::getNumberOfSubordinates))
                .orElseThrow(() -> new NoSuchElementException("No managers found"));
    }

    public static Manager findManagerWithMaxSubordinates(Manager[] managers) {
        return Arrays.stream(managers)
                .max(Comparator.comparingInt(Manager::getNumberOfSubordinates))
                .orElse(null);
    }

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
