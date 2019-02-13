package com.example.androidtest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
    }


    public void signup_page(View view) {
        Intent newIntent = new Intent(this, SignupActivity.class);
        startActivity(newIntent);
    }

    public void login(View view) {



        String _username = username.getText().toString();
        String _pass = pass.getText().toString();
        check = false;

        Intent newIntent = new Intent(this, WelcomeActivity.class);

        Bundle bundle = getIntent().getExtras();
        String username_ = bundle.getString("username", _username);
        String password_ = bundle.getString("password", _pass);

        if(_username.isEmpty()){
            username.setError("This field is empty");
            check = true;
        }
        if(_pass.isEmpty()){
            pass.setError("This field is empty");
            check = true;
        }
        else if(_pass.length() <= 6){
            pass.setError("Password is too short");
            check = true;
        }
        if(!check){
            startActivity(newIntent);
        }

    }
}
