package com.example.todaysdatarithm2;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class al2 extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al1);

        //activity_al2.xml의 텍스트뷰(tv_al2) 연결
        final TextView tv_al2;
        tv_al2 = (TextView)findViewById (R.id.tv_algorithm);

        //파이어베이스 연동
        database = FirebaseDatabase.getInstance(); //DB연동
        databaseReference = database.getReference("algorithm").child("quick");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스에서 데이터 받아옴
                String str_data = dataSnapshot.getValue(String.class);
                tv_al2.setText(str_data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //파이어베이스에서 데이터 받아오기 실패했을 때
                Toast.makeText(al2.this, "빼일드.",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}
