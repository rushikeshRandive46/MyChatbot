package com.example.mychatbot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyHolder> {

    ArrayList<Model> models;

    public RvAdapter(ArrayList<Model> models)
    {
        this.models=models;
    }
    boolean flg=true;
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_question,null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv.setText(models.get(position).getCnt());
    }

    @Override
    public int getItemCount() {

        return models.size();
    }

    public  class MyHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
          tv=itemView.findViewById(R.id.userQustion);



        }
    }


    public  void add(Model model)
    {
        models.add(model);
    }
}
