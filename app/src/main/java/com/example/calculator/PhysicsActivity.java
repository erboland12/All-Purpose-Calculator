package com.example.calculator;

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
    private RecyclerView rv;
    private OperationsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";
    public static final String ALPHA = "\u03b1";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        ops = new ArrayList<>();
        populateOperations();

        rv = findViewById(R.id.rvOperations);
        adapter = new OperationsAdapter(ops);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }

    private void populateOperations(){
        ops.add(new Operations("Force (F = ma)"));
        ops.add(new Operations("Weight (W = mg)"));
        ops.add(new Operations("Acceleration (" + DELTA + "v/" + DELTA + "t)"));
        ops.add(new Operations("Momentum (p = mv)"));
        ops.add(new Operations("Centripetal Acceleration (v2/r)"));
        ops.add(new Operations("Centripetal Acceleration (" + OMEGA + "2/r)"));
        ops.add(new Operations("Impulse (" + DELTA + "p = F" + DELTA + "t)"));
        ops.add(new Operations("Kinetic Energy (1/2 * mv2)"));
        ops.add(new Operations("Kinetic Energy (p2/2m)"));
        ops.add(new Operations("Gravitation P.E (" + DELTA + "Ug = mg" + DELTA +"h)"));
        ops.add(new Operations("Power (" + DELTA + "W/" + DELTA + "t)"));
        ops.add(new Operations("Hooke's Law (F = -k" + DELTA + "x)"));

    }

    public static String superscript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }


}
