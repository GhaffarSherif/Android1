package com.example.cstuser.assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import packFinals.InterFinals;
import packFinals.clsFinals;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, InterFinals {
    // Declaring new student object to store info and two strings for the results for both classes
    clsFinals studentInfo;
    String prog1Results = PROGRAMMING_1_HEADER;
    String prog2Results = PROGRAMMING_2_HEADER;

    // Declaring widgets
    Button compute;
    Button clear;
    Button done;
    Button exit;
    RadioButton prog1;
    RadioButton prog2;
    RadioGroup radioGroup;
    TextView eval1;
    TextView eval2;
    TextView eval3;
    TextView finalScore;
    EditText name;
    EditText studentId;
    EditText mark1;
    EditText mark2;
    EditText mark3;
    TextView resultsBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the proper IDs for the proper widgets
        compute = (Button) this.findViewById(R.id.compute);
        clear = (Button) this.findViewById(R.id.clear);
        done = (Button) this.findViewById(R.id.done);
        exit = (Button) this.findViewById(R.id.exit);

        prog1 = (RadioButton) this.findViewById(R.id.prog1);
        prog2 = (RadioButton) this.findViewById(R.id.prog2);
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);

        eval1 = (TextView) this.findViewById(R.id.eval1);
        eval2=(TextView) this.findViewById(R.id.eval2);
        eval3= (TextView) this.findViewById(R.id.eval3);
        finalScore = (TextView) this.findViewById(R.id.finalScore);
        resultsBox = (TextView) this.findViewById(R.id.resultsBox);


        mark1 = (EditText) this.findViewById(R.id.mark1);
        mark2 = (EditText) this.findViewById(R.id.mark2);
        mark3 = (EditText) this.findViewById(R.id.mark3);
        name = (EditText) this.findViewById(R.id.name);
        studentId = (EditText) this.findViewById(R.id.studentId);

        //Setting the listeners for the widgets in use
        compute.setOnClickListener(this);
        clear.setOnClickListener(this);
        done.setOnClickListener(this);
        exit.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == compute.getId()) { // Onclick compute button
            if (isFilled() && isValid()){
                // Checking which radiobutton is checked, then passing info to the clsFinals object
                if (prog1.isChecked())
                    studentInfo = new clsFinals(Integer.parseInt(studentId.getText().toString()), name.getText().toString(), Integer.parseInt(mark1.getText().toString()),
                            Integer.parseInt(mark2.getText().toString()), Integer.parseInt(mark3.getText().toString()), true);
                else
                    studentInfo = new clsFinals(Integer.parseInt(studentId.getText().toString()), name.getText().toString(), Integer.parseInt(mark1.getText().toString()),
                            Integer.parseInt(mark2.getText().toString()), Integer.parseInt(mark3.getText().toString()), false);

                studentInfo.calculateScore();
                setFinalScore();
            }
        }

        if (v.getId() == clear.getId()) { // onclick clear button
            mark1.getText().clear();
            mark2.getText().clear();
            mark3.getText().clear();
            name.getText().clear();
            studentId.getText().clear();
            finalScore.setText(BLANK);
            Toast.makeText(getApplicationContext(), "Screen Cleared!", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == done.getId()) {
            if (isFilled()) {
                compute.performClick();
                alertMessage();
            }
        }

        if (v.getId() == exit.getId()) {
            showReport();

            final Handler handler = new Handler();
            //Delays the calling of the finish() method by
            //time equal to TIME_TO_END_PROCESS_MS in milliseconds.
            handler.postDelayed(new Runnable(){
                @Override
                public void run() {
                    finish();
                }
            }, TIME_TO_END_PROCESS_MS);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == prog1.getId()){
            eval1.setText(R.string.eval1Prog1);
            eval2.setText(R.string.eval2Prog1);
            eval3.setText(R.string.eval3Prog1);

        }
        if (checkedId == prog2.getId()){
            eval1.setText(R.string.eval1Prog2);
            eval2.setText(R.string.eval2Prog2);
            eval3.setText(R.string.eval3Prog2);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isFilled(){
        // Checks if not filled
        if (name.getText().toString().trim().length()==0 || studentId.getText().toString().trim().length()==0 ||
                mark1.getText().toString().trim().length()==0 || mark2.getText().toString().trim().length()==0
                || mark3.getText().toString().trim().length()==0){
            Toast.makeText(MainActivity.this, "Not all fields are filled!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setFinalScore(){
        finalScore.setText(String.format("%s%-18s","Final Score: ", studentInfo.finalGrade) +  "Letter Grade: " + studentInfo.letterGrade);
    }

    /**
     * Creates and displays a confirmation message to check if the user would like to enter more values.
     */
    private void alertMessage() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        clear.performClick();
                        addResults();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        clear.performClick();
                        addResults();
                        exit.performClick();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to enter another student?")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    /**
     * Adds the results of a student to the cumulative string containing all student's value for a given class.
     */
    private void addResults() {
        if(prog1.isChecked())
            prog1Results += studentInfo.returnStudentResults();
        else
            prog2Results += studentInfo.returnStudentResults();
    }

    /**
     * Sets the text of the resultsBox to have the report.
     */
    private void showReport() {
        String allResults = prog1Results + prog2Results;

        resultsBox.setText(getString(R.string.report, allResults));
    }

    /**
     * Checks if all marks entered are valid.
     * @return true if valid.
     */
    private boolean isValid(){
        if(Double.parseDouble(mark1.getText().toString()) > 100 || Double.parseDouble(mark1.getText().toString()) < 0){
            Toast.makeText(getApplicationContext(), "First Evaluation Invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(Double.parseDouble(mark2.getText().toString()) > 100 || Double.parseDouble(mark2.getText().toString()) < 0){
            Toast.makeText(getApplicationContext(), "Second Evaluation Invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(Double.parseDouble(mark3.getText().toString()) > 100 || Double.parseDouble(mark3.getText().toString()) < 0){
            Toast.makeText(getApplicationContext(), "Third Evaluation Invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }
}
