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

public class OperationsAdapter extends
    RecyclerView.Adapter<OperationsAdapter.ViewHolder>{

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
        textView.setText(ops.getTitle());

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
