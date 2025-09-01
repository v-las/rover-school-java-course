import java.util.Arrays;
import java.util.stream.Collectors;

public class Lesson006 {
    public static void main(String[] args) {
        foo();
        bar();
    }

    private static void foo() {
        int[][] weeklySteps = {
                {98, 8050, 30, 875, 872},
                {9529, 712, -8, -1656, 29},
                {746, -159, 175, 417, 273},
                {4, -830, -2568, 3, 73},
                {2663, 3784, 214, 1193, -237},
                {63, 4367, 214, 76, -237},
                {23, 374, 3425, 23, -97}
        };

        for (int[] dailySteps : weeklySteps) {
            for (int currentSteps : dailySteps) {
                System.out.println("currentSteps = " + currentSteps);
            }
        }
    }

    private static void bar() {
        String str = "opt java libexec openjdk jdk Contents Home bin bin bin bin bin bin java";
        String[] words = str.split(" ");

        int max = Arrays.stream(words)
                .mapToInt(String::length)
                .max().getAsInt();
        System.out.println("max = " + max);


        String[] vowels = str.split("");
        Object[] filtredVowels = Arrays.stream(vowels).filter(w
                        -> w.equals("e") ||
                        w.equals("y") ||
                        w.equals("u") ||
                        w.equals("i") ||
                        w.equals("o") ||
                        w.equals("a"))
                .distinct().toArray();

        System.out.println("vowels = " + Arrays.toString(filtredVowels));
    }
}
