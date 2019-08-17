import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MonsterListParser.java
 * Written by Lukas Adkins
 * 8/16/2019
 * Creates Monster Objects from monster list raw text (from roll20.com)
 */
public class MonsterListParser {
    private File monsterList;

    /**
     * Default Constructor
     * /TODO FIX FOR VARIATIONS
     */
    public MonsterListParser(File monsterList, ArrayList<Monster> monsters) throws FileNotFoundException{
        Scanner sc = new Scanner(monsterList);
        while(sc.hasNext()){
            String name = sc.nextLine();
            String sizeRaw = sc.next();
            Size size = null;
            switch (sizeRaw.toLowerCase()){
                case "tiny":
                    size = Size.Tiny;
                    break;
                case "small":
                    size = Size.Small;
                    break;
                case "medium":
                    size = Size.Medium;
                    break;
                case "large":
                    size = Size.Large;
                    break;
                case "huge":
                    size = Size.Huge;
                    break;
                case "gargantuan":
                    size = Size.Gargantuan;
                    break;
                default:
                    System.err.println("ERROR: Size not read for " + name);
                    break;

            }
            Type type = null;
            String typeRaw = sc.next();

            switch (typeRaw.toLowerCase()) {
                case "aberration,":
                    type = Type.Aberration;
                    break;
                case "beast,":
                    type = Type.Beast;
                    break;
                case "celestial,":
                    type = Type.Celestial;
                    break;
                case "construct,":
                    type = Type.Construct;
                    break;
                case "dragon,":
                    type = Type.Dragon;
                    break;
                case "elemental,":
                    type = Type.Elemental;
                    break;
                case "fey,":
                    type = Type.Fey;
                    break;
                case "fiend,":
                    type = Type.Fiend;
                    break;
                case "giant,":
                    type = Type.Giant;
                    break;
                case "humanoid,":
                    type = Type.Humanoid;
                    break;
                case "ooze,":
                    type = Type.Ooze;
                    break;
                case "plant,":
                    type = Type.Plant;
                    break;
                case "undead,":
                    type = Type.Undead;
                    break;
                case "monstrosity,":
                    type = Type.Monstrosity;
                    break;
                default:
                    System.err.println("ERROR: Type not read for " + name);
                    break;
            }
            Alignment alignment = null;
            String alignmentRaw = sc.next() + " " + sc.next();

            switch (alignmentRaw.toLowerCase()){
                case "lawful good":
                    alignment = Alignment.LawfulGood;
                    break;
                case "neutral good":
                    alignment = Alignment.NeutralGood;
                    break;
                case "chaotic good":
                    alignment = Alignment.ChaoticGood;
                    break;
                case "lawful neutral":
                    alignment = Alignment.LawfulNeutral;
                    break;
                case "neutral":
                    alignment = Alignment.Neutral;
                    break;
                case "chaotic neutral":
                    alignment = Alignment.ChaoticNeutral;
                    break;
                case "lawful evil":
                    alignment = Alignment.LawfulEvil;
                    break;
                case "neutral evil":
                    alignment = Alignment.NeutralEvil;
                    break;
                case "chaotic evil":
                    alignment = Alignment.ChaoticEvil;
                    break;
                default:
                    System.err.println("ERROR: Alignment not read for " + name);
                    break;
            }
            sc.next();
            sc.next();
            int HP = sc.nextInt();
            sc.next();
            sc.next();
            sc.next();
            int AC = sc.nextInt();
            sc.next();
            sc.next();
            sc.next();
            int speed = sc.nextInt();
            int challengeRating = 0;
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            String XPRaw = sc.next().replace(",","");
            //System.out.println(sc.next());
            sc.next();
            sc.nextLine();
            int XP = Integer.parseInt(XPRaw.substring(1));
            monsters.add(new Monster(name,size,type,alignment,HP,AC,speed,challengeRating,XP));
        }
    }
}