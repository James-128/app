import java.awt.*;
import javax.swing.JFrame;

public class PieChart extends Canvas {

    int totalCal = 0;
    int fruitCal = 0;
    int veggieCal = 0;
    int proteinCal = 0;
    int DairyCals = 0;
    int grainCals = 0;
    int trashCals = 0;

    private final Color RED = Color.RED;
    private final Color GREEN = Color.GREEN;
    private final Color YELLOW = Color.YELLOW;
    private final Color BLACK = Color.BLACK;
    private final Color PINK = new Color (252, 0, 227, 255);
    private final Color PURPLE = new Color (101, 0, 252, 255);

    int currentAngle = 0;

    private final int pcw = 200;
    private final int pch = 200;
    private final int pcX = (250 - pcw)/2;
    private final int pcY = (250 - pch)/2 - 10;


    public PieChart() {
//        this.setBackground(Color.BLACK);
        this.setSize(250, 250);
    }

    public void update() {

        // get all the calorie info
        int[] data = FoodData.getFoodData();

        totalCal = data[0];
        fruitCal = data[1];
        veggieCal = data[2];
        proteinCal = data[3];
        DairyCals = data[4];
        grainCals = data[5];
        trashCals = data[6];

        this.invalidate();
    }

    @Override
    public void paint (Graphics g) {

        int angle = 0;

        g.setColor(GREEN);
        angle = Utility.caloriesToAngle(veggieCal, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(PURPLE);
        angle = Utility.caloriesToAngle(proteinCal, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(RED);
        angle = Utility.caloriesToAngle(fruitCal, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(PINK);
        angle = Utility.caloriesToAngle(DairyCals, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(BLACK);
        angle = Utility.caloriesToAngle(trashCals, totalCal);
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

        g.setColor(YELLOW);
        angle = 360 - currentAngle;
        g.fillArc(pcX,pcY, pcw,pch, currentAngle, angle);
        currentAngle += angle;

    }

}
