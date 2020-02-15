package com.hfad.naruto;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Naruto app - This app uses bluetooth connectivity to emulate a battle between
 *      different Naruto characters and show the user who wins and who doesn't
 * MainActivity.java - Main acitvity for Naruto app.
 * @author Feng Jiang & Rodolfo "Ofo" Croes
 * @class CSCI 343
 * @date 5/5/2019
 * @final FinalProject1 (Naruto)
 * @email fjiang@coastal.edu & rjcroes@coastal.edu
 */
public class MainActivity extends AppCompatActivity {

    List<Character> lstCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mp	=	//conMnues on next line
                MediaPlayer.create(this, R.raw.the_theme);
        mp.start();

        lstCharacter = new CharacterData().getList();

        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstCharacter);

        myrv.setLayoutManager(new GridLayoutManager(this,3));

        myrv.setAdapter(myAdapter);
    }
}
