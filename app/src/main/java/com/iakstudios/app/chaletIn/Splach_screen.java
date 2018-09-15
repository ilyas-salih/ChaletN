package com.iakstudios.app.chaletIn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splach_screen extends AppCompatActivity {
    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;
    TextView textView,textView2;
    FrameLayout fram;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
         progressBar=(ProgressBar) findViewById(R.id.progressBar);
         progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#04C355"), PorterDuff.Mode.SRC_IN);
         progressBar.setProgress(0);
         textView2=(TextView)findViewById(R.id.textView);
         textView=(TextView)findViewById(R.id.textView1);
         textView.setText("");
         Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/flat.ttf");
         textView2.setTypeface(myTypeface);

         final long period = 25;
         timer=new Timer();
         timer.schedule(new TimerTask() {
             @Override
             public void run() {
                 //this repeats every 100 ms
                 if (i<100){
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             textView.setText(String.valueOf(i)+" "+"%"+" "+"تحميل التطبيق");
                         }
                     });
                     progressBar.setProgress(i);
                     i++;
                 }else{
                     //closing the timer
                     timer.cancel();
                     startActivity(new Intent(Splach_screen.this,Intro_page.class));



                 }
             }
         }, 0, period);
     }

}
