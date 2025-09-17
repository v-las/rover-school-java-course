package homeworks.homework010;

public class Manager extends Employee {

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

    @Override
    public double getSalary() {
        double bonus = (double) numberOfSubordinates / 100 * 3;
        return super.getBaseSalary() + super.getBaseSalary() * bonus;
    }
}
