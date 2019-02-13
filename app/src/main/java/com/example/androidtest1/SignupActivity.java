package com.example.androidtest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SignupActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText pass;
    Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
    }
    public void signup(View view){
        String username_text = username.getText().toString();
        String email_text = email.getText().toString();
        String pass_text = pass.getText().toString();
        check = false;

        Intent welcomeIntent = new Intent(this, WelcomeActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString("username", username_text);
        bundle.putString("email", email_text);
        bundle.putString("password", pass_text);

        welcomeIntent.putExtras(bundle);


        if(email_text.isEmpty()){
            email.setError("This field is empty");
            check = true;
        }
        if(pass_text.isEmpty()){
            pass.setError("This field is empty");
            check = true;
        }
        else if(pass.length() <= 6){
            pass.setError("Password is too short");
            check = true;
        }
        if(!check){
            startActivity(welcomeIntent);
        }

    }
}

