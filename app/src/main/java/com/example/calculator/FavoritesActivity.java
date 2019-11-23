package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private ArrayList<Operations> ops;
    private ArrayList<String> addToList;
    public static ArrayList<String> favs = new ArrayList<>();
    private OperationsAdapter adapter;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private TextView noFavs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Favorites");
        setContentView(R.layout.activity_favorites);

        ops = new ArrayList<>();
        addToList = new ArrayList<>();
        if(favs == null){
            return;
        } else{
            addToList.addAll(favs);
        }

        noFavs = findViewById(R.id.fav_no_items);

        rv = findViewById(R.id.rvOperations);
        adapter = new OperationsAdapter(ops);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        if(adapter.getItemCount() == 0){
            noFavs.setVisibility(View.VISIBLE);
        }else{
            noFavs.setVisibility(View.INVISIBLE);
        }
        if(addToList.size() > 0){
            populateOperations();
        }
    }

    private void populateOperations(){
        for(int i = 0; i < addToList.size(); i++){
            ops.add(new Operations(addToList.get(i)));
        }
    }
}
