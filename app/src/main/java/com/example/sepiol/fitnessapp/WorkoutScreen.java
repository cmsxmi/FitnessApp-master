package com.example.sepiol.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import static com.example.sepiol.fitnessapp.SelectWorkoutMode.bestPlan;

public class WorkoutScreen extends AppCompatActivity {

    private String url;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("30 Day Workout Plan");
        setWorkoutPlan(1); //hardcoded the plan for test. should retreive from getWorkoutPlan()
        retreiveData();
    }

        //create method that checks sharedpref for completion status
        public void retreiveData(){
            SharedPreferences prefs = getSharedPreferences("userProgress", Context.MODE_PRIVATE);
            Button day1 = (Button) findViewById(R.id.day1);
            Button day2 = (Button) findViewById(R.id.day2);
            Button day3 = (Button) findViewById(R.id.day3);
            Button day4 = (Button) findViewById(R.id.day4);
            Button day5 = (Button) findViewById(R.id.day5);
            Button day6 = (Button) findViewById(R.id.day6);
            Button day7 = (Button) findViewById(R.id.day7);
            Button day8 = (Button) findViewById(R.id.day8);
            Button day9 = (Button) findViewById(R.id.day9);
            Button day10 = (Button) findViewById(R.id.day10);
            Button day11 = (Button) findViewById(R.id.day11);
            Button day12 = (Button) findViewById(R.id.day12);
            Button day13 = (Button) findViewById(R.id.day13);
            Button day14 = (Button) findViewById(R.id.day14);
            Button day15 = (Button) findViewById(R.id.day15);
            Button day16 = (Button) findViewById(R.id.day16);
            Button day17 = (Button) findViewById(R.id.day17);
            Button day18 = (Button) findViewById(R.id.day18);
            Button day19 = (Button) findViewById(R.id.day19);
            Button day20 = (Button) findViewById(R.id.day20);
            Button day21 = (Button) findViewById(R.id.day21);
            Button day22 = (Button) findViewById(R.id.day22);
            Button day23 = (Button) findViewById(R.id.day23);
            Button day24 = (Button) findViewById(R.id.day24);
            Button day25 = (Button) findViewById(R.id.day25);
            Button day26 = (Button) findViewById(R.id.day26);
            Button day27 = (Button) findViewById(R.id.day27);
            Button day28 = (Button) findViewById(R.id.day28);
            Button day29 = (Button) findViewById(R.id.day29);
            Button day30 = (Button) findViewById(R.id.day30);

            day2.setEnabled(false);
            day3.setEnabled(false);
            day4.setEnabled(false);
            day5.setEnabled(false);
            day6.setEnabled(false);
            day7.setEnabled(false);
            day8.setEnabled(false);
            day9.setEnabled(false);
            day10.setEnabled(false);
            day11.setEnabled(false);
            day12.setEnabled(false);
            day13.setEnabled(false);
            day14.setEnabled(false);
            day15.setEnabled(false);
            day16.setEnabled(false);
            day17.setEnabled(false);
            day18.setEnabled(false);
            day19.setEnabled(false);
            day20.setEnabled(false);
            day21.setEnabled(false);
            day22.setEnabled(false);
            day23.setEnabled(false);
            day24.setEnabled(false);
            day25.setEnabled(false);
            day26.setEnabled(false);
            day27.setEnabled(false);
            day28.setEnabled(false);
            day29.setEnabled(false);
            day30.setEnabled(false);

            int day_1 = prefs.getInt("day_1", 0); //0 if it doesnt exist.
            int day_2 = prefs.getInt("day_2", 0);
            int day_3 = prefs.getInt("day_3", 0);
            int day_4 = prefs.getInt("day_4", 0);
            int day_5 = prefs.getInt("day_5", 0);
            int day_6 = prefs.getInt("day_6", 0);
            int day_7 = prefs.getInt("day_7", 0);
            int day_8 = prefs.getInt("day_8", 0);
            int day_9 = prefs.getInt("day_9", 0);
            int day_10 = prefs.getInt("day_10", 0);
            int day_11 = prefs.getInt("day_11", 0);
            int day_12 = prefs.getInt("day_12", 0);
            int day_13 = prefs.getInt("day_13", 0);
            int day_14 = prefs.getInt("day_14", 0);
            int day_15 = prefs.getInt("day_15", 0);
            int day_16 = prefs.getInt("day_16", 0);
            int day_17 = prefs.getInt("day_17", 0);
            int day_18 = prefs.getInt("day_18", 0);
            int day_19 = prefs.getInt("day_19", 0);
            int day_20 = prefs.getInt("day_20", 0);
            int day_21 = prefs.getInt("day_21", 0);
            int day_22 = prefs.getInt("day_22", 0);
            int day_23 = prefs.getInt("day_23", 0);
            int day_24 = prefs.getInt("day_24", 0);
            int day_25 = prefs.getInt("day_25", 0);
            int day_26 = prefs.getInt("day_26", 0);
            int day_27 = prefs.getInt("day_27", 0);
            int day_28 = prefs.getInt("day_28", 0);
            int day_29 = prefs.getInt("day_29", 0);
            int day_30 = prefs.getInt("day_30", 0);

            ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);

            if(day_1 == 1){
                day1.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 3;
                progressBar.setProgress(progress);
                day2.setEnabled(true);
            }
            if(day_2 == 1){
                day2.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 7;
                progressBar.setProgress(progress);
                day3.setEnabled(true);
            }
            if(day_3 == 1){
                day3.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 10;
                progressBar.setProgress(progress);
                day4.setEnabled(true);
            }
            if(day_4 == 1){
                day4.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 13;
                progressBar.setProgress(progress);
                day5.setEnabled(true);
            }
            if(day_5 == 1){
                day5.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 17;
                progressBar.setProgress(progress);
                day6.setEnabled(true);
            }
            if(day_6 == 1){
                day6.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 20;
                progressBar.setProgress(progress);
                day7.setEnabled(true);
            }
            if(day_7 == 1){
                day7.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 23;
                progressBar.setProgress(progress);
                day8.setEnabled(true);
            }
            if(day_8 == 1){
                day8.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 27;
                progressBar.setProgress(progress);
                day9.setEnabled(true);
            }
            if(day_9 == 1){
                day9.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 30;
                progressBar.setProgress(progress);
                day10.setEnabled(true);
            }
            if(day_10 == 1){
                day10.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 34;
                progressBar.setProgress(progress);
                day11.setEnabled(true);
            }
            if(day_11 == 1){
                day11.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 37;
                progressBar.setProgress(progress);
                day12.setEnabled(true);
            }
            if(day_12 == 1){
                day12.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 40;
                progressBar.setProgress(progress);
                day13.setEnabled(true);
            }
            if(day_13 == 1){
                day13.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 44;
                progressBar.setProgress(progress);
                day14.setEnabled(true);
            }
            if(day_14 == 1){
                day14.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 47;
                progressBar.setProgress(progress);
                day15.setEnabled(true);
            }
            if(day_15 == 1){
                day15.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 50;
                progressBar.setProgress(progress);
                day16.setEnabled(true);
            }
            if(day_16 == 1){
                day16.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 54;
                progressBar.setProgress(progress);
                day17.setEnabled(true);
            }
            if(day_17 == 1){
                day17.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 57;
                progressBar.setProgress(progress);
                day18.setEnabled(true);
            }
            if(day_18 == 1){
                day18.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 60;
                progressBar.setProgress(progress);
                day19.setEnabled(true);
            }
            if(day_19 == 1){
                day19.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 64;
                progressBar.setProgress(progress);
                day20.setEnabled(true);
            }
            if(day_20 == 1){
                day20.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 67;
                progressBar.setProgress(progress);
                day21.setEnabled(true);
            }
            if(day_21 == 1){
                day21.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 70;
                progressBar.setProgress(progress);
                day22.setEnabled(true);
            }
            if(day_22 == 1){
                day22.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 74;
                progressBar.setProgress(progress);
                day23.setEnabled(true);
            }
            if(day_23 == 1){
                day23.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 77;
                progressBar.setProgress(progress);
                day24.setEnabled(true);
            }
            if(day_24 == 1){
                day24.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 80;
                progressBar.setProgress(progress);
                day25.setEnabled(true);
            }
            if(day_25 == 1){
                day25.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 84;
                progressBar.setProgress(progress);
                day26.setEnabled(true);
            }
            if(day_26 == 1){
                day26.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 87;
                progressBar.setProgress(progress);
                day27.setEnabled(true);
            }
            if(day_27 == 1){
                day27.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 90;
                progressBar.setProgress(progress);
                day28.setEnabled(true);
            }
            if(day_28 == 1){
                day28.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 94;
                progressBar.setProgress(progress);
                day29.setEnabled(true);
            }
            if(day_29 == 1){
                day29.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 97;
                progressBar.setProgress(progress);
                day30.setEnabled(true);
            }
            if(day_30 == 1){
                day30.setBackgroundColor(Color.parseColor("#FF4081"));
                progress = 100;
                progressBar.setProgress(progress);
            }
        }

        /**
         * Returns the best plan for the user.
         * 1 = lose weight with bmi 100-120
         * 2 = lose weight with bmi 120-140
         * @return
         */
        public int getWorkoutPlan(){
            return bestPlan;
        }


        public void setWorkoutPlan(int plan){
            Button day1 = (Button) findViewById(R.id.day1);
            Button day2 = (Button) findViewById(R.id.day2);
            Button day3 = (Button) findViewById(R.id.day3);
            Button day4 = (Button) findViewById(R.id.day4);
            Button day5 = (Button) findViewById(R.id.day5);
            Button day6 = (Button) findViewById(R.id.day6);
            Button day7 = (Button) findViewById(R.id.day7);
            Button day8 = (Button) findViewById(R.id.day8);
            Button day9 = (Button) findViewById(R.id.day9);
            Button day10 = (Button) findViewById(R.id.day10);
            Button day11 = (Button) findViewById(R.id.day11);
            Button day12 = (Button) findViewById(R.id.day12);
            Button day13 = (Button) findViewById(R.id.day13);
            Button day14 = (Button) findViewById(R.id.day14);
            Button day15 = (Button) findViewById(R.id.day15);
            Button day16 = (Button) findViewById(R.id.day16);
            Button day17 = (Button) findViewById(R.id.day17);
            Button day18 = (Button) findViewById(R.id.day18);
            Button day19 = (Button) findViewById(R.id.day19);
            Button day20 = (Button) findViewById(R.id.day20);
            Button day21 = (Button) findViewById(R.id.day21);
            Button day22 = (Button) findViewById(R.id.day22);
            Button day23 = (Button) findViewById(R.id.day23);
            Button day24 = (Button) findViewById(R.id.day24);
            Button day25 = (Button) findViewById(R.id.day25);
            Button day26 = (Button) findViewById(R.id.day26);
            Button day27 = (Button) findViewById(R.id.day27);
            Button day28 = (Button) findViewById(R.id.day28);
            Button day29 = (Button) findViewById(R.id.day29);
            Button day30 = (Button) findViewById(R.id.day30);

            //8 plans
            if (plan == 1){
                url = "plan1/plan_";
            }else if (plan == 2) {
                url = "plan2/plan_";
            }else if(plan == 3){
                url = "plan3/plan_";
            }else if(plan == 4){
                url = "plan4/plan_";
            }else if(plan == 5){
                url = "plan5/plan_";
            }else if(plan == 6){
                url = "plan6/plan_";
            }else if(plan == 7){
                url = "plan7/plan_";
            }else if(plan == 8){
                url = "plan8/plan_";
            }

            day1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"1.html");
                    intent.putExtra("workoutDay", "day_1");
                    startActivity(intent);
                }
            });

            //change _dayone.html & workoutDay value
            day2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"2.html");
                    intent.putExtra("workoutDay", "day_2");
                    startActivity(intent);
                }
            });


            day3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"3.html");
                    intent.putExtra("workoutDay", "day_3");
                    startActivity(intent);
                }
            });

            day4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"4.html");
                    intent.putExtra("workoutDay", "day_4");
                    startActivity(intent);
                }
            });

            day5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"5.html");
                    intent.putExtra("workoutDay", "day_5");
                    startActivity(intent);
                }
            });

            day6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"6.html");
                    intent.putExtra("workoutDay", "day_6");
                    startActivity(intent);
                }
            });

            day7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"7.html");
                    intent.putExtra("workoutDay", "day_7");
                    startActivity(intent);
                }
            });

            day8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"8.html");
                    intent.putExtra("workoutDay", "day_8");
                    startActivity(intent);
                }
            });

            day9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"9.html");
                    intent.putExtra("workoutDay", "day_9");
                    startActivity(intent);
                }
            });

            day10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"10.html");
                    intent.putExtra("workoutDay", "day_10");
                    startActivity(intent);
                }
            });

            day11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"11.html");
                    intent.putExtra("workoutDay", "day_11");
                    startActivity(intent);
                }
            });

            day12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"12.html");
                    intent.putExtra("workoutDay", "day_12");
                    startActivity(intent);
                }
            });

            day13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"13.html");
                    intent.putExtra("workoutDay", "day_13");
                    startActivity(intent);
                }
            });

            day14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"14.html");
                    intent.putExtra("workoutDay", "day_14");
                    startActivity(intent);
                }
            });

            day15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"15.html");
                    intent.putExtra("workoutDay", "day_15");
                    startActivity(intent);
                }
            });

            day16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"16.html");
                    intent.putExtra("workoutDay", "day_16");
                    startActivity(intent);
                }
            });

            day17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"17.html");
                    intent.putExtra("workoutDay", "day_17");
                    startActivity(intent);
                }
            });

            day18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"18.html");
                    intent.putExtra("workoutDay", "day_18");
                    startActivity(intent);
                }
            });

            day19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"19.html");
                    intent.putExtra("workoutDay", "day_19");
                    startActivity(intent);
                }
            });

            day20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"20.html");
                    intent.putExtra("workoutDay", "day_20");
                    startActivity(intent);
                }
            });

            day21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"21.html");
                    intent.putExtra("workoutDay", "day_21");
                    startActivity(intent);
                }
            });

            day22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"22.html");
                    intent.putExtra("workoutDay", "day_22");
                    startActivity(intent);
                }
            });

            day23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"23.html");
                    intent.putExtra("workoutDay", "day_23");
                    startActivity(intent);
                }
            });

            day24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"24.html");
                    intent.putExtra("workoutDay", "day_24");
                    startActivity(intent);
                }
            });

            day25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"25.html");
                    intent.putExtra("workoutDay", "day_25");
                    startActivity(intent);
                }
            });

            day26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"26.html");
                    intent.putExtra("workoutDay", "day_26");
                    startActivity(intent);
                }
            });

            day27.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"27.html");
                    intent.putExtra("workoutDay", "day_27");
                    startActivity(intent);
                }
            });

            day28.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"28.html");
                    intent.putExtra("workoutDay", "day_28");
                    startActivity(intent);
                }
            });

            day29.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"29.html");
                    intent.putExtra("workoutDay", "day_29");
                    startActivity(intent);
                }
            });

            day30.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutScreen.this, WorkoutActivityView.class);
                    intent.putExtra("id", "file:///android_asset/"+url+"30.html");
                    intent.putExtra("workoutDay", "day_30");
                    startActivity(intent);
                }
            });

        }
}

