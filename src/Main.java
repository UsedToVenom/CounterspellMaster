import java.util.Arrays;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //hardcode
        System.out.println("Initialising global spellbook");



        Character hero = new Character("John Hero",Statistic.getRandomStatistic(), Statistic.getRandomStatistic(), Statistic.getRandomStatistic(), Statistic.getRandomStatistic(), Statistic.getRandomStatistic(), Statistic.getRandomStatistic(), new WizardClass(4, Statistic.getRandomStatistic()));
        System.out.println(Arrays.toString(hero.currentSpellSlots) + " current spell slots");
        hero.statblock.printValues();
        Encounter encounter = new Encounter();
        encounter.fight(hero);
    }
}