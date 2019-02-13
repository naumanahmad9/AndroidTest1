package com.example.androidtest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText student_id;
    EditText student_name;
    EditText student_email;
    EditText student_age;
    EditText student_gender;
    EditText student_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        student_id = findViewById(R.id.student_id);
        student_name = findViewById(R.id.student_name);
        student_email = findViewById(R.id.student_email);
        student_age = findViewById(R.id.student_age);
        student_gender = findViewById(R.id.student_gender);
        student_course = findViewById(R.id.student_course);
    }

    public void submit(View view) {

        String _id = student_id.getText().toString();
        String _name = student_name.getText().toString();
        String _email = student_email.getText().toString();
        String _age = student_age.getText().toString();
        String _gender = student_gender.getText().toString();
        String _course = student_course.getText().toString();


        Intent dIntent = new Intent(this, DetailsActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString("id", _id);
        bundle.putString("name", _name);
        bundle.putString("email", _email);
        bundle.putString("age", _age);
        bundle.putString("gender",  _gender);
        bundle.putString("course", _course);


        dIntent.putExtras(bundle);


        startActivity(dIntent);
    }
}
