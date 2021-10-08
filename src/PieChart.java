import java.awt.*;
import javax.swing.JFrame;

public class PieChart extends Canvas {

    int totalCal = 267;
    int veggieCal = 10;
    int protienCal = 100;
    int DairyCals = 157;

    int currentAngle = 0;

    private final int pcw = 200;
    private final int pch = 200;
    private final int pcX = (250 - pcw)/2;
    private final int pcY = (250 - pch)/2 - 10;


    public PieChart() {
        this.setBackground(Color.BLACK);
        this.setSize(250, 250);
    }

    @Override
    public void paint (Graphics g) {

        int angle = 0;
        g.setColor(Color.GREEN);
        angle = Utility.caloriesToAngle(veggieCal, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(Color.RED);
        angle = Utility.caloriesToAngle(protienCal, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(Color.YELLOW);
        angle = 360 - currentAngle;
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

    }

}
