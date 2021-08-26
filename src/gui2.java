import javax.swing.*;
import java.awt.*;

public class gui2 extends state implements Runnable {

    JFrame frame;

    JPanel panel1;
    JPanel panel2;

    public void run() {


        frame = new JFrame();
        frame.setSize(500,500);
        frame.setLayout(new GridLayout());

        panel1 = new JPanel();
        frame.add(panel1);
        panel1.setBackground(Color.BLACK);
        panel2 = new JPanel();
        frame.add(panel2);
        panel2.setBackground(Color.BLUE);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new gui2());
    }

    public gui2() {

    }
}
