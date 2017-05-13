package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import entities.Product;
import java.util.*;
import Adapters.*;

import android.view.MenuItem;
import android.widget.*;


public class Main4Activity extends AppCompatActivity {

    private GridView gridViewProducts;
    private List<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main4);

        products.add(new Product("p1","Chocolate Oreo",R.drawable.coklatoreo));
        products.add(new Product("p2","Chocolate Raspberry",R.drawable.coklatrasp));
        products.add(new Product("p3","Chocolate Vanilla",R.drawable.coklatvan));
        products.add(new Product("p4","Red Velvet Oreo",R.drawable.redoreo));
        products.add(new Product("p5","Red Velvet Raspberry",R.drawable.redrasp));
        products.add(new Product("p6","Red Velvet Vanilla",R.drawable.redvan));
        products.add(new Product("p7","Original Oreo",R.drawable.vanoreo));
        products.add(new Product("p8","Original Raspberry",R.drawable.vanrasp));
        products.add(new Product("p9","Original Vanilla",R.drawable.vanvan));

        this.gridViewProducts = (GridView) findViewById(R.id.gridViewProducts);
        this.gridViewProducts.setAdapter(new ProductListAdapter(this, products));

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
