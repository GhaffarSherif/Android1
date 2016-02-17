package com.example.cstuser.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import packFinals.clsFinals;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    // Declaring Arrays for course
    String[] programming1;
    String[] programming2;
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
    EditText name;
    EditText studentId;
    EditText mark1;
    EditText mark2;
    EditText mark3;
    TextView resultBox;


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

        resultBox = (TextView) this.findViewById(R.id.resultsBox);


        //Setting the listeners for the widgets
        compute.setOnClickListener(this);
        clear.setOnClickListener(this);
        done.setOnClickListener(this);
        exit.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == compute.getId()) {
            compute.setText("a");

            clear.setText("Clear");
            done.setText("Done");
            exit.setText("Exit");
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

        //EXIT button
        if (v.getId() == exit.getId()) {
            clsFinals.displayResults(resultBox);

            //try {
            //    wait(30000);
                finish();
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
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


    /*
    public void computeButton(View v){
        // Do something when buttons are clicked
        Button button = (Button) v;

        ((Button) v).setText("A");
    }

    public void clearButton(View v){
        Button button = (Button) v;
    }

    public void doneButton(View v){
        Button button = (Button) v;
    }

    public void exitButtton(View v){
        Button button = (Button) v;
    }
    */



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
