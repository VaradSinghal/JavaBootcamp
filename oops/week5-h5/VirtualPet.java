import java.util.UUID;

public class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    private String petName;
    private int age;
    private int happiness;
    private int health;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Baby", "Teen", "Adult"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    // Main constructor
    public VirtualPet(String petName, PetSpecies species, int age, int happiness, int health) {
        if(species == null) throw new IllegalArgumentException("Species cannot be null");
        this.petId = generatePetId();
        this.species = species;
        this.birthTimestamp = System.currentTimeMillis();

        this.petName = petName != null ? petName : "Unknown";
        this.age = age >= 0 ? age : 0;
        this.happiness = validateStat(happiness);
        this.health = validateStat(health);

        checkEvolution();
    }

    // Constructor chaining
    public VirtualPet(String petName, PetSpecies species) {
        this(petName, species, 1, 50, 50);
    }

    public VirtualPet(String petName) {
        this(petName, new PetSpecies("DefaultPet", DEFAULT_EVOLUTION_STAGES, 10, "Home"));
    }

    public VirtualPet() {
        this("RandomPet");
    }

    // JavaBean getters and setters
    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName != null ? petName : this.petName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age >= 0 ? age : this.age; }

    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { this.happiness = validateStat(happiness); }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = validateStat(health); }

    public String getPetId() { return petId; }
    public PetSpecies getSpecies() { return species; }
    public long getBirthTimestamp() { return birthTimestamp; }

    // Public methods
    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHealth(bonus);
        modifyHappiness(bonus/2);
        System.out.println(petName + " has been fed " + foodType);
    }

    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
        modifyHealth(-effect/5);
        System.out.println(petName + " played " + gameType);
    }

    // Package-private for debugging
    int[] getInternalState() {
        return new int[]{age, happiness, health};
    }

    @Override
    public String toString() {
        return "VirtualPet{" + "petId='" + petId + '\'' + ", name='" + petName + '\'' +
                ", species=" + species + ", age=" + age + ", happiness=" + happiness + ", health=" + health + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof VirtualPet)) return false;
        return petId.equals(((VirtualPet)o).petId);
    }

    @Override
    public int hashCode() {
        return petId.hashCode();
    }

    // Protected/internal helpers
    protected int calculateFoodBonus(String foodType) {
        return foodType.length() * 2; // simple example
    }

    protected int calculateGameEffect(String gameType) {
        return gameType.length(); // simple example
    }

    // Private helpers
    private void modifyHappiness(int delta) {
        happiness = validateStat(happiness + delta);
        checkEvolution();
    }

    private void modifyHealth(int delta) {
        health = validateStat(health + delta);
        checkEvolution();
    }

    private void checkEvolution() {
        // placeholder logic
        int stageIndex = Math.min(age / 5, species.getEvolutionStages().length - 1);
        String stage = species.getEvolutionStages()[stageIndex];
    }

    private int validateStat(int value) {
        return Math.max(0, Math.min(100, value));
    }

    private String generatePetId() {
        return UUID.randomUUID().toString();
    }
}
