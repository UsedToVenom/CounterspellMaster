public enum Dice {
    D2(2),
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20);

    private int diceValue;

    Dice(int diceValue) {
        this.diceValue = diceValue;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public static int rollDice(Dice die){
        return 1+(int)(Math.random()*die.diceValue);
    }
}
