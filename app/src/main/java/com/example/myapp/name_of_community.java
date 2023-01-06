package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class name_of_community extends AppCompatActivity {
    private EditText n;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_of_community);
        n=findViewById(R.id.name);
        valider=findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(name_of_community.this,suggestedcommunities.class);
                intent.putExtra("keyname",n.getText().toString());

                startActivity(intent);
            }
        });
    }
}