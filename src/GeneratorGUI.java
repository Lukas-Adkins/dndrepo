import com.sun.org.apache.bcel.internal.generic.SWITCH;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html

public class GeneratorGUI extends Frame implements ActionListener, ListSelectionListener {
    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;
    private static final int DEADLY = 4;


    private Label partyLvlLabel;
    private TextField partyLvlField;
    private int partyLvlInt;
    private Button partyLvlBt;

    private JList difficultyList;
    private static final String[] DIFFICULTIES = {"Easy", "Medium", "Hard", "Deadly"};
    private int difficulty;

    /**
     * GUI constructor: initializes variables
     */
    public GeneratorGUI(){
        //Flow layout arranges components from left-to-right, and flow to next row from top-to-bottom
        setLayout(new FlowLayout());

        //Initializes party level, and button
        this.partyLvlLabel = new Label("Party Level: ");
        add(partyLvlLabel);
        partyLvlField = new TextField(String.valueOf(partyLvlInt), 1);
        partyLvlField.setEditable(true);
        add(partyLvlField);
        partyLvlBt = new Button("++");
        add(partyLvlBt);
        partyLvlBt.addActionListener(this);

        //Initializes list difficulty selector
        difficultyList = new JList(DIFFICULTIES);
        difficultyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        difficultyList.setSelectedIndex(0);
        difficultyList.setLayoutOrientation(difficultyList.HORIZONTAL_WRAP);
        difficultyList.setPreferredSize(new Dimension(250,100));
        add(difficultyList);
        difficultyList.addListSelectionListener(this);


        setTitle("D&D 5e Encounter Generator");
        setSize(250,100);
        setVisible(true);

    }

    public static void main(String[] args){
        GeneratorGUI gui = new GeneratorGUI();
    }

    /**
     * Listens for incrementation of the party level, and increments partyLvlInt by 1.
     * @param event new ActionEvent by the user
     */
    @Override
    public void actionPerformed(ActionEvent event){
        partyLvlInt++;
        partyLvlField.setText(String.valueOf(partyLvlInt));
        //Debug print
        System.out.println("Party level increased to: " + partyLvlInt);
    }


    /**
     * Listens for difficulty changes, and updates difficult integer depending on selection.
     * @param event new ListSelectionEvent by the user
     */
    @Override
    public void valueChanged(ListSelectionEvent event){
        if(!event.getValueIsAdjusting()) {
            switch (difficultyList.getSelectedIndex()) {
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
}
