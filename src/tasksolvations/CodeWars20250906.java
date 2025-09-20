package tasksolvations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CodeWars20250906 {
    public static void main(String[] args) {
        System.out.println(mouthSize("toucan"));
        System.out.println(mouthSize("ant bear"));
        System.out.println(mouthSize("alligator"));
        System.out.println();

        System.out.printf("exp: %f, act: %f%n", 5.65d, fuelPrice(5, 1.23d));
        System.out.printf("exp: %f, act: %f%n", 18.40d, fuelPrice(8, 2.5d));
        System.out.printf("exp: %f, act: %f%n", 27.50d, fuelPrice(5, 5.6d));
        System.out.println();

        System.out.printf("exp: %d, act: %d%n", -1, closeCompare(4, 5));
        System.out.printf("exp: %d, act: %d%n", 0, closeCompare(5, 5));
        System.out.printf("exp: %d, act: %d%n", 1, closeCompare(6, 5));
        System.out.printf("exp: %d, act: %d%n", -1, closeCompare(-6, -5));

        System.out.printf("exp: %d, act: %d%n", 0, closeCompare(2, 5, 3));
        System.out.printf("exp: %d, act: %d%n", 1, closeCompare(8.1, 5, 3));
        System.out.printf("exp: %d, act: %d%n", -1, closeCompare(1.99, 5, 3));
        System.out.println();

        System.out.printf("Should be true | %b%n", setAlarm(true, false));
        System.out.printf("Should be false | %b%n", setAlarm(true, true));
        System.out.printf("Should be false | %b%n", setAlarm(false, false));
        System.out.printf("Should be false | %b%n", setAlarm(false, true));
        System.out.println();

        System.out.printf("£100000 | %s%n", bonusTime(10000, true));
        System.out.printf("£250000 | %s%n", bonusTime(25000, true));
        System.out.printf("£10000 | %s%n", bonusTime(10000, false));
        System.out.printf("£60000 | %s%n", bonusTime(60000, false));
        System.out.printf("£20 | %s%n", bonusTime(2, true));
        System.out.printf("£78 | %s%n", bonusTime(78, false));
        System.out.printf("£678900 | %s%n", bonusTime(67890, true));
    }

    public static String bonusTime(final int salary, final boolean bonus) {
        // Do I get a bonus?
        // https://www.codewars.com/kata/56f6ad906b88de513f000d96/train/java
        return String.format("£%d", bonus ? salary * 10 : salary);
    }

    public static boolean setAlarm(boolean employed, boolean vacation) {
        // L1: Set Alarm
        // https://www.codewars.com/kata/568dcc3c7f12767a62000038/train/java
        return employed && !vacation;
    }

    public static int closeCompare(double a, double b) {
        // Compare within margin
        // https://www.codewars.com/kata/56453a12fcee9a6c4700009c/train/java
        return Double.compare(a, b);
    }

    public static int closeCompare(double a, double b, double margin) {
        // Compare within margin
        if (Math.abs(a - b) <= margin) {
            return 0;
        }
        return closeCompare(a, b);
    }

    public static double fuelPrice(int litres, double pricePerLitre) {
        // Fuel Calculator: Total Cost
        // https://www.codewars.com/kata/57b58827d2a31c57720012e8/train/java
        /*
                >= 2l = 5c/l
                >= 4l = 10c/l
                >= 6l = 15
                >= 8l = 20
                >= 10l = 25
                max - 25 c\l
        */
        double discountPerLitre = Math.min(litres / 2 * 0.05 /*cents*/, 0.25 /*cents*/);
        double totalPrice = litres * (pricePerLitre - discountPerLitre);
        double totalPriceRounded = BigDecimal.valueOf(totalPrice)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();

        return totalPriceRounded;
    }

    public static String mouthSize(String animal) {
        // The Wide-Mouthed frog!
        // https://www.codewars.com/kata/57ec8bd8f670e9a47a000f89/train/java
        return animal.equalsIgnoreCase("alligator") ? "small" : "wide";
    }
}
