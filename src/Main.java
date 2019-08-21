import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean running = true;
        int players, level, difficultly = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Monster> monsterList= new ArrayList<>();
        MonsterListParser listParser = new MonsterListParser(new File("monsters.txt"));
        listParser.fillList(monsterList);
        EncounterGenerator generator = new EncounterGenerator(new File("exp.txt"));

        System.out.println("Welcome to Goo's D&D Encounter generator. Please enter the number of players in your party:");
        players = sc.nextInt();
        System.out.println("Next, please enter your party's level:");
        level = sc.nextInt();
        System.out.println("To begin generating encounters, please enter a biome and difficultly. Or type 'quit' to exit.");
        System.out.println("Example input 'Hard Coast' would generate a hard encounter taking place in a coast biome.");
        System.out.println("Difficulties are Easy, Medium, Hard, or Deadly.");
        System.out.println("Possible biomes are as follows: ");
        System.out.println("Forest, Arctic, Coast, Desert, Grassland, Hill, Mountain, Swamp, Underdark, Underwater, or Urban.");

        while(running){
            EncounterGenerator.Location location = null;
            String input = sc.next();
            if(input.toLowerCase().equals("quit"))
                running = false;
            else{
                switch(input.toLowerCase()){
                    case ("easy"):
                        difficultly = 1;
                        break;
                    case ("medium"):
                        difficultly = 2;
                        break;
                    case ("hard"):
                        difficultly = 3;
                        break;
                    case ("deadly"):
                        difficultly = 4;
                        break;

                }
                input = sc.next();
                switch(input.toLowerCase()){
                    case ("forest"):
                        location = EncounterGenerator.Location.Forest;
                        break;
                    case ("arctic"):
                        location = EncounterGenerator.Location.Arctic;
                        break;
                    case ("coast"):
                        location = EncounterGenerator.Location.Coast;
                        break;
                    case ("desert"):
                        location = EncounterGenerator.Location.Desert;
                        break;
                    case ("grassland"):
                        location = EncounterGenerator.Location.Grassland;
                        break;
                    case ("hill"):
                        location = EncounterGenerator.Location.Hill;
                        break;
                    case ("mountain"):
                        location = EncounterGenerator.Location.Mountain;
                        break;
                    case ("swamp"):
                        location = EncounterGenerator.Location.Swamp;
                        break;
                    case ("underdark"):
                        location = EncounterGenerator.Location.Underdark;
                        break;
                    case ("underwater"):
                        location = EncounterGenerator.Location.Underwater;
                        break;
                    case ("urban"):
                        location = EncounterGenerator.Location.Urban;
                        break;
                }
                generator.newEncounter(players,level,difficultly, location);
            }
        }
    }
}
