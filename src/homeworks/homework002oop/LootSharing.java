package homeworks.homework002oop;

import java.util.Arrays;

public class LootSharing {
        /*        Задача №3.
       Создать программу дележа добычи на пиратском корабле. По обычаю, половина добычи идет
    владельцу корабля, половина оставшегося — капитану, остальное делится поровну между всеми
    членами команды, включая капитана.
       Размер добычи (например, в пиастрах) и количество пиратов на корабле задать переменными.
       Вывести на экран кому сколько пиастров полагается
       Сколько получит капитан (Джек Воробей, естественно), если он утверждает, что корабль
    принадлежит ему?*/
    /*
    дележ добычи
    формула дележа
    */

    public static void main(String[] args) {
        Pirate jack = new Pirate("Jack", new String[]{
                "CREW_MEMBER", "SHIP_OWNER", "CAPTAIN"
        });
        System.out.println("jack = " + jack.toString());

        Loot loot = new Loot(10000);
        PirateCrew pirateCrew = new PirateCrew(50);

        System.out.println("shareLoot: " + shareLoot(loot.getTotalLoot(), pirateCrew.getCrewSize(), jack.getRank()));
    }

    public static int shareLoot(int loot, int crewSize, String[] rank) {
        return Arrays.stream(rank).reduce(
                0,
                (share, r) -> share + switch (r) {
                    case "CREW_MEMBER" -> loot / 2 / 2 / crewSize;
                    case "CAPTAIN" -> loot / 2 / 2;
                    case "SHIP_OWNER" -> loot / 2;
                    default -> 0;
                },
                Integer::sum
        );
    }
}
