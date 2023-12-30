public class Statblock {
    Statistic strength;
    Statistic dexterity;
    Statistic constitution;
    Statistic inteligence;
    Statistic wisdom;
    Statistic charisma;

    private Statblock(){
    }

    public Statblock(Statistic strength, Statistic dexterity, Statistic constitution, Statistic inteligence, Statistic wisdom, Statistic charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.inteligence = inteligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public static Statblock generateRandomStatblock(){
        Statblock statblock = new Statblock();

        statblock.strength = Statistic.getRandomStatistic();
        statblock.dexterity = Statistic.getRandomStatistic();
        statblock.constitution = Statistic.getRandomStatistic();
        statblock.inteligence = Statistic.getRandomStatistic();
        statblock.wisdom = Statistic.getRandomStatistic();
        statblock.charisma = Statistic.getRandomStatistic();

        return statblock;
    }

    public void printValues(){
        System.out.println("strength: " + this.strength + "\n" +
                "dexterity: " + this.dexterity + "\n" +
                "constitution: " + this.constitution + "\n" +
                "inteligence: " + this.inteligence + "\n" +
                "wisdom: " + this.wisdom + "\n" +
                "charisma: " + this.charisma);
    }

    public Statistic getStrength() {
        return strength;
    }

    public Statistic getDexterity() {
        return dexterity;
    }

    public Statistic getConstitution() {
        return constitution;
    }

    public Statistic getInteligence() {
        return inteligence;
    }

    public Statistic getWisdom() {
        return wisdom;
    }

    public Statistic getCharisma() {
        return charisma;
    }
}
