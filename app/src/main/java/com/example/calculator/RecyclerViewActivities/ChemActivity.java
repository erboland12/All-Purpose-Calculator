package com.example.calculator.RecyclerViewActivities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.calculator.Operations;
import com.example.calculator.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChemActivity extends AppCompatActivity {
    public static ArrayList<Operations> ops;
    public static ArrayList<Operations> ops2;
    public static ArrayList<Operations> ops3;
    public static ArrayList<Operations> ops4;
    public static ArrayList<Operations> ops5;
    private OperationsAdapter adapter;
    private OperationsAdapter adapter2;
    private OperationsAdapter adapter3;
    private OperationsAdapter adapter4;
    private OperationsAdapter adapter5;
    private RecyclerView rv;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private RecyclerView rv4;
    private RecyclerView rv5;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;
    private RecyclerView.LayoutManager layoutManager4;
    private RecyclerView.LayoutManager layoutManager5;

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";
    public static final String ALPHA = "\u03b1";
    public static final String THETA = "\u03b8";
    public static final String TAU = "\u03c4";
    public static final String RHO = "\u03c1";
    public static final String PI = "\u03c0";
    public static final String LAMBDA = "\u039b";

    private SharedPreferences shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(returnDark()){
            ChemActivity.this.setTheme(R.style.darkTheme);
        }
        super.onCreate(savedInstanceState);
        setTitle(R.string.Chemistry);
        setTitleColor(R.color.colorBlack);
        setContentView(R.layout.activity_chem);

        //Initialize lists used for RVs
        ops = new ArrayList<>();
        populateOperations();
        ops2 = new ArrayList<>();
        //populateOperations2();
        ops3 = new ArrayList<>();
        populateOperations3();
        ops4 = new ArrayList<>();
        populateOperations4();
        ops5 = new ArrayList<>();
        populateOperations5();

        //Populate RVs
        rv = findViewById(R.id.rvOperations);
        adapter = new OperationsAdapter(ops);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        rv2 = findViewById(R.id.rvOperations2);
        adapter2 = new OperationsAdapter(ops2);
        layoutManager2 = new LinearLayoutManager(this);
        rv2.setLayoutManager(layoutManager2);
        rv2.setAdapter(adapter2);

        rv3 = findViewById(R.id.rvOperations3);
        adapter3 = new OperationsAdapter(ops3);
        layoutManager3 = new LinearLayoutManager(this);
        rv3.setLayoutManager(layoutManager3);
        rv3.setAdapter(adapter3);

        rv4 = findViewById(R.id.rvOperations4);
        adapter4 = new OperationsAdapter(ops4);
        layoutManager4 = new LinearLayoutManager(this);
        rv4.setLayoutManager(layoutManager4);
        rv4.setAdapter(adapter4);

        rv5 = findViewById(R.id.rvOperations5);
        adapter5 = new OperationsAdapter(ops5);
        layoutManager5 = new LinearLayoutManager(this);
        rv5.setLayoutManager(layoutManager5);
        rv5.setAdapter(adapter5);


    }


    private void populateOperations() {
        ops.add(new Operations("Density (p = m/v)"));
        ops.add(new Operations("Number of Moles (n = Gm/Mm)"));
        ops.add(new Operations("Molarity (M = n/L)"));
        ops.add(new Operations("Molality (M = n/m)"));
        ops.add(new Operations("Percent Error (PE = ((M - A) / A) * 100%)"));
        ops.add(new Operations("Percent Composition (PC = (Mp / Mw) * 100%)"));
        ops.add(new Operations("Rate of Reaction (Rate = Dq / Dt)"));

    }

    private void populateOperations3() {
        ops3.add(new Operations("pH (-log(H+))"));
        ops3.add(new Operations("pOH (-log(OH-))"));
    }

    private void populateOperations4() {
        ops4.add(new Operations("Boiling Point Elevation (" + DELTA + "Ts = Kb * Ms)"));
        ops4.add(new Operations("Freezing Point Depression (" + DELTA + "Ts = Kf * Ms)"));
        ops4.add(new Operations("Ideal Gas Law (P = nRT/V)"));
        ops4.add(new Operations("Ideal Gas Law (V = nRT/P)"));
        ops4.add(new Operations("Heat Released from Burning (Eh = cMw" + DELTA + "T)"));
    }

    private void populateOperations5() {
        ops5.add(new Operations("Heat Transfer (q = mc" + DELTA + "T)"));
        ops5.add(new Operations("Enthalpy (" + DELTA + "H = Hp - Hr)"));
        ops5.add(new Operations("Entropy (" + DELTA + "S = Sp - Sr)"));
        ops5.add(new Operations("Free Energy (" + DELTA + "G = " + DELTA + "H - T" + DELTA + "S)"));
    }

    private boolean returnDark(){
        shared = getSharedPreferences("DarkMode", MODE_PRIVATE);
        Log.d("Is Dark?", Boolean.toString(shared.getBoolean("darkMode", false)));
        return shared.getBoolean("darkMode", false);
    }
}