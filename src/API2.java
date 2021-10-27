import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API2 extends JPanel {

    JPanel top;
    JPanel bottom;
    JPanel topOfTop;

    GridBagConstraints gbc;

    JButton APISubmit;

    JTextField searchbar;

    JLabel APITitle;
    JLabel bottomLabel;

    public API2() {

        this.setLayout(new GridLayout(2,1));
        this.setBackground(Color.BLACK);

        //----------------------------------- TOP

        top = new JPanel();
        top.setLayout(new GridLayout(3, 2, 10, 10));
        top.setBackground(Color.blue);

        this.add(top);

        //----------------------------------- TOPOFTOP

        topOfTop = new JPanel();
        topOfTop.setLayout(new GridBagLayout());
        top.add(topOfTop);

        //----------------------------------- API TITLE
        APITitle = new JLabel("API");
        topOfTop.add(APITitle);
        //----------------------------------- SEARCHBAR
        searchbar = new JTextField("Food Name?", 10);
        top.add(searchbar);

        //----------------------------------- SUBMIT BUTTON

        APISubmit = new JButton("Submit");
        top.add(APISubmit);

        // ----------------------------------------- Action Listener for searchbar

        APISubmit.addActionListener(e -> {
            String something = searchbar.getText ();
            System.out.println(something);

            bottomLabel.setText(something);
        });

        //----------------------------------- BOTTOM

        bottom = new JPanel();
        bottom.setBackground(Color.YELLOW);
        bottom.setLayout(new GridBagLayout());

        this.add(bottom);

        //----------------------------------- BOTTOMLABEL

        bottomLabel = new JLabel("LABLEL");

        bottom.add(bottomLabel);


    }

    public void fetchResultsFromNutritionAPIOnline (String query) {
        String url = "https://trackapi.nutritionix.com/v2/search/instant?query=" + query;
        String apikey = "716eebfff20e3e750f25fcbd9e860ceb";
        String apiid = "0e1f918f";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create (url))
                .header ("Content-Type", "application/json")
                .header("x-app-key", apikey)
                .header("x-app-id", apiid)
                .build();

        client.sendAsync (request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

}
