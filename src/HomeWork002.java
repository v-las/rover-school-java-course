public class HomeWork002 {
  public static void main(String[] args) {
    /*     Задача №1
       Необходимо создать целочисленные переменные a и b, присвоить произвольные значения
    переменным на ваш выбор и вывести результаты следующих операций с этими переменными:
    сложение, умножение, вычитание, деление и остаток от деления. Также сделать проверку на
    четность этих переменных и вывести результат.*/
    System.out.println("Task1");

    int a = 42;
    int b = 13;

    System.out.println("Summation: " + (a + b));
    System.out.println("Substract: " + (a - b));
    System.out.println("Multiply : " + (a * b));
    System.out.println("Divide   : " + ((double) a / (double) b));
    System.out.println("Reminder : " + (a % b));
    System.out.println();

    System.out.printf("Is number %d even: %b%n", b, isEven(b));
    System.out.printf("Is number %d even: %b%n", a, isEven(a));
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

    double pirateLootInPiastres = 5_123_822;
    int crewSize = 52;

    double shipOwnerLoot = pirateLootInPiastres / 2;
    double captainsLoot = shipOwnerLoot / 2;
    double crewMemberLoot = captainsLoot / crewSize;

    System.out.printf("ship Owner Loot: %.2f%n", shipOwnerLoot);
    System.out.printf("Captains loot: %.2f%n", captainsLoot);
    System.out.printf("crew member Loot: %.2f%n", crewMemberLoot);
    System.out.printf("Captain Jack The Sparrow loot: %.2f%n", captainsLoot + shipOwnerLoot);
  }



  private static boolean isEven(int number) {
    return number % 2 == 0;
  }
}
