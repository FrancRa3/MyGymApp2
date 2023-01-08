package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Vibrator;
import com.example.myapplication.R;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class ActivityTimer extends AppCompatActivity {

    private TextView textView;
    private ImageButton buttonStart;
    private ImageButton buttonReset;
    private  Context context;

    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;

    private long timeleftinmillis;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
       Bundle time=getIntent().getExtras();  //Prendo il numero passato dall'esercizio
        if(time!=null ){
            String value=time.getString("Time");
            timeleftinmillis=Long.valueOf(value)*1000;
        }

        textView=findViewById(R.id.text_countdown);
        buttonStart=findViewById(R.id.button_start);
        buttonReset=findViewById(R.id.button_reset);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    if ( timeleftinmillis>0) {
                        startTimer();
                    }
                }

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        mTimerRunning=false;
        buttonStart.setImageResource(R.drawable.ic_baseline_play_circle_24);
        buttonReset.setVisibility(View.VISIBLE);
    }

    private void startTimer() {
        countDownTimer=new CountDownTimer(timeleftinmillis,1000) {
            @Override
            public void onTick(long l) {
                timeleftinmillis=l;
                updateCountDownText();
            }


            @Override
            public void onFinish() {
                mTimerRunning=false;
                buttonStart.setImageResource(R.drawable.ic_baseline_play_circle_24);
                buttonStart.setVisibility(View.INVISIBLE);
                buttonReset.setVisibility(View.VISIBLE);
                try {
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION); //faccio suonare e vibrare a fine timer
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                    Vibrator v = (Vibrator) getSystemService(context.VIBRATOR_SERVICE);
                    v.vibrate(1000);
// Vibrate for 1000 milliseconds
            }
        }.start();
        mTimerRunning=true;
        buttonStart.setImageResource(R.drawable.ic_baseline_pause_circle_24);
        buttonReset.setVisibility(View.INVISIBLE);
        }

        



    private void updateCountDownText() {
        int minutes=(int) (timeleftinmillis/1000)/60;
        int seconds=(int) (timeleftinmillis/1000) % 60;
        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textView.setText(timeLeftFormatted);
    }

    private  void resetTimer(){
        Bundle time=getIntent().getExtras();
        if(time!=null){
            String value=time.getString("Time");
            timeleftinmillis=Long.valueOf(value)*1000;
        }
        updateCountDownText();
        buttonReset.setVisibility(View.INVISIBLE);
        buttonStart.setVisibility(View.VISIBLE);
    }
}