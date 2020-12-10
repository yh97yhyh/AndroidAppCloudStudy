package com.example.evchargingstationtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder>{
    Context context;
    ArrayList<Station> stations;
    int layout;

    public StationAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        stations = new ArrayList<>();
    }

    public  void addItem(Station station) { stations.add(station); }

    public void clear() {stations.clear();}

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
        Station station = stations.get(position);

        holder.textStName.setText(station.stName);
        holder.textAddr.setText(station.addr);
        holder.textChargeTp.setText(station.chargeTp);
        holder.textCpNm.setText(station.cpNm);
        holder.textCpTp.setText(station.cpTp);
        holder.textCpStat.setText(station.cpStat);
    }

    @Override
    public int getItemCount() { return stations.size(); }

    class ViewHolder extends RecyclerView.ViewHolder {


        TextView textStName;
        TextView textAddr;
        TextView textChargeTp;
        TextView textCpNm;
        TextView textCpTp;
        TextView textCpStat;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textStName = itemView.findViewById(R.id.text_csNm);
            textAddr = itemView.findViewById(R.id.text_addr);
            textChargeTp = itemView.findViewById(R.id.text_chargeTp);
            textCpNm = itemView.findViewById(R.id.text_cpNm);
            textCpTp = itemView.findViewById(R.id.text_cpTp);
            textCpStat = itemView.findViewById(R.id.text_cpStat);
        }
    }
}
