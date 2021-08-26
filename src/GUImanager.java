import javax.swing.*;

public class GUImanager{

    private static state stat;

    public static void main(String[] args) throws InterruptedException {

        stat = new gui1();

        SwingUtilities.invokeLater((Runnable) stat);

        while (true){
            while (stat.active){
                Thread.sleep(300);

            }

            nextState();

            SwingUtilities.invokeLater((Runnable) stat);
        }


    }
    public static void nextState(){

        if (stat.nextState.equals("gui1")){
            stat = new gui1();
        }
        else if  (stat.nextState.equals("gui2")){
            stat = new gui2();
        }
    }
}
