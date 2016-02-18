package packFinals;

import android.widget.EditText;
import android.widget.TextView;
import java.util.*;

/**
 * Created by Shadowfire2303 on 15/02/2016.
 */
public class clsFinals implements InterFinals{
    public int studentId;
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;
    public double finalGrade = ZERO;
    public char letterGrade = ' ';
    boolean isProg1;


    public clsFinals(){
        studentId = ZERO;
        name = BLANK;
        grade1 = ZERO;
        grade2 = ZERO;
        grade3 = ZERO;
    }

    public clsFinals(int studentId, String name, double grade1, double grade2, double grade3, boolean isProg1){
        this.studentId = studentId;
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.isProg1 = isProg1;
    }


    public void setStudentId(int id){
        studentId = id;
    }

    public void setName(String studentName){
        name = studentName;
    }

    public void setGrade1(Double mark1){
        grade1 = mark1;
    }

    public void setGrade2(Double mark2) {

        grade2 = mark2;
    }

    public void setGrade3(Double mark3){

        grade3 = mark3;
    }

    public char getLetterGrade(){
        return letterGrade;
    }

    public double getFinalGrade(){
        return finalGrade;
    }



    public void compute(){ // To compute given grades
        if (isProg1)
            finalGrade = (grade1*0.3)+(grade2*0.3)+(grade3*0.4);
        else
            finalGrade = (grade1*0.2)+(grade2*0.3)+(grade3*0.5);
    }

    public char calcLetterGrade(int grade){
       // if (){

     //   }
        return ' ';
    }


    /*
    public boolean isFilled(){

        if (name.getText().toString().trim().length()==0 || id.getText().toString().trim().length()==0 ||
                mark1.getText().toString().trim().length()==0 || mark2.getText().toString().trim().length()==0
                || mark3.getText().toString().trim().length()==0){
            return false;
        }
        return true;
    }
    */

    /*public void displayResults(TextView resultBox){
        String results = "";

        for(int i = 0; i < studentId.size(); i++){
            results += studentId.get(i) + "\t" + name.get(i) + "\t" + grade1.get(i) + "\t" + grade2.get(i) + "\t" + grade3.get(i) + "\t" + finalGrade.get(i) + "\t" + letterGrade.get(i) + "\n";
        }

        resultBox.setText(programming1Header + results);
    }
    */


}
