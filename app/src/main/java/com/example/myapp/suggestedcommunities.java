package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class suggestedcommunities extends AppCompatActivity {
    private TextView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggested_communities);

        c=findViewById(R.id.Community);
        Bundle extras=getIntent().getExtras();
        String nameCommunity=extras.getString("keyname");
        c.setText(nameCommunity+"");


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(suggestedcommunities.this, title_objective.class);
                startActivity(intent);

            }
        });

    }}
