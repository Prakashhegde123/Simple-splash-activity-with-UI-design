package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
private TextView textView;
private ImageView imageView;
//private TextView textView1;
private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textview1);
        progressBar = (ProgressBar)findViewById(R.id.progress);
        //textView1 = (TextView) findViewById(R.id.textview1);

        Animation progressDelay = AnimationUtils.loadAnimation(this, R.anim.myprogress);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.mytransition2);

        //textView1.startAnimation(animation2);
        textView.startAnimation(animation1);
        progressBar.startAnimation(progressDelay);



        final Intent intent=new Intent(this,homepage.class);

        Thread user =new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        user.start();

    }
}
