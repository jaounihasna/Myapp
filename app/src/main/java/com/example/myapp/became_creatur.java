package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class became_creatur extends AppCompatActivity {
 Button creatur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.became_creatur);
        creatur=findViewById(R.id.creatur);
        creatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(became_creatur.this, name_of_community.class);
                startActivity(intent);
            }
        });

    }
}