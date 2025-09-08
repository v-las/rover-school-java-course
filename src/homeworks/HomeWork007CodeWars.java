package homeworks;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork007CodeWars {
    public static void main(String[] args) {
        System.out.println("doubleInteger: " + doubleInteger(2));
        System.out.println();
        System.out.println("isLove: " + isLove(2, 3));
        System.out.println();
        System.out.println("numberToString: " + numberToString(67));
        System.out.println("numberToString: " + numberToString(123));
        System.out.println("numberToString: " + numberToString(999));
        System.out.println("numberToString: " + numberToString(0));
        System.out.println();
        System.out.println("findSmallestInt: [-8] / " + findSmallestInt(new int[]{78, 56, -2, 12, -8}));
        System.out.println("findSmallestInt: [Integer.MIN_VALUE] / " + findSmallestInt(new int[]{Integer.MIN_VALUE, -666}));
        System.out.println("findSmallestInt: [Integer.MIN_VALUE] / " + findSmallestInt(new int[]{666, Integer.MIN_VALUE}));
        System.out.println("findSmallestInt: [Integer.MAX_VALUE] / " + findSmallestInt(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}));
        System.out.println("findSmallestInt: [Integer.MIN_VALUE] / " + findSmallestInt(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE}));
        System.out.println();
        System.out.println(" // " + countingSheep(0));
        System.out.println("1 sheep... // " + countingSheep(1));
        System.out.println("1 sheep...2 sheep... // " + countingSheep(2));
        System.out.println("1 sheep...2 sheep...3 sheep... // " + countingSheep(3));

    }

    // You Can't Code Under Pressure #1
    // https://www.codewars.com/kata/53ee5429ba190077850011d4/train/java
    public static int doubleInteger(int i) {
        return i * 2;
    }

    //    Opposites Attract
    //        https://www.codewars.com/kata/555086d53eac039a2a000083/train/java
    public static boolean isLove(final int flower1, final int flower2) {
        return (flower1 + flower2) % 2 != 0;
    }

    //    Convert a Number to a String
    // https://www.codewars.com/kata/5265326f5fda8eb1160004c8/train/java
    public static String numberToString(int num) {
        return Integer.toString(num);
    }

    // Find the smallest integer in the array
    // https://www.codewars.com/kata/55a2d7ebe362935a210000b2/train/java
    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args).min().getAsInt();
    }

    // If you can't sleep, just count sheep!!
    // https://www.codewars.com/kata/5b077ebdaf15be5c7f000077/train/java
    public static String countingSheep(int num) {
        return IntStream.rangeClosed(1, num)
                .mapToObj(n -> n + " sheep...")
                .collect(Collectors.joining());
    }
}
