import java.util.Random;

public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }


    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    private String generateRegistrationNumber() {
        Random rand = new Random();
        return "REG-" + (1000 + rand.nextInt(9000));
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Vehicle Info: " + brand + " " + model + " (" + year + 
               "), Engine: " + engineType + ", Reg#: " + registrationNumber;
    }

    public void displaySpecs() {
        System.out.println("Specs:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
class Car extends Vehicle {
   
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }


    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); 
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

  
    @Override
    public void start() {
        super.start(); 
        System.out.println("Car-specific startup sequence complete");
    }


    @Override
    public void displaySpecs() {
        super.displaySpecs(); 
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

 
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

  
    public static void main(String[] args) {
        System.out.println("=== Test 1: Default Constructor ===");
        Car car1 = new Car();
        car1.displaySpecs();
        System.out.println(car1.getVehicleInfo());

        System.out.println("\n=== Test 2: Parameterized Constructor ===");
        Car car2 = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Petrol", "Automatic");
        car2.displaySpecs();
        System.out.println(car2.getVehicleInfo());

        System.out.println("\n=== Test 3: Inherited Methods ===");
        car2.start(); 
        System.out.println("Is running? " + car2.isRunning());
        car2.stop();
        System.out.println("Is running? " + car2.isRunning());

        System.out.println("\n=== Test 4: Car-specific Methods ===");
        car2.openTrunk();
        car2.playRadio();

        System.out.println("\n=== Test 5: Protected Field Access ===");
        System.out.println("Brand accessed from subclass: " + car2.brand);

        System.out.println("\n=== Test 6: Polymorphism ===");
        Vehicle v = new Car("Honda", "Civic", 2021, "Petrol", 4, "Petrol", "CVT");
        v.start();        
        v.displaySpecs(); 
        System.out.println(v.getVehicleInfo());
    }
}
