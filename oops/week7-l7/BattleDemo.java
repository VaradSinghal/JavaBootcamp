abstract class GameCharacter {
    protected String name;

    public GameCharacter(String name) {
        this.name = name;
    }

    public abstract void attack();
}

class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " swings a mighty sword with high defense!");
    }
}

class Mage extends GameCharacter {
    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a powerful spell using mana!");
    }
}

class Archer extends GameCharacter {
    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " shoots a precise arrow from long range!");
    }
}

public class BattleDemo {
    public static void main(String[] args) {
        GameCharacter[] army = new GameCharacter[3];
        army[0] = new Warrior("Thor");
        army[1] = new Mage("Merlin");
        army[2] = new Archer("Legolas");

        for (GameCharacter c : army) {
            c.attack();
        }
    }
}
