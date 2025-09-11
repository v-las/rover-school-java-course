package homeworks.homework002oop;

import java.util.Arrays;

public class Pirate {
    private String name;
    private String[] rank;

    public Pirate(String name, String[] rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return Arrays.toString(rank) + " " + name;
    }

    public String getName() {
        return name;
    }

    public String[] getRank() {
        return rank;
    }
}
