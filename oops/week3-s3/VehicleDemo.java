class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Fuel level: " + fuelLevel);
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Info: " + year + " " + make + " " + model + " | Fuel: " + fuelLevel);
    }
}

class Car extends Vehicle {
    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

    @Override
    public void startVehicle() {
        System.out.println("Car " + make + " " + model + " is now running smoothly.");
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

    @Override
    public void startVehicle() {
        System.out.println("Truck " + make + " " + model + " rumbles to life.");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

    @Override
    public void startVehicle() {
        System.out.println("Motorcycle " + make + " " + model + " revs loudly.");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota", "Corolla", 2020, 50);
        Vehicle v2 = new Truck("Ford", "F-150", 2018, 70);
        Vehicle v3 = new Motorcycle("Yamaha", "R15", 2022, 30);

        Vehicle[] vehicles = {v1, v2, v3};

        for (Vehicle v : vehicles) {
            v.startVehicle();      
            v.displayVehicleInfo(); 
            v.refuel(10);
            v.stopVehicle();
            System.out.println("--------------------");
        }
    }
}
