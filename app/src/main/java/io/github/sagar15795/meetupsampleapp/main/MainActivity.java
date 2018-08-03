package io.github.sagar15795.meetupsampleapp.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.sagar15795.meetupsampleapp.R;
import io.github.sagar15795.meetupsampleapp.data.model.Book;
import io.github.sagar15795.meetupsampleapp.data.remote.BookAPIManager;
import io.github.sagar15795.meetupsampleapp.utils.RecyclerItemClickListner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListner.OnItemClickListener {
    private RecyclerView recyclerView;
    private List<Book> bookList;
    private TextView tvMessage;
    private FloatingActionButton fabAdd;
    private BookAdapter bookAdapter;
    private BookAPIManager bookAPIManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();
        setup();
    }


    @Override
    protected void onResume() {
        super.onResume();
        bookAPIManager = new BookAPIManager();
        bookAPIManager.getBookApi().getBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.body() == null || response.body().size()==0) {
                    Toast.makeText(MainActivity.this, "No Book Found", Toast.LENGTH_SHORT).show();
                } else {
                    bookList.clear();
                    bookList.addAll(response.body());
                    bookAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!bookAPIManager.getBookApi().getBook().isExecuted()) {
            bookAPIManager.getBookApi().getBook().cancel();
        }
    }

    private void viewSetup() {
        recyclerView =  findViewById(R.id.recycler_view);
        tvMessage = findViewById(R.id.tvError);
        fabAdd = findViewById(R.id.fab);
    }

    private void setup() {
        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(bookList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bookAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListner(this,this));
    }


    @Override
    public void onItemClick(View childView, int position) {

    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }
}
