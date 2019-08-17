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
    private String description;
    private int HP;
    private int AC;
    private int speed;
    private int challangeRating;
    private int XP;


    public Monster(String name){

    }


}

enum Size{
    Tiny, Small, Medium, Large, Huge, Gargantuan;
}

enum Alignment {
    LawfulGood, NeutralGood, ChaoticGood, LawfulNeutral, Neutral, ChatoicNeutral, LawfulEvil, NeutralEvil, ChaoticEvil;
}

enum Type{

}
