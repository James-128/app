import javax.swing.*;
import java.awt.*;

public class practice {




    public static void main(String[] args) {
        JFrame frame;

        JPanel pane1;
        JPanel panel12;
        JPanel panel13;
        JPanel pane2;

        JLabel lab;
        JLabel lab2;
        JLabel lab3;

        JLabel namelabel;
        JLabel calnumlabel;

        JTextField nametext;
        JTextField calnumtext;

        JButton submitname;

        frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(800, 500);



        pane1 = new JPanel();
        pane1.setLayout(new GridLayout(1, 2));
        pane1.setBackground(Color.black);



        GridBagConstraints c12 = new GridBagConstraints();





        submitname = new JButton("submit");
        c12.gridx = 1;

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
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = .3;
        c2.weighty = .3;

        lab = new JLabel("food:");
        c2.gridx = 0;
        c2.gridy = 0;
        pane2.add(lab, c2);

        lab2 = new JLabel("cash:");
        c2.gridx = 1;
        c2.gridy = 0;
        pane2.add(lab2, c2);

        lab3 = new JLabel("money:");
        c2.gridx = 2;
        c2.gridy = 0;
        pane2.add(lab3, c2);

        frame.add(pane2);
        frame.setVisible(true);

        frame.invalidate();
    }
}
