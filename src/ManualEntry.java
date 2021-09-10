import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManualEntry extends JPanel {

    private JTextField text;
    private JLabel namelabel;
    private JTextField nametext;
    private GridBagConstraints gbc;
    private JButton submitname;

    public ManualEntry() {

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.cyan);


        gbc = new GridBagConstraints();

        namelabel = new JLabel("name: ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = .1;
        gbc.weighty = .1;
        gbc.insets.left = 25;
        gbc.anchor = GridBagConstraints.LINE_START;

        this.add(namelabel, gbc);

        nametext = new JTextField("hello", 10);
        gbc.weightx = .9;
        gbc.weighty = 0.1;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        this.add (nametext, gbc);

        submitname = new JButton("submit");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets.right = 10;
        gbc.insets.bottom = 10;

        this.add(submitname, gbc);

        submitname.addActionListener(e -> {
            String textFieldtext = nametext.getText();
            System.out.println(textFieldtext);
            });
    }

}
