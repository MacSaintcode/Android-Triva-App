package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        play=findViewById(R.id.play);
        leaderboard=findViewById(R.id.leader);
        logout=findViewById(R.id.logout);

        SharedPreferences storage = getSharedPreferences("logged_in", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = storage.edit();
        String username = storage.getString("username", "");
        System.out.println(username);

        if(!(username==null||username.isBlank())){
            logout.setVisibility(View.VISIBLE);
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username==null||username.isBlank() ){
                    call=new Intent(MainMenu.this,register_login.class);
                    startActivity(call);
                    finish();
                }
                else {
                    call=new Intent(MainMenu.this, MainGame.class);
                    startActivity(call);
                    finish();
                }


            }
        });
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call=new Intent(MainMenu.this,Leaderboard.class);
                startActivity(call);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, username+ " has  been signed out!", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = storage.edit();
                editor.putString("username", "");
                editor.apply();
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