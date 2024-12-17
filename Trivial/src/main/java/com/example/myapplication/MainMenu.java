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

public class MainMenu extends AppCompatActivity {

    private Button play;
    private Button leaderboard;
    boolean Exit=false;
    private DBHandler DBHandler;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        play=findViewById(R.id.play);
        leaderboard=findViewById(R.id.leader);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(MainMenu.this,register_login.class);
                startActivity(call);
            }
        });
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(MainMenu.this,Leaderboard.class);

                startActivity(call);
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