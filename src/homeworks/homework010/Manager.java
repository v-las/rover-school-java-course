package homeworks.homework010;

public class Manager extends Worker {

    private int numberOfSubordinates;

    public Manager(String name, int baseSalary, int numberOfSubordinates) {
        super(name, baseSalary);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public double getBonus() {
        return super.getBaseSalary() * (double) numberOfSubordinates / 100 * 3;
    }

    @Override
    public double getSalary() {
        return super.getBaseSalary() + this.getBonus();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "numberOfSubordinates=" + numberOfSubordinates +
                "} " + super.toString();
    }
}
