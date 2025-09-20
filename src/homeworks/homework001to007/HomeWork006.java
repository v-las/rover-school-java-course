package homeworks.homework001to007;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HomeWork006 {
    public static void main(String[] args) {
        task01();
        task02(emails);
        task03(numbers);
        task04(numbers);
        task05(numbers);
        task06();
        task07(passwordRegex, passwords);
        task08();
        task09();
        task10(9);
    }

    private static void task01() {
        System.out.println("=== task01 ===\n");
/*
        Задача № 1

        Вы ведете записи наивысшей дневной температуры.
        Найдите самый жаркий день.
        Найдите второй самый жаркий.
*/
        LocalDate currentDate = LocalDate.now();

        String previousMonth = LocalDate.of(
                currentDate.getYear(),
                currentDate.getMonthValue() - 1,
                1
        ).getMonth().toString();

        YearMonth previousMonthValue = YearMonth.of(currentDate.getYear(), (currentDate.getMonthValue() - 1));
        int lengthOfLastMonth = previousMonthValue.lengthOfMonth();

        int[] previousMonthTemperatures = ThreadLocalRandom.current()
                .ints(lengthOfLastMonth, 5, 30).toArray();

        System.out.println("previousMonthTemperatures = " + Arrays.toString(previousMonthTemperatures));

//        int previousMonthMaxTemperature = Arrays.stream(previousMonthTemperatures).max().getAsInt();
//        System.out.println("previousMonthMaxTemperature = " + previousMonthMaxTemperature);

        SortedSet<Integer> temperatures = Arrays.stream(previousMonthTemperatures)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));

        int previousMonthMaxTemperature = temperatures.getLast();
//        System.out.println("temperatures = " + temperatures);
        System.out.printf("Max temperature in %s: %d°%n", previousMonth, previousMonthMaxTemperature);

        temperatures.remove(temperatures.getLast());
        int previousMonthSecondToMaxTemperature = temperatures.getLast();
        System.out.printf("Second to max temperature in %s: %d°%n", previousMonth, previousMonthSecondToMaxTemperature);

        for (int i = 0; i < previousMonthTemperatures.length; i++) {
            int currentItem = previousMonthTemperatures[i];

            if (currentItem == previousMonthMaxTemperature) {
                System.out.printf("In the %d of %s, was a MAX temperature day (%d°)%n", i + 1, previousMonth, currentItem);
            } else if (currentItem == previousMonthSecondToMaxTemperature) {
                System.out.printf("In the %d of %s, was a second to MAX temperature day (%d°)%n", i + 1, previousMonth, currentItem);
            }
        }
        System.out.println();
    }

    private static void task02(String[] emailList) {
        System.out.println("=== task02 ===\n");
        /*
            Задача № 2

            У вас есть список адресов электронной почты.
            Найдите все адреса с доменом gmail.com. Адреса поддельных сайтов типа myrealgmail.com не учитывать.
            Найти самый короткий и самый длинный адреса.
            Проверить, нет ли адресов с юзернеймом admin
        */
        Pattern gmailPattern = Pattern.compile(gmailRegex);
        Pattern adminEmailPattern = Pattern.compile(adminEmailRegex);

        boolean hasAdminEmail = Arrays.stream(emailList)
                .map(String::toLowerCase)
                .anyMatch(email -> email.matches(adminEmailRegex));
        System.out.println("has Admin Email: " + hasAdminEmail);

        String longestEmail = Arrays.stream(emailList)
                .max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest email: " + longestEmail);

        String shortestEmail = Arrays.stream(emailList)
                .min(Comparator.comparingInt(String::length)).get();
        System.out.println("Shortest email: " + shortestEmail);

        for (String currentEmail : emailList) {
            String currentEmailLowerCase = currentEmail.toLowerCase();

            Matcher gmailMatcher = gmailPattern.matcher(currentEmailLowerCase);
            boolean isValidGmail = gmailMatcher.matches();

            Matcher adminEmailMatcher = adminEmailPattern.matcher(currentEmailLowerCase);
            boolean isValidAdminEmail = adminEmailMatcher.matches();

            if (isValidGmail) {
                System.out.println("Valid Gmail from the list: " + currentEmail);
            }
            if (isValidAdminEmail) {
                System.out.println("List has admin email: " + currentEmail);
            }
        }
        System.out.println();
    }

    private static void task03(int[][] array) {
        System.out.println("=== task03 ===\n");
    /*
        Задача № 3
        Создайте двумерный массив 5х5, заполните его какими-нибудь числами.
        Напечатайте его таким образом, чтобы он сохранял форматирование (колонки были выровнены),
        если числа в нем будут любыми от -999 до 9999.
    */
        for (int[] currentArray : array) {
            for (int number : currentArray) {
                System.out.printf("| %5d ", number);
            }
            System.out.printf("|%n");
        }
        System.out.println();
    }

    private static void task04(int[][] array) {
        System.out.println("=== task04 ===\n");
        /*
            Задача № 4
            Возьмите массив из предыдущей задачи, и выведите в одну строку все числа, лежащие на
            его диагонали от верхнего левого угла до нижнего правого.
            В другой строке — числа на другой диагонали, от верхнего правого до нижнего левого углов.
        */
        int[] topLeft = new int[array.length];
        int[] topRight = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            topLeft[i] = array[i][i];
            topRight[i] = array[i][array.length - 1 - i];
        }
        System.out.println("topLeft = " + Arrays.toString(topLeft));
        System.out.println("topRight = " + Arrays.toString(topRight));
        System.out.println();
    }

    private static void task05(int[][] array) {
        System.out.println("=== task05 ===\n");
    /*
        Задача № 5

        Возьмите массив из предыдущей задачи, или любой другой квадратный массив (матрицу).
        Зеркально преобразуйте его вокруг диагонали от верхнего левого до нижнего правого угла.

        Например, если был массив
        3 5 7
        1 4 6
        9 2 8

        то после преобразования он должен выглядеть так:
        3 1 9
        5 4 2
        7 6 8
    */
        int[][] newArray = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[j][i] = array[i][j];
            }
        }

        for (int[] curr : newArray) {
            System.out.println(Arrays.toString(curr));
        }

//        System.out.println("newArray = " + Arrays.deepToString(newArray));
        System.out.println();
    }


    private static void task06() {
        System.out.println("=== task06 ===\n");
    /*
            Задача № 6
            Дана строка:
            I’m just 16,
            going on	17!

            (перед 17 стоит Tab, а не пробел). В принципе, это может быть ЛЮБАЯ строка,
            содержащая латинские буквы в верхнем и нижнем регистре, цифры, знаки препинания.

            Найти, сколько в этой строке заглавных букв, сколько прописных, сколько гласных,
            сколько согласных, сколько цифр, сколько знаков препинания, сколько “пробельных” символов
            (в них входят пробелы, символы табуляции, перевод строки и пр. Поищите “whitespace characters”).

            Имейте в виду, что некоторые проверки можно делать легче, чем другие. Поэкспериментируйте.
    */
        String testStr = """
                I’m just 16,
                going on	17!""";

        int numberOfCapitals = 0;
        int numberOfMiniscules = 0;
        int numberOfVowels = 0;
        int numberOfConsonant = 0;
        int numberOfDigits = 0;
        int numberOfSymbols = 0;
        int numberOfSpaces = 0;

        // решение 1

        for (int i = 0; i < testStr.length(); i++) {
            char c = testStr.charAt(i);

            if (c > 65 && c <= 90) {
                numberOfCapitals++;
            }
            if (c > 97 && c <= 122) {
                numberOfMiniscules++;
            }
            if (
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                            c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            ) {
                numberOfVowels++;
            }
            if (
                    (c >= 66 && c <= 90 && c != 65 && c != 69 && c != 73 && c != 79 && c != 85) ||
                            (c >= 98 && c <= 122 && c != 97 && c != 101 && c != 105 && c != 111 && c != 117)

            ) {
                numberOfConsonant++;
            }
            if (c > 48 && c <= 57) {
                numberOfDigits++;
            }
            if (
                    (c >= 33 && c <= 47) ||
                            (c >= 58 && c <= 64) ||
                            (c >= 91 && c <= 96) ||
                            (c >= 123 && c <= 126)
            ) {
                numberOfSymbols++;
            }
            if (c == 32 || c == 9 || c == 10 || c == 13) {
                numberOfSpaces++;
            }
        }

        // решение 2

        for (int i = 0; i < testStr.length(); i++) {
            char currChar = testStr.charAt(i);
            String vowels = "aeiuo";

            if (Character.isLetter(currChar)) {
                if (Character.isUpperCase(currChar)) {
                    numberOfCapitals++;
                } else {
                    numberOfMiniscules++;
                }
                if (vowels.indexOf(Character.toLowerCase(currChar)) > -1) {
                    numberOfVowels++;
                } else {
                    numberOfConsonant++;
                }
            } else if (Character.isDigit(currChar)) {
                numberOfDigits++;
            } else if (Character.isWhitespace(currChar)) {
                numberOfSpaces++;
            } else {
                numberOfSymbols++;
            }

        }
        
        System.out.println("numberOfCapitals: " + numberOfCapitals);
        System.out.println("numberOfMiniscules: " + numberOfMiniscules);
        System.out.println("numberOfVowels: " + numberOfVowels);
        System.out.println("numberOfConsonant: " + numberOfConsonant);
        System.out.println("numberOfDigits: " + numberOfDigits);
        System.out.println("numberOfSymbols: " + numberOfSymbols);
        System.out.println("numberOfSpaces: " + numberOfSpaces);

        System.out.println();
    }


    private static void task07(String regex, String[] array) {
        System.out.println("=== task07 ===\n");
    /*
        Задача № 7
        Напишите код, который будет проверять, насколько трудно подобрать пароль. Чтобы пройти проверку,
        пароль должен быть не менее 8 символов, содержать как минимум:
        заглавную латинскую букву
        строчную латинскую букву
                цифру
        знак препинания из списка: ~@#$%^&*()_-+=
                и не иметь пробелов и символов НЕ упомянутых в этом перечислении.
    */
        Pattern passPattern = Pattern.compile(regex);

        for (String password : array) {
            Matcher passMatcher = passPattern.matcher(password);
            if (!passMatcher.matches()) {
                System.out.println("Password is not valid | " + password + " | ");
            }
        }
        System.out.println();
    }

    //        Задачи со звездочкой (экстра)
    //        Вывести следующие строки с соответствующим форматированием (как пирамиды):

    private static void task08() {
        System.out.println("=== task08 ===\n");
    /*
        Задача № 8

        0  1  2  3  4  5  6  7  8  9
        0  1  2  3  4  5  6  7  8
        0  1  2  3  4  5  6  7
        0  1  2  3  4  5  6
        0  1  2  3  4  5
        0  1  2  3  4
        0  1  2  3
        0  1  2
        0  1
        0
    */
        for (int i = 9; i >= 0; i--) {
            String[] range = IntStream.rangeClosed(0, i)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);

            System.out.println(String.join("  ", range));
        }

        System.out.println();
    }

    private static void task09() {
        System.out.println("=== task09 ===\n");
        /*
                Задача № 9

        0  1  2  3  4  5  6  7  8  9
           0  1  2  3  4  5  6  7  8
              0  1  2  3  4  5  6  7
                 0  1  2  3  4  5  6
                    0  1  2  3  4  5
                       0  1  2  3  4
                          0  1  2  3
                             0  1  2
                                0  1
                                   0
        */
        for (int i = 9; i >= 0; i--) {
            String[] range = IntStream.rangeClosed(0, i)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);

            System.out.print(" ".repeat((9 - i) * 3));
            System.out.println(String.join("  ", range));
        }
        System.out.println();
    }

    private static void task10(int lastNumber) {
        System.out.println("=== task10 ===\n");
        /*
                Задача № 10

        9 8 7 6 5 4 3 2 1 0 1 2 3 4 5 6 7 8 9
          8 7 6 5 4 3 2 1 0 1 2 3 4 5 6 7 8
            7 6 5 4 3 2 1 0 1 2 3 4 5 6 7
              6 5 4 3 2 1 0 1 2 3 4 5 6
                5 4 3 2 1 0 1 2 3 4 5
                  4 3 2 1 0 1 2 3 4
                    3 2 1 0 1 2 3
                      2 1 0 1 2
                        1 0 1
                          0
        */

        // Решение 1
        for (int i = lastNumber; i >= 0; i--) {
            String[] range = IntStream.rangeClosed(0, i)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);

            String[] copyOfRange = Arrays.copyOfRange(range, 1, range.length);
            Collections.reverse(Arrays.asList(copyOfRange));

            String[] both = Stream.concat(
                    Arrays.stream(copyOfRange),
                    Arrays.stream(range)
            ).toArray(String[]::new);

            System.out.print(" ".repeat((lastNumber - i) * 2));
            System.out.println(String.join(" ", both));
        }
        System.out.println();

        // Решение 2
        IntStream.iterate(lastNumber, i -> i >= 0, i -> i - 1)
                .forEach(i -> {
                    String intendant = " ".repeat((lastNumber - i) * 2);

                    String range = IntStream.rangeClosed(-i, i)
                            .map(Math::abs)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "));

                    System.out.println(intendant + range);
                });
        System.out.println();
    }

    private static final String[] emails = {
            "5s_4x@gmail.com",
            "plainaddress",
            "k9fg51wr@mail.com",
            "0gtpbi@protonmail.com",
            "k8y5j4a8ss8@GMAIL.com",
            "kdjp83sw-v@protonmail.com",
            "l0-rpb@icloud.com",
            "ptzgept4g@gmail.com",
            "fepvdud71y@gmail.com",
            "555admin666@gmailfoo.com",
            "2b5fx8uo8@gmx.com",
            "wrong@domain,com",
            "bad@domain",
            ".6mql@gmx.com",
            "eq2upfdigkj0@gmail.com",
            "plainaddress",
            "w002she@gmail.com",
            "sxzztvlloqx@hotmail.com",
            "ADMIN@gmail.com",
            "jg44lzxt@icloud.com",
            "dwrrb@yahoo.com",
            "9mexgj0lwsg@gmail.com",
            "missingatsign.com",
            "wrong@domain,com",
            "missingatsign.com",
            "468ol@gmail.com",
            "r0ie-.@protonmail.com",
            "admin@admin.com",
            "plainaddress",
            "wrong@domain,com",
            "kjjtafsi88c@duck.com",
            "ee968y78@protonmail.com",
            "jf30qieh@duck.com",
            "ehfbvk_d@gmail.com",
            "missingatsign.com",
            "snhsel@gmail.com",
            "test@.com",
            "_riivgtmnas@gmx.com",
            "gx0zu@example.org",
            "qal1ku@gmx.com",
            "-iku0-@gmail.com",
            "j9u2e3v4dvv8@hotmail.com",
            "bad@domain",
            ".9rj0l-f@ya.ru",
            "fkskemail.com",
            "5dfcuh@protonmail.com",
            "34d52o@protonmail.com",
            "i47_l41@gmail.com",
            "no_domain@",
            "1d-0yqb6@zoho.com",
            "pxti9h7-@gmail.com",
            "sjcb1.moh1@gmail.com",
            "admin@yahoo.com",
            "j5xbgf@icloud.com",
            "test@.com",
            "62mkbbvq5@icloud.com",
            "wrong@domain,com",
            "8wxovm@gmail.com",
            "4z84z8-@duck.com",
            "egkyp.mvg@mail.com",
            "q0k4gk-@zoho.com",
            "bad@domain",
            "z0u10gn@icloud.com",
            "no_domain@",
            "plainaddress",
            "9ekdth@icloud.com",
            "m5s7dbrq@hotmail.com",
            "admin@gmail.com",
            "missingatsign.com",
            "ns40lmc@icloud.com",
            "4w3kfp3@protonmail.com",
            "ty7pfliwn@gmail.com",
            "@email.com",
            "plg3s91@mail.com",
            "0u3t1k5ya@icloud.com",
            "4b55e7b5s@ya.ru",
            "admin@admin.com",
            "plainaddress",
            "mvj-94sda@gggmail.com",
            "jxu00bb5n@gmail.com",
            "n8gsic4@zoho.com",
            "wrong@domain,com",
            "tgyk4-3qrv@hotmail.com",
            "o6tr18.9j@admin.com",
            "j7jkk39b@icloud.com",
            "test@.com",
            "4a0x8a@gmail.com",
            "7vfvtehyc@gmail.com",
            "missingatsign.com",
            "0zq3a3dd0k@yahoo.com",
            "plainaddress",
            "v9y6y0vc@icloud.com",
            "7d2i6i@admin.com",
            "2c-4f2vc1g@icloud.com",
            "1h22i@protonmail.com",
            "fkskegmail.com",
            "6tf70-fiw@mail.com",
            "ztl5g8csmx@gmail.com",
    };

    private static final String emailRegex = "^[a-z0-9](\\.?[a-z0-9]){5,}@[a-z0-9-]+(\\.[a-z]{2,})+$";

    private static final String gmailRegex = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";

    private static final String adminEmailRegex = "^admin@[a-z0-9-]+(\\.[a-z]{2,})+$";

    private static final int[][] numbers = {
            {98, 8050, 30, 875, 872},
            {9529, 712, -8, -1656, 29},
            {746, -159, 175, 417, 273},
            {4, -830, -2568, 3, 73},
            {2663, 3784, 214, 1193, -237}
    };

    private static final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[~@#$%^&*()_\\-+=])[A-Za-z\\d~@#$%^&*()_\\-+=]{8,}$";

    private static final String[] passwords = {
            // Валидные (10)
            "Abcdef1~",      // минимально валидный
            "Password1@",
            "Qwerty9$",
            "StrongP@ss2",
            "My_Pass123^",
            "Valid-123+",
            "TestPass8*",
            "Admin#2025",
            "User+Pass1_",
            "Secure*Key9",

            // Невалидные (20)
            "abcdef1~",      // нет заглавной
            "ABCDEF1~",      // нет строчной
            "Abcdefgh@",     // нет цифры
            "Abcdef12",      // нет спецсимвола
            "A1~b",          // меньше 8 символов
            "Abc def1@",     // пробел
            "Abcdef1~%",     // допустим
            "Abcdef1?",      // недопустимый спецсимвол
            "12345678~",     // нет букв
            "ABCDEFGH1~",    // нет строчной
            "abcdefgh1~",    // нет заглавной
            "A!b@C#d$e",     // нет цифры
            "A1~b2@c3",      // валидный, но проверка для примера
            "PassWord_",     // нет цифры
            "Pwd12345",      // нет спецсимвола
            "1234!@#$",      // нет букв
            "aB1",           // меньше 8 символов
            "Val id Pass1@",   // пробелы
            "NoSpaces1#",    // валидный
            "Bad|Char1~"     // недопустимый символ "|"
    };

}
