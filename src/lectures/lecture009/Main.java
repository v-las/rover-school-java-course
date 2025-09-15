package lectures.lecture009;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Sergey", 30, 'm');

        Worker worker2 = new Worker(person1.getName(), 20, 'm', 200000);

        System.out.println("worker2.name = " + worker2.getName());

        System.out.println(person1.sumPublic(1, 2));
        System.out.println(person1.sumStatic(1, 2));
        System.out.println(Person.sumStatic(1, 2));

    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
