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
     */
    public MonsterListParser(File monsterList, ArrayList monsters) throws FileNotFoundException{
        Scanner sc = new Scanner(monsterList);
        while(sc.hasNextLine()){
            String name = sc.nextLine();
            String sizeRaw = sc.next();
            Size size;
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
                    System.err.println("ERROR: Size not read.");
                    break;

            }
            Type type;
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
                default:
                    System.err.println("ERROR: Type not read.");
                    break;
            }
            Alignment alignment;
            String alignmentRaw = sc.next();

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
                    alignment = Alignment.ChatoicNeutral;
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
                    System.err.println("ERROR: Alignment not read.");
                    break;
            }

            int HP;
            int AC;
            int speed;
            int challengeRating;
            int XP;
        }
    }
}