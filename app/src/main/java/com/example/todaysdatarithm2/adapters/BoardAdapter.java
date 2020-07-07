package com.example.todaysdatarithm2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysdatarithm2.R;
import com.example.todaysdatarithm2.models.Board;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    private List<Board> dataList;

    public BoardAdapter(List<Board> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BoardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        Board data = dataList.get(position);
        holder.nickname.setText("작성자 : "+data.getNickname());
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContents());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class BoardViewHolder extends RecyclerView.ViewHolder {
        private TextView nickname;
        private TextView title;
        private TextView content;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);

            nickname = itemView.findViewById(R.id.item_board_nickname);
            title = itemView.findViewById(R.id.item_board_title);
            content = itemView.findViewById(R.id.item_board_content);
        }

    }
}
