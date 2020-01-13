package com.example.adam.reading;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BookFragment extends Fragment {

    private Book[] books = {
            new Book("魔法亲亲", "", 2.99, R.drawable.timg),
            new Book("哈哈哈哈", "", 2.99, R.drawable.timg),
            new Book("暗色东方鲀", "", 2.99, R.drawable.timg),
    };
    private List<Book> bookList = new ArrayList<>();
    private BookAdapter adapter;
    public BookFragment() {
        // Required empty public constructor
    }

    public static BookFragment newInstance(String param1) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putString("args1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        Bundle bundle = getArguments();
        String args1 = bundle.getString("args1");
        init_books();
        RecyclerView recyclerView = view.findViewById(R.id.recyler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void init_books() {
        bookList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            bookList.add(books[random.nextInt(books.length)]);
        }
    }


}
