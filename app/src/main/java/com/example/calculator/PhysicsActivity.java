package com.example.calculator;

import android.graphics.Path;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class PhysicsActivity extends AppCompatActivity {
    private ArrayList<Operations> ops;
    private ArrayList<Operations> ops2;
    private ArrayList<Operations> ops3;
    private OperationsAdapter adapter;
    private OperationsAdapter adapter2;
    private OperationsAdapter adapter3;
    private RecyclerView rv;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";
    public static final String ALPHA = "\u03b1";
    public static final String THETA = "\u03b8";
    public static final String TAU = "\u03c4";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        //Initialize lists used for RVs
        ops = new ArrayList<>();
        populateOperations();
        ops2 = new ArrayList<>();
        populateOperations2();
        ops3 = new ArrayList<>();
        populateOperations3();

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
    }

    private void populateOperations(){
        ops.add(new Operations("Force (F = ma)"));
        ops.add(new Operations("Weight (W = mg)"));
        ops.add(new Operations("Acceleration (" + DELTA + "v/" + DELTA + "t)"));
        ops.add(new Operations("Momentum (p = mv)"));
        ops.add(new Operations("Impulse (" + DELTA + "p = F" + DELTA + "t)"));
        ops.add(new Operations("Kinetic Energy (1/2 * mv2)"));
        ops.add(new Operations("Kinetic Energy (p2/2m)"));
        ops.add(new Operations("Gravitational P.E (" + DELTA + "Ug = mg" + DELTA +"h)"));
        ops.add(new Operations("Power (" + DELTA + "W/" + DELTA + "t)"));
        ops.add(new Operations("Hooke's Law (F = -k" + DELTA + "x)"));

    }

    private void populateOperations2(){
        ops2.add(new Operations("Angular Velocity (" + DELTA + THETA + "/" + DELTA + "t)"));
        ops2.add(new Operations("Angular Acceleration (" + DELTA + OMEGA + "/" + DELTA + "t)"));
        ops2.add(new Operations("Angular Momentum (I" + OMEGA + ")"));
        ops2.add(new Operations("Displacement (r" +  THETA + ")"));
        ops2.add(new Operations("Velocity (r" + OMEGA + ")"));
        ops2.add(new Operations("Acceleration (r" + ALPHA + ")"));
        ops2.add(new Operations("Centripetal Acceleration (v2/r)"));
        ops2.add(new Operations("Centripetal Acceleration (" + OMEGA + "2/r)"));
        ops2.add(new Operations("Centripetal Force (mv2/r)"));
    }

    private void populateOperations3(){
        ops3.add(new Operations("Angular Velocity (" + OMEGA + "0 + " + ALPHA + "t)"));
        ops3.add(new Operations("Average Angular Velocity (1/2(" + OMEGA + OMEGA + "0)"));
        ops3.add(new Operations("Rotational Work (" + TAU + DELTA + THETA + ")"));
        ops3.add(new Operations("Rotational Power (" + TAU + OMEGA + ")"));
        ops3.add(new Operations("Rotational Power (" + TAU + OMEGA + "cos(" + THETA + "))"));
        ops3.add(new Operations("Rotational K.E (K = 1/2 * I" + OMEGA + "2)"));
    }


}
