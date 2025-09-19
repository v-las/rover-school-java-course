package lectures.lecture010;

public class Manager extends Worker {
    private int workerCount;

    public Manager(String name, int age, char sex, int salary, int workerCount) {
        super(name, age, sex, salary);
        this.workerCount = workerCount;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }

    @Override
    public int getSalary() {
        return (int) (super.getSalary() + super.getSalary() * (workerCount / 100.0 * 3));
    }

    @Override
    public String toString() {
        return "Manager{" +
                "workerCount=" + workerCount +
                "} " + super.toString();
    }
}
