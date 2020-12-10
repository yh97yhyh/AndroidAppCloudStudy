package com.example.bookfinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    Context context;
    ArrayList<Book> books;
    int layout;

    public BookAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        books = new ArrayList<>();
    }

    public void addItem(Book book) {
        books.add(book);
    }

    public void clear() {
        books.clear();
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
        Book book = books.get(position);
//        holder.imageView.setImageResource(Integer.parseInt(book.thumbnail));
        Glide.with(context).load(book.thumbnail).into(holder.imageView);
        holder.textTitle.setText(book.title);
        holder.textAuthor.setText(book.authors);
        holder.textPublisher.setText(book.publisher);
        holder.textStatus.setText(book.status);
        holder.textPrice.setText(book.price+"");
        holder.textSalePrice.setText(book.salePrice+"");
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textAuthor;
        TextView textPublisher;
        TextView textStatus;
        TextView textPrice;
        TextView textSalePrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_book_item);
            textTitle = itemView.findViewById(R.id.text_title_item);
            textAuthor = itemView.findViewById(R.id.text_author_item);
            textPublisher = itemView.findViewById(R.id.ltext_publihser_item);
            textStatus = itemView.findViewById(R.id.text_status_item);
            textPrice = itemView.findViewById(R.id.text_price_item);
            textPrice.setPaintFlags(textPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            textSalePrice = itemView.findViewById(R.id.text_sale_price_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Book book = books.get(pos);
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("url", book.url);
                    context.startActivity(intent);
                }
            });
        }
    }
}
