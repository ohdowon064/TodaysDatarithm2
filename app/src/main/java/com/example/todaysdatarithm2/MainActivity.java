package com.example.todaysdatarithm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //데이터 받아 올 배열
    //ArrayList<String> arr_data = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_board).setOnClickListener(this);
        findViewById(R.id.btn_data_struct).setOnClickListener(this);
        findViewById(R.id.btn_algorithm).setOnClickListener(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_board:
                startActivity(new Intent(this, BoardActivity.class));
                break;
            case R.id.btn_data_struct:
                startActivity(new Intent(this, data_struct.class));
                break;
            case R.id.btn_algorithm:
                startActivity(new Intent(this, algorithm.class));
                break;
        }
    }
}
