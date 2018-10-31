package com.example.trani.testapp;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        try{
            TextView textView = findViewById(R.id.textView3);
            runTimer();
        }
        catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e.getMessage());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.create();
            builder.show();
        }

    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickPause(View view){
        running = false;
    }

    public void onClickStop(View view){
        running = false;
    }

    private void runTimer(){
        final TextView textView = findViewById(R.id.textView3);
        final android.os.Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int mins = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%02d:%02d:%02d",hours,mins,secs);
                textView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
