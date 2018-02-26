package com.example.sepiol.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mPeopleRV;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Recipe, HealthScreen.RecipeViewHolder> mPeopleRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Gym Buddy");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setNavDrawerDetails();

        int progressPercentage = 50;
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBarHome);
        progressBar.setProgress(progressPercentage);
        TextView percentageDisplay = (TextView) findViewById(R.id.p1);
        percentageDisplay.setText(String.valueOf(progressPercentage) + "%");
        CardView progressCard = (CardView) findViewById(R.id.cardProgress);
        progressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WorkoutScreen.class);
                startActivity(intent);
            }
        });

        CardView cardView = (CardView) findViewById(R.id.cardWorkout);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WorkoutScreen.class);
                startActivity(intent);
            }
        });

        mPeopleRV = (RecyclerView) findViewById(R.id.homeScreenRecRecycler);
        mPeopleRV.hasFixedSize();
        mPeopleRV.setLayoutManager(new LinearLayoutManager(this));
        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("PopularRecipes");
        Query personsQuery = personsRef.orderByKey();
        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Recipe>().setQuery(personsQuery, Recipe.class).build();

        mPeopleRVAdapter = new FirebaseRecyclerAdapter<Recipe, HealthScreen.RecipeViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(HealthScreen.RecipeViewHolder holder, final int position, final Recipe model) {
                holder.setTitle(model.getTitle());
                holder.setDesc(model.getDesc());
                holder.setImage(getBaseContext(), model.getImage());

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String url = model.getUrl();
                        Intent intent = new Intent(getApplicationContext(), DietWebView.class);
                        intent.putExtra("id", url);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public HealthScreen.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recipe_row, parent, false);

                return new HealthScreen.RecipeViewHolder(view);
            }
        };

        mPeopleRV.setAdapter(mPeopleRVAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        mPeopleRVAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    /**
     * Method for functionality when options selected.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String messageTitle = "Gym Buddy";
            String messageBody = "Hey, check out this fitness app. Great for beginners at the gym.";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, messageTitle);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, messageBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handle navigation menu clicks here in this method.
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_workouts) {
            Intent workoutsIntent = new Intent(getApplicationContext(), WorkoutScreen.class);
            startActivity(workoutsIntent);
        } else if (id == R.id.nav_exercises) {
            Intent exerciseIntent = new Intent(getApplicationContext(), ExerciseCategHome.class);
            startActivity(exerciseIntent);
        } else if (id == R.id.nav_tracker) {

        } else if (id == R.id.nav_gym) {
            //Intent mapIntent = new Intent(getApplicationContext(), RecipeActivity.class);
            //startActivity(mapIntent);
        } else if (id == R.id.nav_diet) {
            Intent dietIntent = new Intent(getApplicationContext(), HealthScreen.class);
            startActivity(dietIntent);
        } else if (id == R.id.nav_settings) {
            Intent settingIntent = new Intent(getApplicationContext(), SettingScreen.class);
            startActivity(settingIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setNavDrawerDetails(){
        SharedPreferences prefs = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        String name = prefs.getString("name", "Invalid Name");
        int selectedPlan = prefs.getInt("selectedPlan", 1);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.userNameTxtView);
        TextView nav_mode = (TextView)hView.findViewById(R.id.selectedPlan);
        nav_user.setText("Hello "+ name);
        if (selectedPlan == 1){
            nav_mode.setText("Lose Weight Plan");
        }else if (selectedPlan == 2){
            nav_mode.setText("Gain Weight Plan");
        }

        //TextView usernameField = (TextView) findViewById(R.id.userName);
        //usernameField.setText("Hello " + name);
        //<TextView
        //android:id="@+id/userName"
        //android:layout_width="match_parent"
        //android:layout_height="75dp"
        //android:layout_margin="7dp"
        //android:layout_marginBottom="5dp"
        //android:background="@color/colorPrimaryDark"
        //android:paddingTop="13dp"
        //android:text="Hello"
        //android:textAlignment="center"
        //android:textColor="@color/white"
        //android:textSize="30sp" />
    }
}
