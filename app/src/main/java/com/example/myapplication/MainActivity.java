package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Animation atg, smltobig;
    ImageView iv1, iv2;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Splash2.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Light.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");
        Typeface MExtralight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-ExtraLight.ttf");

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        smltobig = AnimationUtils.loadAnimation(this, R.anim.smltobig);

        iv1.startAnimation(smltobig);
        iv2.startAnimation(atg);
    }
}
