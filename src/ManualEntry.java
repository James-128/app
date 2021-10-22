import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManualEntry extends JPanel {

    private JLabel Title;

    private JLabel namelabel;
    private JTextField nametext;

    private JLabel calorieLabel;
    private JSpinner calorieSpinner;
    private SpinnerNumberModel calorieNM;

    private JLabel typeLabel;

    private JCheckBox fruitCB;
    private JCheckBox veggieCB;
    private JCheckBox proteinCB;
    private JCheckBox dairyCB;
    private JCheckBox grainsCB;
    private JCheckBox trashCB;

    private JButton submitname;

    private GridBagConstraints gbc;

    private int gbcy = 1;

    PieChart pieChart = null;

    public ManualEntry() {

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.cyan);


        gbc = new GridBagConstraints();

        initManualEntryTitle ();

        namelabel = new JLabel ("Name: ");

        gbc.gridx = 0;
        gbc.gridy = gbcy;
        gbc.weightx = .1;
        gbc.weighty = .1;
        gbc.insets.left = 25;
        gbc.anchor = GridBagConstraints.LINE_START;

        this.add (namelabel, gbc);

        nametext = new JTextField ("hello", 10);
        gbc.weightx = .9;
        gbc.weighty = 0.1;
        gbc.gridx = 1;
        gbc.gridy = gbcy++;
        gbc.anchor = GridBagConstraints.CENTER;

        this.add (nametext, gbc);

        initCalorieComponents();

        initTypeComponents();

        submitname = new JButton ("submit");
        gbc.gridx = 1;
        gbc.gridy = ++gbcy; // 6
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets.right = 10;
        gbc.insets.bottom = 10;

        this.add(submitname, gbc);

        submitname.addActionListener(e -> {
            String textFieldtext = nametext.getText ();
            Object calorieValue = calorieSpinner.getValue();

            boolean fruit = fruitCB.isSelected();
            boolean veggie = veggieCB.isSelected();
            boolean protein = proteinCB.isSelected();
            boolean dairy = dairyCB.isSelected();
            boolean grains = grainsCB.isSelected();
            boolean trash = trashCB.isSelected();

            FoodData data = new FoodData(textFieldtext, calorieValue, fruit, veggie, protein, dairy, grains, trash);
            data.writeToFile();

            // debug
//            System.out.println (textFieldtext);

            if (pieChart != null) {
                pieChart.update();
            }

            practice.getBottom().updateTable();
        });
    }

    private void initManualEntryTitle (){
        Title = new JLabel("Wadjya Eet?");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = gbcy++;
        gbc.gridx = 1;
        gbc.insets.top = 3;

        gbc.anchor = GridBagConstraints.PAGE_START;
        this.add(Title, gbc);
    }

    private void initCalorieComponents(){

        calorieLabel = new JLabel ("Calories: ");
        calorieNM = new SpinnerNumberModel (0, 0, 1000, 7);
        calorieSpinner = new JSpinner (calorieNM);

        GridBagConstraints labelgbc = new GridBagConstraints();
        labelgbc.gridx = 0;
        labelgbc.gridy = gbcy;
        GridBagConstraints spinnergbc = new GridBagConstraints();
        spinnergbc.gridx = 1;
        spinnergbc.gridy = gbcy++;

        this.add(calorieLabel, labelgbc);
        this.add(calorieSpinner, spinnergbc);
    }

    private void initTypeComponents (){

        typeLabel = new JLabel("Categories");
        fruitCB = new JCheckBox("Fruit");
        veggieCB = new JCheckBox("Veggie");
        proteinCB = new JCheckBox("Protein");
        dairyCB = new JCheckBox("Dairy");
        grainsCB = new JCheckBox("Grains");
        trashCB = new JCheckBox("Trash");

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = gbcy++;
        this.add(typeLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = gbcy;
        this.add(fruitCB, gbc);

        gbc.gridx = 1;
        gbc.gridy = gbcy;
        this.add(veggieCB, gbc);

        gbc.gridx = 2;
        gbc.gridy = gbcy++;
        this.add(proteinCB, gbc);

        gbc.gridx = 0;
        gbc.gridy = gbcy;
        this.add(dairyCB, gbc);

        gbc.gridx = 1;
        gbc.gridy = gbcy;
        this.add(grainsCB, gbc);

        gbc.gridx = 2;
        gbc.gridy = gbcy++;
        this.add(trashCB, gbc);

    }

    public void assignPieChart(PieChart p) {
        this.pieChart = p;
    }

}
