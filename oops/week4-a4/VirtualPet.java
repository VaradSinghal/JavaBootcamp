import java.util.*;

public class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String currentStage;
    private boolean isGhost;

    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;




    public VirtualPet() {
        this("Unknown", randomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }


    public VirtualPet(String petName) {
        this(petName, randomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, EVOLUTION_STAGES[2]);
    }


    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.currentStage = stage;
        this.isGhost = false;
        totalPetsCreated++;
    }

    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString();
    }

    private static String randomSpecies() {
        String[] speciesList = {"Dragon", "Cat", "Dog", "Phoenix", "Unicorn"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }

    public void feedPet() {
        if (!isGhost) {
            happiness += 5;
            health += 5;
            System.out.println(petName + " has been fed.");
        } else {
            System.out.println(petName + " is a ghost and cannot eat!");
        }
    }

    public void playWithPet() {
        if (!isGhost) {
            happiness += 10;
            health -= 2;
            System.out.println(petName + " played and is happier!");
        } else {
            System.out.println(petName + " is a ghost and only haunts now...");
        }
    }

    public void healPet() {
        if (!isGhost) {
            health += 15;
            System.out.println(petName + " has been healed.");
        } else {
            System.out.println(petName + " is a ghost and beyond healing!");
        }
    }

    public void evolvePet() {
        if (isGhost) {
            System.out.println(petName + " is a ghost and cannot evolve.");
            return;
        }
        int stageIndex = Arrays.asList(EVOLUTION_STAGES).indexOf(currentStage);
        if (stageIndex < EVOLUTION_STAGES.length - 1 && age > stageIndex * 2 && health > 20 && happiness > 20) {
            currentStage = EVOLUTION_STAGES[stageIndex + 1];
            System.out.println(petName + " has evolved into " + currentStage + " stage!");
        }
    }

    public void simulateDay() {
        if (isGhost) {
            System.out.println(petName + " haunts the daycare...");
            return;
        }
        age++;
        happiness -= new Random().nextInt(5);
        health -= new Random().nextInt(5);

        if (health <= 0) {
            isGhost = true;
            species = "Ghost";
            currentStage = "Ghost";
            System.out.println(petName + " has died and become a Ghost!");
        } else {
            evolvePet();
        }
    }

    public String getPetStatus() {
        return isGhost ? petName + " the Ghost is haunting." :
                petName + " (" + species + ") - Stage: " + currentStage +
                ", Age: " + age + ", Health: " + health + ", Happiness: " + happiness;
    }

    // --- Main ---
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();
        daycare.add(new VirtualPet());  // Egg
        daycare.add(new VirtualPet("Buddy"));  // Baby
        daycare.add(new VirtualPet("Luna", "Cat"));  // Child
        daycare.add(new VirtualPet("Max", "Dragon", 5, 80, 80, "Teen"));

        System.out.println("=== Virtual Pet Daycare Simulation ===");
        for (int day = 1; day <= 5; day++) {
            System.out.println("\n--- Day " + day + " ---");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.feedPet();
                pet.playWithPet();
                System.out.println(pet.getPetStatus());
            }
        }

        System.out.println("\nTotal pets created: " + totalPetsCreated);
    }
}
