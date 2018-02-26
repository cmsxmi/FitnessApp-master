package com.example.sepiol.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class BackExercises extends AppCompatActivity {

    GridLayout mainGrid;
    String[] eArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_exercises);
        eArray = getResources().getStringArray(R.array.backExercises);
        updateTextView();
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);

    }

    public void updateTextView(){
        TextView p0 = (TextView)findViewById(R.id.p0);
        TextView p1 = (TextView)findViewById(R.id.p1);
        TextView p2 = (TextView)findViewById(R.id.p2);
        TextView p3 = (TextView)findViewById(R.id.p3);
        TextView p4 = (TextView)findViewById(R.id.p4);

        p0.setText(eArray[0]);
        p1.setText(eArray[1]);
        p2.setText(eArray[2]);
        p3.setText(eArray[3]);
        p4.setText(eArray[4]);
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
                        Intent intent = new Intent(BackExercises.this, ExcerciseWebView.class);
                        intent.putExtra("id", "file:///android_asset/Deadlift.html");
                        startActivity(intent);
                    }else if(card == 1){
                        Intent intent = new Intent(BackExercises.this, ExcerciseWebView.class);
                        intent.putExtra("id", "file:///android_asset/BarbellRow.html");
                        startActivity(intent);
                    }else if(card == 2){
                        Intent intent = new Intent(BackExercises.this, ExcerciseWebView.class);
                        intent.putExtra("id", "file:///android_asset/WideGripPullUp.html");
                        startActivity(intent);
                    }else if(card == 3){
                        Intent intent = new Intent(BackExercises.this, ExcerciseWebView.class);
                        intent.putExtra("id", "file:///android_asset/StandingTBarRow.html");
                        startActivity(intent);
                    }else if(card == 4){
                        Intent intent = new Intent(BackExercises.this, ExcerciseWebView.class);
                        intent.putExtra("id", "file:///android_asset/SeatedCableRow.html");
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
