package com.aytugburak.peopleperson.classes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.aytugburak.peopleperson.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemHolder> {

    Context context;

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler, parent, false);
        return new ItemHolder(view);
    }

    public RVAdapter(Context context) {
        this.context = context;
    }

    public void modifyData(){
        notifyDataSetChanged();
        notifyItemRangeChanged(0, ClassList.data.size());
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        final Contact temp = ClassList.data.get(position);
        String tempFave = "";
        if (temp.isFavorited()) {
            tempFave = "Yes";
        }
        else {
            tempFave = "No";
        }
        holder.tvRLName.setText("Name : " + temp.getName());
        holder.tvRLSurname.setText("Surname : " + temp.getSurname());
        holder.tvRLDob.setText("Date of Birth : " + temp.getBirthDate());
        holder.tvRLCategory.setText("Category : " + temp.getCategory());
        holder.tvRLFave.setText("Favorite : " + tempFave);
    }

    @Override
    public int getItemCount() {
        return ClassList.data.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        ConstraintLayout layout;
        TextView tvRLName, tvRLSurname, tvRLDob, tvRLCategory, tvRLFave;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvRLName = itemView.findViewById(R.id.tvRLName);
            tvRLSurname = itemView.findViewById(R.id.tvRLSurname);
            tvRLDob = itemView.findViewById(R.id.tvRLDob);
            tvRLCategory = itemView.findViewById(R.id.tvRLCategory);
            tvRLFave = itemView.findViewById(R.id.tvRLFave);
        }
    }
}

