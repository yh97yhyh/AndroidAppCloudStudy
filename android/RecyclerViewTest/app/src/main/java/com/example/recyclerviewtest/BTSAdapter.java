package com.example.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BTSAdapter extends RecyclerView.Adapter<BTSAdapter.ViewHolder> {
    Context context;
    ArrayList<BTS> members;
    int layout;

    public BTSAdapter(Context context, ArrayList<BTS> members, int layout) {
        this.context = context;
        this.members = members;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // 재활용 할 게 없으면 호출
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(layout, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder; // 리사이클러뷰에게 홀더 반환
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // 항상 실행, 몇 번째 데이터를 요구하는지
        BTS member = members.get(position);
        holder.imageView.setImageResource(member.image);
        holder.textNick.setText(member.nick);
        holder.textName.setText(member.name);
    }

    @Override
    public int getItemCount() { // 데이터의 갯수 반환
        return members.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textNick;
        TextView textName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item);
            textNick = itemView.findViewById(R.id.textNick_item);
            textName = itemView.findViewById(R.id.textName_item);
        }
    }
}
