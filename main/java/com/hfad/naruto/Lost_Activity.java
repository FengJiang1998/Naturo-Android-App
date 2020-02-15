package com.hfad.naruto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Lost_Activity.java - Handler for when a player loses a battle
 */
public class Lost_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_);

    }
    public void onClick(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
