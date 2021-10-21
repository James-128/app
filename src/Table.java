import javax.swing.*;

public class Table extends JTable {

    public Table (String[][] data, String[] columnNames) {
        super (data, columnNames);

        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setBounds(30, 30, 200, 300);
        this.setFillsViewportHeight(true);
        this.rowHeight = 20;
    }

    @Override
    public boolean isCellEditable (int row, int column) {
        //all cells false
        return false;
    }
}
