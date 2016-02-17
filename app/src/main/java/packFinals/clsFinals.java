package packFinals;

import android.view.View;
import android.widget.TextView;

import java.util.*;

/**
 * Created by Shadowfire2303 on 15/02/2016.
 */
public class clsFinals {
    public static ArrayList<String> id = new ArrayList<String>();
    public static ArrayList<String> name = new ArrayList<String>();
    public static ArrayList<Double> grade1 = new ArrayList<Double>();
    public static ArrayList<Double> grade2 = new ArrayList<Double>();
    public static ArrayList<Double> grade3 = new ArrayList<Double>();
    public static ArrayList<Double> finalGrade = new ArrayList<Double>();
    public static ArrayList<String> letterGrade = new ArrayList<String>();
    public static ArrayList<Integer> isProgramming1 = new ArrayList<Integer>();

    private static String programming1Header = "ID\tStudent\tCase /30\tEx 1/30\tEx 2/40\tFinal/100\tLetter Grade\n";
    private static String programming2Header = "ID\tStudent\tAs1/20\tAs2/30\tEx/50\tFinal/100\tLetter Grade\n";

    /*public static calculate(){

    }*/

    public static void displayResults(TextView resultBox){
        String programming1 = "";
        String programming2 = "";

        for(int i = 0; i < id.size(); i++){
            if(isProgramming1.get(i) == 1)
                programming1 += id.get(i) + "\t" + name.get(i) + "\t" + grade1.get(i) + "\t" + grade2.get(i) + "\t" + grade3.get(i) + "\t" + finalGrade.get(i) + "\t" + letterGrade.get(i) + "\n";
            else if(isProgramming1.get(i) == 0)
                programming2 += id.get(i) + "\t" + name.get(i) + "\t" + grade1.get(i) + "\t" + grade2.get(i) + "\t" + grade3.get(i) + "\t" + finalGrade.get(i) + "\t" + letterGrade.get(i) + "\n";
        }

        resultBox.setText(programming1Header + programming1 + programming2Header + programming2);
    }
}
