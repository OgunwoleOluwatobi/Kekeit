package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Login extends AppCompatActivity {

    ImageView logo;
    EditText phone, pass;
    Button submit;
    Animation atg, joinup, smltobig, btanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logo = findViewById(R.id.logo);
        phone = findViewById(R.id.phone);
        pass = findViewById(R.id.pass);
        submit = findViewById(R.id.submit);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Light.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");
        Typeface MExtralight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-ExtraLight.ttf");

        phone.setTypeface(MExtralight);
        pass.setTypeface(MExtralight);
        submit.setTypeface(MLight);

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        smltobig = AnimationUtils.loadAnimation(this, R.anim.smltobig);
        joinup = AnimationUtils.loadAnimation(this, R.anim.joinup);
        btanim = AnimationUtils.loadAnimation(this, R.anim.btanim);

        phone.startAnimation(joinup);
        pass.startAnimation(joinup);
        submit.startAnimation(btanim);

    }
}
