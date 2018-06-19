package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClickptv(View v) {
        //takes the user to the places to visit page
        Intent goPtV = new Intent(this, PtVActivity.class);
        startActivity(goPtV);
    }    public void onClickWGO(View v) {
        Intent goWGO = new Intent(this, WhatGoingOn.class);
        startActivity(goWGO);
    }
    public void onClickGetAround(View v) {
        //takes the user to the get around page
        Intent goGetAround = new Intent(this, GetAroundActivity.class);
        startActivity(goGetAround);
    }
    public void onClickViewReview(View v) {
        //takes the user to the view reviews pages
        Intent goveiwreview = new Intent(this, reviewview.class);
        startActivity(goveiwreview);
    }
}
