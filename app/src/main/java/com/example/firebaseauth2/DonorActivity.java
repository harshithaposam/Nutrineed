package com.example.firebaseauth2;


//import android.os.Bundle;
//import android.util.Log;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
////    private DatabaseReference databaseReference;
////    private DatabaseReference mDatabase;
////
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        // Get a reference to the Firebase database
//////        FirebaseDatabase database = FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app");
//////        databaseReference = database.getReference("Halli Mane"); // Replace "your_database_node" with your actual node name
////        mDatabase = FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants");
////
////        mDatabase.child("Halli Mane").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
////            @Override
////            public void onComplete(@NonNull Task<DataSnapshot> task) {
////                if (!task.isSuccessful()) {
////                    Log.e("firebase", "Error getting data", task.getException());
////                }
////                else {
////                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
////                }
////            }
////        });
//
//        // Attach a ValueEventListener to the database reference
////        databaseReference.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                // This method will be called whenever data in the database changes.
////                // You can retrieve the data from the dataSnapshot object.
////
////                // For example, if you expect a String value:
////                String value = dataSnapshot.getValue(String.class);
////                Log.d("TAG", "Value: " + value);
////
////                // If the data is in a nested structure, you can access it like this:
////                // String nestedValue = dataSnapshot.child("nested_node").getValue(String.class);
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError databaseError) {
////                // This method will be called if there is an error reading the data.
////                Log.w("TAG", "Failed to read value.", databaseError.toException());
////            }
////        });
//    }
//}
//
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;


public class DonorActivity extends AppCompatActivity {

    private EditText food_name, quantity, rest_name, address, phone, price;
    private TextView food_prepared, category;
    private Button addProductsBtn;
    private String Pfood_name, Pquantity, Pfood_prepared, Prest_name, Pcategory, Paddress, Pphone, Pprice;
    private Uri image_uri;

    public static final  String[] time_slot={
            "Morning",
            "Afternoon",
            "Evening"
    };

    public static final  String[] category_available={
            "Veg",
            "Non-veg",
            "Vegan"
    };

    //    private DatabaseReference reference;
    private DatabaseReference mDatabase;

    private void food_prepared() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("time slot").setItems(time_slot, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String category=time_slot[i];
                        food_prepared.setText(category);
                    }
                })
                .show();
    }

    private void category() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Category available").setItems(category_available, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String cat=category_available[i];
                        category.setText(cat);
                    }
                })
                .show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        rest_name = findViewById(R.id.rest_name);
        food_name = findViewById(R.id.food_name);
        quantity = findViewById(R.id.quantity);
        food_prepared = findViewById(R.id.food_prepared);
        category = findViewById(R.id.category);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        price = findViewById(R.id.price);
        addProductsBtn = findViewById(R.id.addProductsBtn);

//        mDatabase = FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Test");
//        mDatabase.setValue("Hello, world");

//        reference = FirebaseDatabase.getInstance().getReference().child("test");

//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app");
//        DatabaseReference myRef = database.getReference();
//        myRef.setValue("Hello, World!");

        food_prepared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food_prepared();
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category();
            }
        });

        addProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String data = input.getText().toString();
//                mDatabase = FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants");
//                mDatabase.child("A2B").child("Name").setValue(data);
//                mDatabase.setValue(data);
//                reference.setValue(data);
                Toast.makeText(DonorActivity.this, "Data updated in Firebase", Toast.LENGTH_SHORT).show();

                Prest_name = rest_name.getText().toString().trim();
                Pfood_name = food_name.getText().toString().trim();
                Pquantity = quantity.getText().toString().trim();
                Pfood_prepared = food_prepared.getText().toString().trim();
                Pcategory = category.getText().toString().trim();
                Pphone = phone.getText().toString().trim();
                Pprice = price.getText().toString().trim();
                Paddress = address.getText().toString().trim();

                if (TextUtils.isEmpty(Prest_name)) {
                    Toast.makeText(DonorActivity.this, "Restaurant name required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Pfood_name)) {
                    Toast.makeText(DonorActivity.this, "Food name required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Pquantity)) {
                    Toast.makeText(DonorActivity.this, "Quantity required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Pfood_prepared)) {
                    Toast.makeText(DonorActivity.this, "Food prepared time required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Pcategory)) {
                    Toast.makeText(DonorActivity.this, "Food category required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Paddress)) {
                    Toast.makeText(DonorActivity.this, "Address required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Pphone)) {
                    Toast.makeText(DonorActivity.this, "Phone number required", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisecs = System.currentTimeMillis();
//              DateFormat.getDateTimeInstance().format(new Date(0));
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                Date resultdate = new Date(millisecs);
                String timestamp = "" + sdf.format(resultdate);
                if (image_uri == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("productId", "" + timestamp);
                    hashMap.put("food_name", "" + Pfood_name);
                    hashMap.put("quantity", "" + Pquantity);
                    hashMap.put("food_prepared", "" + Pfood_prepared);
                    hashMap.put("category", "" + Pcategory);
                    hashMap.put("address", "" + Paddress);
                    hashMap.put("phone", "" + Pphone);
                    hashMap.put("price", "" + Pprice);
                    hashMap.put("rest_name", "" + Prest_name);
                    hashMap.put("timestamp", "" + timestamp);

                    mDatabase = FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants");
                    mDatabase.child(Prest_name).setValue(hashMap);
                }
            }


        });
    }
}

