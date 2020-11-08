package com.excode.telkomindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.awt.font.TextAttribute;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        toolbar = findViewById(R.id.toolbar);

        // Sets the Toolbar to act as the Action Bar for this activity window.
        // Make sure the toolbar exist in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Telkom Indonesia");
        getSupportActionBar().setSubtitle("Cabang Kedaton - Unit");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // Open Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.home_menu:
                selectedFragment = new HomeFragment();
                break;
            case R.id.place_menu:
                selectedFragment = new PlaceFragment();
                //Intent mapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Telkom+Indonesia+Cabang+Kedaton+-+Unit/@-5.3781389,105.2600335,17z/data=!4m13!1m7!3m6!1s0x0:0x0!2zNcKwMjInNDEuMyJTIDEwNcKwMTUnNDQuMCJF!3b1!8m2!3d-5.3781389!4d105.2622222!3m4!1s0x2e40dad62159b2e3:0xb0f8a18037de1eff!8m2!3d-5.3781636!4d105.2622125"));
                //startActivity(mapsIntent);
                break;
            case R.id.contact_menu:
                selectedFragment = new ContactFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        return true;
    }

}