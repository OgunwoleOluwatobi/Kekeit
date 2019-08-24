package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Customer_map extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLaatLocation;
    LocationRequest mLocationRequest;

    //private Button logout;
    LinearLayout menu;
    FrameLayout rel, overlay;
    ImageView pic, menuopen;
    TextView name, profile, trip, pay, set, out;
    EditText text1, text2;
    Button regular, express, cash, card, one, two, three, four, order;
    HorizontalScrollView scroll;

    Animation top, bot, left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        /*logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(Customer_map.this, Splash2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });*/

        menu = findViewById(R.id.menu);
        rel = findViewById(R.id.rel);
        overlay = findViewById(R.id.overlay);
        pic = findViewById(R.id.pic);
        name = findViewById(R.id.name);
        profile = findViewById(R.id.profile);
        trip = findViewById(R.id.trip);
        pay = findViewById(R.id.pay);
        set = findViewById(R.id.set);
        out = findViewById(R.id.out);
        menuopen = findViewById(R.id.menuopen);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        regular = findViewById(R.id.regular);
        express = findViewById(R.id.express);
        cash = findViewById(R.id.cash);
        card = findViewById(R.id.card);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        order = findViewById(R.id.order);
        scroll = findViewById(R.id.scroll);

        top = AnimationUtils.loadAnimation(this, R.anim.frmtop);
        bot = AnimationUtils.loadAnimation(this, R.anim.topbottom);
        left = AnimationUtils.loadAnimation(this, R.anim.leftback);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Light.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");
        Typeface MExtralight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-ExtraLight.ttf");

        text1.setTypeface(MExtralight);
        text2.setTypeface(MExtralight);
        profile.setTypeface(MLight);
        trip.setTypeface(MLight);
        pay.setTypeface(MLight);
        set.setTypeface(MLight);
        out.setTypeface(MRegular);
        regular.setTypeface(MMedium);
        express.setTypeface(MMedium);
        cash.setTypeface(MMedium);
        card.setTypeface(MMedium);
        one.setTypeface(MMedium);
        two.setTypeface(MMedium);
        three.setTypeface(MMedium);
        four.setTypeface(MMedium);
        order.setTypeface(MMedium);

        menuopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel.animate().translationX(0);
                menu.animate().translationX(0);
                overlay.setVisibility(view.VISIBLE);
                overlay.animate().alpha(1);

                pic.startAnimation(bot);
                name.startAnimation(left);
                profile.startAnimation(top);
                trip.startAnimation(top);
                pay.startAnimation(top);
                set.startAnimation(top);
                out.startAnimation(top);
            }
        });

        rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel.animate().translationX(-735);
                menu.animate().translationX(-735);
                overlay.animate().alpha(0);
            }
        });

        overlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel.animate().translationX(0);
                menu.animate().translationX(-735);
                overlay.setVisibility(view.GONE);
                overlay.animate().alpha(0);
            }
        });

        regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regular.setVisibility(View.GONE);
                express.setVisibility(View.GONE);
                scroll.setVisibility(View.VISIBLE);
            }
        });

        express.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regular.setVisibility(View.GONE);
                express.setVisibility(View.GONE);
                cash.setVisibility(View.VISIBLE);
                card.setVisibility(View.VISIBLE);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.setVisibility(View.GONE);
                cash.setVisibility(View.VISIBLE);
                card.setVisibility(View.VISIBLE);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.setVisibility(View.GONE);
                cash.setVisibility(View.VISIBLE);
                card.setVisibility(View.VISIBLE);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.setVisibility(View.GONE);
                cash.setVisibility(View.VISIBLE);
                card.setVisibility(View.VISIBLE);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scroll.setVisibility(View.GONE);
                cash.setVisibility(View.VISIBLE);
                card.setVisibility(View.VISIBLE);
            }
        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash.setVisibility(View.GONE);
                card.setVisibility(View.GONE);
                order.setVisibility(View.VISIBLE);
            }
        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cash.setVisibility(View.GONE);
                card.setVisibility(View.GONE);
                order.setVisibility(View.VISIBLE);
            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(Customer_map.this, Splash2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(6.893600, 3.723932);
        mMap.addMarker(new MarkerOptions().position(sydney).title("My Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18.0f));
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
