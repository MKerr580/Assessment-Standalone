package uk.ac.cityofglasgowcollege.assessment3app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.id.list;
import static uk.ac.cityofglasgowcollege.assessment3app.R.id.usercommenttxt;

public class reviewview extends AppCompatActivity {
    private MyDB database2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewview);
        //initalising the database
       database2= new MyDB(this);
        ArrayList<Review> commentinfo ;
        commentinfo=database2.getComments();
        ArrayList<String> UserReview=new ArrayList<>();
        String UserReviewtxt;
        for(Review n: commentinfo){
            //filling userreviewtxt with all the information gained from the database(getcomments)
            UserReviewtxt=n.getusersname()+"" +
                    " Posted:    "+n.getusercomment() + ".           " +
                    " User Rating:   "+n.getuserrating()+"" +
                    " Location id: " + n.getlocationid()+"" +
                    " Date Submitted: "+n.getdatesubmission();
            //adding the single user review to the array of user reviews
            UserReview.add(UserReviewtxt);
            //adding the whole list of user reviews to the list.
            ListView iv = (ListView) findViewById(R.id.usercommenttxt);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, UserReview);
            iv.setAdapter(dataAdapter);


        }


    }
    }

