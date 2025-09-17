package homeworks.homework010;

public class Worker extends Employee {

    public Worker(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getSalary() {
        return super.getBaseSalary();
    }
}
