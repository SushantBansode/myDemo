package com.example.recyclerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<DateDay> DateDaysList;
    int sel = -1;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView day, date;
        LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            day = (TextView) view.findViewById(R.id.day);
            linearLayout = (LinearLayout) view.findViewById(R.id.root);

        }
    }


    public CustomAdapter(Context context, List<DateDay> DateDaysList) {
        this.DateDaysList = DateDaysList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowlayout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.day.setText(DateDaysList.get(position).getDay());
        holder.date.setText(DateDaysList.get(position).getDate());
        if (sel != -1) {
            if (sel == position) {
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            } else {
                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.white));
            }

        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel = position;
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return DateDaysList.size();
    }
}