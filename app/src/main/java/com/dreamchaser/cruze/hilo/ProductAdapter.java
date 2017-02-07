package com.dreamchaser.cruze.hilo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Model.Product;

/**
 * Created by Cruze on 1/27/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CouponViewHolder>{
    List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public CouponViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coupon_cardview, viewGroup, false);
        CouponViewHolder couponViewHolder = new CouponViewHolder(v);
        return couponViewHolder;
    }

    @Override
    public void onBindViewHolder(CouponViewHolder couponViewHolder, int i) {
        couponViewHolder.tView.setText(products.get(i).title);
        couponViewHolder.pView.setText(products.get(i).price);
        couponViewHolder.iView.setImageResource(products.get(i).image);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class CouponViewHolder extends RecyclerView.ViewHolder {
        CardView cView;
        ImageView iView;
        TextView tView;
        TextView pView;

        CouponViewHolder(View itemView) {
            super(itemView);

            cView = (CardView)itemView.findViewById(R.id.cardView);
            iView = (ImageView)itemView.findViewById(R.id.cardImage);
            tView = (TextView)itemView.findViewById(R.id.cardText);
            pView = (TextView)itemView.findViewById(R.id.cardPrice);
        }
    }
}
