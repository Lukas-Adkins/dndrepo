import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EncounterGenerator {
    private static final int ARRAY_HEIGHT = 20;
    private static final int ARRAY_WIDTH = 4;
    private int[][] expArray;


    public EncounterGenerator(File exp) throws FileNotFoundException{
        expArray = new int[ARRAY_HEIGHT][ARRAY_WIDTH];
        Scanner sc = new Scanner(exp);
        for(int i = 0; i < ARRAY_HEIGHT; i++){
            for(int o = 0; o < ARRAY_WIDTH; o++){
                expArray[i][o] = sc.nextInt();
            }
        }
    }

    public void newEncounter(int players, int level, int difficultly, Location location){
        int xpBudget = xpBudget(players,level,difficultly);
        int crBudget = level;
        if(level > 5)
            crBudget += 3;

        System.out.println("Generating encounter for a " + players + " player level " + level + " party in " + location + " biome.");
        System.out.println("XP budget is: " + xpBudget);
        System.out.println("CR budget is: " + crBudget);
        //TODO encounter generation script
    }

    /**
     * Generates XP budget for encounter
     * @param players Number of players in the party
     * @param level Level of the party members
     * @param difficulty Double value of easy, medium, hard, or deadly difficultly (1 - 4)
     * @return XP budget for encounter
     */
    private int xpBudget(int players, int level, int difficulty){
        if(level > 0 && level < 20 && difficulty > 0 && difficulty < 5){
            return players * expArray[level - 1][ difficulty - 1];
        }
        System.err.println("Improper level or difficulty input.");
        return -1;
    }

    enum Location{
        Forest, Arctic, Coast, Desert, Grassland, Hill, Mountain, Swamp, Underdark, Underwater, Urban
    }
}