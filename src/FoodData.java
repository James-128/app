import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        return new int[3];
    }

    private int getDairyTotal () {
        return 0;
    }

    private int getProteinTotal () {
        return 0;
    }

    private int getVeggieTotal () {
        return 0;
    }

    private int getTrashTotal () {
        return 0;
    }

    private int getFruitTotal () {
        return 0;
    }

    private int getGrainTotal () {
        return 0;
    }

    private int getTotalCalories () {
        return 0;
    }


}
