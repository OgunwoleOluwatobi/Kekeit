package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    EditText text1, text2, text3, text4;
    Button submit;
    ImageView logo;
    Animation atg, joinup, smltobig, btanim;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        logo = findViewById(R.id.logo);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        submit = findViewById(R.id.submit);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String txt1 = text1.getText().toString().trim();
                final String txt2 = text2.getText().toString().trim();
                final String txt3 = text3.getText().toString().trim();
                final String txt4 = text4.getText().toString().trim();

                if (TextUtils.isEmpty(txt1)){
                    Toast.makeText(getApplicationContext(),"Please Enter your name", Toast.LENGTH_SHORT).show();
                    text1.setError("Please Enter Your fullname");
                    text1.requestFocus();
                }else {
                    if (TextUtils.isEmpty(txt2)) {
                        Toast.makeText(getApplicationContext(), "Please Enter your Phone Number", Toast.LENGTH_SHORT).show();
                        text2.setError("Please Enter Phone Number");
                        text2.requestFocus();
                    } else {
                        if (txt2.length() < 10) {
                            Toast.makeText(getApplicationContext(), "Please Enter a valid Phone Number", Toast.LENGTH_SHORT).show();
                            text2.setError("Please Enter a valid Phone Number");
                            text2.requestFocus();
                        } else {
                            if (TextUtils.isEmpty(txt3)) {
                                Toast.makeText(getApplicationContext(), "Please Enter your Course of Study", Toast.LENGTH_SHORT).show();
                                text3.setError("Please Enter Course of study");
                                text3.requestFocus();
                            } else {
                                if (TextUtils.isEmpty(txt4)) {
                                    Toast.makeText(getApplicationContext(), "Please Enter your Password", Toast.LENGTH_SHORT).show();
                                    text4.setError("Please Enter Password");
                                    text4.requestFocus();
                                } else {

                                    Signup_save user = new Signup_save(txt1, txt2, txt3, txt4);
                                    databaseReference.child("Customer").child(txt1).setValue(user);
                                    Intent open = new Intent(Signup.this, Verify.class);
                                    open.putExtra("phonenumber", txt2);
                                    startActivity(open);
                                }
                            }
                        }
                    }
                }
            }
        });

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Light.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");
        Typeface MExtralight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-ExtraLight.ttf");

        text1.setTypeface(MExtralight);
        text2.setTypeface(MExtralight);
        text3.setTypeface(MExtralight);
        text4.setTypeface(MExtralight);
        submit.setTypeface(MLight);

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        smltobig = AnimationUtils.loadAnimation(this, R.anim.smltobig);
        joinup = AnimationUtils.loadAnimation(this, R.anim.joinup);
        btanim = AnimationUtils.loadAnimation(this, R.anim.btanim);

        text1.startAnimation(joinup);
        text2.startAnimation(joinup);
        text3.startAnimation(joinup);
        text4.startAnimation(joinup);
        submit.startAnimation(btanim);
    }
}
