import java.util.*;

public final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String kingdomName, int foundingYear, String[] allowedStructureTypes, Map<String, Integer> resourceLimits) {
        if(kingdomName == null || kingdomName.isEmpty()) throw new IllegalArgumentException("Kingdom name required");
        if(foundingYear <= 0) throw new IllegalArgumentException("Invalid founding year");
        if(allowedStructureTypes == null || allowedStructureTypes.length == 0) throw new IllegalArgumentException("Allowed structures required");
        if(resourceLimits == null || resourceLimits.isEmpty()) throw new IllegalArgumentException("Resource limits required");

        this.kingdomName = kingdomName;
        this.foundingYear = foundingYear;
        this.allowedStructureTypes = allowedStructureTypes.clone();
        this.resourceLimits = new HashMap<>(resourceLimits);
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return allowedStructureTypes.clone(); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }

    public static KingdomConfig createDefaultKingdom() {
        String[] structures = {"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"};
        Map<String, Integer> resources = Map.of("Gold", 1000, "Mana", 500, "Stone", 800);
        return new KingdomConfig("Avaloria", 1000, structures, resources);
    }

    public static KingdomConfig createFromTemplate(String type) {
        switch(type) {
            case "Fortress":
                return new KingdomConfig("Fortuna", 1200, new String[]{"EnchantedCastle","DragonLair"}, Map.of("Gold",2000,"Stone",1500,"Mana",200));
            default:
                return createDefaultKingdom();
        }
    }

    @Override
    public String toString() {
        return kingdomName + " (" + foundingYear + ")";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof KingdomConfig)) return false;
        return kingdomName.equals(((KingdomConfig)o).kingdomName);
    }

    @Override
    public int hashCode() {
        return kingdomName.hashCode();
    }
}
