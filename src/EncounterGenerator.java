import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EncounterGenerator {
    private static final double EASY = 0.5;
    private static final double MEDIUM = 0.5;
    private static final double HARD = 1.5;
    private static final double DEADLY = 2;

    public EncounterGenerator(){

    }

    /**
     * Generates XP budget for encounter
     * @param players Number of players in the party
     * @param level Level of the party members
     * @param difficulty Double value of easy, medium, hard, or deadly difficultly
     * @return XP budget for encounter
     */
    public double xpBudget(int players, int level, double difficulty){
        double baseXP = 0;
        if(level < 4)
            baseXP = 50 * level;
        else if(level == 4){
            baseXP = 250;
        }
        else if(level == 5){
            baseXP = 500;
        }
        else if(level == 6){
            baseXP = 600;
        }
        else if(level == 7){
            baseXP = 750;
        }
        else if(level == 8){
            baseXP = 900;
        }
        else if(level == 9){
            baseXP = 1100;
        }
        else if(level == 10){
            baseXP = 1200;
        }
        else if(level == 12){
            baseXP = 2000;
        }
        else if(level == 13){
            baseXP = 2200;
        }
        else if(level == 14){
            baseXP = 2500;
        }
        else if(level == 15){
            baseXP = 2800;
        }
        else if(level == 16){
            baseXP = 3200;
        }
        else if(level == 17){
            baseXP = 3900;
        }
        else if(level == 18){
            baseXP = 4200;
        }
        else if(level == 19){
            baseXP = 4900;
        }
        else if(level == 20){
            baseXP = 5700;
        }
        return baseXP * players * difficulty;
    }
}