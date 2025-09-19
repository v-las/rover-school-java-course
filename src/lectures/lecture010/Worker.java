package lectures.lecture010;

public class Worker extends Person {
    private int salary;

    public Worker(String name, int age, char sex, int salary) {
        super(name, age, sex);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
