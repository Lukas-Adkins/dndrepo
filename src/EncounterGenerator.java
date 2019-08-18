import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EncounterGenerator {
    private static final double EASY = 0.5;
    private static final double MEDIUM = 0.5;
    private static final double HARD = 1.5;
    private static final double DEADLY = 2;
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

    /**
     * Generates XP budget for encounter
     * @param players Number of players in the party
     * @param level Level of the party members
     * @param difficulty Double value of easy, medium, hard, or deadly difficultly (1 - 4)
     * @return XP budget for encounter
     */
    public int xpBudget(int players, int level, int difficulty){
        return players * expArray[level - 1][ difficulty - 1];
    }
}