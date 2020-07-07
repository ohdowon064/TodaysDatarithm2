package com.example.todaysdatarithm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class algorithm extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        findViewById(R.id.btn_al1).setOnClickListener(this);
        findViewById(R.id.btn_al2).setOnClickListener(this);
        findViewById(R.id.btn_al3).setOnClickListener(this);
        findViewById(R.id.btn_al4).setOnClickListener(this);
        findViewById(R.id.btn_al5).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_al1:
                startActivity(new Intent(this, ds1.class));
                break;
            case R.id.btn_al2:
                startActivity(new Intent(this, ds2.class));
                break;
            case R.id.btn_al3:
                startActivity(new Intent(this, ds3.class));
                break;
            case R.id.btn_al4:
                startActivity(new Intent(this, ds4.class));
                break;
            case R.id.btn_al5:
                startActivity(new Intent(this, ds5.class));
                break;
        }
    }
}
