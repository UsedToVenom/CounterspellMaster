import java.util.Scanner;

public class SpellBook {

    public static void castLightSpell(Character target, Character source, int level){
        int damage = 0;
        if(target.name != "Villain"){
        System.out.println(source.name + " is casting a " + level + " level spell! do you want to counter?");
        if(target.counterspell(target, level)) return;
        }


        if (level>=1){
            for (int i=1; i <= level; i++){
                damage += Dice.rollDice(Dice.D4)+1;
            }
            System.out.println(source.name + " dealt " + damage + " points of damage to " + target.name + "!");
            target.takeDamage(damage);
        }else{
            System.out.println("Oh no! that spell slot is to weak to cast this spell!");
        }
    }
}
