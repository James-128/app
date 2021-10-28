import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;

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

            API2.fetchResultsFromNutritionAPIOnline(something);
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

    public static void fetchResultsFromNutritionAPIOnline (String query) {

        String apikey = "fYwLcMgU9oUkNPRX8lVknkuwSWDehaqhoa9mXSAd";
        String url = "https://api.nal.usda.gov/fdc/v1/foods/search?query=" + query + "&pageSize=2&api_key=" + apikey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (response == null) {
            System.out.println ("api response is null");
            return;
        }

//        System.out.println(response.body());

        JSONObject jo = new JSONObject(response.body());
        JSONArray results = jo.getJSONArray("foods");
//        System.out.println(results.toString());
        JSONObject first = new JSONObject(results.get(0).toString());
//        System.out.println(first.toString());
        JSONArray nutrients = new JSONArray(first.getJSONArray("foodNutrients"));
//        System.out.println (nutrients.toString());
        int numNutrients = nutrients.length();

        ArrayList<String> info = new ArrayList<>(10);
        for (int i = 0; i < numNutrients; i++) {

            JSONObject nutrient = new JSONObject(nutrients.get(i).toString());

            String nutrientName = nutrient.get("nutrientName").toString();
            String unitName = nutrient.get("unitName").toString();
            String value = nutrient.get("value").toString();

            if (nutrientName.equals("Total lipid (fat)")) {
                nutrientName = "Fat";
            }
            else if (nutrientName.equals("Carbohydrate, by difference")) {
                nutrientName = "Carbs";
            }
            else if (nutrientName.equals("Energy")) {
                nutrientName = "";
            }
            else if (nutrientName.equals("Sugars, total including NLEA")) {
                nutrientName = "Sugar";
            }
            else if (nutrientName.equals("Fiber, total dietary")) {
                nutrientName = "Fiber";
            }
            else if (nutrientName.equals("Sodium, Na")) {
                nutrientName = "Sodium";
            }
            else if (nutrientName.equals("Fatty acids, total trans")) {
                continue;
            }
            else if (nutrientName.equals("Fatty acids, total saturated")) {
                continue;
            }

            if (unitName.equals("KCAL")) {
                info.add (value + " cal");
                continue;
            }

            info.add (nutrientName + " " + value + unitName);
        }

        for (String infoItem : info) {
            System.out.println (infoItem);
        }

    }

}
