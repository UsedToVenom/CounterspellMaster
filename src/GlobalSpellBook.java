public enum GlobalSpellBook implements Spell {
    magicMissile(new MagicMissile(), "Magic Missile"),
    counterSpell(new Counterspell(), "Counterspell"),
    nullSpell (new NullSpell(),"");
    private Spell spell;
    private String spellName;

    GlobalSpellBook(Spell spell, String spellName) {
        this.spell = spell;
        this.spellName = spellName;
    }

    public String getSpellName() {
        return this.spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public static Spell getSpell(String spellName) {
        for (GlobalSpellBook spell: GlobalSpellBook.values()){
            if (spell.getSpellName() == spellName){
                return spell;
            }
        }
        return nullSpell;
    }
}
