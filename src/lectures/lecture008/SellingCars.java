package lectures.lecture008;

public class SellingCars {
    public static void main(String[] args) {
        Car pacifica = new Car("Chrysler", "Pacifica", 80000, 2014);
        Car accord = new Car("Honda", "Accord", 120000, 2007);

        CarSaleAd ad1 = new CarSaleAd(accord, 8000, "06-Sep-25");
        CarSaleAd ad2 = new CarSaleAd(pacifica, 18000, "10-Sep-25");

        System.out.println(forSaleAd(ad1));
        System.out.println(forSaleAd(ad2));

        Car[] carsFoeSale = {
                pacifica,
                accord,
                new Car("Mazda", "3", 2023, 1000),
                new Car("Toyota", "Camry", 50000, 2018),
                new Car("Honda", "Civic", 30000, 2019),
                new Car("Ford", "Focus", 70000, 2017),
                new Car("Chevrolet", "Malibu", 40000, 2020),
                new Car("Nissan", "Altima", 60000, 2016),
                new Car("Hyundai", "Elantra", 20000, 2021),
                new Car("BMW", "3 Series", 80000, 2015),
                new Car("Audi", "A4", 45000, 2019),
                new Car("Mercedes", "C-Class", 55000, 2018),
                new Car("Volkswagen", "Passat", 35000, 2020)
        };

        // Проверка вывода
        for (Car car : carsFoeSale) {
            System.out.println(car);
        }
    }

    public static String forSaleAd(CarSaleAd ad) {
        Car car = ad.car;
        return "-----------------------\n" +
                "FOR SALE: only $" + ad.price + "!!!\n" +
                "-----------------------\n" +
                "Rare find! Good price!\n" +
                car.year + " " + car.make + " " + car.model + "\n" +
                "Sale starts on " + ad.saleStart + "\n" +
                "Only " + car.mileage + " miles!\n";
    }
}
