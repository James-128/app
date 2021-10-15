import java.io.*;
import java.util.ArrayList;

public class FoodData {

    private String foodName;
    private Object calorieCount;
    private int  FruitCals;
    private int  VeggieCals;
    private int ProteinCals;
    private int  DairyCals;
    private int  GrainCals;
    private int TrashCals;

    public FoodData(String foodName, Object calorieCount, boolean isFruit, boolean isVeggie, boolean isProtein, boolean isDairy, boolean isGrain, boolean isTrash) {
        this.foodName = foodName;
        this.calorieCount = calorieCount;

        int cals = (int) this.calorieCount;
        int numChecked = 0;

        // create boolean array of the checkboxes
        boolean[] checkboxes = new boolean [] { isFruit, isVeggie, isProtein, isDairy, isGrain, isTrash};

        // increment numChecked for each box that is checked
        for (boolean checked : checkboxes) {
            if (checked) {
                numChecked++;
            }
        }

        // avoid divide by zero
        if (numChecked == 0) {
            System.out.println ("[ERROR] cannot divide by zero in FoodData");
            return;
        }

        // calculate the split calorie value
        int splitCals = cals / numChecked;

        this.FruitCals = isFruit ? splitCals : 0;
        this.VeggieCals = isVeggie ? splitCals : 0;
        this.ProteinCals = isProtein ? splitCals : 0;
        this.DairyCals = isDairy ? splitCals : 0;
        this.GrainCals = isGrain ? splitCals : 0;
        this.TrashCals = isTrash ? splitCals : 0;

    }

    @Override
    public String toString() {
        return        foodName +
                "," + calorieCount +
                "," + FruitCals +
                "," + VeggieCals +
                "," + ProteinCals +
                "," + DairyCals +
                "," + GrainCals +
                "," + TrashCals + '\n';
    }

    public void writeToFile(){
        String filename = "foodData.csv";
        try {

            File f = new File(filename);


            if(f.createNewFile()) {
                System.out.println("file created");

            } else {
                System.out.println("file already exists");

            }

        } catch (IOException e){
            e.printStackTrace();

        }

        try{

            FileWriter writer = new FileWriter(filename, true);
            writer.write(this.toString());
            writer.close();

        } catch (IOException e){
            e.printStackTrace();

        }
    }

    public static int[] getFoodData() {
        int[] fd = new int[7];

        // create file reader
        BufferedReader br = null;
        try {
            br = new BufferedReader( new FileReader("foodData.csv") );
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // reads foodData.csv to end-of-file filling up an array list with the lines
        ArrayList<String> lines = new ArrayList<>(1000);
        String line = "";
        while (line != null) {
            try {
                line = br.readLine();

                if (line == null){
                    break;
                }

                lines.add (line);
            }
            catch (Exception e ) {
                e.printStackTrace();
            }

        }

        fd [0] = getTotalCalories (lines);
        fd [1] = getFruitTotal (lines);
        fd [2] = getVeggieTotal (lines);
        fd [3] = getProteinTotal (lines);
        fd [4] = getDairyTotal (lines);
        fd [5] = getGrainTotal (lines);
        fd [6] = getTrashTotal (lines);

        return fd;
    }

    private static int getDairyTotal (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "dairy");
        }

        return total;
    }

    private static int getProteinTotal (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "protein");
        }

        return total;
    }

    private static int getVeggieTotal (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "veggie");
        }

        return total;
    }

    private static int getTrashTotal (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "trash");
        }

        return total;
    }

    private static int getFruitTotal (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "fruit");
        }

        return total;
    }

    private static int getGrainTotal (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "grain");
        }

        return total;
    }

    private static int getTotalCalories (ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            total += getValueAtColumn(line, "total");
        }

        return total;
    }

    private static int getValueAtColumn (String line, String column) {
        String[] splitted = line.split(",");

        switch (column) {
            case "total"  : return Integer.valueOf(splitted [1]);
            case "fruit"  : return Integer.valueOf(splitted [2]);
            case "veggie" : return Integer.valueOf(splitted [3]);
            case "protein": return Integer.valueOf(splitted [4]);
            case "dairy"  : return Integer.valueOf(splitted [5]);
            case "grain"  : return Integer.valueOf(splitted [6]);
            case "trash"  : return Integer.valueOf(splitted [7]);
        }

        return -1;
    }


}
