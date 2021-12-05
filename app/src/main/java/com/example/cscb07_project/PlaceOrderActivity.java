package com.example.cscb07_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity {

    List<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

//        ListView listView = (ListView) findViewById(R.id.listViewItems);
//
//        products.add(new Product("Apple", 2.3, 3));
//        products.add(new Product("Pear", 1.8, 1));
//        products.add(new Product("Banana", 3.0, 4));
//
//        ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.activity_place_order, products);
//
//        listView.setAdapter(itemAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(PlaceOrderActivity.this, PopupActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }


}