import javax.swing.*;
import java.awt.*;

public class practice {
    static bottom bottomComponents;

    public static void main(String[] args) {

        JFrame frame;

        JPanel tophalf;
        JPanel right;
        JPanel bottomhalf;

//---------------------------------------------------------- overall frame
        frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(855, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//------------------------------------------------top half

        tophalf = new JPanel();
        tophalf.setLayout(new GridLayout(1, 2));
        tophalf.setBackground(Color.black);
        frame.add(tophalf);
        tophalf.setBorder(BorderFactory.createLineBorder(Color.black));
//------------------------------------------------top left


        // Top left quadrant
        ManualEntry manualEntryComponent = new ManualEntry();
        tophalf.add (manualEntryComponent);


//------------------------------------------------top right
        right = new JPanel();
        right.setLayout(new GridLayout(1,1));
        right.setBackground(Color.yellow);
        API2 api = new API2();
        right.add(api);
        tophalf.add(right);
        right.setBorder(BorderFactory.createLineBorder(Color.black));


//------------------------------------------------bottom half

        bottomhalf = new JPanel();
        bottomhalf.setLayout(new GridBagLayout());
        bottomComponents = new bottom();
        bottomhalf.add(bottomComponents);
        bottomhalf.setBackground(Color.ORANGE);
        frame.add(bottomhalf);
        manualEntryComponent.assignPieChart (bottomComponents.getPieChart());

        bottomhalf.setBorder(BorderFactory.createLineBorder(Color.black));

        // update drawn components
        bottomComponents.getPieChart().update();

        frame.setVisible(true);
        frame.invalidate();
    }

    public static bottom getBottom () {
        return practice.bottomComponents;
    }
}
