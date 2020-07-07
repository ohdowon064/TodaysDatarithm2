package com.example.todaysdatarithm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class data_struct extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_struct);
        findViewById(R.id.btn_ds1).setOnClickListener(this);
        findViewById(R.id.btn_ds2).setOnClickListener(this);
        findViewById(R.id.btn_ds3).setOnClickListener(this);
        findViewById(R.id.btn_ds4).setOnClickListener(this);
        findViewById(R.id.btn_ds5).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_ds1:
                startActivity(new Intent(this, ds1.class));
                break;
            case R.id.btn_ds2:
                startActivity(new Intent(this, ds2.class));
                break;
            case R.id.btn_ds3:
                startActivity(new Intent(this, ds3.class));
                break;
            case R.id.btn_ds4:
                startActivity(new Intent(this, ds4.class));
                break;
            case R.id.btn_ds5:
                startActivity(new Intent(this, ds5.class));
                break;
        }
    }
}
