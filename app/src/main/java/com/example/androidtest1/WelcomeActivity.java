package com.example.androidtest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView profile_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        profile_name = findViewById(R.id.profile_name);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String email = bundle.getString("email");
        String password = bundle.getString("password");

        profile_name.setText(username);
    }

    public void add(View view) {
        Intent newIntent = new Intent(this, AddActivity.class);
        startActivity(newIntent);
    }

    public void view(View view) {
        Intent dIntent = new Intent(this, DetailsActivity.class);
        startActivity(dIntent);
    }
}
