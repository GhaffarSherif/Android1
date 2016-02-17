package packFinals;

import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

/**
 * Created by Shadowfire2303 on 15/02/2016.
 */
public class clsFinals implements InterFinals{
    public ArrayList<String> studentId;
    public ArrayList<String> name;
    public ArrayList<Double> grade1;
    public ArrayList<Double> grade2;
    public ArrayList<Double> grade3;
    public ArrayList<Double> finalGrade;
    public ArrayList<String> letterGrade;


    public clsFinals(){
        studentId = new ArrayList<String>();
        name = new ArrayList<String>();
        grade1 = new ArrayList<Double>();
        grade2 = new ArrayList<Double>();
        grade3 = new ArrayList<Double>();
        finalGrade = new ArrayList<Double>();
        letterGrade = new ArrayList<String>();
    }


    public static double compute(int mark1, int mark2, int mark3, boolean isProg1){ // To compute given grades
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

    public void displayResults(TextView resultBox){
        String results = "";

        for(int i = 0; i < studentId.size(); i++){
            results += studentId.get(i) + "\t" + name.get(i) + "\t" + grade1.get(i) + "\t" + grade2.get(i) + "\t" + grade3.get(i) + "\t" + finalGrade.get(i) + "\t" + letterGrade.get(i) + "\n";
        }

        resultBox.setText(programming1Header + results);
    }

    public static void clear(){

    }

}
