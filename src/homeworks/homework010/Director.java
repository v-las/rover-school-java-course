package homeworks.homework010;

public class Director extends Manager {

    public Director(String name, int baseSalary, int numberOfSubordinates) {
        super(name, baseSalary, numberOfSubordinates);
    }

    @Override
    public double getSalary() {
        double bonus = (double) this.getNumberOfSubordinates() / 100 * 9;
        return super.getBaseSalary() + super.getBaseSalary() * bonus;
    }
}
