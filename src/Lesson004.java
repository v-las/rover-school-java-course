import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Lesson004 {
    public static void main(String[] args) {

        int[] ints = new int[5];
        ints[0] = 5;
        ints[1] = 1;
        ints[2] = 3;
        ints[3] = 3;
        ints[4] = 5;

        System.out.println("ints = " + Arrays.toString(ints));
        System.out.println();

        ints[2] = 122;
        System.out.println("ints = " + Arrays.toString(ints));
        System.out.println();

        int[] matchesInBox = {59, 60, 60, 58, 61, 55, 63, 61, 58, 58};

        System.out.println("Arrays.toString(matchesInBox) = " + Arrays.toString(matchesInBox));
        System.out.println();

        for (int i = 0; i < matchesInBox.length; i++) {
            System.out.println("matchesInBox[i] = " + matchesInBox[i]);
        }
        System.out.println();

        int[] arr = {1, 2, 3};

        // Получаем класс объекта (массив int[])
        Class<?> clazz = arr.getClass();

        // Выводим поля
        System.out.println("Поля:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field);
        }

        // Выводим методы
        System.out.println("\nМетоды:");
        for (Method method : clazz.getMethods()) {
            System.out.println("  " + method);
        }

        // Отдельно длина массива
        System.out.println("\nДлина массива: " + arr.length);
        System.out.println();

        for (int i = 0; i < matchesInBox.length; i++) {
            int currentMatchesInBox = matchesInBox[i];

            if (currentMatchesInBox != 60) {
                System.out.println("currentMatchesInBox = " + currentMatchesInBox);
                matchesInBox[i] = 60;
            }

        }
        System.out.println();

        System.out.println("Arrays.toString(matchesInBox) = " + Arrays.toString(matchesInBox));
        System.out.println();

        int acc = Integer.MIN_VALUE;

        for (int i = 0; i < matchesInBox.length; i++) {
            int currentMatchesInBox = matchesInBox[i];

            if (currentMatchesInBox > acc) {
                acc = currentMatchesInBox;
            }
        }

        System.out.println("acc = " + acc);
        System.out.println();

        String[] deltas = new String[matchesInBox.length];

        for (int i = 0; i < matchesInBox.length; i++) {
            int matchesInCurrentBox = matchesInBox[i];
            deltas[i] = "Нужно добавить: " + (60 - matchesInCurrentBox);
        }
        System.out.println("Arrays.toString(deltas) = " + Arrays.toString(deltas));

        System.out.println();

        String str = "s;dfkgaaAAAaAAjlnksdglkn";
        String[] strArr = {"s;df", "kgaa", "AAAa", "AAjlnk", "sdglkn"};

        for (int i = 0; i < str.length(); i++) {
            System.out.println("str.charAt(i) = " + str.charAt(i));
        }
        System.out.println();

        System.out.println(10 + "10");
        System.out.println();

        System.out.println("aHBhvhJbUubIubiuBiUBIOUbbc".toLowerCase().substring(1, 6));
        System.out.println("str.toLowerCase() = " + str.toLowerCase());
        System.out.println("str.toUpperCase() = " + str.toUpperCase());
        System.out.println("str.indexOf('A') = " + str.indexOf('A'));
        System.out.println("str.lastIndexOf('A') = " + str.lastIndexOf('A'));
        System.out.println("str.startsWith(\"A\") = " + str.startsWith("A"));
        System.out.println("str.replace(\"a\", \"x\") = " + str.replace("a", "x"));
        System.out.println("String.join(\"||\", strArr) = " + String.join("||", strArr));
        System.out.println("Arrays.toString(str.split(\"A\")) = " + Arrays.toString(str.split("A")));

        char a = 'ф' + '0';
        System.out.println("a = " + a);
    }
}
