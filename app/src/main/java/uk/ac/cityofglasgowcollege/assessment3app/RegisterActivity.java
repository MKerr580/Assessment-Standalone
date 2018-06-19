package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private String firstnametext;
    private EditText firstname;
    private String lastnametext;
    private EditText lastname;
    private String emailtext;
    private EditText email;
    private String addresstext;
    private EditText address;
    private String citytext;
    private EditText city;
    private String postcodetext;
    private EditText postcode;
    private String usernametext;
    private EditText username;
    private String password1text;
    private EditText password1;
    private String password2text;
    private EditText password2;
    private MyDB database2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClickRegister(View v)
    {
        //collecting info from all the text boxes and then converting them to strongs
        firstname = (EditText) findViewById(R.id.forenametxt);
        firstnametext = firstname.getText().toString();
        lastname = (EditText) findViewById(R.id.surnametxt);
        lastnametext = lastname.getText().toString();
        email = (EditText) findViewById(R.id.emailtxt);
        emailtext = email.getText().toString();
        address = (EditText) findViewById(R.id.addresstxt);
        addresstext = address.getText().toString();
        city = (EditText) findViewById(R.id.citytxt);
        citytext = city.getText().toString();
        postcode = (EditText) findViewById(R.id.postcodetxt);
        postcodetext = postcode.getText().toString();
        username = (EditText) findViewById(R.id.usernametxt);
        usernametext = username.getText().toString();

        password1 = (EditText) findViewById(R.id.password1txt);
        password1text = password1.getText().toString();
        password2 = (EditText) findViewById(R.id.password2txt);
        password2text = password2.getText().toString();
        if (password1text.equals(password2text))
        {
            //creating an instance of the user
            User u = new User();
            //filling in the user info with information we took in earlier from the user
            u.setFirstname(firstnametext);
            u.setLastname(lastnametext);
            u.setEmail(emailtext);
            u.setAddress(addresstext);
            u.setCity(citytext);
            u.setPostcode(postcodetext);
            u.setUsername(usernametext);
            u.setPassword(password1text);
            //initalising the database
            database2=new MyDB(this);
            //inserting user into the database
            database2.insertuser(u);
            Toast toast2= Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT);
            toast2.show();
            Intent myIntent = new Intent( this, LoginActivity.class);
            startActivity( myIntent );
        }else {
            Toast toast3 = Toast.makeText(this, "Passwords Don't Match", Toast.LENGTH_SHORT);
            toast3.show();
        }
    }
}
