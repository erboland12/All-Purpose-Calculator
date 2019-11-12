package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GeoActivity extends AppCompatActivity {

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

    public static final String PI = "\u03c0";
    public static final String SQRT = "\u221a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);
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
        ops.add(new Operations("Square (a2)"));
        ops.add(new Operations("Triangle ((1/2)bh)"));
        ops.add(new Operations("Rectangle (bh)"));
        ops.add(new Operations("Trapezoid (h/2 * (b1 + b2))"));
        ops.add(new Operations("Circle (" + PI + "r2)"));
        ops.add(new Operations("Ellipse (" + PI + "r1r2)"));
    }

    private void populateOperations2(){
        ops2.add(new Operations("Cube (6a2)"));
        ops2.add(new Operations("Rectangular Prism (2lw + 2lh + 2wh)"));
        ops2.add(new Operations("Sphere (4" + PI + "r2)"));
        ops2.add(new Operations("Cylinder (2" + PI + "r2 + 2" + PI + "rh)"));
        ops2.add(new Operations("Cone (" + PI + "r2 + " + PI + "r(" + SQRT + "(h2 + r2)))"));
        ops2.add(new Operations("Pyramid (s2 + 2sl)"));
    }

    private void populateOperations3(){
        ops3.add(new Operations("Cube (a3)"));
        ops3.add(new Operations("Rectangular Prism (lwh)"));
        ops3.add(new Operations("Cylinder (" + PI + "r2h)"));
        ops3.add(new Operations("Pyramid ((1/3)bh)"));
        ops3.add(new Operations("Cone ((1/3)" + PI + "r2h)"));
        ops3.add(new Operations("Sphere ((4/3)" + PI + "r3)"));
        ops3.add(new Operations("Ellipsoid ((4/3)" + PI + "r1r2r3)"));
    }
}
