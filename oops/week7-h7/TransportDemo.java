abstract class Vehicle {
    protected String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public abstract void dispatch();
}

class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String id, int passengerCapacity) {
        super(id);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void dispatch() {
        System.out.println("Bus [" + id + "] dispatched on fixed route | Capacity: " + passengerCapacity + " passengers");
    }
}

class Taxi extends Vehicle {
    private double farePerKm;

    public Taxi(String id, double farePerKm) {
        super(id);
        this.farePerKm = farePerKm;
    }

    @Override
    public void dispatch() {
        System.out.println("Taxi [" + id + "] available for door-to-door service | Fare per km: ₹" + farePerKm);
    }
}

class Train extends Vehicle {
    private int cars;

    public Train(String id, int cars) {
        super(id);
        this.cars = cars;
    }

    @Override
    public void dispatch() {
        System.out.println("Train [" + id + "] dispatched on schedule | Cars: " + cars);
    }
}

class Bike extends Vehicle {
    public Bike(String id) {
        super(id);
    }

    @Override
    public void dispatch() {
        System.out.println("Bike [" + id + "] ready for short-distance eco-friendly trips");
    }
}

public class TransportDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[4];
        fleet[0] = new Bus("B101", 50);
        fleet[1] = new Taxi("T202", 25.0);
        fleet[2] = new Train("TR303", 8);
        fleet[3] = new Bike("BK404");

        for (Vehicle v : fleet) {
            v.dispatch();
        }
    }
}
