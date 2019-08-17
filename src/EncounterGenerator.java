import java.io.File;
import java.io.FileNotFoundException;

public class EncounterGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        MonsterListParser listParser = new MonsterListParser( new File("monsters.txt"));

    }
}
