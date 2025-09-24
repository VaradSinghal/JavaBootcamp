public class Animal {
   
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;


    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

  
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
               ", Lifespan: " + lifespan + " years, Wildlife: " + isWildlife;
    }
}


class Mammal extends Animal {
  
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

   
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true;
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }


    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

  
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}


class Dog extends Mammal {

    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel; 
    private String favoriteActivity;

 
    public Dog(String breed) {
        super("Dog", "Domestic", 13, false, "Various", 60);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 7;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating basic " + breed + " dog");
    }

 
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating detailed " + breed + " dog");
    }

 
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog constructor: Copying " + other.breed + " dog");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }


    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Dog's loyalty level: " + loyaltyLevel + "/10");
    }

    public void demonstrateInheritance() {
        System.out.println("\n=== Demonstrating Inheritance Chain ===");
        eat();    
        sleep();  
        move();  
        nurse(); 
        regulateTemperature(); 
        System.out.println(getAnimalInfo()); 
    }

  
    public static void main(String[] args) {
        System.out.println("=== Test 1: Basic Constructor ===");
        Dog d1 = new Dog("Labrador");
        d1.demonstrateInheritance();
        d1.bark();
        d1.fetch();
        d1.showLoyalty();

        System.out.println("\n=== Test 2: Detailed Constructor ===");
        Dog d2 = new Dog("Dog", "Household", 15, false,
                         "Brown", 63, "Beagle", true, 9, "Chasing squirrels");
        d2.demonstrateInheritance();

        System.out.println("\n=== Test 3: Copy Constructor ===");
        Dog d3 = new Dog(d2);
        d3.demonstrateInheritance();

        System.out.println("\n=== Test 4: instanceof Relationships ===");
        System.out.println("d1 instanceof Dog? " + (d1 instanceof Dog));
        System.out.println("d1 instanceof Mammal? " + (d1 instanceof Mammal));
        System.out.println("d1 instanceof Animal? " + (d1 instanceof Animal));
    }
}
