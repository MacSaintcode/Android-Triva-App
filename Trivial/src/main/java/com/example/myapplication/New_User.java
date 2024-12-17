package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class New_User extends AppCompatActivity {

    private ImageView back;
    private EditText name;
    EditText username;
    private EditText password;
    private EditText cpassword;
    private EditText phone;

    private DBHandler DBHandler;
    private Button post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        back=findViewById(R.id.back);
        post = findViewById(R.id.post);
        cpassword = findViewById(R.id.cpass);
        password = findViewById(R.id.pass);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        phone=findViewById(R.id.phone);
        DBHandler = new DBHandler(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(New_User.this,register_login.class);
                startActivity(call);
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cpass=cpassword.getText().toString();
                String pass=password.getText().toString();
                String names = name.getText().toString();
                String user=username.getText().toString();
                String phon=phone.getText().toString();
                if(pass.isEmpty()|| user.isEmpty()||names.isEmpty()||cpass.isEmpty()){
                    Toast.makeText(New_User.this, "All field must be filled", Toast.LENGTH_SHORT).show();

                } else if (!pass.equals(cpass)) {
                    Toast.makeText(New_User.this, "Password Does not match!", Toast.LENGTH_SHORT).show();

                } else {

                    if (!DBHandler.newuser(names,user,pass,0,phon,phone,username)) {
                        Toast.makeText(New_User.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                        Intent call = new Intent(New_User.this, register_login.class);
                        startActivity(call);
                    }
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent cal=new Intent(New_User.this,register_login.class);
        startActivity(cal);
        finish();
    }
}