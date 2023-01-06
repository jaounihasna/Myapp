package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_tasks extends AppCompatActivity {

    EditText t1,t2,t3;
    Button save;
    EditText s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tasks);

        t1=findViewById(R.id.task1);
        t2=findViewById(R.id.task2);
        t3=findViewById(R.id.task3);
        s=findViewById(R.id.score);
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keytask1=t1.getText().toString();
                String keytask2=t2.getText().toString();
                String keytask3=t3.getText().toString();
                String keyscore1=s.getText().toString();



;                Intent intent=new Intent(add_tasks.this,task.class);
                intent.putExtra("keytask1",keytask1);
                intent.putExtra("keytask2",keytask2);
                intent.putExtra("keytask3",keytask3);
                intent.putExtra("keyscore1",keyscore1);
                startActivity(intent);
            }
        });

    }
}