import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class HomeWork004 {
    public static void main(String[] args) {
/*
        Задача №1

        Дан массив:
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
        необходимо вывести все нечетные числа из массива.
*/

        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};

        for (int num : array) {
            if (num % 2 != 0) {
                System.out.println("num = " + num);
            }
        }

        System.out.println();

/*
        Задача №2

        Дан массив:
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
        необходимо вывести все значения массива больше 5.
*/

        for (int num : array) {
            if (num > 5) {
                System.out.println("num = " + num);
            }
        }

        System.out.println();

/*
        Задача №3

        Дан массив:
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
        необходимо увеличить все значения массива на 15.
*/

        for (int i = 0; i < array.length; i++) {
            array[i] += 15;
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        System.out.println();
/*
        Задача №4

        Дана строка:
        String s = “Перестановочный алгоритм быстрого действия”;
        необходимо вывести все буквы “о”из этой строки.
        Для указанной строки ответ будет “ооооо”(или в столбик)
*/

        String s = "Перестановочный алгоритм быстрого действия. Перевыборы выбранного президента";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'о') {
                System.out.printf("Символ '%s', позиция [%d]%n", currentChar, i);
            }
        }

        System.out.println();

/*
        Задача №5

        Дана строка:
        String s = “Перевыборы выбранного президента”;
        необходимо подсчитать количество букв “е” в строке.
        Для указанной строки ответ будет 4.
*/

        int charSum = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'е') {
                charSum++;
            }
        }

        System.out.println("charSum = " + charSum);
        System.out.println();
/*
        Задача №6

        Дан массив:
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
        необходимо вывести сумму всех значений массива.
*/
        int numSum = 0;

        for (int num : array) {
            numSum += num;
        }

        System.out.println("numSum = " + numSum);
        System.out.println();
/*
        Задача №7
        (немного подумать придется)

        Возвращаясь к маньяку со спичками с лекции.

        Имеется 20 коробок спичек. Найти все коробки, количество спичек в которых отличается от среднего
        количества больше, чем на 3. Например, если есть следующие данные:
        60, 59, 58, 59, 64, 60,
        то среднее количество будет чуть меньше 60. Соответственно, коробка с 64 спичками будет
        сильно отличаться от среднего.
*/

        int[] matchesInBoxes = {61, 57, 50, 50, 62, 59, 65, 56, 60, 58, 63, 62, 55, 64, 59, 57, 61, 60, 65, 58};

        IntStream stream = IntStream.of(matchesInBoxes);
        long averageMatchesInBox = Math.round(stream.average().orElse(0));
        System.out.println("averageMatchesInBox = " + averageMatchesInBox);

        for (int matchesInBox : matchesInBoxes) {
            if (matchesInBox != averageMatchesInBox) {
                System.out.printf(
                        "Текущий коробок '%d' отличается от среднего '%d'.%n",
                        matchesInBox, averageMatchesInBox
                );
            }
        }

        System.out.println();

        int boxesTotal = parseIntWithMessage("Сколько всего коробков?");
        int idealBox = 60;
        int idealOffset = parseIntWithMessage("Допустимая погрешность для количества спичек (±)?");
        int realOffset = idealOffset * 2;

        int[] boxes = ThreadLocalRandom.current()
                .ints(boxesTotal, idealBox - realOffset, idealBox + realOffset)
                .toArray();

        System.out.println("Текущий набор коробков: " + Arrays.toString(boxes));

        long averageBox = Math.round(IntStream.of(boxes).average().orElse(0));
        System.out.println("Среднее количество спичек в коробке: " + averageBox);


        for (int i = 0; i < boxes.length; i++) {
            int currentBox = boxes[i];

            if (currentBox < averageBox - idealOffset || currentBox > averageBox + idealOffset) {
                System.out.printf(
                        "Коробок №%3d [%3d шт.] отличается от среднего [%d шт.] на %d%n",
                        i, currentBox, averageBox, Math.abs(currentBox - averageBox)
                );
            }
        }
    }

    private final static Scanner keyboard = new Scanner(System.in);

    private static int parseIntWithMessage(String message) {
        System.out.printf("%s: ", message);
        return keyboard.nextInt();
    }
}
