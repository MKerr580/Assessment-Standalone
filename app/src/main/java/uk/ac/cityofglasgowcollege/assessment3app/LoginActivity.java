package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickRegister(View v) {
        Intent goRegister = new Intent(this, RegisterActivity.class);
        startActivity(goRegister);
    }

    public void onClickLogin(View v) {
        //declaring variables to hold the text from the username and password textboxes
        EditText usernametext;
        EditText passwordtext;
        //storing data from textboxes
        usernametext=(EditText) findViewById(R.id.usernametxt);
        passwordtext=(EditText) findViewById(R.id.passwordtxt);
        //initalising dstabase
        MyDB database= new MyDB(this);
        //converting data gained earlier into strings so we can use them
        String username=usernametext.getText().toString();
        String password=passwordtext.getText().toString();
        if (database.isValidUser(username,password)){
            Intent goMenu = new Intent( this, MenuActivity.class);
            startActivity( goMenu );
        }else{
            Toast toast4 = Toast.makeText(this, "Username and Password don't match.", Toast.LENGTH_SHORT);
            toast4.show();
            return;
        }
    }
}
