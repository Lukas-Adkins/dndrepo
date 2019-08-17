/**
 * Monster.java
 * Written by Lukas Adkins
 * 8/16/2019
 * Provides versatile Monster object to be used in encounter generation
 */

public class Monster{
    private String name;
    private Size size;
    private Alignment alignment;
    private Type type;
    private int HP;
    private int AC;
    private int speed;
    private int challengeRating;
    private int XP;

    /**
     * Represents a D&D monster.
     * @param name Name of the monster.
     * @param size Size of the monster.
     * @param type Type of the monster.
     * @param alignment Alignment of the monster.
     * @param HP Hit point total of the monster.
     * @param AC Armor class of the monster.
     * @param speed Speed (in ft. per turn) of the monster.
     * @param challengeRating Challenge Rating of the monster.
     * @param XP Experience points given for defeating the monster.
     */
    public Monster(String name, Size size, Type type, Alignment alignment, int HP, int AC, int speed, int challengeRating, int XP){
        this.name = name;
        this.size = size;
        this.type = type;
        this.alignment = alignment;
        this.HP = HP;
        this.AC = AC;
        this.speed = speed;
        this.challengeRating = challengeRating;
        this.XP = XP;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(int challengeRating) {
        this.challengeRating = challengeRating;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

enum Size{
    Tiny, Small, Medium, Large, Huge, Gargantuan;
}

enum Alignment {
    LawfulGood, NeutralGood, ChaoticGood, LawfulNeutral, Neutral, ChatoicNeutral, LawfulEvil, NeutralEvil, ChaoticEvil;
}

enum Type{
    Abberation, Beast, Celestial, Construct, Dragon, Elemental, Fey, Fiend, Giant, Humanoid, Monstrosity, Ooze, Plant,
    Undead;
}