import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FoodData {

    private String foodName;
    private Object calorieCount;
    private boolean isFruit;
    private boolean isVeggie;
    private boolean isProtein;
    private boolean isDairy;
    private boolean isGrain;
    private boolean isTrash;

    public FoodData(String foodName, Object calorieCount, boolean isFruit, boolean isVeggie, boolean isProtein, boolean isDairy, boolean isGrain, boolean isTrash) {
        this.foodName = foodName;
        this.calorieCount = calorieCount;
        this.isFruit = isFruit;
        this.isVeggie = isVeggie;
        this.isProtein = isProtein;
        this.isDairy = isDairy;
        this.isGrain = isGrain;
        this.isTrash = isTrash;
    }

    @Override
    public String toString() {
        return        foodName +
                "," + calorieCount +
                "," + isFruit +
                "," + isVeggie +
                "," + isProtein +
                "," + isDairy +
                "," + isGrain +
                "," + isTrash + '\n';
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
