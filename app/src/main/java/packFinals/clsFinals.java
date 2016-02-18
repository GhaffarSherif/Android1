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
    public char letterGrade = BLANK_CHAR;


    public clsFinals(){
        studentId = ZERO;
        name = BLANK;
        grade1 = ZERO;
        grade2 = ZERO;
        grade3 = ZERO;
    }

    public clsFinals(int studentId, String name, double grade1, double grade2, double grade3){
        this.studentId = studentId;
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
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



    public static double compute(int mark1, int mark2, int mark3, boolean isProg1){ // To compute given grades
         double average= 0;
        if (isProg1)
            average = (mark1*0.3)+(mark2*0.3)+(mark3*0.4);
        else
            average = (mark1*0.2)+(mark2*0.3)+(mark3*0.5);
        return average;
    }

    public char calcLetterGrade(int grade){
        char letterGrade = BLANK_CHAR;

        if(grade >= GRADE_A_LOWER_LIMIT && grade < GRADE_A_UPPER_LIMIT)
            letterGrade = GRADE_A;
        else if(grade >= GRADE_B_LOWER_LIMIT && grade < GRADE_B_UPPER_LIMIT)
            letterGrade = GRADE_B;
        else if(grade >= GRADE_C_LOWER_LIMIT && grade < GRADE_C_UPPER_LIMIT)
            letterGrade = GRADE_C;
        else if(grade >= GRADE_D_LOWER_LIMIT && grade < GRADE_D_UPPER_LIMIT)
            letterGrade = GRADE_D;
        else if(grade >= GRADE_F_LOWER_LIMIT && grade < GRADE_F_UPPER_LIMIT)
            letterGrade = GRADE_F;

        return letterGrade;
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


    public String displayResults(){
        String results = studentId + "\t" + name + "\t" + grade1 + "\t" + grade2 + "\t" + grade3 + "\t" + finalGrade + "\t" + letterGrade + "\n";
        return results;
    }

    public static void clear(){

    }

}
