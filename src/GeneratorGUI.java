import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;

//https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html

public class GeneratorGUI extends JFrame implements ActionListener, ListSelectionListener, ItemListener {
    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;
    private static final int DEADLY = 4;
    private static final String ENCOUNTER_GEN = "Generate Encounters!";

    private EncounterGenerator generator;

    private Label partyLvlLabel;
    private TextField partyLvlField;
    private int partyLvl;
    private Button partyLvlBt;
    private Panel partyLvlPanel;

    private JList diffList;
    private Label diffLabel;
    private static final String[] DIFFICULTIES = {"Easy", "Medium", "Hard", "Deadly"};
    private int difficulty;
    private Panel diffPanel;

    private Choice biomeChoice;
    private Label biomeLabel;
    private static final String[] BIOMES = {"Forest", "Arctic", "Coast", "Desert",
            "Grassland", "Hill", "Mountain", "Swamp", "Underdark", "Underwater", "Urban"};
    private String biome;
    private Panel biomePanel;

    private Button generateBt;
    private Panel genPanel;


    /**
     * GUI constructor: initializes variables
     */
    public GeneratorGUI(){
        //Flow layout arranges components from left-to-right, and flow to next row from top-to-bottom
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        partyLvlPanel = new Panel();
        biomePanel = new Panel();
        diffPanel = new Panel();
        genPanel = new Panel();

        //Initializes party level, and button
        partyLvlLabel = new Label("Party Level: ");
        partyLvlPanel.add(partyLvlLabel);
        partyLvl = 1;
        partyLvlField = new TextField(String.valueOf(partyLvl), 1);
        partyLvlField.setEditable(true);
        partyLvlPanel.add(partyLvlField);
        partyLvlBt = new Button("++");
        partyLvlPanel.add(partyLvlBt);
        partyLvlBt.addActionListener(this);
        partyLvlField.addActionListener(this);

        //Initializes list difficulty selector
        diffLabel = new Label("Difficulty: ");
        diffPanel.add(diffLabel);
        diffList = new JList(DIFFICULTIES);
        diffList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        diffList.setSelectedIndex(0);
        difficulty = EASY;
        diffList.setLayoutOrientation(diffList.HORIZONTAL_WRAP);
        diffList.setPreferredSize(new Dimension(70,100));
        diffPanel.add(diffList);
        diffList.addListSelectionListener(this);

        //Initializes biome selector
        biome = "Forest";
        biomeLabel = new Label("Biome: ");
        biomePanel.add(biomeLabel);
        biomeChoice = new Choice();
        for(String biomes : BIOMES){
            biomeChoice.add(biomes);
        }
        biomePanel.add(biomeChoice);
        biomeChoice.addItemListener(this);

        //Initializes "Generate" button
        generateBt = new Button(ENCOUNTER_GEN);
        generateBt.setPreferredSize(new Dimension(150,40));
        genPanel.add(generateBt);
        generateBt.addActionListener(this);

        //Adds containers to content plane
        container.add(partyLvlPanel);
        container.add(diffPanel);
        container.add(biomePanel);
        container.add(genPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("D&D 5e Encounter Generator");
        setSize(600,600);
        setVisible(true);
    }

    /**
     * Listens for incrementation of the party level, and increments partyLvl by 1.
     * @param event new ActionEvent by the user
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionLabel = event.getActionCommand();
        int partyLvlTemp = partyLvl;

        if(actionLabel.equals(ENCOUNTER_GEN)){
            System.out.println("Generating encounters...");
            try {
                generateEncounter();
            }
            catch (FileNotFoundException e){
                System.err.println("exp file not found. Terminating program.");
                System.exit(1);
            }
        }
        else if(actionLabel.equals("++") && !(partyLvl > 19) && !(partyLvl < 1)){
            this.partyLvl++;
        }
        else{
            try {
                partyLvl = Integer.parseInt(event.getActionCommand());
                if(partyLvl < 1 || partyLvl > 20){
                    partyLvl = partyLvlTemp;
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException ex){
                System.err.println("Invalid number input for player level.");
            }
        }
        //Debug print
        this.partyLvlField.setText(String.valueOf(partyLvl));
        System.out.println("Party level increased to: " + partyLvl);
    }


    /**
     * Listens for difficulty changes, and updates difficulty integer depending on selection.
     * @param event new ListSelectionEvent by the user
     */
    @Override
    public void valueChanged(ListSelectionEvent event){
        if(!event.getValueIsAdjusting()) {
            switch (diffList.getSelectedIndex()) {
                case 0:
                    difficulty = EASY;
                    break;
                case 1:
                    difficulty = MEDIUM;
                    break;
                case 2:
                    difficulty = HARD;
                    break;
                case 3:
                    difficulty = DEADLY;
                    break;
            }
            //Debug print
            System.out.println("New difficulty selection: " + difficulty);
        }
    }

    /**
     * Listens for biome choice changes, and updates biome string depending on selection.
     * @param event
     */
    @Override
    public void itemStateChanged(ItemEvent event){
        this.biome = String.valueOf(event.getItem());
        System.out.println("New biome selection: " + biome);
    }

    /**
     * Initializes a new EncounterGenerator instance to fetch results.
     * @throws FileNotFoundException if exp constant file is not found.
     */
    public void generateEncounter() throws FileNotFoundException {
        generator = new EncounterGenerator(new File("exp.txt"));
        generator.newEncounter(4,partyLvl,difficulty,biome);
    }
}

