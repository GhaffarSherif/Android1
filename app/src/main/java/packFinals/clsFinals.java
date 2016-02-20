package packFinals;

public class clsFinals implements InterFinals{
    public int studentId;
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;
    public double finalGrade = ZERO;
    public char letterGrade = BLANK_CHAR;
    boolean isProg1;

    /**
     * Constructor to initialize data members to default value
     */
    public clsFinals(){
        studentId = ZERO;
        name = BLANK;
        grade1 = ZERO;
        grade2 = ZERO;
        grade3 = ZERO;
        isProg1 = true;
    }

    /**
     * Constructor to initialize the data members to given values
     * @param studentId
     * @param name
     * @param grade1
     * @param grade2
     * @param grade3
     * @param isProg1
     */
    public clsFinals(int studentId, String name, double grade1, double grade2, double grade3, boolean isProg1){
        this.studentId = studentId;
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.isProg1 = isProg1;
    }

    public void calculateScore(){ // To compute given grades
        if (isProg1) {
            grade1 = Math.round(grade1 * 0.3 * 100.0)/100.0;
            grade2 = Math.round(grade2 * 0.3 * 100.0)/100.0;
            grade3 = Math.round(grade3 * 0.4 * 100.0)/100.0;
            finalGrade = Math.round((grade1 + grade2 + grade3)*100.0)/100.0;
            letterGrade = calcLetterGrade((int) finalGrade);
        }
        else{
            grade1 = grade1 * 0.2;
            grade2 = grade2 * 0.3;
            grade3 = grade3 * 0.5;
            finalGrade = grade1 + grade2 + grade3;
            letterGrade = calcLetterGrade((int) finalGrade);
        }
    }

    private char calcLetterGrade(int grade) {
        char letterGrade = BLANK_CHAR;

        if(grade >= GRADE_A_LOWER_LIMIT && grade <= GRADE_A_UPPER_LIMIT)
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

    public String returnStudentResults() {
        return String.format("%-6s", studentId) + String.format("%-22s", name) + String.format("%-9s", grade1) + String.format("%-9s", grade2) + String.format("%-9s", grade3) + String.format("%-11s", finalGrade) + String.format("%-12s", letterGrade) + "\n";
    }
}
