package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class title_objective extends AppCompatActivity {
 EditText T;
 Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_objective);

        T=findViewById(R.id.title);
        add=findViewById(R.id.add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(title_objective.this,suggestedactivities.class);
                    intent.putExtra("keytitle",T.getText().toString());
                    startActivity(intent);
                }
            });
    }
}