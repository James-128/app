import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

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
        String[][] data = { { "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" }, { "Anand Jha", "6014", "IT" }, { "Name", "Roll Number", "Department" }};
        table = new Table(data, columnNames);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;

        this.add(table, gbc);

    }

    public void updateTable () {
        //Get the components in the panel
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c instanceof JTable){

                //Remove it
                this.remove(c);
            }
        }

        this.revalidate();
        this.repaint();

        String[] columnNames = { "Name", "Roll Number", "Department" };
        String[][] data = { { "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" },{ "Kundan Kumar Jha", "4031", "CSE" }, { "Anand Jha", "6014", "IT" }, { "Name", "Roll Number", "Department" }};

        table = new Table(data, columnNames);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;

        this.add(table, gbc);
    }


    public PieChart getPieChart () { return this.pieChart; }

}
