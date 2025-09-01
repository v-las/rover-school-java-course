import java.util.Arrays;

public class HomeWork005 {
    public static void main(String[] args) {
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
        int[][] twoDimensionalArray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};

        System.out.println("task01: " + task01(array));
        System.out.println("task02: " + task02(array));
        System.out.println("task03: " + task03(array));
        System.out.println("task04: " + task04(array));

        System.out.println("task01e: " + task01e(twoDimensionalArray));
        System.out.println("task02e: " + task02e(twoDimensionalArray));
        System.out.println("task03e: " + task03e(twoDimensionalArray));
    }

/*
    Задача №1

    Дан массив:
    int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
    необходимо вывести сумму всех значений массива.
*/

    public static int task01(int[] intArray) {
        return Arrays.stream(intArray).sum();
    }

/*
    Задача №2

    Дан массив:
    int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
    необходимо вывести максимальное значение массива.
*/

    public static int task02(int[] intArray) {
        return Arrays.stream(intArray).max().getAsInt();
    }

/*
    Задача №3

    Дан массив:
    int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
    необходимо вывести мицнимальное значение массива.
*/

    public static int task03(int[] intArray) {
        return Arrays.stream(intArray).min().getAsInt();
    }

/*
    Задача №4

    Дан массив:
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    необходимо вывести среднее арифметическое всех значений массива.
*/

    public static double task04(int[] intArray) {
        return Arrays.stream(intArray).average().getAsDouble();
    }

    /*
    Экстра задача №1

    Дан массив:
    int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
    необходимо вывести сумму элементов массива.
*/

    public static int task01e(int[][] int2dArray) {
        return Arrays.stream(int2dArray)
                .reduce(
                        0,
                        (acc, cur) -> acc + Arrays.stream(cur).sum(),
                        Integer::sum
                );
    }

/*
    Экстра задача №2

    Дан массив:
    int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
    необходимо вывести максимальное значение массива.
*/

    public static int task02e(int[][] int2dArray) {
        return Arrays.stream(int2dArray)
                .flatMapToInt(Arrays::stream)
                .max().getAsInt();
    }

/*
    Экстра задача №3

    Дан массив:
    int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};
    необходимо вывести количество элементов в массиве.
*/

    public static int task03e(int[][] int2dArray) {
        int[] flattenArray = Arrays.stream(int2dArray)
                .flatMapToInt(Arrays::stream)
                .toArray();

        return flattenArray.length;
    }
}
