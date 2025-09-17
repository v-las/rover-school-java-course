package homeworks.homework010;

public class Main {
    public static void main(String[] args) {
        // === Демонстрация Employee ===
        System.out.println("===== Employee =====");
        Employee emp = new Employee("Алексей", 40000);
        System.out.println("Имя: " + emp.getName());
        System.out.println("Базовая ставка: " + emp.getBaseSalary());
        System.out.println("Зарплата: " + emp.getSalary());

        emp.setName("Александр");
        emp.setBaseSalary(45000);
        System.out.println("Новое имя: " + emp.getName());
        System.out.println("Новая базовая ставка: " + emp.getBaseSalary());
        System.out.println("Зарплата после изменений: " + emp.getSalary());

        // === Демонстрация Worker ===
        System.out.println("\n===== Worker =====");
        Worker worker = new Worker("Иван", 50000);
        System.out.println("Имя: " + worker.getName());
        System.out.println("Базовая ставка: " + worker.getBaseSalary());
        System.out.println("Зарплата (равна базовой): " + worker.getSalary());

        worker.setBaseSalary(52000);
        System.out.println("После изменения ставки: " + worker.getSalary());

        // === Демонстрация Manager ===
        System.out.println("\n===== Manager =====");
        Manager manager = new Manager("Мария", 70000, 10);
        System.out.println("Имя: " + manager.getName());
        System.out.println("Базовая ставка: " + manager.getBaseSalary());
        System.out.println("Количество подчинённых: " + manager.getNumberOfSubordinates());
        System.out.println("Зарплата: " + manager.getSalary());

        manager.setNumberOfSubordinates(0);
        System.out.println("Подчинённых теперь: " + manager.getNumberOfSubordinates());
        System.out.println("Зарплата без подчинённых: " + manager.getSalary());

        manager.setNumberOfSubordinates(20);
        System.out.println("Подчинённых теперь: " + manager.getNumberOfSubordinates());
        System.out.println("Зарплата с 20 подчинёнными: " + manager.getSalary());

        // === Демонстрация Director ===
        System.out.println("\n===== Director =====");
        Director director = new Director("Олег", 100000, 30);
        System.out.println("Имя: " + director.getName());
        System.out.println("Базовая ставка: " + director.getBaseSalary());
        System.out.println("Количество подчинённых: " + director.getNumberOfSubordinates());
        System.out.println("Зарплата: " + director.getSalary());

        director.setNumberOfSubordinates(0);
        System.out.println("Подчинённых теперь: " + director.getNumberOfSubordinates());
        System.out.println("Зарплата без подчинённых: " + director.getSalary());

        director.setNumberOfSubordinates(50);
        System.out.println("Подчинённых теперь: " + director.getNumberOfSubordinates());
        System.out.println("Зарплата с 50 подчинёнными: " + director.getSalary());

        // === Демонстрация полиморфизма ===
        System.out.println("\n===== Полиморфизм =====");
        Employee[] employees = {emp, worker, manager, director};
        for (Employee e : employees) {
            System.out.println(e.getClass().getSimpleName() + " " + e.getName() +
                    " получает зарплату: " + e.getSalary());
        }
    }
}
