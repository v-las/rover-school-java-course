package homeworks.homework001to007;

public class HomeWork007Task01 {
    public static void main(String[] args) {
        /* Задача №1

            Необходимо написать 4 метода:
            сложение 2х чисел
            вычитание 2х чисел
            умножение 2х чисел
            деление 2х чисел
        */
        int number1 = 73;
        int number2 = 6;

        int sum = sum(number1, number2);
        int sub = sub(number1, number2);
        int mult = mult(number1, number2);
        double div = div(number1, number2);

        System.out.printf("Sum: %d | Sub: %d | Mult: %d | Div: %.3f", sum, sub, mult, div);
    }

    private static int sum(int number1, int number2) {
        return number1 + number2;
    }

    private static int sub(int number1, int number2) {
        return number1 - number2;
    }

    private static int mult(int number1, int number2) {
        return number1 * number2;
    }

    private static double div(int number1, int number2) {
        return (double) number1 / number2;
    }
}
