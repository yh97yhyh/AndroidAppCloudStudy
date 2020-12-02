package com.example.btscustomadapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class BTSAdapter extends BaseAdapter {

    Context context;
    ArrayList<BTS> members;
    int layout;

    public BTSAdapter(Context context, ArrayList<BTS> members, int layout) {
        this.context = context;
        this.members = members;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // parent = listView
        BTS member = members.get(position);
        String nick = member.nick;
        String name = member.name;
        int image = member.image;

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_item);
            holder.textNick = convertView.findViewById(R.id.textNick_item);
            holder.textName = convertView.findViewById(R.id.textName_item);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(image);
        holder.textNick.setText(nick);
        holder.textName.setText(name);

        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textNick;
        TextView textName;
    }
}
