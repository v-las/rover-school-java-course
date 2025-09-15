package lectures.lecture009;

public class Worker extends Person {
    private int salary;

    public Worker(String name, int age, char sex, int salary) {
        super(name, age, sex);
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }
}
