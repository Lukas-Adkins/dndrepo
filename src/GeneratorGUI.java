import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html

public class GeneratorGUI extends Frame implements ActionListener {
    private Label partyLvlLabel;
    private TextField partyLvlField;
    private int partyLvlInt;
    private Button partyLvlBt;

    private JList difficultySelect;


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

        //Initializes difficulty selector





        setTitle("D&D 5e Encounter Generator");
        setSize(250,100);
        setVisible(true);

    }

    public static void main(String[] args){
        GeneratorGUI gui = new GeneratorGUI();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        partyLvlInt++;
        partyLvlField.setText(String.valueOf(partyLvlInt));
    }
}
