package com.example.sepiol.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class UserDetails extends AppCompatActivity {

    EditText username;
    EditText userage;
    EditText userheight;
    EditText userweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        username = (EditText) findViewById(R.id.nameinput);
        userage = (EditText) findViewById(R.id.ageinput);
        userheight = (EditText) findViewById(R.id.heightinput);
        userweight = (EditText) findViewById(R.id.weightinput);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        String sUsername = username.getText().toString();
        String sHeight = userheight.getText().toString();
        String sWeight = userweight.getText().toString();
        int sAge = Integer.parseInt(userage.getText().toString());
        String stringAge = String.valueOf(sAge);

        float height = Float.parseFloat(sHeight);
        float weight = Float.parseFloat(sWeight);

        if (sUsername.matches("") || (stringAge.matches("")) ||
                (sHeight.matches("") || (sWeight.matches("")))){
            Toast.makeText(this, "Please enter all details.", Toast.LENGTH_LONG).show();
            return;
        }else{
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", username.getText().toString());
            editor.putInt("age", sAge);
            editor.putString("height", userheight.getText().toString());
            editor.putString("weight", userweight.getText().toString());
            editor.putBoolean("appAlreadyLaunched", true);
            float bmi = calculateBMI(weight, height);
            editor.putFloat("bmi", bmi);
            editor.apply();
            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show();
            emptyTextFields();
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            Intent intent = new Intent(getApplicationContext(), SelectWorkoutMode.class);
            startActivity(intent);
        }
    }

    /**
     * Empties and clears the text input fields.
     */
    public void emptyTextFields(){
        username.setText(null);
        userage.setText(null);
        userheight.setText(null);
        userweight.setText(null);
    }

    /**
     * This method calculates the users BMI.
     * @param weight The users weight
     * @param height The users height
     * @return The users calculated BMI
     */
    public float calculateBMI(float weight, float height){
        float weight_kg = weight;
        float height_m = height;
        float bmi;

        float calc_one = (weight_kg/height_m); //divide your weight in kilograms (kg) by your height in metres (m)
        bmi = (calc_one/height_m); //then divide the answer by your height again to get your BMI

        return bmi;
    }
}

