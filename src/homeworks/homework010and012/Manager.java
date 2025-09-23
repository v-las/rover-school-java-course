package homeworks.homework010and012;

public class Manager extends Worker {

    private int numberOfSubordinates;

    public Manager(String name, int baseDayRate, int numberOfSubordinates) {
        super(name, baseDayRate);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public double getBonus() {
        return super.getBaseDayRate() * (double) numberOfSubordinates / 100 * 3;
    }

    @Override
    public double getDayRate() {
        return super.getBaseDayRate() + this.getBonus();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "numberOfSubordinates=" + numberOfSubordinates +
                "} " + super.toString();
    }
}
