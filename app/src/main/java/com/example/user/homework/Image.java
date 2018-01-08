package com.example.user.homework;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Image extends AppCompatActivity {
    private ImageView img;
    private TextView textView;
    //Переменная для установления связи между приложением и камерой
    private int CAMERA_CAPTURE;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        img.setImageBitmap((Bitmap) data.getExtras().getParcelable("data"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        img = findViewById(R.id.ImageView);
        textView = findViewById(R.id.textmes);
        //Используем стандартное системное намерение на использование камеры:
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Задаем возможность работать с полученными с камеры данными:
        startActivityForResult(captureIntent, CAMERA_CAPTURE);
        Intent intent = getIntent();

        String s = intent.getStringExtra("name");

        textView.setText(s);

    }

}

