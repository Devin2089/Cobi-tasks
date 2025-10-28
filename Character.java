import java.util.List;
import java.util.Objects;

public class Character {
    private final String name;
    private final String role;
    private final int maxHp;
    private int hp;
    private final int attack;
    private final int defense;
    private final boolean isHealer;
    private final boolean isRogue;
    private final boolean isRanger;
    private final boolean isWarrior;
    private final boolean isPaladin;

    public Character(String name, String role, int maxHp, int attack, int defense,
                     boolean isHealer, boolean isRogue, boolean isRanger, boolean isWarrior, boolean isPaladin) {
        this.name = name;
        this.role = role;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.isHealer = isHealer;
        this.isRogue = isRogue;
        this.isRanger = isRanger;
        this.isWarrior = isWarrior;
        this.isPaladin = isPaladin;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }

    public boolean isAlive() { return hp > 0; }

    public void healFull() { this.hp = this.maxHp; }

    public void heal(int amount) { this.hp = Math.min(this.maxHp, this.hp + amount); }

    public void takeDamage(int dmg) {
        int mitigated = Math.max(1, dmg - defense);
        this.hp = Math.max(0, this.hp - mitigated);
    }

    /**
     * Damage this character deals during a fight round. firstRound can be used for rogue backstab.
     */
    public int attackDamage(boolean firstRound) {
        int dmg = this.attack;
        if (isRogue && firstRound) {
            dmg *= 2; // backstab first round
        }
        if (isRanger) {
            dmg += 4; // ranger's steady damage
        }
        return dmg;
    }

    /**
     * Passive defense bonus this character provides to the party (reduces dragon attack).
     */
    public int defenseBonus() {
        if (isWarrior) return 6;
        if (isPaladin) return 4;
        return 0;
    }

    /**
     * Pet or passive damage (e.g., ranger's wolf).
     */
    public int petDamage() {
        if (isRanger) return 6;
        return 0;
    }

    /**
     * Apply support abilities after a round (heals or minor auras).
     */
    public void applyPassiveSupport(List<Character> party) {
        if (!isAlive()) return;
        if (isHealer) {
            // Elara heals the whole party a modest amount each round
            for (Character p : party) if (p.isAlive()) p.heal(15);
        }
        if (isPaladin) {
            // Paladin grants a small aura heal to everyone
            for (Character p : party) if (p.isAlive()) p.heal(6);
        }
    }

    public boolean isHealer() { return isHealer; }
    public boolean isRogue() { return isRogue; }
    public boolean isRanger() { return isRanger; }
    public boolean isWarrior() { return isWarrior; }
    public boolean isPaladin() { return isPaladin; }

    @Override
    public String toString() {
        return name + " (" + role + ") HP: " + hp + "/" + maxHp;
    }

    public static Character createById(int id) {
        switch (id) {
            case 1:
                return new Character("Bronn the Warrior", "Warrior - tank", 120, 18, 6, false, false, false, true, false);
            case 2:
                return new Character("Elara the Mage", "Mage - healer/support", 80, 10, 2, true, false, false, false, false);
            case 3:
                return new Character("Dain the Rogue", "Rogue - sneaky", 85, 15, 3, false, true, false, false, false);
            case 4:
                return new Character("Thalia the Ranger", "Ranger - archer", 90, 14, 3, false, false, true, false, false);
            case 5:
                return new Character("Kael the Paladin", "Paladin - holy knight", 110, 16, 5, false, false, false, false, true);
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
