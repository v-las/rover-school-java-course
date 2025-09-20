package homeworks.homework009;

// https://www.codewars.com/kata/577bd8d4ae2807c64b00045b/train/java
public class TwoFightersSecondTry {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attacker = fighter1.name.equals(firstAttacker) ? fighter1 : fighter2;
        Fighter defender = !fighter1.name.equals(firstAttacker) ? fighter1 : fighter2;

        double attackerHitCount = Math.ceil(defender.health * 1.0 / attacker.damagePerAttack);
        double defenderHitCount = Math.ceil(attacker.health * 1.0 / defender.damagePerAttack);

        return attackerHitCount <= defenderHitCount ? attacker.name : defender.name;
    }

    public static void main(String[] args) {
        // Tests
        System.out.println("exp: " + "Lew" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Lew", 10, 2),
                        new Fighter("Harry", 5, 4),
                        "Lew"));

        System.out.println("exp: " + "Harry" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Lew", 10, 2),
                        new Fighter("Harry", 5, 4),
                        "Harry"));

        System.out.println("exp: " + "Harald" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Harald", 20, 5),
                        new Fighter("Harry", 5, 4),
                        "Harry"));

        System.out.println("exp: " + "Harald" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Harald", 20, 5),
                        new Fighter("Harry", 5, 4),
                        "Harald"));

        System.out.println("exp: " + "Harald" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Jerry", 30, 3),
                        new Fighter("Harald", 20, 5),
                        "Jerry"));

        System.out.println("exp: " + "Harald" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Jerry", 30, 3),
                        new Fighter("Harald", 20, 5),
                        "Harald"));

        System.out.println("exp: " + "Mark" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Mark", 40, 8),
                        new Fighter("Paul", 25, 10),
                        "Mark"));

        System.out.println("exp: " + "Paul" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Mark", 40, 8),
                        new Fighter("Paul", 25, 10),
                        "Paul"));

        System.out.println("exp: " + "Anna" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Anna", 60, 12),
                        new Fighter("Sophie", 50, 15),
                        "Sophie"));

        System.out.println("exp: " + "Anna" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Anna", 60, 12),
                        new Fighter("Sophie", 50, 15),
                        "Anna"));

        System.out.println("exp: " + "Victor" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Victor", 70, 20),
                        new Fighter("Chris", 100, 5),
                        "Victor"));

        System.out.println("exp: " + "Victor" + " | act: " +
                TwoFightersSecondTry.declareWinner(
                        new Fighter("Victor", 70, 20),
                        new Fighter("Chris", 100, 5),
                        "Chris"));
    }
}
