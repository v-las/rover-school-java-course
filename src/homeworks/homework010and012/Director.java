package homeworks.homework010and012;

public class Director extends Manager {

    public Director(String name, int baseDayRate, int numberOfSubordinates) {
        super(name, baseDayRate, numberOfSubordinates);
    }

    @Override
    public double getBonus() {
        return super.getBaseDayRate() * (double) super.getNumberOfSubordinates() / 100 * 9;
    }

    @Override
    public String toString() {
        return "Director{} " + super.toString();
    }
}
