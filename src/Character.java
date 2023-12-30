import java.util.ArrayList;
import java.util.Scanner;

public class Character {

    String name;
    Statblock statblock;

    int maximumHealth;

    int currentHealth;

    CharacterClass[] characterClasses;

    int[] maximumSpellSlots;

    int[] currentSpellSlots;

    ArrayList <Spell> spellBook;

    public Character(String name, Statistic strength, Statistic dexterity, Statistic constitution, Statistic inteligence, Statistic wisdom, Statistic charisma, CharacterClass... classes) {

        this.statblock = new Statblock(strength, dexterity, constitution, inteligence, wisdom, charisma);
        this.characterClasses = classes;
        this.maximumSpellSlots = getMaximumSpellSlots(classes);
        this.currentSpellSlots = maximumSpellSlots;
        this.maximumHealth = getInitialHealth(classes);
        this.currentHealth = maximumHealth;
        this.name = name;
        this.spellBook = getSpellBook(classes);
    }
    public Character (String name, Statblock statblock, CharacterClass... classes){
        this.statblock = statblock;
        this.characterClasses = classes;
        this.maximumSpellSlots = getMaximumSpellSlots(classes);
        this.currentSpellSlots = maximumSpellSlots;
        this.maximumHealth = getInitialHealth(classes);
        this.currentHealth = maximumHealth;
        this.name = name;
    }

    private ArrayList<Spell> getSpellBook(CharacterClass... classes){
        ArrayList <Spell> spellBook = new ArrayList<>();
        for(CharacterClass characterClass : classes){
            spellBook.addAll(characterClass.spellBook);
        }
        return spellBook;
    }

    private int getInitialHealth(CharacterClass... classes){
        int health = 0;
        for(CharacterClass characterClass : classes){
            health += characterClass.getPartialHealth();
        }
        return health;
    }

    private int[] getMaximumSpellSlots(CharacterClass... classes){
        int [] maximumSpellSlots = new int[9];
        for(CharacterClass characterClass : classes){
            int [] classSpellSlots = characterClass.getSpellSlots(characterClass.level);
            for(int i =0; i<classSpellSlots.length; i++){
                maximumSpellSlots[i] += classSpellSlots[i];
            }
        }
        return maximumSpellSlots;
    }

    public void castSpell(int spellSlotLevel) throws Exception {
        if(currentSpellSlots[spellSlotLevel]>0){
            System.out.println("Success! you've cast a spell!");
            currentSpellSlots[spellSlotLevel]-=1;
        }else{
            throw new Exception() ;
        }
    }

    public void rest(){
        currentSpellSlots = maximumSpellSlots;
        currentHealth = maximumHealth;
    }

    public void takeDamage(int damage) {
        this.currentHealth-=damage;
    }

    public void attack(Character target, int spellType, int spellLevel) {
        if(spellType == 1)SpellBook.castLightSpell(target, this, spellLevel);
        else System.out.println("other spells not implemented yet");
    }

    public void randomAttack(Character target, int spellLevel) {
        System.out.println("random attacks do only light level spells for now");

        SpellBook.castLightSpell(target, this, spellLevel);
    }

    public boolean counterspell(Character target, int attackLevel) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Y/N");
        String output = scanner.next();
        if (output.equals("Y")) {
            System.out.println("What spellslot do you want to use?");
            int counterLevel = scanner.nextInt();
            if(target.currentSpellSlots[counterLevel-1]>=1){
                target.currentSpellSlots[counterLevel-1]-=1;
                if (counterLevel >= attackLevel) {
                    System.out.println("Spell countered successfully!");
                    return true;
                } else {
                    int diceRoll = Dice.rollDice(Dice.D20);
                    int modifier = target.statblock.inteligence.getModifier();
                    if (diceRoll + modifier >= 10 + attackLevel) {
                        System.out.println("you rolled a " + diceRoll + " to counter. \n It was a success! " + (diceRoll + modifier) + " vs " + (10 + attackLevel));
                        return true;
                    } else {
                        System.out.println("you rolled a " + diceRoll + " to counter. \n It was a failure! " + (diceRoll + modifier) + " vs " + (10 + attackLevel));
                        return false;
                    }
                }
            }
            else{
                System.out.println("oh no! no spellslots available at that level!");
                return false;
            }
        }
        if (output.equals("N")) {
            return false;
        }
        System.out.println("Wrong Input");
        return target.counterspell(target, attackLevel);
    }

}

