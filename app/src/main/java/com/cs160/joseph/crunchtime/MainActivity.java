package com.cs160.joseph.crunchtime;

import static com.cs160.joseph.crunchtime.ExerciseListViewAdapter.FIRST_COLUMN;
import static com.cs160.joseph.crunchtime.ExerciseListViewAdapter.SECOND_COLUMN;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    // Amount to burn 100 Calories for 150lb person
    public static final int BASE_CALORIES = 100;
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
    public static final String REPS = "reps";
    public static final String MINUTES = "minutes";
    public static final String[] EXERCISES = {"cycling", "jogging", "jumping-jacks", "leg-lift", "plank", "pullup", "pushup", "situp", "squats", "stair-climbing", "swimming", "walking"};
    public static final HashMap<String, Integer> exerciseCalories = new HashMap<String, Integer>() {
        {
            put("cycling", CYCLING);
            put("jogging", JOGGING);
            put("jumping-jacks", JUMPING_JACKS);
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
    public static final HashMap<String, String> exerciseUnits = new HashMap<String, String>() {
        {
            put("cycling", MINUTES);
            put("jogging", MINUTES);
            put("jumping-jacks", MINUTES);
            put("leg-lift", MINUTES);
            put("plank", MINUTES);
            put("pullup", REPS);
            put("pushup", REPS);
            put("situp", REPS);
            put("squats", REPS);
            put("stair-climbing", MINUTES);
            put("swimming", MINUTES);
            put("walking", MINUTES);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> exerciseList = new ArrayList<String>(exerciseCalories.keySet());


        Spinner exerciseSpinner = (Spinner) findViewById(R.id.exerciseSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> exerciseSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.exercise_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        exerciseSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        exerciseSpinner.setAdapter(exerciseSpinnerAdapter);

//        TableLayout exerciseTable = (TableLayout) findViewById(R.id.exerciseTable);
//        for (String key: exerciseCalories.keySet()) {
//            TableRow exerciseRow = new TableRow(this);
//
//            TextView exerciseName = new TextView(this);
//            exerciseName.setText(key);
//            exerciseName.setTextSize(18);
//            exerciseName.setGravity(Gravity.LEFT);
//
//            TextView exerciseCount = new TextView(this);
//            exerciseCount.setText("0");
//            exerciseCount.setTextSize(18);
//            exerciseCount.setGravity(Gravity.RIGHT);
//
//            exerciseRow.addView(exerciseName);
//            exerciseRow.addView(exerciseCount);
//            exerciseTable.addView(exerciseRow, new TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.WRAP_CONTENT));
//        }

//        ListView exerciseListView = (ListView) findViewById(R.id.exerciseListView);
////        ArrayList<String> exerciseList = new ArrayList<String>(R.array.exercise_array);
////        ArrayAdapter<String> exerciseListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exerciseList);
//        ArrayList<HashMap<String, String>> exerciseListMap = new ArrayList<HashMap<String, String>>();
//        for (String key: exerciseCalories.keySet()) {
//            HashMap<String, String> map = new HashMap<String, String>();
//            map.put(FIRST_COLUMN, key);
//            map.put(SECOND_COLUMN, exerciseCalories.get(key).toString());
//        }
////        SimpleAdapter exerciseListAdapter = new SimpleAdapter(this, exerciseListMap, R.layout.exercise_row, new String[] {"exercise", "count"}, new int[] {R.id.exerciseName, R.id.exerciseCount});
//        ExerciseListViewAdapter exerciseListAdapter = new ExerciseListViewAdapter(this, exerciseListMap);
//        exerciseListView.setAdapter(exerciseListAdapter);
////        setListAdapter(exerciseListAdapter);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        String exercise = parent.getItemAtPosition(pos).toString();
//        updateView(exercise, 0, 0);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void updateToCalories(View view) {
        Spinner exerciseSpinner =(Spinner) findViewById(R.id.exerciseSpinner);
        String curExercise = exerciseSpinner.getSelectedItem().toString().toLowerCase().replaceAll(" ", "-");

        EditText countField = (EditText) findViewById(R.id.exerciseCount);
        String countString = countField.getText().toString();

        if (countString.length() == 0) {
            Toast.makeText(MainActivity.this, "Please enter reps/minutes count...", Toast.LENGTH_SHORT).show();
            return;
        }

        float count = Float.valueOf(countString);
        float equivalentCalories = count / exerciseCalories.get(curExercise) * BASE_CALORIES;
        StringBuffer outputBuffer = new StringBuffer();
        for (String exercise: EXERCISES) {
//            outputBuffer.append(exercise);
//            outputBuffer.append(getString(R.string.tab));
            float equivalentCount = count / exerciseCalories.get(curExercise) * exerciseCalories.get(exercise);
//            outputBuffer.append(String.format("%.2f", equivalentCount));
//            outputBuffer.append("\t");
//            outputBuffer.append(exerciseUnits.get(exercise));
//            outputBuffer.append("\n");
            outputBuffer.append(String.format("%s %s %s\n", exercise, String.format("%.2f", equivalentCount), exerciseUnits.get(exercise)));
        }

        EditText caloriesField = (EditText) findViewById(R.id.exerciseCalories);
        caloriesField.setText(Float.toString(equivalentCalories));

        TextView convertedTextView = (TextView) findViewById(R.id.convertedText);
        convertedTextView.setText(outputBuffer.toString());

    }

    public void updateFromCalories(View view) {
        Spinner exerciseSpinner =(Spinner) findViewById(R.id.exerciseSpinner);
        String exercise = exerciseSpinner.getSelectedItem().toString().toLowerCase().replaceAll(" ", "-");

        EditText caloriesField = (EditText) findViewById(R.id.exerciseCalories);
        String caloriesString = caloriesField.getText().toString();
        int calories;
        if (caloriesString.length() == 0) {
            Toast.makeText(MainActivity.this, "Please enter calories burnt...", Toast.LENGTH_SHORT).show();
            return;
        }

        calories = Integer.valueOf(caloriesString);
    }
}
