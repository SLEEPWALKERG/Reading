package com.example.adam.reading;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParsePosition;
import java.util.List;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private Context context;
    private List<Book> bookList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView_name;
        TextView textView_price;
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView)view;
            imageView = view.findViewById(R.id.book_image);
            textView_name = view.findViewById(R.id.book_name);
            textView_price = view.findViewById(R.id.book_price);
        }
    }

    public BookAdapter(List<Book> books) {
        bookList = books;
    }
    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.textView_name.setText(book.getName());
        holder.textView_price.setText(book.getPrice());
        Glide.with(context).load(book.getId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
