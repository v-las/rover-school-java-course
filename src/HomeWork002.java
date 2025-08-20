import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeWork002 {
  public static void main(String[] args) {
    /*     Задача №1
       Необходимо создать целочисленные переменные a и b, присвоить произвольные значения
    переменным на ваш выбор и вывести результаты следующих операций с этими переменными:
    сложение, умножение, вычитание, деление и остаток от деления. Также сделать проверку на
    четность этих переменных и вывести результат.*/
    System.out.println("Task1");

    double a = 42;
    double b = 13;

    HashMap<String, Double> mathOperations = new HashMap<>();

    mathOperations.put("Summation", a + b);
    mathOperations.put("Substract", a - b);
    mathOperations.put("Multiply", a * b);
    mathOperations.put("Divide", a / b);
    mathOperations.put("Reminder", a % b);

    System.out.println();

    for (Map.Entry<String, Double> stringDoubleEntry : mathOperations.entrySet()) {
      System.out.printf(
          "%-9s ...... %s%n",
          stringDoubleEntry.getKey(), Double.toString(stringDoubleEntry.getValue()));
    }

    System.out.println();

    String content =
        mathOperations.entrySet().stream()
            .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
            .collect(Collectors.joining("\n"));

    System.out.println(content);

    System.out.println();

    System.out.println("mathOperations = " + mathOperations);
    System.out.println("mathOperations = " + Arrays.toString(mathOperations.entrySet().toArray()));

    System.out.println();

    System.out.println("Summation: " + (a + b));
    System.out.println("Substract: " + (a - b));
    System.out.println("Multiply : " + (a * b));
    System.out.println("Divide   : " + ((double) a / (double) b));
    System.out.println("Reminder : " + (a % b));
    System.out.println();

    System.out.printf("Is number %.0f even: %B%n", b, isEven(b));
    System.out.printf("Is number %.0f even: %B%n", a, isEven(a));
    System.out.println();

    /*        Задача №2
       Необходимо создать целочисленные переменные a и b, присвоить им произвольные значения, а
    потом поменять значения местами (значение переменной a должно оказаться в переменной b и
    наоборот).*/

    System.out.println("Task2");

    System.out.println("Value `a` before: " + a);
    System.out.println("Value `b` before: " + b);

    b = a + b;
    a = b - a;
    b = b - a;

    System.out.println("Value `a` after: " + a);
    System.out.println("Value `b` after: " + b);
    System.out.println();

    /*        Задача №3
       Создать программу дележа добычи на пиратском корабле. По обычаю, половина добычи идет
    владельцу корабля, половина оставшегося — капитану, остальное делится поровну между всеми
    членами команды, включая капитана.
       Размер добычи (например, в пиастрах) и количество пиратов на корабле задать переменными.
       Вывести на экран кому сколько пиастров полагается
       Сколько получит капитан (Джек Воробей, естественно), если он утверждает, что корабль
    принадлежит ему?*/

    System.out.println("Task3");

    double pirateLootInPiastres = 10000;
    int crewSize = 50;

    double shipOwnerLoot = pirateLootInPiastres / 2;
    double captainsLoot = shipOwnerLoot / 2;
    double crewMemberLoot = captainsLoot / crewSize;

    System.out.printf("ship Owner Loot: %.2f%n", shipOwnerLoot);
    System.out.printf("Captains loot: %.2f%n", captainsLoot);
    System.out.printf("crew member Loot: %.2f%n", crewMemberLoot);
    System.out.printf("Captain Jack The Sparrow loot: %.2f%n", captainsLoot + shipOwnerLoot);
  }

  private static boolean isEven(double number) {
    return number % 2 == 0;
  }
}
