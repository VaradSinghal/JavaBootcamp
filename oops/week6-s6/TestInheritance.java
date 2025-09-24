class Vehicle{
    void start(){
        System.out.println("Vehicle is starting..");
    }

    void stop(){
        System.out.println("Vehicle is stopping");
    }
}
class Car extends Vehicle{
    void music(){
        System.out.println("Plays Music");
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.music();
    }
}
