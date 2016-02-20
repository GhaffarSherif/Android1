package packFinals;

public interface InterFinals {
    public final char GRADE_A = 'A';
    public final char GRADE_B = 'B';
    public final char GRADE_C = 'C';
    public final char GRADE_D = 'D';
    public final char GRADE_F = 'F';

    public final int GRADE_A_UPPER_LIMIT = 100;
    public final int GRADE_A_LOWER_LIMIT = 90;
    public final int GRADE_B_UPPER_LIMIT = 89;
    public final int GRADE_B_LOWER_LIMIT = 80;
    public final int GRADE_C_UPPER_LIMIT = 79;
    public final int GRADE_C_LOWER_LIMIT = 70;
    public final int GRADE_D_UPPER_LIMIT = 69;
    public final int GRADE_D_LOWER_LIMIT = 60;
    public final int GRADE_F_UPPER_LIMIT = 59;
    public final int GRADE_F_LOWER_LIMIT = 0;

    public final String PROGRAMMING_1_HEADER = String.format("%-6s", "ID") + String.format("%-22s", "Student Name") + String.format("%-9s", "Case/30") + String.format("%-9s", "Ex1/30") + String.format("%-9s", "Ex2/40") + String.format("%-11s", "Final/100") + String.format("%-12s", "Letter Grade") + "\n";
    public final String PROGRAMMING_2_HEADER = "\n" + String.format("%-6s", "ID") + String.format("%-22s", "Student Name") + String.format("%-9s", "As1/20") + String.format("%-9s", "As2/30") + String.format("%-9s", "Ex/50") + String.format("%-11s", "Final/100") + String.format("%-12s", "Letter Grade") + "\n";
    public final String BLANK = "";
    public final char BLANK_CHAR = ' ';
    public final int ZERO = 0;

    public final int TIME_TO_END_PROCESS_MS = 30000;
}
