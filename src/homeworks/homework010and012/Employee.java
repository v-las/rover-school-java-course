package homeworks.homework010and012;

public abstract class Employee {
    private String name;
    private final int baseDayRate;

    public Employee(String name, int baseDayRate) {
        this.name = name;
        this.baseDayRate = baseDayRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDayRate() {
        return baseDayRate;
    }

    public abstract double getDayRate();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", baseDayRate=" + baseDayRate +
                '}';
    }
}
