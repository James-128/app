import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

public class bottom extends JPanel{

    private JLabel stats;

    private GridBagConstraints gbc;

    private PieChart pieChart;
    private PieChartKey key;
    private Table table;


    public bottom() {


        this.setLayout(new GridBagLayout());


        pieChart = new PieChart();

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        this.add(pieChart, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;

        key = new PieChartKey();
        this.add(key, gbc);

        stats = new JLabel("stats");
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets.bottom = 100;

        this.add(stats, gbc);

        String[] columnNames = { "Total", "Fruit", "Veggie", "Protein", "Dairy", "Grain", "Trash"};
        String[][] data = {
                { "Total", "Fruit", "Veggie", "Protein", "Dairy", "Grain", "Trash"},
                {"", "", "", "", "", "", "", "" },
                {"", "", "", "", "", "", "", "" }};


        table = new Table(data, columnNames);

        this.table.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(6).setPreferredWidth(50);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets.right = 5;

        this.add(table, gbc);
        this.updateTable();
    }

    public void updateTable () {
        int[] foodData = FoodData.getFoodData();
        double tot = foodData[0];

        table.setValueAt(String.valueOf(foodData[0]), 1,0);
        table.setValueAt(String.valueOf(foodData[1]), 1,1);
        table.setValueAt(String.valueOf(foodData[2]), 1,2);
        table.setValueAt(String.valueOf(foodData[3]), 1,3);
        table.setValueAt(String.valueOf(foodData[4]), 1,4);
        table.setValueAt(String.valueOf(foodData[5]), 1,5);
        table.setValueAt(String.valueOf(foodData[6]), 1,6);
        //-------------------------------------------------------------
        table.setValueAt(String.format("%d%%", 100), 2,0);
        table.setValueAt(String.format("%.1f%%", foodData[1]/tot*100), 2,1);
        table.setValueAt(String.format("%.1f%%", foodData[2]/tot*100), 2,2);
        table.setValueAt(String.format("%.1f%%", foodData[3]/tot*100), 2,3);
        table.setValueAt(String.format("%.1f%%", foodData[4]/tot*100), 2,4);
        table.setValueAt(String.format("%.1f%%", foodData[5]/tot*100), 2,5);
        table.setValueAt(String.format("%.1f%%", foodData[6]/tot*100), 2,6);
    }


    public PieChart getPieChart () { return this.pieChart; }
}
