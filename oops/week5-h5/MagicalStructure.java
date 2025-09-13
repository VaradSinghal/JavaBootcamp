import java.util.UUID;

public class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;

    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    // Main constructor
    public MagicalStructure(String structureName, String location, int magicPower, boolean isActive) {
        if(structureName == null || structureName.isEmpty()) throw new IllegalArgumentException("Name required");
        if(location == null || location.isEmpty()) throw new IllegalArgumentException("Location required");
        if(magicPower < MIN_MAGIC_POWER || magicPower > MAX_MAGIC_POWER) throw new IllegalArgumentException("Invalid magic power");

        this.structureId = UUID.randomUUID().toString();
        this.constructionTimestamp = System.currentTimeMillis();
        this.structureName = structureName;
        this.location = location;
        this.magicPower = magicPower;
        this.isActive = isActive;
        this.currentMaintainer = "Unknown";
    }

    public MagicalStructure(String structureName, String location, int magicPower) {
        this(structureName, location, magicPower, true);
    }

    public MagicalStructure(String structureName, String location) {
        this(structureName, location, 100, true);
    }

    // Getters and setters
    public String getStructureId() { return structureId; }
    public long getConstructionTimestamp() { return constructionTimestamp; }
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }

    public int getMagicPower() { return magicPower; }
    public void setMagicPower(int magicPower) {
        if(magicPower < MIN_MAGIC_POWER || magicPower > MAX_MAGIC_POWER) return;
        this.magicPower = magicPower;
    }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public String getCurrentMaintainer() { return currentMaintainer; }
    public void setCurrentMaintainer(String maintainer) { this.currentMaintainer = maintainer; }

    @Override
    public String toString() {
        return structureName + " at " + location + " [Power: " + magicPower + "]";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof MagicalStructure)) return false;
        return structureId.equals(((MagicalStructure)o).structureId);
    }

    @Override
    public int hashCode() { return structureId.hashCode(); }
}
