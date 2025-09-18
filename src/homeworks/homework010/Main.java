package homeworks.homework010;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        Worker[] workers = new Worker[10];
        Manager[] managers = new Manager[10];
        Director[] directors = new Director[10];

        for (int i = 0; i < 10; i++) {
            employees[i] = new Employee("Emp" + (i + 1), 40000 + i * 1000);
            workers[i] = new Worker("Worker" + (i + 1), 45000 + i * 1000);
            managers[i] = new Manager("Manager" + (i + 1), 60000 + i * 2000, 3 + i);
            directors[i] = new Director("Director" + (i + 1), 90000 + i * 3000, 15 + i);
        }

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
                e.setName(e.getName() + " Updated");
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
        System.out.printf("Минимальная надбавка: %.2f%n", Utils.getMinBonus(managers));
        System.out.printf("Максимальная надбавка: %.2f%n", Utils.getMaxBonus(managers));
    }
}
