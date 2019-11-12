package com.example.calculator;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.calculator.OperationsActivity.OMEGA;
import static com.example.calculator.OperationsActivity.superscript;

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
        else if(ops.getTitle() == "Kinetic Energy (1/2 * mv2)"){
            textView.setText("Kinetic Energy (1/2 * " + superscript("mv2)"));
        }
        else if (ops.getTitle() == "Kinetic Energy (p2/2m)"){
            textView.setText("Kinetic Energy (" + superscript("p2") + "/2m)");
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
