class Vehicle{
    void start(){
        System.out.println("Vehicle starts...");
    }
}

class Car extends Vehicle{
    @Override
    void start(){
        System.out.println("Car starts with a key ignition...");
    }
}

class ElectricCar extends Car{
    @Override
    void start(){
        System.out.println("Electric car starts");
    }
}

public class MethodOverridingDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();
        Vehicle v3 = new ElectricCar();

        v1.start();
        v2.start();
        v3.start();
    }
}
