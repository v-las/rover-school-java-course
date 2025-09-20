package homeworks.homework009;

import java.util.Arrays;

// https://www.codewars.com/kata/577bd8d4ae2807c64b00045b/train/java
public class TwoFightersOneWinner {
    private record FightQueue(
            Fighter fighter1,
            Fighter fighter2,
            String firstAttacker
    ) {
        public Fighter getNextAttacker() {
            return Arrays.stream(new Fighter[]{fighter1, fighter2})
                    .filter(f -> f.name.equals(firstAttacker))
                    .findFirst()
                    .orElse(null);
        }

        public Fighter getNextDamageTaker() {
            return Arrays.stream(new Fighter[]{fighter1, fighter2})
                    .filter(f -> !f.name.equals(firstAttacker))
                    .findFirst()
                    .orElse(null);
        }

        public String getNextAttackerName() {
            return this.getNextDamageTaker().name;
        }
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        FightQueue fightQueue = new FightQueue(fighter1, fighter2, firstAttacker);

        while (true) {
            Fighter nextAttacker = fightQueue.getNextAttacker();
            Fighter nextDamageTaker = fightQueue.getNextDamageTaker();
            String nextAttackerName = fightQueue.getNextAttackerName();

            nextDamageTaker.health -= nextAttacker.damagePerAttack;

            if (nextDamageTaker.health <= 0) {
                return nextAttacker.name;
            }

            fightQueue = new FightQueue(nextAttacker, nextDamageTaker, nextAttackerName);
        }
    }

        public static void main(String[] args) {
        // Tests
        System.out.println("exp: " + "Lew" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Lew", 10, 2),
                                new Fighter("Harry", 5, 4),
                                "Lew"));

        System.out.println("exp: " + "Harry" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Lew", 10, 2),
                                new Fighter("Harry", 5, 4),
                                "Harry"));

        System.out.println("exp: " + "Harald" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Harald", 20, 5),
                                new Fighter("Harry", 5, 4),
                                "Harry"));

        System.out.println("exp: " + "Harald" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Harald", 20, 5),
                                new Fighter("Harry", 5, 4),
                                "Harald"));

        System.out.println("exp: " + "Harald" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Jerry", 30, 3),
                                new Fighter("Harald", 20, 5),
                                "Jerry"));

        System.out.println("exp: " + "Harald" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Jerry", 30, 3),
                                new Fighter("Harald", 20, 5),
                                "Harald"));

        System.out.println("exp: " + "Mark" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Mark", 40, 8),
                                new Fighter("Paul", 25, 10),
                                "Mark"));

        System.out.println("exp: " + "Paul" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Mark", 40, 8),
                                new Fighter("Paul", 25, 10),
                                "Paul"));

        System.out.println("exp: " + "Anna" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Anna", 60, 12),
                                new Fighter("Sophie", 50, 15),
                                "Sophie"));

        System.out.println("exp: " + "Anna" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Anna", 60, 12),
                                new Fighter("Sophie", 50, 15),
                                "Anna"));

        System.out.println("exp: " + "Victor" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Victor", 70, 20),
                                new Fighter("Chris", 100, 5),
                                "Victor"));

        System.out.println("exp: " + "Victor" + " | act: " +
                        TwoFightersOneWinner.declareWinner(
                                new Fighter("Victor", 70, 20),
                                new Fighter("Chris", 100, 5),
                                "Chris"));
    }
}
