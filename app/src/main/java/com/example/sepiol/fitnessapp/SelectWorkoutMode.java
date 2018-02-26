package com.example.sepiol.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectWorkoutMode extends AppCompatActivity {

    public static int userSelectedWorkout; // 1 = lose weight & 2 = gain muscle
    public static int bestPlan; // the workout plan we have chosen for the user.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workout_mode);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        buttonOnClick();
    }

    public void buttonOnClick(){
        Button weightButton = (Button)findViewById(R.id.weightButton);
        Button muscleButton = (Button)findViewById(R.id.muscleButton);

        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                float bmi = sharedPref.getFloat("bmi", 0);
                int age = sharedPref.getInt("age", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("selectedPlan", 1); // 1 = lose weight
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), NavigationDrawer.class);
                startActivity(intent);
                userSelectedWorkout = 1;
                chooseUserWorkoutPlan(bmi, age);
            }
        });

        muscleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                float bmi = sharedPref.getFloat("bmi", 0);
                int age = sharedPref.getInt("age", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("selectedPlan", 2); // 2 = gain muscle
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), NavigationDrawer.class);
                startActivity(intent);
                userSelectedWorkout = 2;
                chooseUserWorkoutPlan(bmi, age);
            }
        });
    }

    /**
     * Method that chooses a tailored workout plan for the user.
     */

    public void chooseUserWorkoutPlan(float bmi, int age){
        if(userSelectedWorkout == 1){
            makeLoseWeightPlan(bmi, age);
        }else if(userSelectedWorkout == 2){
            makeGainMusclePlan(bmi, age);
        }

    }

    /**
     * Method will only use lose weight plans.
     */
    public void makeLoseWeightPlan(float bmi, int age){
        if(age >= 18 && age <=30 && bmi>=25 && bmi<=35){
            bestPlan = 1;
        }else if(age >= 19 && age <=28 && bmi>=19 && bmi<=28){
            bestPlan = 2;
        }else if(age >= 23 && age <=35 && bmi>=22 && bmi<=30){
            bestPlan = 3;
        }else if(age >= 28 && age <=37 && bmi>=27 && bmi<=37){
            bestPlan = 4;
        }else if(age >= 30 && age <=40 && bmi>=25 && bmi<=35){
            bestPlan = 5;
        }
    }

    /**
     * Method will only use gain muscle plans.
     */
    public void makeGainMusclePlan(float bmi, int age){
        if(age >= 19 && age <=25 && bmi>=14 && bmi<=19){
            bestPlan = 1;
        }else if(age >= 35 && age <=40 && bmi>=25 && bmi<=30){
            bestPlan = 1;
        }else if(age >= 19 && age <=25 && bmi>=22 && bmi<=35){
            bestPlan = 1;
        }else if(age >= 19 && age <=27 && bmi>=15 && bmi<=25){
            bestPlan = 1;
        }
    }
}
