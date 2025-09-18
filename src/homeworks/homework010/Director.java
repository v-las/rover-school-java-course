package homeworks.homework010;

public class Director extends Manager {

    public Director(String name, int baseSalary, int numberOfSubordinates) {
        super(name, baseSalary, numberOfSubordinates);
    }

    @Override
    public double getBonus() {
        return super.getBaseSalary() * (double) super.getNumberOfSubordinates() / 100 * 9;
    }

    @Override
    public String toString() {
        return "Director{} " + super.toString();
    }
}
