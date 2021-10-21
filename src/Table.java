import javax.swing.*;

public class Table extends JTable {


    public Table (){

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
    }
}
