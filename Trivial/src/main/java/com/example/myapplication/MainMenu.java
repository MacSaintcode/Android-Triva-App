package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    private Button play;
    private Button leaderboard;
    boolean Exit=false;

    ImageView logout;
    private DBHandler DBHandler;
    int counter=0;
    Intent call;

    String logged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



        play=findViewById(R.id.play);
        leaderboard=findViewById(R.id.leader);
        logout=findViewById(R.id.logout);


        call = getIntent();
        logged= call.getStringExtra("username");
        if(!(logged==null||logged.isBlank())){
            logout.setVisibility(View.VISIBLE);
        }
        System.out.println(logged+"this is me");
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logged==null||logged.isBlank() ){
                    call=new Intent(MainMenu.this,register_login.class);
                    startActivity(call);
                    finish();
                }
                else {
                    call=new Intent(MainMenu.this, MainGame.class);
                    call.putExtra("username",logged);
                    startActivity(call);
                    finish();
                }


            }
        });
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call=new Intent(MainMenu.this,Leaderboard.class);
                call.putExtra("username",logged);
                startActivity(call);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, logged+ " has  been signed out!", Toast.LENGTH_SHORT).show();
                logged="";
                logout.setVisibility(View.INVISIBLE);

            }
        });
    }
    @Override
    public void onBackPressed() {
        counter++;
        if(counter==2){
            new AlertDialog.Builder(MainMenu.this)

                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)  // Prevent dialog from being dismissed when tapped outside
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Close the app
                            finish();  // Close the current activity, effectively exiting the app
                        }
                    })
                    .setNegativeButton("No", null)  // If "No", just dismiss the dialog
                    .show();
            counter=0;
            }
    }
}