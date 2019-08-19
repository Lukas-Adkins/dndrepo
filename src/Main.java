import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<Monster> monsterList= new ArrayList<>();
        MonsterListParser listParser = new MonsterListParser(new File("monsters.txt"));
        listParser.fillList(monsterList);
        EncounterGenerator generator = new EncounterGenerator(new File("exp.txt"));

        System.out.println("Welcome to Goo's D&D Encounter generator. Please enter the number of players in your party:");
        int players = sc.nextInt();
        System.out.println("Next, please enter your party's level:");
        int level = sc.nextInt();
        System.out.println("To begin generating encounters, please enter a biome and difficultly.");
        System.out.println("Example input 'Hard Coast' would generate a hard encounter taking place in a coast biome.");
        System.out.println("Difficulties are Easy, Medium, Hard, or Deadly.");
        System.out.println("Possible biomes are as follows: ");
        System.out.println("Forest, Arctic, Coast, Desert, Grassland, Hill, Mountain, Swamp, Underdark, Underwater, or Urban.");

        while(running){
            //TODO add user input parsing
            generator.newEncounter(players,level,2, EncounterGenerator.Location.Forest);
        }
    }
}
