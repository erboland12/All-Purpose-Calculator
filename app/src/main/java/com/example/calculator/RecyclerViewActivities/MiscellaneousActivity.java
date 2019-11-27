package com.example.calculator.RecyclerViewActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;

import com.example.calculator.Operations;
import com.example.calculator.R;

import java.util.ArrayList;

public class MiscellaneousActivity extends AppCompatActivity {
    private RatingBar r;
    private ArrayList<Operations> ops;
    private OperationsAdapter adapter;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;

    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(returnDark()){
            MiscellaneousActivity.this.setTheme(R.style.darkTheme);
        }
        super.onCreate(savedInstanceState);
        setTitle(R.string.Misc);
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
        ops.add(new Operations("Fahrenheit to Celsius"));
        ops.add(new Operations("Celsius to Fahrenheit"));
        ops.add(new Operations("Celsius to Kelvin"));
    }

    private boolean returnDark(){
        shared = getSharedPreferences("DarkMode", MODE_PRIVATE);
        Log.d("Is Dark?", Boolean.toString(shared.getBoolean("darkMode", false)));
        return shared.getBoolean("darkMode", false);
    }
}
