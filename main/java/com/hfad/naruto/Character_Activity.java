package com.hfad.naruto;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Character_Activity.java - Handles the character object and all of it's data
 */

public class Character_Activity extends AppCompatActivity {

    private TextView tvname, tvdescription, tvcountry, gamehealth, gameattack, gamedefense, gamespeed;
    private ImageView img;
    private String Name;
    private int Id, Health, Attack, Defense, Speed, image;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_2);
        mContext=getApplicationContext();

        tvname = (TextView) findViewById(R.id.txtname);
        tvdescription = (TextView) findViewById(R.id.txtdescription);
        tvcountry = (TextView) findViewById(R.id.txtcountry);
        img = (ImageView)findViewById(R.id.characterthumbnail);
        gamehealth = (TextView)findViewById(R.id.txthealth);
        gameattack = (TextView)findViewById(R.id.txtattack);
        gamedefense = (TextView)findViewById(R.id.txtdefense);
        gamespeed = (TextView)findViewById(R.id.txtspeed);

        //Receive data

        Intent intent = getIntent();

        Id = intent.getExtras().getInt("Id");
        Name = intent.getExtras().getString("Name");
        String Description = intent.getExtras().getString("Description");
        String country = intent.getExtras().getString("Country");
        image = intent.getExtras().getInt("Thumbnail");
        Health = intent.getExtras().getInt("Health");
        Attack = intent.getExtras().getInt("Attack");
        Defense = intent.getExtras().getInt("Defense");
        Speed = intent.getExtras().getInt("Speed");

        // Setting values

        tvname.setText(Name);
        tvdescription.setText(Description);
        tvcountry.setText(country);
        img.setImageResource(image);
        gamehealth.setText(Integer.toString(Health));
        gameattack.setText(Integer.toString(Attack));
        gamedefense.setText(Integer.toString(Defense));
        gamespeed.setText(Integer.toString(Speed));

        Button selectionButton = (Button)findViewById(R.id.buttonSelectCharacter);
        selectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BluetoothConnection_Activity.class);
                intent.putExtra("Id",Id);
                startActivity(intent);
            }
        });

    }
}
