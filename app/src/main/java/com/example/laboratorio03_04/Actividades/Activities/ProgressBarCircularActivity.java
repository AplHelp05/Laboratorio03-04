package com.example.laboratorio03_04.Actividades.Activities;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.laboratorio03_04.R;

public class ProgressBarCircularActivity extends AppCompatActivity {
    /*
    Parsania H. Android Circular Progress Bar With Percentage Programmatically, 05/05/2019, sitio web demonuts: https://demonuts.com/circular-progress-bar/
     *
     *
    * */
    private int pStatusC = 0;
    private Handler handler = new Handler();
    TextView txtCircular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_ProgressBar));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_circular);

        txtCircular = (TextView) findViewById(R.id.id_txtCircularProcess1);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.circular_pb);
        final ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.circular_pb);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(100);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(drawable);
        txtCircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pStatusC==100){
                    pStatusC = 0;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (pStatusC < 100){
                            pStatusC += 1;

                            handler.post(new Runnable() {

                                @Override
                                public void run() {
                                    progressBar.setProgress(pStatusC);
                                    txtCircular.setText(pStatusC+"%");
                                }
                            });
                            try{
                                Thread.sleep(20);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

    }
}
