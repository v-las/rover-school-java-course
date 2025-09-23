package homeworks.homework010and012;

public class Main {
    public static void main(String[] args) {
        int baseDayRate = 100;

        Worker[] workers = new Worker[10];
        Manager[] managers = new Manager[10];
        Director[] directors = new Director[10];

        workers[0] = new Worker("Liam Scott", baseDayRate);
        workers[1] = new Worker("Mia Evans", baseDayRate);
        workers[2] = new Worker("Noah Hill", baseDayRate);
        workers[3] = new Worker("Olivia Baker", baseDayRate);
        workers[4] = new Worker("Paul Carter", baseDayRate);
        workers[5] = new Worker("Quinn Foster", baseDayRate);
        workers[6] = new Worker("Ruby Ward", baseDayRate);
        workers[7] = new Worker("Sam Hughes", baseDayRate);
        workers[8] = new Worker("Tina Russell", baseDayRate);
        workers[9] = new Worker("Uma Price", baseDayRate);

        managers[0] = new Manager("Victor Long", baseDayRate, 7);
        managers[1] = new Manager("Wendy Cole", baseDayRate, 12);
        managers[2] = new Manager("Xander Fox", baseDayRate, 3);
        managers[3] = new Manager("Yara Stone", baseDayRate, 9);
        managers[4] = new Manager("Zane Knight", baseDayRate, 15);
        managers[5] = new Manager("Anna Bell", baseDayRate, 4);
        managers[6] = new Manager("Brian Reed", baseDayRate, 11);
        managers[7] = new Manager("Cindy Lane", baseDayRate, 8);
        managers[8] = new Manager("Derek Shaw", baseDayRate, 14);
        managers[9] = new Manager("Ella Ross", baseDayRate, 6);

        directors[0] = new Director("Franklin Pierce", baseDayRate, 23);
        directors[1] = new Director("Gloria Hunt", baseDayRate, 47);
        directors[2] = new Director("Harrison Wells", baseDayRate, 31);
        directors[3] = new Director("Isabel Moore", baseDayRate, 28);
        directors[4] = new Director("Jason Clark", baseDayRate, 50);
        directors[5] = new Director("Katherine Young", baseDayRate, 36);
        directors[6] = new Director("Leonard Fox", baseDayRate, 42);
        directors[7] = new Director("Monica Gray", baseDayRate, 21);
        directors[8] = new Director("Nathan Price", baseDayRate, 39);
        directors[9] = new Director("Olga Bennett", baseDayRate, 44);

        Employee[][] allStaff = {workers, managers, directors};

        for (Employee[] group : allStaff) {
            for (Employee e : group) {
                if (e instanceof Manager m) {
                    System.out.printf("Имя: %s, Базовая ставка: %d, Подчинённые: %d, Бонус: %.2f%n",
                            m.getName(), m.getBaseDayRate(), m.getNumberOfSubordinates(), m.getBonus());
                } else {
                    System.out.printf("Имя: %s, Базовая ставка: %d%n", e.getName(), e.getBaseDayRate());
                }
                e.setName(e.getName() + " [Updated]");
                if (e instanceof Manager m) m.setNumberOfSubordinates(m.getNumberOfSubordinates() + 1);
                System.out.printf("Ставка: %.2f, Обновленный сотрудник: %s%n%n", e.getDayRate(), e);
            }
        }

        // Демонстрация методов DayRateUtils
        Employee[] allEmployees = new Employee[30];
        int index = 0;
        for (Employee[] group : allStaff) {
            for (Employee e : group) allEmployees[index++] = e;
        }

        System.out.println("=== Демонстрация DayRateUtils ===");

        System.out.println("Поиск по имени Olivia Baker [Updated]: " +
                DayRateUtils.findByName("Olivia Baker [Updated]", allEmployees));

        System.out.println("Поиск по части имени 'Cole': " +
                DayRateUtils.findByNameChunk("Cole", allEmployees));

        System.out.printf("Общий бюджет ставок в день: %.2f%n", DayRateUtils.sumDayRates(allEmployees));
        System.out.printf("Минимальная зарплата в день: %.2f%n", DayRateUtils.getMinDayRate(allEmployees));
        System.out.printf("Максимальная зарплата в день: %.2f%n", DayRateUtils.getMaxDayRate(allEmployees));

        System.out.printf("Минимальное количество подчинённых: %d%n", DayRateUtils.getMinSubordinates(managers));
        System.out.printf("Максимальное количество подчинённых: %d%n", DayRateUtils.getMaxSubordinates(managers));
        System.out.printf("Минимальная надбавка в день: %.2f%n", DayRateUtils.getMinBonus(directors));
        System.out.printf("Максимальная надбавка в день: %.2f%n", DayRateUtils.getMaxBonus(directors));

        System.out.printf("Директор с минимальным количеством подчиненных: %s%n",
                DayRateUtils.findManagerWithMinSubordinates(directors));
        System.out.printf("Директор с максимальным количеством подчиненных: %s%n",
                DayRateUtils.findManagerWithMaxSubordinates(directors));

        System.out.printf("Общая сумма выплат за 1 квартал 2025 года: %.2f%n",
                DayRateUtils.calculateTotalSalaryForPeriod(allEmployees, MonthUtils.Q1_2025));
    }
}
