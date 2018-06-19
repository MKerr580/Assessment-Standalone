package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GetAroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_around);
    }

    public void onClickBackToMenu(View v) {
        //sending the user back to main menu
        Intent goMenu = new Intent(this, MenuActivity.class);
        startActivity(goMenu);

    }
}
