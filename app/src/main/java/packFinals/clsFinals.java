package packFinals;

import android.widget.EditText;

import java.util.*;

/**
 * Created by Shadowfire2303 on 15/02/2016.
 */
public class clsFinals {
    public ArrayList<String> id = new ArrayList<String>();
    public ArrayList<String> name = new ArrayList<String>();
    public ArrayList<Double> grade1 = new ArrayList<Double>();
    public ArrayList<Double> grade2 = new ArrayList<Double>();
    public ArrayList<Double> grade3 = new ArrayList<Double>();
    public ArrayList<Double> finalGrade = new ArrayList<Double>();
    public ArrayList<String> letterGrade = new ArrayList<String>();
    public ArrayList<Integer> isProgramming1 = new ArrayList<Integer>();


    public static double compute(int mark1, int mark2, int mark3, boolean isProg1){
         double average= 0;
        if (isProg1)
            average = (mark1*0.3)+(mark2*0.3)+(mark3*0.4);
        else
            average = (mark1*0.2)+(mark2*0.3)+(mark3*0.5);
        return average;
    }

    /**
     * Intended to validate if all fields are empty or not
     */
    public static boolean isFilled(EditText name,EditText id, EditText mark1, EditText mark2,EditText mark3){


        if (name.getText().toString().trim().length()==0 || id.getText().toString().trim().length()==0 ||
                mark1.getText().toString().trim().length()==0 || mark2.getText().toString().trim().length()==0
                || mark3.getText().toString().trim().length()==0){
            return false;
        }
        return true;
    }



    public static void clear(){

    }

}
