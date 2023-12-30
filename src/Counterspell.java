import java.util.Scanner;

public class Counterspell implements Spell{
    public static boolean cast(Character source, int attackLevel){
        System.out.println("Do you want to counter it?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Y/N");
        String output = scanner.next();
        if (output.equals("Y")) {
            System.out.println("What spellslot do you want to use?");
            int counterLevel = scanner.nextInt();
            if(source.currentSpellSlots[counterLevel-1]>=1){
                source.currentSpellSlots[counterLevel-1]-=1;
                if (counterLevel >= attackLevel) {
                    System.out.println("Spell countered successfully!");
                    return true;
                } else {
                    int diceRoll = Dice.rollDice(Dice.D20);
                    int modifier = source.statblock.inteligence.getModifier();
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
        return source.counterspell(source, attackLevel);
    }
}
