package com.hfad.naruto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Win_Activity.java - Handles when a player wins a battle.
 */
public class Win_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_);

    }
    public void onClick(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
