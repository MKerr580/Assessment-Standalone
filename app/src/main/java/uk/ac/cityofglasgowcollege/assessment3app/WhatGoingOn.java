package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WhatGoingOn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_going_on);
    }
    public void onClickBackToMenu(View v) {
        //sending the user back to main menu
        Intent goMenu = new Intent(this, MenuActivity.class);
        startActivity(goMenu);
    }
    public void onClickAddReview(View v) {
        //sending the user to add a review page
        Intent goReviewAdd = new Intent(this, ReviewAddActivity.class);
        startActivity(goReviewAdd);
    }

}
