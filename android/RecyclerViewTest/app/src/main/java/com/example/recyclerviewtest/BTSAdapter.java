package com.example.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // 재활용 할 게 없을 때
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(layout, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BTS member = members.get(position);
        holder.imageView.setImageResource(member.image);
        holder.textNick.setText(member.nick);
        holder.textName.setText(member.name);

    }

    @Override
    public int getItemCount() { // 데이터의 갯수
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    BTS member = members.get(pos);
                    Toast.makeText(context, member.name, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
