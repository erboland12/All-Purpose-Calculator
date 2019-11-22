package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class TrigActivity extends AppCompatActivity {

    private RecyclerView rv;
    private OperationsAdapter adapter;
    private ArrayList<Operations> trigList;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
