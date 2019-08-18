import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Monster> monsterList= new ArrayList<>();
        MonsterListParser listParser = new MonsterListParser(new File("monsters.txt"));
        listParser.fillList(monsterList);
        EncounterGenerator generator = new EncounterGenerator(new File("exp.txt"));
        generator.newEncounter(4,1,2, EncounterGenerator.Location.Forest);
    }
}
