package com.example.laboratorio03_04.Actividades.Activities;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.laboratorio03_04.R;

public class ProgressBarHActivity extends AppCompatActivity {
    //Referencias
    /*
    * Parsania H. Android Indeterminate Horizontal Progress Bar Programmatically, 05/05/2019, sitio web demonuts: https://demonuts.com/android-indeterminate-horizontal-progress-bar/
    * Parsania H. Android Horizontal Progress Bar With Percentage Programmatically, 05/05/2019, sitio web demonuts: https://demonuts.com/android-horizontal-progress-bar/
    * */
    private TextView txt1;
    private TextView txt2;

    private Button btn1;
    private Button btn2;

    private ProgressBar p1;
    private ProgressBar p2;
    private ProgressBar p3;
    private ProgressBar p4;

    private int pStatus = 0;
    private int pStatus2 = 0;
    private int pStatus3 = 0;
    private int pStatus4 = 0;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_ProgressBarH));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        txt1 = findViewById(R.id.id_TxtProgress1);
        txt2 = findViewById(R.id.id_TxtProgress2);

        btn1 = findViewById(R.id.btnProcess1);
        btn2 = findViewById(R.id.btnProcess2);

        p1 = findViewById(R.id.progressBar1);
        p2 = findViewById(R.id.progressBar2);
        p3 = findViewById(R.id.progressBar3);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(pStatus == 100){
                    pStatus = 0;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(pStatus < 100){
                            pStatus += 1;
                            try{
                                Thread.sleep(20);
                            }catch(InterruptedException  e){
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    p1.setProgress(pStatus);
                                    txt1.setText(pStatus+"/100");
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(pStatus2 == 100){
                    pStatus2 = 0;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(pStatus2 < 100){
                            pStatus2 += 1;
                            try{
                                Thread.sleep(20);
                            }catch(InterruptedException  e){
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    p2.setProgress(pStatus2);
                                    p2.setSecondaryProgress(pStatus2+15);
                                    txt2.setText(pStatus2+"/100");
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(pStatus3 < 100){
                    pStatus3++;
                    if(pStatus3 == 99){
                        pStatus3 = 0;
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            p3.setProgress(pStatus3);
                            p3.setSecondaryProgress(pStatus3+15);
                        }
                    });
                    try{
                        Thread.sleep(20);
                    }catch(InterruptedException  e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
