package com.dreamchaser.cruze.hilo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Helpers.RecyclerItemClickListener;
import Helpers.ShoppingCartData;
import Model.Product;

public class ProductCatalogue extends AppCompatActivity {
    private ProductAdapter adapter; //Create adapter for coupon
    private List<Product> myProducts = new ArrayList<>(); //Store coupon data that will be passed to adapter
    RecyclerView myView;
    private SearchView mySearch;
    private final int[] PRODUCT_IMAGE_LIST = ProductList.prodImageList;
    private final String[] PRODUCT_NAME_LIST = ProductList.productNameList;
    private final String[] PRODUCT_PRICE_LIST = ProductList.productPriceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalogue);

        Log.d("ONCLICKSAVE", ShoppingCartData.getCartList().toString());

        //Populate the ArrayList
        for(int i = 0; i < PRODUCT_IMAGE_LIST.length; i++){
            myProducts.add(new Product(PRODUCT_NAME_LIST[i], PRODUCT_PRICE_LIST[i], PRODUCT_IMAGE_LIST[i]));
        }

        //Add data to adapter
        adapter = new ProductAdapter(myProducts);
        myView = (RecyclerView)findViewById(R.id.catalogRecyclerView);
        myView.setHasFixedSize(true);
        myView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onStart(){
        super.onStart();

        //Custom RecyclerView setOnClick method call
        launch(myView);
    }

    private void launch(RecyclerView recyclerView) {
        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener
        .OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                String productTitle = adapter.products.get(position).title;
                String productPrice = adapter.products.get(position).price;
                int productImage = adapter.products.get(position).image;


                Intent intent = new Intent(ProductCatalogue.this, ProductDetailsActivity.class);
                intent.putExtra("title", productTitle);
                intent.putExtra("price", productPrice);
                intent.putExtra("image",productImage);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position){
                Context context = getApplicationContext();
                CharSequence text = adapter.products.get(position).title;
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }));
    }
}

class ProductList {

    static final String[] productNameList = {
            "Hot Sauces", "Syrups", "Free Coconut Milk", "Whole Kernel Corn", "Free Water Bottle"
    };

    static final int[] prodImageList = {
             R.drawable.coupon1, R.drawable.coupon2, R.drawable.coupon3, R.drawable.coupon4, R.drawable.coupon5
    };

    static final String[] productPriceList = {
            "$150.00", "$200.00", "$170.00", "$80.00", "$250.00"
    };
}
