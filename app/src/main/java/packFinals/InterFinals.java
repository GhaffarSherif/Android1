package packFinals;

import java.util.*;

/**
 * Created by Shadowfire2303 on 15/02/2016.
 */
public interface InterFinals {
    public ArrayList<String> id = new ArrayList<String>();
    public ArrayList<String> name = new ArrayList<String>();
    public ArrayList<Double> grade1 = new ArrayList<Double>();
    public ArrayList<Double> grade2 = new ArrayList<Double>();
    public ArrayList<Double> grade3 = new ArrayList<Double>();
    public ArrayList<Double> finalGrade = new ArrayList<Double>();
    public ArrayList<String> letterGrade = new ArrayList<String>();
    public ArrayList<Integer> isProgramming1 = new ArrayList<Integer>();

    public int calculateFinalGrade();
    public void displayAllGrades();
}
