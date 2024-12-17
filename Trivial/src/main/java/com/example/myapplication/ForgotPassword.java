package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private ImageView back;
    private EditText pass;
    private EditText cpass;
    private EditText username;
    private EditText phone;
    private Button btn;
    DBHandler DBHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        back=findViewById(R.id.back);
        username=findViewById(R.id.users);
        cpass=findViewById(R.id.cpassword);
        pass=findViewById(R.id.password);
        btn=findViewById(R.id.btnchange);
        phone=findViewById(R.id.phone);
        DBHandler = new DBHandler(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(ForgotPassword.this,register_login.class);
                startActivity(call);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(pass.getText().toString().isEmpty()|| username.getText().toString().isEmpty()||cpass.getText().toString().isEmpty()||phone.getText().toString().isEmpty() ){
                    Toast.makeText(ForgotPassword.this, "All fields must be filled", Toast.LENGTH_SHORT).show();

                } else if (!pass.getText().toString().equals(cpass.getText().toString())) {
                    Toast.makeText(ForgotPassword.this, "Password Does not match!", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (DBHandler.forgotpassword(username.getText().toString(),pass.getText().toString(),phone.getText().toString())){
                        Toast.makeText(ForgotPassword.this, "Password Changed!", Toast.LENGTH_SHORT).show();
                        Intent call=new Intent(ForgotPassword.this,register_login.class);
                        startActivity(call);

                    } else if (DBHandler.check(username.getText().toString(),pass.getText().toString())) {
                        Toast.makeText(ForgotPassword.this, "Use a different password!", Toast.LENGTH_SHORT).show();
                        cpass.setText("");
                        pass.setText("");

                    } else{
                        username.setText("");
                        username.setHint("User Does Not Exist!");
                        username.setHintTextColor(Color.RED);
                    }
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent cal=new Intent(ForgotPassword.this,register_login.class);
        startActivity(cal);
        finish();
    }
}