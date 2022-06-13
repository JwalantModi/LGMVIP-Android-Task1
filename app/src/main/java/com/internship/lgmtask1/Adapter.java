package com.internship.lgmtask1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.lgmtask1.model.City;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CityHolder> {

    public ArrayList<City> list = new ArrayList<>();

    public Adapter(ArrayList<City> list) {
        this.list = list;
    }

    public void dataChange(ArrayList<City> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_layout, parent, false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder holder, int position) {
        holder.txtState.setText(list.get(position).getName());
        holder.txtCurrCases.setText("Active Cases: "+list.get(position).getCurrCases());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CityHolder extends RecyclerView.ViewHolder {

        TextView txtState;
        TextView txtCurrCases;

        public CityHolder(@NonNull View itemView) {
            super(itemView);

            txtState = itemView.findViewById(R.id.txtStatesName);
            txtCurrCases = itemView.findViewById(R.id.txtCurrentCases);
        }
    }
}
