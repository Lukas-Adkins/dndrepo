import java.io.File;
import java.io.FileNotFoundException;
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
    public MonsterListParser(File monsterList) throws FileNotFoundException{
        Scanner sc = new Scanner(monsterList);
        System.out.println(sc.next());

    }



}