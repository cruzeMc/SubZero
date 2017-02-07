package com.dreamchaser.cruze.hilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button coupon = (Button) findViewById(R.id.mainActivityCouponButton);
        coupon.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ProductCatalogue.class);
                startActivity(intent);
            }
        });
    }
}
