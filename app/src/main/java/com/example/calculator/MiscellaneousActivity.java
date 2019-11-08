package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Path;
import android.os.Bundle;

import java.util.ArrayList;

public class MiscellaneousActivity extends AppCompatActivity {

    private ArrayList<Operations> ops;
    private OperationsAdapter adapter;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous);
        ops = new ArrayList<>();
        populateOperations();

        rv = findViewById(R.id.rvOperations);
        adapter = new OperationsAdapter(ops);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }

    private void populateOperations(){
        ops.add(new Operations("Fibonacci"));
        ops.add(new Operations("Factorial"));
        ops.add(new Operations("Modulo"));
        ops.add(new Operations("Trigonometry"));
    }
}
