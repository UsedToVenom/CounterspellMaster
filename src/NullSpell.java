public class NullSpell implements Spell {
    public static void cast(){
        System.out.println("Null Spell access, this shouldn't be happenning");
    }
}
