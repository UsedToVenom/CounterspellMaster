import java.util.Arrays;

public enum Statistic {
    one(1),
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine (9),
    ten (10),
    eleven (11),
    twelve (12),
    thirteen (13),
    fourteen (14),
    fifteen (15),
    sixteen (16),
    seventeen (17),
    eighteen (18);

    private int value;
    private int modifier;

    Statistic(int value) {
        value = (value<=20 && value>= 1) ? value : 1;
        this.modifier = (value/2) - 5;
    }

    public int getModifier(){
        return modifier;
    }

    public static Statistic getRandomStatistic (){
        int randomNumber1 = 1+(int)(Math.random() * 6);
        int randomNumber2 = 1+(int)(Math.random() * 6);
        int randomNumber3 = 1+(int)(Math.random() * 6);
        int randomNumber4 = 1+(int)(Math.random() * 6);
        int[] results = new int[]{randomNumber1, randomNumber2, randomNumber3, randomNumber4};
        int number = Arrays.stream(results).sum() - Arrays.stream(results).min().getAsInt();
        switch(number){
            case 1: return one;
            case 2: return two;
            case 3: return three;
            case 4: return four;
            case 5: return five;
            case 6: return six;
            case 7: return seven;
            case 8: return eight;
            case 9: return nine;
            case 10: return ten;
            case 11: return eleven;
            case 12: return twelve;
            case 13: return thirteen;
            case 14: return fourteen;
            case 15: return fifteen;
            case 16: return sixteen;
            case 17: return seventeen;
            case 18: return eighteen;
            default: return one;
        }
    }
}

