import javax.swing.*;
import java.awt.*;

public class ManualEntry extends JPanel {
//    private GridBagConstraints gbc;
    private JTextField text;

    public ManualEntry() {
//        this.setLayout(new GridBagLayout());
        this.setBackground(Color.CYAN);
//        gbc = new GridBagConstraints();
        text = new JTextField("test");
        this.add(text);
    }
}
