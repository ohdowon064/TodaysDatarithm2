package com.example.todaysdatarithm2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class al1 extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al1);

        //activity_al1.xml의 텍스트뷰(tv_al1) 연결
        final TextView tv_al1;
        tv_al1 = (TextView)findViewById (R.id.tv_algorithm);

        //파이어베이스 연동
        database = FirebaseDatabase.getInstance(); //DB연동
        databaseReference = database.getReference("algorithm").child("merge"); //'algorithm'하위 'merge'에 참조

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스에서 데이터 받아옴
                String str_data = dataSnapshot.getValue(String.class);
                tv_al1.setText(str_data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //파이어베이스에서 데이터 받아오기 실패했을 때
            }

        });
    }
}
