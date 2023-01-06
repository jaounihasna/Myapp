package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class task extends AppCompatActivity {
private Button t1,t2,t3  ;
private TextView s;
    private TextView SAVE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);

t1=findViewById(R.id.task1);
t2=findViewById(R.id.task2);
t3=findViewById(R.id.task3);
s=findViewById(R.id.score1);


       String keytask1="" +getIntent().getExtras().getString("keytask1");
        String keytask2="" +getIntent().getExtras().getString("keytask2");
        String keytask3="" +getIntent().getExtras().getString("keytask3");
        String keyscore1=""+getIntent().getExtras().getString("keyscore1");
       t1.setText(keytask1+"");
       t2.setText(keytask2+"");
       t3.setText(keytask3+"");
       s.setText(keyscore1+"");

        SAVE = findViewById(R.id.SAVE);
        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(task.this, result.class);
                startActivity(intent);
            }
        });
    }
}