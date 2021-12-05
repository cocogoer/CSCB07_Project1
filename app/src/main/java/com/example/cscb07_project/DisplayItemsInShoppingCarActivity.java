package com.example.cscb07_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DisplayItemsInShoppingCarActivity extends AppCompatActivity {

    public List<Product> products = new ArrayList<Product>();
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_items_in_shopping_car);

//        ListView listView = (ListView) findViewById(R.id.listViewItems);
//
//        products.add(new Product("Apple", 2.3, 3));
//        products.add(new Product("Pear", 1.8, 1));
//        products.add(new Product("Banana", 3.0, 4));
//
//        ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.shopping_car, products);
//
//        listView.setAdapter(itemAdapter);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(DisplayItemsInShoppingCarActivity.this, PopupActivity.class);
//                startActivity(intent);
//
//            }
//        });


    }
}