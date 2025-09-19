package lectures.lecture010;

public class Main {
    public static void main(String[] args) {

        Person[] people = {
                new Person("Sergey", 30, 'm'),
                new Person("Sergey", 30),
                new Person("Sergey"),
                new Person(),
        };

        for (Person p : people) {
            System.out.println("p = " + p);
        }

        Manager manager = new Manager("Vas", 52, 'm', 100000, 20);

        System.out.println("manager = " + manager);

        System.out.println("manager.getSalary() = " + manager.getSalary());
    }
}
