package homeworks.homework010;

public class Main {
    public static void main(String[] args) {
        int baseSalary = 10000;

        Employee[] employees = new Employee[10];
        Worker[] workers = new Worker[10];
        Manager[] managers = new Manager[10];
        Director[] directors = new Director[10];

        employees[0] = new Employee("Alice Johnson", baseSalary);
        employees[1] = new Employee("Bob Smith", baseSalary);
        employees[2] = new Employee("Clara Lee", baseSalary);
        employees[3] = new Employee("David Brown", baseSalary);
        employees[4] = new Employee("Eva Green", baseSalary);
        employees[5] = new Employee("Frank White", baseSalary);
        employees[6] = new Employee("Grace Kim", baseSalary);
        employees[7] = new Employee("Henry Adams", baseSalary);
        employees[8] = new Employee("Ivy Clark", baseSalary);
        employees[9] = new Employee("Jack Turner", baseSalary);

        workers[0] = new Worker("Liam Scott", baseSalary);
        workers[1] = new Worker("Mia Evans", baseSalary);
        workers[2] = new Worker("Noah Hill", baseSalary);
        workers[3] = new Worker("Olivia Baker", baseSalary);
        workers[4] = new Worker("Paul Carter", baseSalary);
        workers[5] = new Worker("Quinn Foster", baseSalary);
        workers[6] = new Worker("Ruby Ward", baseSalary);
        workers[7] = new Worker("Sam Hughes", baseSalary);
        workers[8] = new Worker("Tina Russell", baseSalary);
        workers[9] = new Worker("Uma Price", baseSalary);

        managers[0] = new Manager("Victor Long", baseSalary, 7);
        managers[1] = new Manager("Wendy Cole", baseSalary, 12);
        managers[2] = new Manager("Xander Fox", baseSalary, 3);
        managers[3] = new Manager("Yara Stone", baseSalary, 9);
        managers[4] = new Manager("Zane Knight", baseSalary, 15);
        managers[5] = new Manager("Anna Bell", baseSalary, 4);
        managers[6] = new Manager("Brian Reed", baseSalary, 11);
        managers[7] = new Manager("Cindy Lane", baseSalary, 8);
        managers[8] = new Manager("Derek Shaw", baseSalary, 14);
        managers[9] = new Manager("Ella Ross", baseSalary, 6);

        directors[0] = new Director("Franklin Pierce", baseSalary, 23);
        directors[1] = new Director("Gloria Hunt", baseSalary, 47);
        directors[2] = new Director("Harrison Wells", baseSalary, 31);
        directors[3] = new Director("Isabel Moore", baseSalary, 28);
        directors[4] = new Director("Jason Clark", baseSalary, 50);
        directors[5] = new Director("Katherine Young", baseSalary, 36);
        directors[6] = new Director("Leonard Fox", baseSalary, 42);
        directors[7] = new Director("Monica Gray", baseSalary, 21);
        directors[8] = new Director("Nathan Price", baseSalary, 39);
        directors[9] = new Director("Olga Bennett", baseSalary, 44);

        Employee[][] allStaff = {employees, workers, managers, directors};

        for (Employee[] group : allStaff) {
            for (Employee e : group) {
                System.out.println(e);
                if (e instanceof Manager m) {
                    System.out.printf("Имя: %s, Базовая зарплата: %d, Подчинённые: %d, Бонус: %.2f%n",
                            m.getName(), m.getBaseSalary(), m.getNumberOfSubordinates(), m.getBonus());
                } else {
                    System.out.printf("Имя: %s, Базовая зарплата: %d%n", e.getName(), e.getBaseSalary());
                }
                e.setName(e.getName() + " [Updated]");
                if (e instanceof Manager m) m.setNumberOfSubordinates(m.getNumberOfSubordinates() + 1);
                System.out.printf("Зарплата: %.2f, Обновленный сотрудник: %s%n%n", e.getSalary(), e);
            }
        }

        // Демонстрация методов Utils
        Employee[] allEmployees = new Employee[40];
        int index = 0;
        for (Employee[] group : allStaff) {
            for (Employee e : group) allEmployees[index++] = e;
        }

        System.out.println("=== Демонстрация Utils ===");

        System.out.println("Поиск по имени Emp1 Updated: " +
                Utils.findByName("Emp1 Updated", allEmployees));

        System.out.println("Поиск по части имени 'Worker': " +
                Utils.findByNameChunk("Worker", allEmployees));

        System.out.printf("Общий бюджет зарплат: %.2f%n", Utils.sumSalary(allEmployees));
        System.out.printf("Минимальная зарплата: %.2f%n", Utils.getMinSalary(allEmployees));
        System.out.printf("Максимальная зарплата: %.2f%n", Utils.getMaxSalary(allEmployees));

        System.out.printf("Минимальное количество подчинённых: %d%n", Utils.getMinSubordinates(managers));
        System.out.printf("Максимальное количество подчинённых: %d%n", Utils.getMaxSubordinates(managers));
        System.out.printf("Минимальная надбавка: %.2f%n", Utils.getMinBonus(directors));
        System.out.printf("Максимальная надбавка: %.2f%n", Utils.getMaxBonus(directors));

        System.out.printf("Директор с минимальным количеством подчиненных: %s%n", Utils.findManagerWithMinSubordinates(directors));
        System.out.printf("Директор с максимальным количеством подчиненных: %s%n", Utils.findManagerWithMaxSubordinates(directors));
    }
}
