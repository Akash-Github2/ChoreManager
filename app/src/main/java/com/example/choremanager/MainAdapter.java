package com.example.choremanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;
    private int indexOfColoredItem = 0;


    public MainAdapter(Context context, ArrayList<MainModel> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.dateTextView.setText(mainModels.get(position).getDate());
        holder.DOTWTextView.setText(mainModels.get(position).getDOTW());
        holder.bindItem(position);
        holder.fullDateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexOfColoredItem = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initalize Variables
        TextView DOTWTextView;
        LinearLayout fullDateItem;
        TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign Variable
            DOTWTextView = itemView.findViewById(R.id.DOTWTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            fullDateItem = itemView.findViewById(R.id.dateView);
        }
        void bindItem(int pos) {
            MainModel txt = mainModels.get(pos);
            if(indexOfColoredItem==pos){
                fullDateItem.setBackground(ContextCompat.getDrawable(context, R.drawable.layout_selected_bg));
            } else{
                fullDateItem.setBackground(ContextCompat.getDrawable(context, R.drawable.layout_unselected_bg));
            }
        }
    }
}
