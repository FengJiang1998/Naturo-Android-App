package com.hfad.naruto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Battle_Activity.java - Handles the battle phase of the fight, including health and damage.
 */
public class Battle_Activity extends AppCompatActivity {

    Character enemysCharacter;
    Character myCharacter;

    private CharacterData myData;
    private int myId;
    private int idOfEnemy;

    private ImageView myImage;
    private ImageView enemyImage;

    private TextView myName;
    private TextView enemyName;

    private TextView myHealthView;
    private TextView enemyHealthView;

    private Button btnAttack;
    private Button btnAttack2;
    private Button btnAttack3;
    private Button btnAttack4;

    private Context context;

    Intent attackMessageIntent;

    private int myCurrentHealth;
    private int enemyCurrentHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_);

        attackMessageIntent = new Intent("attackMessage");
        context=getApplicationContext();

        btnAttack=(Button)findViewById(R.id.btnAttack);
        btnAttack2=(Button)findViewById(R.id.btnAttack2);
        btnAttack3=(Button)findViewById(R.id.btnAttack3);
        btnAttack4=(Button)findViewById(R.id.btnAttack4);
        myName = (TextView)findViewById(R.id.myName);
        enemyName=(TextView)findViewById(R.id.enemyName);

        myHealthView = (TextView)findViewById(R.id.myHealthView);
        enemyHealthView = (TextView)findViewById(R.id.enemyHealthView);


        myImage = (ImageView)findViewById(R.id.my_image);
        enemyImage=(ImageView)findViewById(R.id.enemy_image);

        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver3, new IntentFilter("toBattleMessage"));


        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myId",String.valueOf(myId));
                Log.d("idOfenemy",String.valueOf(idOfEnemy));

                String attack = "attack";

                healthShow(enemyHealthView,enemyCurrentHealth-=myCharacter.getAttack(),enemysCharacter.getHealth());
                if(enemyCurrentHealth<=0)
                {
                    Log.d("Win","win");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_LONG);
                    myToast.show();
                    win();

                }
                attackMessageIntent.putExtra("attackMessage",attack);
                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(attackMessageIntent);
            }
        });


        btnAttack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myId",String.valueOf(myId));
                Log.d("idOfenemy",String.valueOf(idOfEnemy));

                String attack = "attack2";

                healthShow(enemyHealthView,enemyCurrentHealth-=(myCharacter.getAttack())*0.8,enemysCharacter.getHealth());
                if(enemyCurrentHealth<=0)
                {
                    Log.d("Win","win");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_LONG);
                    myToast.show();
                    win();

                }
                attackMessageIntent.putExtra("attackMessage",attack);
                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(attackMessageIntent);
            }
        });


        btnAttack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myId",String.valueOf(myId));
                Log.d("idOfenemy",String.valueOf(idOfEnemy));

                String attack = "attack3";

                healthShow(enemyHealthView,enemyCurrentHealth-=myCharacter.getAttack()*0.5,enemysCharacter.getHealth());
                if(enemyCurrentHealth<=0)
                {
                    Log.d("Win","win");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_LONG);
                    myToast.show();
                    win();

                }
                attackMessageIntent.putExtra("attackMessage",attack);
                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(attackMessageIntent);
            }
        });

        btnAttack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myId",String.valueOf(myId));
                Log.d("idOfenemy",String.valueOf(idOfEnemy));

                String attack = "attack4";

                healthShow(enemyHealthView,enemyCurrentHealth-=0.25*myCharacter.getAttack(),enemysCharacter.getHealth());
                if(enemyCurrentHealth<=0)
                {
                    Log.d("Win","win");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_LONG);
                    myToast.show();
                    win();

                }
                attackMessageIntent.putExtra("attackMessage",attack);
                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(attackMessageIntent);
            }
        });



        getMyId();
        myData = new CharacterData();

        myCharacter = myData.getItem(myId);
        //Character enemysCharacter = myData.getItem(idOfEnemy);

        myName.setText(myCharacter.getName());
        //enemyName.setText(enemysCharacter.getName());

        myImage.setImageResource(myData.getItem(myId).getThumbnail());
        //enemyImage.setImageResource(myData.getItem(idOfEnemy).getThumbnail());

        //healthTextView1.setText(String.valueOf(myCharacter.getHealth()));
        //healthTextView2.setText(String.valueOf(enemysCharacter.getHealth()));
        findEnemy();

    }

    private void setEnemy() {
        enemysCharacter = myData.getItem(idOfEnemy);

        enemyName.setText(enemysCharacter.getName());

        enemyImage.setImageResource(myData.getItem(idOfEnemy).getThumbnail());

        myCurrentHealth = myCharacter.getHealth();
        enemyCurrentHealth = enemysCharacter.getHealth();

        Log.d("Myhealth", String.valueOf(myCurrentHealth));
        Log.d("enemyhealth", String.valueOf(enemyCurrentHealth));
        healthShow(myHealthView,myCurrentHealth,myCharacter.getHealth());
        healthShow(enemyHealthView,enemyCurrentHealth,enemysCharacter.getHealth());
    }


    BroadcastReceiver mReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("theMessage");
            Log.d("From mReceiver3",message);

            if(message.equals("attack"))
            {
                //healthTextView1.setText(String.valueOf(health--));
                healthShow(myHealthView,myCurrentHealth-=enemysCharacter.getAttack(),myCharacter.getHealth());
                if(myCurrentHealth<=0)
                {
                    Log.d("Lost","Lost");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_LONG);
                    myToast.show();
                    lost();
                }
                Log.d("mReceriver3","attack");
            }
            if(message.equals("attack2"))
            {
                //healthTextView1.setText(String.valueOf(health--));
                healthShow(myHealthView,myCurrentHealth-=enemysCharacter.getAttack()*0.8,myCharacter.getHealth());
                if(myCurrentHealth<=0)
                {
                    Log.d("Lost","Lost");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_LONG);
                    myToast.show();
                    lost();
                }
                Log.d("mReceriver3","attack");
            }
            if(message.equals("attack3"))
            {
                //healthTextView1.setText(String.valueOf(health--));
                healthShow(myHealthView,myCurrentHealth-=enemysCharacter.getAttack()*0.5,myCharacter.getHealth());
                if(myCurrentHealth<=0)
                {
                    Log.d("Lost","Lost");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_LONG);
                    myToast.show();
                    lost();
                }
                Log.d("mReceriver3","attack");
            }
            if(message.equals("attack4"))
            {
                //healthTextView1.setText(String.valueOf(health--));
                healthShow(myHealthView,myCurrentHealth-=enemysCharacter.getAttack()*0.25,myCharacter.getHealth());
                if(myCurrentHealth<=0)
                {
                    Log.d("Lost","Lost");
                    Toast myToast = Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_LONG);
                    myToast.show();
                    lost();
                }
                Log.d("mReceriver3","attack");
            }

            if(message.equals("0"))
            {
                idOfEnemy=0;
                setEnemy();

            }
            if(message.equals("1"))
            {
                idOfEnemy=1;
                setEnemy();
            }
            if(message.equals("2"))
            {
                idOfEnemy=2;
                setEnemy();
            }
            if(message.equals("3"))
            {
                idOfEnemy=3;
                setEnemy();

            }
            if(message.equals("4"))
            {
                idOfEnemy=4;
                setEnemy();
            }
        }
    };

    public void getMyId()
    {
        Intent intent = getIntent();
        myId=intent.getExtras().getInt("Id");
    }
    public void findEnemy()
    {
        Intent attackMessageIntent = new Intent("findMessage");
        attackMessageIntent.putExtra("findMessage","find");
        LocalBroadcastManager.getInstance(context)
                .sendBroadcast(attackMessageIntent);

    }

    public void healthShow(TextView healthView,int currentHealth, int health)
    {
        String theHealth = currentHealth +" "+"/"+" "+health;
        healthView.setText(theHealth);
    }

    public void win()
    {
        Intent intent =  new Intent(this,Win_Activity.class);
        startActivity(intent);
    }
    public void lost()
    {
        Intent intent =  new Intent(this,Lost_Activity.class);
        startActivity(intent);
    }

}
