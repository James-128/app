import java.awt.*;

public class PieChartKey extends Canvas {

        private final Color RED = Color.RED;
        private final Color GREEN = Color.GREEN;
        private final Color YELLOW = Color.YELLOW;
        private final Color BLACK = Color.BLACK;
        private final Color PINK = new Color (252, 0, 227, 255);
        private final Color PURPLE = new Color (101, 0, 252, 255);
        private int labely;

        public PieChartKey () {

            this.setSize(150, 200);
        }
        @Override
        public void paint(Graphics g)
        {
            labely = 30;
            // set Font
            g.setFont(new Font("Bold", 1, 10));

            // Protein
            g.setColor(PURPLE);
            g.drawString("         Protein", 10, labely);
            g.fillRect(20, labely-10, 10, 10);
            labely += 20;

            // Trash
            g.setColor(Color.ORANGE);
            g.drawString("         Trash", 10, labely);
            g.fillRect(20, labely-10, 10, 10);
            labely += 20;

            // Veggie
            g.setColor(GREEN);
            g.drawString("         Veggie", 10, labely);
            g.fillRect(20, labely-10, 10, 10);
            labely += 20;

            // Dairy
            g.setColor(Color.WHITE);
            g.drawString("         Dairy", 10, labely);
            g.fillRect(20, labely-10, 10, 10);
            labely += 20;

            // Fruit
            g.setColor(RED);
            g.drawString("         Fruit", 10, labely);
            g.fillRect(20, labely-10, 10, 10);
            labely += 20;

            // Grain
            g.setColor(YELLOW);
            g.drawString("         Grain", 10, labely);
            g.fillRect(20, labely-10, 10, 10);
            labely += 20;
        }
}

