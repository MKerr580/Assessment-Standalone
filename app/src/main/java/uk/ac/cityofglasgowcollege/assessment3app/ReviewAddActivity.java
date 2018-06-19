package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ReviewAddActivity extends AppCompatActivity {
    private MyDB database2;
    private String usercomment;
    private int userrating;
    private String datesubmission;
    private int locationid;
    private String usersname;
    private EditText usercommenttxt;
    private EditText userratingtxt;
    private EditText datesubmissiontxt;
    private EditText locationidtxt;
    private EditText  usersnametxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_add);
    }
    public void onClickSubmit(View v)
    {
        //obtaining information from textboxes and then converting them to strings and if necessary parsing them into ints
         usersnametxt= (EditText) findViewById(R.id.username1txt);
         usersname = usersnametxt.getText().toString();
        usercommenttxt= (EditText) findViewById(R.id.comment1txt);
         usercomment= usercommenttxt.getText().toString();
        locationidtxt= (EditText) findViewById(R.id.locid1txt);
        String placeholder = locationidtxt.getText().toString();
        locationid= Integer.parseInt(placeholder);
        userratingtxt= (EditText) findViewById(R.id.rating1txt);
         placeholder= userratingtxt.getText().toString();
        userrating=Integer.parseInt(placeholder);
         datesubmissiontxt= (EditText) findViewById(R.id.datesubmittxt);
        datesubmission= datesubmissiontxt.getText().toString();
//declaring the if statement that as long as user comment has data inside it , it will fill user review data
        if (usercomment!=null)
        {
            Review u = new Review();
            u.setusersname(usersname);
            u.setusercomment(usercomment);
            u.setuserrating(userrating);
            u.setlocationid(locationid);
            u.setdatesubmission(datesubmission);

            database2=new MyDB(this);
            database2.insertuserreview(u);
            Toast toast2= Toast.makeText(this, "Review Submitted", Toast.LENGTH_SHORT);
            toast2.show();
            Intent myIntent = new Intent( this, MenuActivity.class);
            startActivity( myIntent );
        }else {
            Toast toast3 = Toast.makeText(this, "Please enter a comment.", Toast.LENGTH_SHORT);
            toast3.show();
        }
    }
}
