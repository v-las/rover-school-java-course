import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupCallTasks20250907 {
    public static void main(String[] args) {
        task01();
        task02();
        task03();
        System.out.println(task04("aaa bbb ccc eee fff"));
    }

    private static void task01() {
        //    №1
        //    Выведите текущую дату в формате год-месяц-день.
        System.out.println(LocalDate.now());
    }

    private static void task02() {
        //№2
        //    Выведите название текущего дня недели.
        System.out.println(LocalDate.now().getDayOfWeek());
    }

    private static void task03() {
        //  №3
        //  Попросите пользователя ввести число через консоль. В результате выведите квадратный корень этого числа.
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.println("Math.sqrt(number) = " + Math.sqrt(number));
    }

    private static String task04(String str) {
        //№4
        //    Дана некоторая строка со словами:
        //            "aaa bbb ccc eee fff"
        //    Удалите из этой строки каждое второе слово. В нашем случае должно получится следующее:
        //            "aaa ccc fff"

        // решение 1
        String[] arrStr = str.split(" ");
//
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < arrStr.length; i++) {
            if (i % 2 == 0) {
                newStr.append(newStr.isEmpty() ? "" : " ")
                        .append(arrStr[i]);
            }
        }

//        return newStr.toString();

        // решение 2

        return IntStream.range(0, arrStr.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> arrStr[i])
                .collect(Collectors.joining(" "));
    }
}
