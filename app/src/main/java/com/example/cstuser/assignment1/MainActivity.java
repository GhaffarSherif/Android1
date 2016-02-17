package com.example.cstuser.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import packFinals.InterFinals;
import packFinals.clsFinals;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, InterFinals {
    // Declaring Arrays for course
    ArrayList<String> prog1Course;
    ArrayList<String> prog2Course;
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

        mark1 = (EditText) this.findViewById(R.id.mark1);
        mark2 = (EditText) this.findViewById(R.id.mark2);
        mark3 = (EditText) this.findViewById(R.id.mark3);
        name = (EditText) this.findViewById(R.id.name);
        studentId = (EditText) this.findViewById(R.id.studentId);
        finalScore = (TextView) this.findViewById(R.id.finalScore);

        // Setting up the arraylist
        prog1Course = new ArrayList<String>();
        prog2Course = new ArrayList<String>();


        //Setting the listeners for the widgets
        compute.setOnClickListener(this);
        clear.setOnClickListener(this);
        done.setOnClickListener(this);
        exit.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == compute.getId()) { // Onclick compute button
            double finalGrade;

            if (clsFinals.isFilled(name, studentId, mark1, mark2, mark3)){
                // Create method to check if fields are empty before computing
                if (prog1.isChecked())
                    finalGrade = clsFinals.compute(Integer.parseInt(mark1.getText().toString()),Integer.parseInt(mark2.getText().toString()), Integer.parseInt(mark3.getText().toString()), true);
                else
                    finalGrade = clsFinals.compute(Integer.parseInt(mark1.getText().toString()), Integer.parseInt(mark2.getText().toString()), Integer.parseInt(mark3.getText().toString()), false);

                finalScore.append(""+finalGrade);
                finalScore.setVisibility(View.VISIBLE);
            }
            else
                Toast.makeText(MainActivity.this, "Not all fields are filled!", Toast.LENGTH_SHORT).show();

        }

        if (v.getId() == clear.getId()) { // onclick clear button
            // mark1, mark2, mark3, name, studentId
            mark1.getText().clear();
            mark2.getText().clear();
            mark3.getText().clear();
            name.getText().clear();
            studentId.getText().clear();
            Toast.makeText(getApplicationContext(), "Screen Cleared!", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == done.getId()) {
            done.setText("c");

            clear.setText("Clear");
            compute.setText("Compute");
            exit.setText("Exit");
        }

        if (v.getId() == exit.getId()) {
            exit.setText("d");

            clear.setText("Clear");
            compute.setText("Compute");
            done.setText("Done");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == prog1.getId()){
            eval1.setText("Case Study");
            eval2.setText("Exam 1");
            eval3.setText("Exam 2");

        }
        if (checkedId == prog2.getId()){
            eval1.setText("Assignment 1");
            eval2.setText("Assignment 2");
            eval3.setText("Exam");
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


}
