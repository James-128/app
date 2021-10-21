import java.awt.*;
import javax.swing.*;

public class bottom extends JPanel{

    private JLabel lab;
    private JLabel lab2;
    private JLabel lab3;

    private GridBagConstraints gbc;

    private PieChart pieChart;
    private PieChartKey key;
    private Table table;

    public bottom() {


        this.setLayout(new GridBagLayout());


        pieChart = new PieChart();

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
//        gbc.insets = new Insets(0,0,0,350);
//        gbc.anchor = GridBagConstraints.PAGE_START;
        this.add(pieChart, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
//        gbc.insets = new Insets(0,0,0,200);
//        gbc.anchor = GridBagConstraints.CENTER;
        key = new PieChartKey();
        this.add(key, gbc);




        // Column Names
        String[] columnNames = { "Name", "Roll Number", "Department" };
        String[][] data = { { "Kundan Kumar Jha", "4031", "CSE" }, { "Anand Jha", "6014", "IT" }};
        table = new Table(data, columnNames);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        this.add(table, gbc);

    }

    public PieChart getPieChart () { return this.pieChart; }
}
