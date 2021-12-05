package com.example.cscb07_project;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Consumer;

public class Model {
    private static Model instance;


    private DatabaseReference storesRef;

    //private FirebaseAuth auth;

    private Model() {

        storesRef = FirebaseDatabase.getInstance().getReference("Stores");
        //auth = FirebaseAuth.getInstance();
    }

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    public void postStore(Store store, Consumer<Boolean> callback) {
        storesRef.child(store.storeName).setValue(store).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                callback.accept(task.isSuccessful());
            }
        });
    }




    public void getStoreByOwner(String owner, Consumer<Store> callback) {

        storesRef.orderByChild("owner").equalTo(owner).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot storeSnapShot: snapshot.getChildren()) {
                    Store store = storeSnapShot.getValue(Store.class);
                    callback.accept(store);
                    return;
                }
                // not exist
                callback.accept(null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}
