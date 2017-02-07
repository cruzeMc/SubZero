package com.dreamchaser.cruze.hilo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cruze on 1/27/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public ArrayList<String> coupon;

    public RecyclerViewAdapter(ArrayList<String> coupon) {
        this.coupon = coupon;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_cardview, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.couponNameView.setText(coupon.get(position));
        holder.couponPriceView.setText(coupon.get(position));
    }

    @Override
    public int getItemCount() {
        return coupon.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView couponNameView;
        private  TextView couponPriceView;

        public MyViewHolder(View itemView) {
            super(itemView);
            couponNameView = (TextView)itemView.findViewById(R.id.cardText);
            couponPriceView = (TextView)itemView.findViewById(R.id.cardPrice);
        }
    }
}
