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
    public static ArrayList<Operations> ops;
    public static ArrayList<Operations> ops2;
    public static ArrayList<Operations> ops3;
    public static ArrayList<Operations> ops4;
    public static ArrayList<Operations> ops5;
    public static ArrayList<Operations> ops6;
    private OperationsAdapter adapter;
    private OperationsAdapter adapter2;
    private OperationsAdapter adapter3;
    private OperationsAdapter adapter4;
    private OperationsAdapter adapter5;
    private OperationsAdapter adapter6;
    private RecyclerView rv;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private RecyclerView rv4;
    private RecyclerView rv5;
    private RecyclerView rv6;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;
    private RecyclerView.LayoutManager layoutManager4;
    private RecyclerView.LayoutManager layoutManager5;
    private RecyclerView.LayoutManager layoutManager6;

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";
    public static final String ALPHA = "\u03b1";
    public static final String THETA = "\u03b8";
    public static final String TAU = "\u03c4";
    public static final String RHO = "\u03c1";
    public static final String PI = "\u03c0";




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
        ops4 = new ArrayList<>();
        populateOperations4();
        ops5 = new ArrayList<>();
        populateOperations5();
        ops6 = new ArrayList<>();
        populateOperations6();

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

        rv6 = findViewById(R.id.rvOperations6);
        adapter6 = new OperationsAdapter(ops6);
        layoutManager6 = new LinearLayoutManager(this);
        rv6.setLayoutManager(layoutManager6);
        rv6.setAdapter(adapter6);

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
        ops3.add(new Operations("Average Angular Velocity (1/2(" + OMEGA + "+" + OMEGA + "0))"));
        ops3.add(new Operations("Rotational Work (" + TAU + DELTA + THETA + ")"));
        ops3.add(new Operations("Rotational Power (" + TAU + OMEGA + ")"));
        ops3.add(new Operations("Rotational Power (" + TAU + OMEGA + "cos(" + THETA + "))"));
        ops3.add(new Operations("Rotational K.E (K = 1/2 * I" + OMEGA + "2)"));
    }

    private void populateOperations4(){
        ops4.add(new Operations("Density (p = m/v)"));
        ops4.add(new Operations("Pressure (P = F/A)"));
        ops4.add(new Operations("Change of Pressure (" + DELTA + "P = pgh)"));
        ops4.add(new Operations("Dynamic Pressure (q = 1/2" + RHO + "v2)"));

    }

    private void populateOperations5(){
        ops5.add(new Operations("Solid Sphere (I = 2/5 * MR2)"));
        ops5.add(new Operations("Hollow Sphere (I = 2/3 * MR2)"));
        ops5.add(new Operations("Solid Cylinder (I = 1/2 * MR2)"));
        ops5.add(new Operations("Hollow Cylinder (I = 1/2 *  M(Ra2 + Rb2))"));
        ops5.add(new Operations("Rect. Plate, Center Axis (I = 1/12 * M(a2 + b2))"));
        ops5.add(new Operations("Rect. Plate, Edge Axis (I = 1/3 * Ma2)"));
        ops5.add(new Operations("Slender Rod, Center Axis (I = 1/12 * ML2)"));
        ops5.add(new Operations("Slender Rod, Edge Axis (I = 1/3 * ML2)"));
    }

    private void populateOperations6(){
        ops6.add(new Operations("Position (x = A*cos(" + OMEGA + ")t)"));
        ops6.add(new Operations("Velocity (v = -A" + OMEGA + "*sin(" + OMEGA + ")t)"));
        ops6.add(new Operations("Acceleration (a = -A" + OMEGA + "2 * cos(" + OMEGA + ")t)"));
        ops6.add(new Operations("Force (F = -kx)"));
        ops6.add(new Operations("Period (2" + PI + "/" + OMEGA + ")"));
    }




}
