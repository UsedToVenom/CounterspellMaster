import java.util.ArrayList;

public abstract class CharacterClass {
    protected int level;
    protected int partialHealth;

    protected int[] spellSlots = new int[10];

    protected ArrayList<Spell> spellBook;

    public int getLevel() {
        return level;
    }

    protected int getPartialHealth() {
        return partialHealth;
    }

    protected int[] getSpellSlots(int level) {
        return spellSlots;
    }
}
