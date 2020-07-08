package com.example.todaysdatarithm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //데이터 받아 올 배열
    //ArrayList<String> arr_data = new ArrayList<String>();
    private Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_board).setOnClickListener(this);
        findViewById(R.id.btn_data_struct).setOnClickListener(this);
        findViewById(R.id.btn_algorithm).setOnClickListener(this);
        findViewById(R.id.btn_alarm).setOnClickListener(this);

        //search버튼 클릭 -> 해당 내용 화면으로 전환
        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //EditText에서 검색할 content받음 -> search_text에 저장
                EditText et_search = (EditText) findViewById(R.id.et_search);
                final String search_text = et_search.getText().toString();

                switch (search_text) {
                    //algorithm
                    case "merge":
                        startActivity(new Intent(MainActivity.this, al1.class));
                        break;
                    case "quick":
                        startActivity(new Intent(MainActivity.this, al2.class));
                        break;
                    case "binary":
                        startActivity(new Intent(MainActivity.this, al3.class));
                        break;
                    case "sequential":
                        startActivity(new Intent(MainActivity.this, al4.class));
                        break;
                    case "combination":
                        startActivity(new Intent(MainActivity.this, al5.class));
                        break;

                    //data_struct
                    case "list":
                        startActivity(new Intent(MainActivity.this, ds1.class));
                        break;
                    case "tuple":
                        startActivity(new Intent(MainActivity.this, ds2.class));
                        break;
                    case "dictionary":
                        startActivity(new Intent(MainActivity.this, ds3.class));
                        break;
                    case "set":
                        startActivity(new Intent(MainActivity.this, ds4.class));
                        break;
                    case "sequence":
                        startActivity(new Intent(MainActivity.this, ds5.class));
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"no match content", Toast.LENGTH_SHORT).show();

                }

            }
        });
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
            case R.id.btn_alarm:
                startActivity(new Intent(this, alarm_setting.class));
                break;
        }
    }
}
