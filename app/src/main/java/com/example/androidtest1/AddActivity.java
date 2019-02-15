package com.example.androidtest1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddActivity extends AppCompatActivity {
    ImageView student_img;
    EditText student_id;
    EditText student_name;
    EditText student_email;
    EditText student_age;
    EditText student_gender;
    EditText student_course;
    Uri imageUri;
    private int Capture_Image = 123;
    private int Pick = 456;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        student_img = findViewById(R.id.student_img);
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

    public void opencamera(View view){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, Capture_Image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 123 && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            student_img.setImageBitmap(bitmap);
        }
        else if(requestCode == 456 && resultCode == RESULT_OK){
            imageUri = data.getData();
            student_img.setImageURI(imageUri);
        }
    }

    public void opengallery(View view) {
        Intent openGallery = new Intent();

        openGallery.setAction(Intent.ACTION_PICK);
        openGallery.setType("Image/*");
        startActivityForResult(Intent.createChooser(openGallery, "Select Image"), Pick);

    }
}
