package com.example.cscb07_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CustomerPage extends AppCompatActivity {
    private String username = "";
    private String customerId = "";
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private Button ShoppingCarBtn;
    private Button LogoutBtn;
    private Button ViewBtn;

    public ArrayList<Product> orderProductList = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        customerId = intent.getStringExtra("customerId");
        TextView tv = (TextView)findViewById(R.id.welcome);
        tv.setText("Welcome " + username);

        ShoppingCarBtn = (Button) findViewById(R.id.ShoppingCarbutton);
        ShoppingCarBtn.setOnClickListener(this::viewShoppingCar);

        LogoutBtn = (Button) findViewById(R.id.customerLogout);
        LogoutBtn.setOnClickListener(this::customerLogout);

        ViewBtn = (Button) findViewById(R.id.viewProducts);
        ViewBtn.setOnClickListener(this::viewProducts);

    }

    public void viewShoppingCar (View view){

//        orderProductList.add(new Product("Apple", 2.3, 3));
//        orderProductList.add(new Product("Pear", 1.8, 1));
//        orderProductList.add(new Product("Banana", 3.0, 4));

        Intent intent = new Intent(CustomerPage.this, ShoppingCar.class);
//        intent.putExtra("items", orderProductList);
        startActivity(intent);
    }

    public void viewProducts (View view){
        Intent intent = new Intent(CustomerPage.this, CustomStorePage.class);
        intent.putExtra("username", username);
        intent.putExtra("customerId", customerId);
        startActivity(intent);
    }

    public void customerLogout(View view){
        startActivity (new Intent(CustomerPage.this, MainActivity.class));

    }
}
