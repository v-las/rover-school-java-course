package lectures.lecture008;

public class Car {
    String make;
    String model;
    int mileage;
    int year;

    public Car(String make, String model, int mileage, int year) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + mileage + " km)";
    }
}
