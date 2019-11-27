package com.example.calculator.RecyclerViewActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.calculator.Operations;
import com.example.calculator.R;
import com.example.calculator.RecyclerViewActivities.OperationsAdapter;

import java.util.ArrayList;

public class TrigActivity extends AppCompatActivity {

    private RecyclerView rv;
    private OperationsAdapter adapter;
    private ArrayList<Operations> trigList;
    private RecyclerView.LayoutManager layoutManager;

    private SharedPreferences shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(returnDark()){
            TrigActivity.this.setTheme(R.style.darkTheme);
        }
        super.onCreate(savedInstanceState);
        setTitle(R.string.Trig);
        setContentView(R.layout.activity_trig);

        trigList = new ArrayList<>();
        populateList();

        rv = findViewById(R.id.rvOperations);
        adapter = new OperationsAdapter(trigList);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

    }

    private void populateList(){
        trigList.add(new Operations("Cosine"));
        trigList.add(new Operations("Sine"));
        trigList.add(new Operations("Tangent"));
        trigList.add(new Operations("Arccos"));
        trigList.add(new Operations("Arcsin"));
        trigList.add(new Operations("Arctan"));
    }

    private boolean returnDark(){
        shared = getSharedPreferences("DarkMode", MODE_PRIVATE);
        Log.d("Is Dark?", Boolean.toString(shared.getBoolean("darkMode", false)));
        return shared.getBoolean("darkMode", false);
    }
}
