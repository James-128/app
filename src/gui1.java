import javax.swing.*;
import java.awt.*;

public class gui1 extends state implements Runnable {

    JFrame frame;

    JPanel panel1;
    JPanel panel2;

    public void run() {


        frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(500,500);


        panel1 = new JPanel();
        frame.add(panel1);
        panel1.setLayout(new GridLayout(1, 1));

        panel1.setBackground(Color.BLACK);
//        panel1.setBounds(10, 10, 20, 10);

        panel2 = new JPanel();
        frame.add(panel2);
        panel2.setLayout(new GridLayout(1, 1));

        panel2.setBackground(Color.BLUE);
//        panel2.setBounds(10, 10, 20, 10);


        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new gui2());
    }

    public gui1() {

    }
}
