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

public class BTSAdapter1 extends RecyclerView.Adapter<BTSAdapter1.ViewHolder> {

    Context context;
    ArrayList<BTS> members;
    int layout;

    public BTSAdapter1(Context context, ArrayList<BTS> members, int layout) {
        this.context = context;
        this.members = members;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
    public int getItemCount() {
        return members.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textNick;
        TextView textName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item_hor);
            textNick = itemView.findViewById(R.id.textNick_item_hor);
            textName = itemView.findViewById(R.id.textName_item_hor);
        }
    }
}
