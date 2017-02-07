package com.dreamchaser.cruze.hilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Helpers.ShoppingCartData;
import Model.Product;

public class ProductDetailsActivity extends AppCompatActivity {
    String intentTitle;
    String intentPrice;
    int intentImage;
    boolean selected = false;

    TextView productTitle;
    ImageView productImage;
    TextView productDescription;
    Button removeFromCart;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Log.d("CRUZEMCFARLANE", ShoppingCartData.getCartList().toString());

        intentTitle = getIntent().getStringExtra("title");
        intentPrice = getIntent().getStringExtra("price");
        intentImage = getIntent().getIntExtra("image", 0);

        productTitle = (TextView) findViewById(R.id.couponTextView);
        productTitle.setText(intentTitle);

        productImage = (ImageView) findViewById(R.id.couponImageView);
        productImage.setImageResource(intentImage);

        productDescription = (TextView) findViewById(R.id.productDetailsTextView);

        removeFromCart = (Button) findViewById(R.id.removeFromCartButton);
        removeFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Removed From Cart", Toast.LENGTH_LONG).show();

            }
        });

        addToCart = (Button) findViewById((R.id.addToCartButtom));
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = true;
                ShoppingCartData.setCartList(new Product(intentTitle, intentPrice, intentImage,
                        productDescription.getText().toString(), selected));

                Toast.makeText(getApplicationContext(), "Added To Cart", Toast.LENGTH_LONG).show();
            }
        });

    }
}
