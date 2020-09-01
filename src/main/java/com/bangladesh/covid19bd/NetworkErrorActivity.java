package com.bangladesh.covid19bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class NetworkErrorActivity extends AppCompatActivity {
    Button btn;
    boolean state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_error);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.networkerror).into(imageView);
        btn=findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NetworkErrorActivity.this,CountryInfo.class));
                finish();
            }
        });
    }
}