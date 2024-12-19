package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class Leaderboard extends AppCompatActivity {

    private ImageView back;
    private TextView user;
    private TextView scores;
    private TextView user1;
    private TextView scores1;
    private TextView user2;
    private TextView scores2;
    private TextView user3;
    private TextView scores3;
    private TextView user4;
    private TextView scores4;
    private TextView user5;
    private TextView scores5;
    private TextView user6;
    private TextView scores6;
    private TextView user7;
    private TextView scores7;
    private TextView user8;
    private TextView scores8;
    private TextView user9;
    private TextView scores9;

    private String logged;
    DBHandler dbHandler;
    String arr[][]={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        back=findViewById(R.id.back);
        scores=findViewById(R.id.sco);
        user=findViewById(R.id.nam);
        scores1=findViewById(R.id.sco1);
        user1=findViewById(R.id.nam1);
        user2=findViewById(R.id.nam2);
        scores2=findViewById(R.id.sco2);
        user3=findViewById(R.id.nam3);
        scores3=findViewById(R.id.sco3);
        user4=findViewById(R.id.nam4);
        scores4=findViewById(R.id.sco4);
        user5=findViewById(R.id.nam5);
        scores5=findViewById(R.id.sco5);
        user6=findViewById(R.id.nam6);
        scores6=findViewById(R.id.sco6);
        user7=findViewById(R.id.nam7);
        scores7=findViewById(R.id.sco7);
        user8=findViewById(R.id.nam8);
        scores8=findViewById(R.id.sco8);
        user9=findViewById(R.id.nam9);
        scores9=findViewById(R.id.sco9);
        dbHandler = new DBHandler(this);
//        13 top players

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(Leaderboard.this,MainMenu.class);

                startActivity(call);
                finish();
            }
        });
        TextView arr[][]={{user,scores},{user1,scores1},{user2,scores2},{user3,scores3},{user4,scores4},
                {user5,scores5},{user6,scores6},{user7,scores7},{user8,scores8},{user9,scores9},};
        int n=0;
        Cursor c=dbHandler.getleaders();
        while(c.moveToNext()){
            arr[n][0].setText(c.getString(2));
            arr[n][1].setText(c.getString(4));
            n++;
        }
    }
    @Override
    public void onBackPressed() {
        Intent call=new Intent(Leaderboard.this,MainMenu.class);
        startActivity(call);
        finish();
    }
}
