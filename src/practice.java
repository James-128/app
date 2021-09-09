import javax.swing.*;
import java.awt.*;

public class practice {


    public static void main(String[] args) {
        JFrame frame;

        JPanel pane1;
        JPanel panel12;
        JPanel panel13;
        JPanel pane2;

        JLabel namelabel;
        JLabel calnumlabel;

        JTextField nametext;
        JTextField calnumtext;

        JButton submitname;
//----------------------------------------------------------
        frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(800, 500);

        pane1 = new JPanel();
        pane1.setLayout(new GridLayout(1, 2));
        pane1.setBackground(Color.black);

//------------------------------------------------top left panel

        panel13 = new JPanel();
        panel13.setLayout(new GridBagLayout());
        panel13.setBackground(Color.yellow);

        // Top left quadrant
        ManualEntry manualEntryComponent = new ManualEntry();
        pane1.add (manualEntryComponent);


//        panel12.add(nametext, c12);
        pane1.add(panel13);
        frame.add(pane1);


//-----------------------------------------------------------------------------------

        pane2 = new JPanel();
        pane2.setLayout(new GridBagLayout());
        bottom bottom = new bottom();
        pane2.add(bottom);
        frame.add(pane2);
        frame.setVisible(true);

        frame.invalidate();
    }
}
