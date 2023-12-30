import java.util.ArrayList;
import java.util.HashSet;

public class WizardClass extends CharacterClass{
    private Dice hitDie = Dice.D6;


    public WizardClass(Character character,int levelsGained, Statistic constitution) {
        super();
        this.level = (levelsGained<=1 || levelsGained>=20) ? levelsGained : 1;
        this.partialHealth = calculateHealth(this.level, constitution);
        this.spellSlots = getSpellSlots(this.level);
        this.spellBook = new ArrayList<>();
        this.spellBook.add(GlobalSpellBook.magicMissile);
        this.spellBook.add(GlobalSpellBook.counterSpell);
    }

    private int calculateHealth(int level, Statistic constitution ){
        int health = this.partialHealth<=8 ? 8: this.partialHealth;
        for(int i = 1; i<=level; i++){
            int healthIncrease= constitution.getModifier() + (int)(1 + Math.random()*hitDie.getDiceValue());
            if (healthIncrease<=1) health+=1;
            else health+=healthIncrease;
        }
        return health;
    }

    protected int[] getSpellSlots(int level){
        int[] slots;
        switch(level){
            case 1: slots = new int[] {2, 0, 0, 0, 0, 0, 0, 0, 0}; break;
            case 2: slots = new int[] {3, 0, 0, 0, 0, 0, 0, 0, 0}; break;
            case 3: slots = new int[] {4, 2, 0, 0, 0, 0, 0, 0, 0}; break;
            case 4: slots = new int[] {4, 3, 0, 0, 0, 0, 0, 0, 0}; break;
            case 5: slots = new int[] {4, 3, 2, 0, 0, 0, 0, 0, 0}; break;
            case 6: slots = new int[] {4, 3, 3, 0, 0, 0, 0, 0, 0}; break;
            case 7: slots = new int[] {4, 3, 3, 1, 0, 0, 0, 0, 0}; break;
            case 8: slots = new int[] {4, 3, 3, 2, 0, 0, 0, 0, 0}; break;
            case 9: slots = new int[] {4, 3, 3, 3, 1, 0, 0, 0, 0}; break;
            case 10: slots = new int[] {4, 3, 3, 3, 2, 0, 0, 0, 0}; break;
            case 11, 12: slots = new int[] {4, 3, 3, 3, 2, 1, 0, 0, 0}; break;
            case 13, 14: slots = new int[] {4, 3, 3, 3, 2, 1, 1, 0, 0}; break;
            case 15, 16: slots = new int[] {4, 3, 3, 3, 2, 1, 1, 1, 0}; break;
            case 17: slots = new int[] {4, 3, 3, 3, 2, 1, 1, 1, 1}; break;
            case 18: slots = new int[] {4, 3, 3, 3, 3, 1, 1, 1, 1}; break;
            case 19: slots = new int[] {4, 3, 3, 3, 3, 2, 1, 1, 1}; break;
            case 20: slots = new int[] {4, 3, 3, 3, 3, 2, 2, 1, 1}; break;

            default: slots = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};

        }
        return slots;
    }
}
