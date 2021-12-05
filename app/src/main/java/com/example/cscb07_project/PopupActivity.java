package com.example.cscb07_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.zip.Inflater;

public class PopupActivity extends AppCompatActivity{

    private Button orderPopup;
    private Button cancelBtn;
    private Button confirmBtn;

    private FirebaseAuth mAuth;
    DatabaseReference orderDbRef;
    String orderId;

    private FirebaseUser fbUser;
    DatabaseReference userRef;
    String userId;

    List<Product> allProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order_popup);

//        Intent intent = getIntent();
//        allProducts = intent.getParcelableExtra("order");

//        fbUser = FirebaseAuth.getInstance().getCurrentUser();
//        userRef = FirebaseDatabase.getInstance().getReference();
//        userId = fbUser.getDisplayName();

//        orderId = mAuth.getUid();
//        orderDbRef = FirebaseDatabase.getInstance().getReference("Orders");

        cancelBtn = (Button) findViewById(R.id.cancel_button);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        confirmBtn = (Button) findViewById(R.id.confirm_button);
//        confirmBtn.setOnClickListener(this);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Order order = new Order ("hello", userId);
//                order.addProducts(new Product("Apple", 2.5,3));
//                order.addProducts(new Product("Banana", 2.25,8));
//                order.addProducts(new Product("Pear", 1.5,2));
//
//                orderDbRef.push().setValue(order);
                Toast.makeText(PopupActivity.this, "Order Sent", Toast.LENGTH_LONG).show();
//                updateConfirmOrderData();
            }
        });


//        orderPopup = (Button) findViewById(R.id.checkoutButton);
//        orderPopup.setOnClickListener(this::showPopup);
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int) (width*0.8), (int) (height*0.6));

    }

    public void cancel (){
        Intent intent = new Intent(PopupActivity.this, ShoppingCar.class);
        Toast.makeText(this,"Order Canceled", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    public void updateConfirmOrderData (){
//        Order order = new Order ("hello", userId);
//        order.addProducts(new Product("Apple", 2.5,3));
//        order.addProducts(new Product("Banana", 2.25,8));
//        order.addProducts(new Product("Pear", 1.5,2));
//
//        String key = orderDbRef.push().getKey();
//        orderDbRef.child(key).setValue(order);
        Toast.makeText(PopupActivity.this, "Order Sent", Toast.LENGTH_LONG).show();
//        Toast.makeText(this,"Confirm", Toast.LENGTH_SHORT).show();
    }

//    public void showPopup (){

//        Intent intent = new Intent(PopupActivity.this, )

//        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View popWindowView = layoutInflater.inflate(R.layout.confirm_order_popup, null);
//
//        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//        boolean focusable = true;
//        final PopupWindow popup = new PopupWindow(popWindowView, width, height,focusable);
//
//        popup.showAtLocation(view, Gravity.CENTER, 0,0);
//
//        Button confirmBtn = popWindowView.findViewById(R.id.confirm_button);
//        confirmBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        popWindowView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                popup.dismiss();
//                return true;
//            }
//        });

//    }

//    @Override
//    public void onClick (View view){
//        switch (view.getId()) {
//            case R.id.cancel_button:
//                cancel();
//                break;
//            case R.id.confirm_button:
//                updateConfirmOrderData();
//                break;
//        }
//    }
}