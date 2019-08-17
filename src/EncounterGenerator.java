import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EncounterGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Monster> monsterList= new ArrayList<>();
        MonsterListParser listParser = new MonsterListParser(new File("monsters.txt"), monsterList);

        /*
        for(Monster m : monsterList){
            m.printInfo();
        }
         */
    }
}
