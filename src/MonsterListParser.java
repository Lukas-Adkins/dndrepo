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
    private static final int OFFSET_VALUE = 3;
    private Scanner sc;

    /**
     * Default Constructor
     */
    public MonsterListParser(File monsterList) throws FileNotFoundException{
         sc = new Scanner(monsterList);
    }

    public void fillList(ArrayList<Monster> monsters) {
        while (sc.hasNext()) {
            Monster newMonster = new Monster();
            newMonster.setName(sc.nextLine());
            String nextLine = sc.nextLine();
            Scanner sb = new Scanner(nextLine.substring(0, nextLine.indexOf(',')));
            newMonster.setSize(parseSize(sb.next()));
            newMonster.setType(parseType(sb.next()));
            newMonster.setAlignment(parseAlignment(nextLine.substring(nextLine.indexOf(',') + 2)));
            sc.nextLine();
            newMonster.setHP(Integer.parseInt(sc.next()));
            newMonster.setHpDice(sc.next());
            sc.nextLine();
            nextLine = sc.nextLine();
            newMonster.setAC(Integer.parseInt(nextLine.substring(0, nextLine.indexOf(' '))));
            newMonster.setChallengeRating(0);
            nextLine = sc.nextLine();
            newMonster.setSpeed(nextLine.substring(0, nextLine.indexOf('C')));
            nextLine = sc.nextLine();
            newMonster.setXP(Integer.parseInt(nextLine.substring(nextLine.indexOf('(') + 1, nextLine.indexOf(')') - OFFSET_VALUE).replace(",", "")));
            monsters.add(newMonster);
        }
    }

    private Size parseSize(String s){
        switch (s.toLowerCase()){
            case "tiny":
                return Size.Tiny;
            case "small":
                return Size.Small;
            case "medium":
                return Size.Medium;
            case "large":
                return Size.Large;
            case "huge":
                return Size.Huge;
            case "gargantuan":
                return Size.Gargantuan;

        }
        return null;
    }

    private Type parseType(String s){
        switch (s.toLowerCase()) {
            case "aberration":
                return Type.Aberration;
            case "beast":
                return Type.Beast;
            case "celestial":
                return Type.Celestial;
            case "construct":
                return Type.Construct;
            case "dragon":
                return Type.Dragon;
            case "elemental":
                return Type.Elemental;
            case "fey":
                return Type.Fey;
            case "fiend":
                return Type.Fiend;
            case "giant":
                return Type.Giant;
            case "humanoid":
                return Type.Humanoid;
            case "ooze,":
                return Type.Ooze;
            case "plant":
                return Type.Plant;
            case "undead":
                return Type.Undead;
            case "monstrosity":
                return Type.Monstrosity;

        }
        return null;
    }

    private Alignment parseAlignment(String s){
        switch (s.toLowerCase()){
            case "lawful good":
                return Alignment.LawfulGood;
            case "neutral good":
                return Alignment.NeutralGood;
            case "chaotic good":
                return Alignment.ChaoticGood;
            case "lawful neutral":
                return Alignment.LawfulNeutral;
            case "neutral":
                return Alignment.Neutral;
            case "chaotic neutral":
                return Alignment.ChaoticNeutral;
            case "lawful evil":
                return Alignment.LawfulEvil;
            case "neutral evil":
                return Alignment.NeutralEvil;
            case "chaotic evil":
                return Alignment.ChaoticEvil;
            case "any alignment":
                return Alignment.Any;
        }
        return null;
    }
}