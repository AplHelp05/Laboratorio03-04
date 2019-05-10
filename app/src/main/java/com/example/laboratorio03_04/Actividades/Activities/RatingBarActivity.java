package com.example.laboratorio03_04.Actividades.Activities;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laboratorio03_04.R;

public class RatingBarActivity extends AppCompatActivity {
    /*
    * Mkyong, (29/08/2012) Android rating bar example, Fecha de recuperación: 05/05/2019 de mkyon.com: https://www.mkyong.com/android/android-rating-bar-example/
    * */
    TextView txtResult;
    TextView txtRating;
    RatingBar ratingBar;
    Button btnRating;
    ImageView ic1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_ratingbar));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        gestionRatingBar();
        buttonRate();
    }

    public void gestionRatingBar(){
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtResult = (TextView) findViewById(R.id.txtResult);
        ic1 = (ImageView) findViewById(R.id.img1);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtResult.setText(String.valueOf(rating));
                if(ratingBar.getRating() == 1.0){
                    ic1.setVisibility(View.VISIBLE);
                    ic1.setImageResource(R.drawable.ic_dismiss);
                }else if(ratingBar.getRating() == 2.0){
                    ic1.setVisibility(View.VISIBLE);
                    ic1.setImageResource(R.drawable.ic_sad);
                }else if(ratingBar.getRating() == 3.0){
                    ic1.setVisibility(View.VISIBLE);
                    ic1.setImageResource(R.drawable.ic_satisfied);
                }else if(ratingBar.getRating() == 4.0){
                    ic1.setVisibility(View.VISIBLE);
                    ic1.setImageResource(R.drawable.ic_happy);
                }else if(ratingBar.getRating() == 5.0){
                    ic1.setVisibility(View.VISIBLE);
                    ic1.setImageResource(R.drawable.ic_whatsho);
                }
            }
        });
    }

    public void buttonRate(){
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnRating = (Button) findViewById(R.id.btnRating);
        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
