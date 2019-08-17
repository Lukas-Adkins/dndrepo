import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Monster> monsterList= new ArrayList<>();
        MonsterListParser listParser = new MonsterListParser(new File("monsters.txt"), monsterList);
        EncounterGenerator generator = new EncounterGenerator();

        System.out.println(generator.xpBudget(4,10,2.3));

        /*
        for(Monster m : monsterList){
            m.printInfo();
        }
         */
    }
}
