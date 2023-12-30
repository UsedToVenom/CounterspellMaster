import java.util.Arrays;
import java.util.Scanner;

public class Encounter {
    Character villain;

    public Encounter() {
        Statblock statblock = Statblock.generateRandomStatblock();
        this.villain = new Character("Villain",Statblock.generateRandomStatblock(), new WizardClass(5, statblock.getConstitution()));
    }

    public void fight(Character hero) {
        System.out.println("Round starts \n" + hero.name + " spell slots: " + Arrays.toString(hero.currentSpellSlots) + "\n health points = " + hero.currentHealth );
        int randomLevelSpell = 1 + (int) (Math.random() * 3);
        Scanner scanner = new Scanner(System.in);
        villain.randomAttack(hero, randomLevelSpell);
        if (hero.currentHealth <= 0) {
            System.out.println("you got knocked out!");
            hero.rest();
            return;
        }
        System.out.println("choose spell\n1:light\n2:medium\n3:heavy");
        int spellType = scanner.nextInt();
        System.out.println("choose spell slot level");
        int spellLevel = scanner.nextInt();
        hero.attack(villain, spellType, spellLevel);
        if (villain.currentHealth <= 0) {
            System.out.println(villain.name + " vanquished! " + hero.name + " moves to the next encounter!");
        } else {
            this.fight(hero);
        }
    }




//        System.out.println("i am " + villain + " and I have " + villain.currentHealth + "health points remaining!");
//        int randomLevelSpell = 1+(int)(Math.random()*5);
//        System.out.println(String.format("villain tries to cast %d level spell", randomLevelSpell));
//        try {
//            villain.castSpell(randomLevelSpell);
//            System.out.println("spell cast at level " + randomLevelSpell);
//        }
//            catch (Exception e){
//                System.out.println("No spell slots available at this level!");
//                if(Arrays.stream(villain.currentSpellSlots).sum() == 0){
//                    System.out.println("The villain is out of spell slots! you beat him to death! good job!");
//                }else
//                {this.fight(hero);}
//        }

}
