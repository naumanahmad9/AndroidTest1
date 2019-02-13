package com.example.androidtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView s_id;
    TextView s_name;
    TextView s_email;
    TextView s_age;
    TextView s_gender;
    TextView s_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        s_id = findViewById(R.id.student_id_);
        s_name = findViewById(R.id.student_name_);
        s_email = findViewById(R.id.student_email_);
        s_age = findViewById(R.id.student_age_);
        s_gender = findViewById(R.id.student_gender_);
        s_course = findViewById(R.id.student_course_);

        Bundle bundle = getIntent().getExtras();

        String id_ = bundle.getString("id");
        String name_ = bundle.getString("name");
        String email_ = bundle.getString("email");

        s_id.setText(id_);
        s_name.setText(name_);
        s_email.setText(email_);

    }
}
