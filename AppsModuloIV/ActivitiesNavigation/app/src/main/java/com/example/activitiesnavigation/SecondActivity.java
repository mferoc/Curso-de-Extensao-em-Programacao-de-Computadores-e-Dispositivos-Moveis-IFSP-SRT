package com.example.activitiesnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btVoltar = (Button) findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chamaHomePage();
            }
        });
    }

    void chamaHomePage() {

        Intent intent = new Intent();
        intent.setClass(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
