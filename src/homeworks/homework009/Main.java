package homeworks.homework009;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Alice", 28, 'f');
        Person p2 = new Person("Bob", 35, 'm');
        Person p3 = new Person("Charlie", 22, 'x');

        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());

        Employee e1 = new Employee("Alice", 28, 'f', 5000);
        Employee e2 = new Employee("David", 40, 'm', 7000);
        Employee e3 = new Employee("Alice", 30, 'f', 6000);

        System.out.println("e1 and e2 same name? " + e1.isSameName(e2));
        System.out.println("e1 and e3 same name? " + e1.isSameName(e3));

        Employee[] employees = {e1, e2, e3};
        int totalSalary = SalaryHelper.getSum(employees);

        System.out.println("Total salary of employees: " + totalSalary);

        e1.setSalary(5500);
        System.out.println("Updated salary for e1: " + e1.getSalary());

        e2.setName("Daniel");
        System.out.println("Updated official name for e2: " + e2.getName(true));

        e3.setAge(31);
        System.out.println("Updated age for e3: " + e3.getAge());
    }
}
