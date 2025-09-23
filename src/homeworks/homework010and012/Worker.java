package homeworks.homework010and012;

public class Worker extends Employee {

    public Worker(String name, int baseDayRate) {
        super(name, baseDayRate);
    }

    @Override
    public double getDayRate() {
        return this.getBaseDayRate();
    }

    @Override
    public String toString() {
        return "Worker{} " + super.toString();
    }
}
