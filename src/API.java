import javax.swing.*;
import java.awt.*;

public class API extends JPanel {

    JLabel APITitle;
    JTextField searchbar;
    GridBagConstraints gbc;
    JLabel searchBarLabel;
    JButton APISubmit;

    public API() {

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.YELLOW);

        gbc = new GridBagConstraints();

        // ---------------------------------------- Start
        APITitle = new JLabel("API");
        gbc.gridx = 1;
        gbc.gridy = 0;
//        gbc.insets.bottom = 50;

        this.add(APITitle, gbc);
        gbc = new GridBagConstraints();

        //---------------------------------------- Label for Searchbar

//        searchBarLabel = new JLabel("Name");
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//
//        this.add(searchBarLabel, gbc);
//        gbc = new GridBagConstraints();

        // ---------------------------------------- searchbar

        searchbar = new JTextField("Food Name?", 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
//        gbc.insets.left = 50;
        this.add(searchbar, gbc);
        gbc = new GridBagConstraints();

        APISubmit = new JButton("Submit");

        // ----------------------------------------- Action Listener for searchbar
        APISubmit.addActionListener(e -> {


        });
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(APISubmit, gbc);
    }

}
