package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class suggestedactivities extends AppCompatActivity {
    private TextView Curan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggested_activities);

        Curan = findViewById(R.id.Curan);
        Bundle extra=getIntent().getExtras();
        String t=extra.getString("keytitle");
        Curan.setText(t+"");
        Curan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(suggestedactivities.this, add_tasks.class);
                startActivity(intent);
            }
        });
    }
}