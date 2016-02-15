package com.example.cstuser.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button compute;
    Button clear;
    Button done;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compute = (Button) this.findViewById(R.id.compute);
        clear = (Button) this.findViewById(R.id.clear);
        done = (Button) this.findViewById(R.id.done);
        exit = (Button) this.findViewById(R.id.exit);

        compute.setOnClickListener(this);
        clear.setOnClickListener(this);
        done.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    public void onClick(View v) {

        if (v.getId() == compute.getId()) {
            compute.setText("CHANGED");

            clear.setText("CLEAR");
            done.setText("DONE");
            exit.setText("EXIT");
        }

        if (v.getId() == clear.getId()) {
            clear.setText("CHANGED");

            compute.setText("COMPUTE");
            done.setText("DONE");
            exit.setText("EXIT");
        }

        if (v.getId() == done.getId()) {
            done.setText("CHANGED");

            clear.setText("CLEAR");
            compute.setText("COMPUTE");
            exit.setText("EXIT");
        }

        if (v.getId() == exit.getId()) {
            exit.setText("CHANGED");

            clear.setText("CLEAR");
            compute.setText("COMPUTE");
            done.setText("DONE");
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
