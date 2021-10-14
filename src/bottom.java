import java.awt.*;
import javax.swing.*;

public class bottom extends JPanel{

    private JLabel lab;
    private JLabel lab2;
    private JLabel lab3;
    private PieChart pieChart;
    private GridBagConstraints gbc;

    public bottom() {


        this.setLayout(new GridBagLayout());


        pieChart = new PieChart();

        gbc = new GridBagConstraints();

        gbc.insets = new Insets(0,0,0,650);

        this.add(pieChart, gbc);

//        GridBagConstraints c2 = new GridBagConstraints();
//        c2.fill = GridBagConstraints.HORIZONTAL;
//        c2.weightx = .1;
//        c2.weighty = .1;
//
//        lab = new JLabel("food:");
//        c2.gridx = 0;
//        c2.gridy = 0;
//        this.add(lab, c2);
//
//        lab2 = new JLabel("cash:");
//        c2.gridx = 1;
//        c2.gridy = 0;
//        this.add(lab2, c2);
//
//        lab3 = new JLabel("money:");
//        c2.gridx = 2;
//        c2.gridy = 1;
//        this.add(lab3, c2);

    }
}
