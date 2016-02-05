package com.cs160.joseph.crunchtime;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.HashMap;

public class MainActivity extends ActionBarActivity {

    // Amount to burn 100 Calories for 150lb person
    public static final int CYCLING = 12;
    public static final int JOGGING = 12;
    public static final int JUMPING_JACKS = 10;
    public static final int LEG_LIFT = 25;
    public static final int PLANK = 25;
    public static final int PULLUP = 100;
    public static final int PUSHUP = 350;
    public static final int SITUP = 200;
    public static final int SQUATS = 225;
    public static final int STAIR_CLIMBING = 15;
    public static final int SWIMMING = 13;
    public static final int WALKING = 20;
    public static final HashMap<String, Integer> exerciseCalories = new HashMap<String, Integer>() {
        {
            put("cycling", CYCLING);
            put("jogging", JOGGING);
            put("jumping jacks", JUMPING_JACKS);
            put("leg-lift", LEG_LIFT);
            put("plank", PLANK);
            put("pullup", PULLUP);
            put("pushup", PUSHUP);
            put("situp", SITUP);
            put("squats", SQUATS);
            put("stair-climbing", STAIR_CLIMBING);
            put("swimming", SWIMMING);
            put("walking", WALKING);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner exerciseSpinner = (Spinner) findViewById(R.id.exerciseSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        exerciseSpinner.setAdapter(adapter);
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

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
