package com.example.calculator.RecyclerViewActivities;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.calculator.MovePage;
import com.example.calculator.Operations;
import com.example.calculator.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.calculator.RecyclerViewActivities.OperationsActivity.OMEGA;
import static com.example.calculator.RecyclerViewActivities.OperationsActivity.superscript;
import static com.example.calculator.RecyclerViewActivities.PhysicsActivity.ALPHA;
import static com.example.calculator.RecyclerViewActivities.PhysicsActivity.RHO;

public class OperationsAdapter extends
    RecyclerView.Adapter<OperationsAdapter.ViewHolder>{

    public static final String PI = "\u03c0";
    public static final String SQRT = "\u221a";

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;

        public ViewHolder(View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.recycler_title);
        }
    }

    private List<Operations> mOperations;
    public List<Operations>  mOperationsCopy = new ArrayList<>();

    public OperationsAdapter(ArrayList<Operations> operations){
        mOperations = operations;
        mOperationsCopy.addAll(mOperations);
    }

    @Override
    public OperationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final OperationsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Operations ops = mOperations.get(position);

        // Set item views based on your views and data model
        final TextView textView = viewHolder.titleTextView;
        if(ops.getTitle() == "Centripetal Acceleration (v2/r)" ||  ops.getTitle() == "Centripetal Acceleration (" + OMEGA + "2/r)"){
            textView.setText(superscript(ops.getTitle()));
        }
        else if(ops.getTitle() == "Kinetic Energy (KE = 1/2 * mv2)"){
            textView.setText("Kinetic Energy (KE = 1/2 * " + superscript("mv2)"));
        }
        else if (ops.getTitle() == "Kinetic Energy (KE = p2/2m)"){
            textView.setText("Kinetic Energy (KE = " + superscript("p2") + "/2m)");
        }
        else if (ops.getTitle() == "Square (a2)"){
            textView.setText(superscript("Square (a2)"));
        }
        else if (ops.getTitle() == "Circle (" + PI + "r2)"){
            textView.setText("Circle (" + PI + superscript("r2)"));
        }
        else if (ops.getTitle() == "Cube (6a2)"){
            textView.setText("Cube (6" + superscript("a2)"));
        }
        else if (ops.getTitle() == "Sphere (4" + PI + "r2)"){
            textView.setText("Sphere (4" + PI + superscript("r2)"));
        }
        else if (ops.getTitle() == "Cylinder (2" + PI + "r2 + 2" + PI + "rh)"){
            textView.setText("Cylinder(2" + PI + superscript("r2") + " + 2" + PI + "rh)" );
        }
        else if (ops.getTitle() == "Cone (" + PI + "r2 + " + PI + "r(" + SQRT + "(h2 + r2)))"){
            textView.setText("Cone (" + PI + superscript("r2" + " + " + PI + "r(" + SQRT + superscript("(h2 + r2)))")));
        }
        else if (ops.getTitle() == "Pyramid (s2 + 2sl)"){
            textView.setText("Pyramid (" + superscript("s2") + " + 2sl)");
        }
        else if (ops.getTitle() == "Cube (a3)"){
            textView.setText(superscript("Cube (a3)"));
        }
        else if (ops.getTitle() == "Cylinder (" + PI + "r2h)"){
            textView.setText("Cylinder (" + PI + superscript("r2h)"));
        }
        else if (ops.getTitle() == "Cone ((1/3)" + PI + "r2h)"){
            textView.setText("Cone ((1/3)" + PI + superscript("r2h)"));
        }
        else if (ops.getTitle() == "Sphere ((4/3)" + PI + "r3)"){
            textView.setText("Sphere ((4/3)" + PI + superscript("r3)"));
        }
        else if (ops.getTitle() == "Centripetal Force (F = mv2/r)"){
            textView.setText(superscript("Centripetal Force (F = mv2/r)"));
        }
        else if (ops.getTitle() == "Rotational K.E (KE = 1/2 * I" + OMEGA + "2)"){
            textView.setText("Rotational K.E (KE = 1/2 * I" + OMEGA + superscript("2)"));
        }

        else if (ops.getTitle() == "Centripetal Acceleration (" + ALPHA + " = v2/r)"){
            textView.setText("Centripetal Acceleration (" + ALPHA + superscript(" = v2/r)"));
        }
        else if (ops.getTitle() == "Centripetal Acceleration (" + ALPHA + " = " + OMEGA + "2/r)"){
            textView.setText("Centripetal Acceleration (" + ALPHA + " = " + OMEGA + superscript("2/r)"));
        }
        else if (ops.getTitle() == "Dynamic Pressure (q = 1/2" + RHO + "v2"){
            textView.setText("Dynamic Pressure (q = 1/2" + RHO + superscript("v2"));
        }
        else if (ops.getTitle() == "Bernoulli's Equation (Constant = P + 1/2" + RHO + "v2 + " + RHO + "pgh)"){
            textView.setText("Bernoulli's Equation (Constant = P + 1/2" + RHO + superscript("v2") + RHO + "pgh)");
        }
        else if (ops.getTitle() == "Solid Sphere (I = 2/5 * MR2)"){
            textView.setText("Solid Sphere (I = 2/5 * " + superscript("MR2)"));
        }
        else if (ops.getTitle() == "Hollow Sphere (I = 2/3 * MR2)"){
            textView.setText("Hollow Sphere (I = 2/3 * " + superscript("MR2)"));
        }
        else if (ops.getTitle() == "Solid Cylinder (I = 1/2 * MR2)"){
            textView.setText("Solid Cylinder (I = 1/2 * " + superscript("MR2)"));
        }
        else if (ops.getTitle() == "Hollow Cylinder (I = 1/2 *  M(Ra2 + Rb2))"){
            textView.setText("Hollow Cylinder (I = 1/2 *  " + superscript("M(Ra2 + Rb2))"));
        }
        else if (ops.getTitle() == "Rect. Plate, Center Axis (I = 1/12 * M(a2 + b2))"){
            textView.setText("Rect. Plate, Center Axis (I = 1/12 * " + superscript("M(a2 + b2))"));
        }
        else if (ops.getTitle() == "Rect. Plate, Center Axis (I = 1/12 * M(a2 + b2))"){
            textView.setText("Rect. Plate, Center Axis (I = 1/12 * " + superscript("M(a2 + b2))"));
        }
        else if (ops.getTitle() == "Rect. Plate, Edge Axis (I = 1/3 * Ma2)"){
            textView.setText("Rect. Plate, Edge Axis (I = 1/3 * " + superscript("Ma2)"));
        }
        else if (ops.getTitle() == "Slender Rod, Center Axis (I = 1/12 * ML2)"){
            textView.setText("Slender Rod, Center Axis (I = 1/12 * " + superscript("ML2)"));
        }
        else if (ops.getTitle() == "Slender Rod, Edge Axis (I = 1/3 * ML2)"){
            textView.setText("Slender Rod, Edge Axis (I = 1/3 * " + superscript("ML2)"));
        }
        else if (ops.getTitle() == "Velocity (v = 2" + PI + "f * " + SQRT + "(A2 - x2))"){
            textView.setText("Velocity (v = 2" + PI + "f * " + SQRT + superscript("(A2 - x2))"));
        }
        else if (ops.getTitle() == "Acceleration (a = (-2" + PI + "f)2 * x)"){
            textView.setText("Acceleration (a = (-2" + PI + superscript("f)2 * x)"));
        }
        else if (ops.getTitle() == "Pressure of Ideal Gas (p = 1/3 * " + RHO + "v2"){
            textView.setText("Pressure of Ideal Gas (p = 1/3 * " + RHO + superscript("v2"));
        }
        else if (ops.getTitle() == "Coulomb's Law (Fe = Ke * (Q1Q2 / r2))"){
            textView.setText("Coulomb's Law (Fe = Ke * (Q1Q2 / " + superscript("r2))"));
        }
        else{
            textView.setText(ops.getTitle());
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovePage m = new MovePage();
                OperationsActivity.opTitle = ops.getTitle();
                m.moveActivity(viewHolder.itemView.getContext(), OperationsActivity.class);
            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mOperations.size();
    }




}
