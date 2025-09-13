
abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Unknown", true);
    }

    MagicalStructure(String structureName, int magicPower, String location) {
        this(structureName, magicPower, location, true);
    }

    MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    WizardTower(String name, int power) {
        super(name, power);
        this.spellCapacity = 5;
        this.knownSpells = new String[]{"Fireball"};
    }

    WizardTower(String name, int power, String[] spells) {
        super(name, power);
        this.spellCapacity = spells.length;
        this.knownSpells = spells;
    }

    WizardTower(String name, int power, int spellCapacity, String[] spells) {
        super(name, power);
        this.spellCapacity = spellCapacity;
        this.knownSpells = spells;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts a spell from its tower!");
    }
}

class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    EnchantedCastle(String name, int power) {
        super(name, power);
        this.defenseRating = 50;
        this.hasDrawbridge = false;
    }

    EnchantedCastle(String name, int power, boolean drawbridge) {
        super(name, power);
        this.defenseRating = 100;
        this.hasDrawbridge = drawbridge;
    }

    EnchantedCastle(String name, int power, int defenseRating, boolean drawbridge) {
        super(name, power);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = drawbridge;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " activates castle defenses!");
    }
}

class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    MysticLibrary(String name, int power) {
        super(name, power);
        this.bookCount = 100;
        this.ancientLanguage = "None";
    }

    MysticLibrary(String name, int power, int bookCount) {
        super(name, power);
        this.bookCount = bookCount;
        this.ancientLanguage = "Unknown";
    }

    MysticLibrary(String name, int power, int bookCount, String language) {
        super(name, power);
        this.bookCount = bookCount;
        this.ancientLanguage = language;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts wisdom spell from ancient books!");
    }
}

class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    DragonLair(String name, int power, String dragonType) {
        super(name, power);
        this.dragonType = dragonType;
        this.treasureValue = 1000;
    }

    DragonLair(String name, int power, String dragonType, int treasureValue) {
        super(name, power);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon flames!");
    }
}

class KingdomManager {
    static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return !(s1 instanceof DragonLair && s2 instanceof DragonLair);
    }

    static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        return attacker.magicPower > defender.magicPower
                ? attacker.structureName + " defeats " + defender.structureName
                : defender.structureName + " withstands attack from " + attacker.structureName;
    }

    static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int totalPower = 0;
        int towerCount = 0;
        boolean hasLibrary = false;
        boolean hasCastle = false;
        boolean hasLair = false;

        for (MagicalStructure s : structures) {
            totalPower += s.magicPower;
            if (s instanceof WizardTower) towerCount++;
            if (s instanceof MysticLibrary) hasLibrary = true;
            if (s instanceof EnchantedCastle) hasCastle = true;
            if (s instanceof DragonLair) hasLair = true;
        }

        if (towerCount > 1) totalPower += 50; // Magic network
        if (towerCount > 0 && hasLibrary) totalPower += 100; // Knowledge boost
        if (hasCastle && hasLair) totalPower += 150; // Dragon guard

        return totalPower;
    }

    static void categorizeStructures(MagicalStructure[] structures) {
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) System.out.println(s.structureName + " is a Wizard Tower");
            else if (s instanceof EnchantedCastle) System.out.println(s.structureName + " is an Enchanted Castle");
            else if (s instanceof MysticLibrary) System.out.println(s.structureName + " is a Mystic Library");
            else if (s instanceof DragonLair) System.out.println(s.structureName + " is a Dragon Lair");
        }
    }
}

public class KingdomSystem {
    public static void main(String[] args) {
        MagicalStructure t1 = new WizardTower("Tower A", 120, new String[]{"Fireball", "Lightning"});
        MagicalStructure l1 = new MysticLibrary("Library A", 90, 500, "Elder Tongue");
        MagicalStructure c1 = new EnchantedCastle("Castle A", 150, true);
        MagicalStructure d1 = new DragonLair("Dragon Lair A", 200, "Fire Dragon", 5000);

        MagicalStructure[] kingdom = {t1, l1, c1, d1};

        KingdomManager.categorizeStructures(kingdom);
        System.out.println("Kingdom Total Magic Power: " + KingdomManager.calculateKingdomMagicPower(kingdom));
        System.out.println(KingdomManager.performMagicBattle(t1, d1));
    }
}
