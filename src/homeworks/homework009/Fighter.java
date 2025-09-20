package homeworks.homework009;

public class Fighter {
    public String name;
    public int health;
    public int damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    @Override
    public String toString() {
        return "[" + name +
                ", HP: " + health +
                ", DMG: " + damagePerAttack +
                ']';
    }
}