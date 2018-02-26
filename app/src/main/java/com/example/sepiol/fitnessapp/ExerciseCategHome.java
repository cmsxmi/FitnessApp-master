package com.example.sepiol.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class ExerciseCategHome extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_categ_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
        setTitle("Exercises");
    }


    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int card = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(card == 0){
                        Intent intent = new Intent(ExerciseCategHome.this, ChestExercises.class);
                        startActivity(intent);
                    }else if(card == 1){
                        Intent intent = new Intent(ExerciseCategHome.this, BackExercises.class);
                        startActivity(intent);
                    }else if(card == 2){
                        Intent intent = new Intent(ExerciseCategHome.this, ShoulderExercises.class);
                        startActivity(intent);
                    }else if(card == 3){
                        Intent intent = new Intent(ExerciseCategHome.this, AbsExcercises.class);
                        startActivity(intent);
                    }
                    else if(card == 4){
                        Intent intent = new Intent(ExerciseCategHome.this, LegsExercises.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

}
