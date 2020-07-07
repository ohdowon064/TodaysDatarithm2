package com.example.todaysdatarithm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysdatarithm2.adapters.BoardAdapter;
import com.example.todaysdatarithm2.models.Board;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private RecyclerView mBoardRecyclerView;

    private BoardAdapter mAdapter;
    private List<Board> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        mBoardRecyclerView = findViewById(R.id.board_recyclerview);

        findViewById(R.id.board_post).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDataList = new ArrayList<>();
        mStore.collection(FirebaseID.post)
                .orderBy(FirebaseID.timestamp, Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (queryDocumentSnapshots != null) {
                            mDataList.clear();
                            for (DocumentSnapshot snap : queryDocumentSnapshots.getDocuments()) {
                                Map<String, Object> shot = snap.getData();
                                String documentId = String.valueOf(shot.get(FirebaseID.documentId));
                                String nickname = String.valueOf(shot.get(FirebaseID.nickname));
                                String title = String.valueOf(shot.get(FirebaseID.title));
                                String content = String.valueOf(shot.get(FirebaseID.content));
                                Board data = new Board(documentId, nickname, title, content);
                                mDataList.add(data);
                            }
                            mAdapter = new BoardAdapter(mDataList);
                            mBoardRecyclerView.setAdapter(mAdapter);
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, PostActivity.class));
    }
}