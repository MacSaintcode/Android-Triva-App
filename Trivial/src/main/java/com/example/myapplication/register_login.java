package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class register_login extends AppCompatActivity {
    public String use;
    private ImageView back;
    private TextView forgot;
    private TextView account;
    private  EditText passcod;
    private EditText users;

    private Button login;
    private DBHandler DBHandler;
    int n=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

        back=findViewById(R.id.back);
        forgot=  findViewById(R.id.fpassword);
        account= findViewById(R.id.caccount);
        login=findViewById(R.id.login);
        users=findViewById(R.id.user);
        passcod=findViewById(R.id.passcode);
        DBHandler = new DBHandler(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(register_login.this,MainMenu.class);
                startActivity(call);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(register_login.this,ForgotPassword.class);
                startActivity(call);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(register_login.this,New_User.class);
                startActivity(call);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if user exist in db first

                if(users.getText().toString().isEmpty()||passcod.getText().toString().isEmpty()){
                    Toast.makeText(register_login.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }
                else if (DBHandler.confirm(users.getText().toString(),passcod.getText().toString())){
                    Intent call;
                    use=users.getText().toString();
                    call=new Intent(register_login.this, MainGame.class);
                    call.putExtra("username",use);
                    startActivity(call);

                }
                else {
                    n--;
                    if (n==0){
                        Toast.makeText(register_login.this, "User Does Not Exist!", Toast.LENGTH_SHORT).show();
                        Intent call=new Intent(register_login.this,MainMenu.class);
                        startActivity(call);
                    }else {
                        Toast.makeText(register_login.this, "User Does Not Exist!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(register_login.this, "You Have " + n + " More Tries!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent cal=new Intent(register_login.this,MainMenu.class);
        startActivity(cal);
        finish();
    }

}