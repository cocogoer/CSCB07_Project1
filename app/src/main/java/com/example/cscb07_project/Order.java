package com.example.cscb07_project;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order extends AppCompatActivity {

    public List<Product> orderProducts;
    //Pending; Processing; Wait for pick up; Complete; Cancelled; SentOut
    public String status;
    public String orderId;

    //store the information that which customer order products from which store
    public String store;
    public String customer;

    public String userID;

    // order time




    ListView listView_items;
    ListView listView_amount;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
    }

    public void show_orders(View view){

        //for every item in the order, get the string of the item
        //and the amount it needed

        listView_items = (ListView)findViewById(R.id.items);
        listView_amount = (ListView)findViewById(R.id.amount);

        ArrayList<String> arrayList_items = new ArrayList<>();
        ArrayList<Integer> arrayList_amount = new ArrayList<>();

        userID = getIntent().getStringExtra("userID");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("userID");
        DatabaseReference details = reference.child("stores").child("orders").child("orderid").child("details");

        details.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    String Name = ds.child("Name").getValue(String.class);
                    Integer Amount = ds.child("Amount").getValue(Integer.class);

                    arrayList_items.add(Name);
                    arrayList_amount.add(Amount);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ArrayAdapter arrayAdapter_items = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList_items);
        ArrayAdapter arrayAdapter_amount = new ArrayAdapter(this, android.R.layout.simple_list_item_2,arrayList_amount);

        listView_items.setAdapter(arrayAdapter_items);
        listView_amount.setAdapter(arrayAdapter_amount);

        TextView order_id = view.findViewById(R.id.orderid);
        order_id.setText("Order id is " + "orderid");
    }



    public void Completed(View view){
        Button button_completed = view.findViewById(R.id.Completed);
        String status = "Completed";
        button_completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<>();
                map.put("status", status);

                FirebaseDatabase.getInstance().getReference("userID").child("stores").child("orders").child("orderid")
                        .updateChildren(map);
            }
        });
    }

    public void Uncompleted(View view){
        Button button_uncompleted = view.findViewById(R.id.Uncompleted);
        String status = "Uncompleted";
        button_uncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<>();
                map.put("status", status);

                FirebaseDatabase.getInstance().getReference("userID").child("stores").child("orders").child("orderid")
                        .updateChildren(map);
            }
        });
    }

    public Order (String storeName, String customerId){
        this.status = "pending";
        this.store = storeName;
        customer = customerId;
    }

    public void addProducts (Product product){
        orderProducts.add(product);
    }

}
