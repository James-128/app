import javax.swing.*;
import java.awt.*;

public class practice implements Runnable{


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

    @Override
    public void run() {

        frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(800, 500);



        pane1 = new JPanel();
        pane1.setLayout(new GridLayout(1, 2));
        pane1.setBackground(Color.black);

        panel12 = new JPanel();
        panel12.setLayout(new GridBagLayout());
        panel12.setBackground(Color.cyan);


        namelabel = new JLabel("name: ");
        GridBagConstraints c12 = new GridBagConstraints();
        c12.gridx = 0;
        c12.gridy = 0;
        c12.weightx = .1;
        c12.weighty = .1;
        c12.anchor = GridBagConstraints.PAGE_START;
        panel12.add(namelabel);

        panel13 = new JPanel();
        panel13.setLayout(new GridBagLayout());
        panel13.setBackground(Color.yellow);


//        GridBagConstraints c13 = new GridBagConstraints();

        pane1.add(panel12);
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
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new practice());
    }
}
