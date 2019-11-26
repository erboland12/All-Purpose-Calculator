package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FavoritesActivity extends AppCompatActivity {

    private ArrayList<Operations> ops;
    private ArrayList<String> addToList;
    public static String favs = "";
    private OperationsAdapter adapter;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private TextView noFavs;

    private SharedPreferences shared;
    private SharedPreferences.Editor edit;
    private Map<String, ?> keys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Favorites");
        setContentView(R.layout.activity_favorites);

        noFavs = findViewById(R.id.fav_no_items);

        //Sets up RV
        ops = new ArrayList<>();
        addToList = new ArrayList<>();
        setUpArrayLists();
//        clearFavs();
        //Calls populate ops if size is greater than 0
        if(!keys.isEmpty()){
            noFavs.setVisibility(View.INVISIBLE);
            populateOperations();
        }


        rv = findViewById(R.id.rvOperations);
        adapter = new OperationsAdapter(ops);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        //Determines empty message depending on size of RV adapter
//        if(adapter.getItemCount() == 0){
//            noFavs.setVisibility(View.VISIBLE);
//        }
//        else if(adapter.getItemCount() > 0){
//            noFavs.setVisibility(View.INVISIBLE);
//        }

        OperationsActivity.isGeo = true;


    }

    //Inserts all items in array list into RV
    private void populateOperations(){
        for(int i = 0; i < addToList.size(); i++){
//            ops.add(new Operations(addToList.get(i)));
        }
    }

    private void initializeSharedPreferences(){
        for(Map.Entry<String, ?> entry: keys.entrySet()){
            addToList.add(entry.getValue().toString());
        }

        ops.add(new Operations(shared.getString("KeySquare (a2)", "Square (a2)")));

    }

    private void setUpArrayLists(){
        shared = getSharedPreferences("favorites", MODE_PRIVATE);
        edit = shared.edit();
        keys = shared.getAll();

        if(favs == null) {
            return;
        }else{
            edit.putString("Key".concat(favs), favs);
            edit.apply();
            edit.commit();
        }

        initializeSharedPreferences();
    }

    private void clearFavs(){
        edit.clear();
        edit.apply();
    }
}
