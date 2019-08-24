package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Splash2 extends AppCompatActivity {

    Button signup, login;
    ImageView iv1, iv2;
    Animation atg, smltobig, btanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Splash2.this, Signup.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Splash2.this, Login.class);
                b.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(b);
            }
        });

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Light.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");
        Typeface MExtralight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-ExtraLight.ttf");

        signup.setTypeface(MRegular);
        login.setTypeface(MRegular);

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        smltobig = AnimationUtils.loadAnimation(this, R.anim.smltobig);
        btanim = AnimationUtils.loadAnimation(this, R.anim.btanim);


        signup.startAnimation(btanim);
        login.startAnimation(btanim);



    }
    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent intent = new Intent(Splash2.this, Customer_map.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
