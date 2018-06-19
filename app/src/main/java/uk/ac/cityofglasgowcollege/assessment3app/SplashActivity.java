package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Intent LoginIntent = new Intent(this,LoginActivity.class);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity( LoginIntent );
            }
        }, 5000);

    }
}
