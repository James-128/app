import javax.swing.*;
import java.awt.*;

public class practice {


    public static void main(String[] args) {

        JFrame frame;

        JPanel tophalf;
        JPanel right;
        JPanel bottomhalf;

//---------------------------------------------------------- overall frame
        frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//------------------------------------------------top half

        tophalf = new JPanel();
        tophalf.setLayout(new GridLayout(1, 2));
        tophalf.setBackground(Color.black);
        frame.add(tophalf);
//------------------------------------------------top left


        // Top left quadrant
        ManualEntry manualEntryComponent = new ManualEntry();
        tophalf.add (manualEntryComponent);


//------------------------------------------------top right
        right = new JPanel();
        right.setLayout(new GridBagLayout());
        right.setBackground(Color.yellow);
        tophalf.add(right);

//------------------------------------------------bottom half

        bottomhalf = new JPanel();
        bottomhalf.setLayout(new GridBagLayout());
        bottom bottomComponents = new bottom();
        bottomhalf.add(bottomComponents);
        frame.add(bottomhalf);
        manualEntryComponent.assignPieChart (bottomComponents.getPieChart());

        // update drawn components
        bottomComponents.getPieChart().update();

        frame.setVisible(true);
        frame.invalidate();
    }
}
