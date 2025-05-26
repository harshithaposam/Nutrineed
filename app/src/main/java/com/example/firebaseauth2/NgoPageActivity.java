package com.example.firebaseauth2;



import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class NgoPageActivity extends AppCompatActivity{
    RecyclerView recview;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngopage);

        setTitle("");

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants"), model.class)
                        .build();

        adapter=new MainAdapter(options, this);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.search,menu);

        MenuItem item=menu.findItem(R.id.search_food_name);

        SearchView searchView=(SearchView)item.getActionView();

        int searchImgId = getResources().getIdentifier("android:id/search_button", null, null);
        ImageView v = (ImageView) searchView.findViewById(searchImgId);
        v.setImageResource(R.drawable.baseline_fastfood_24);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

//        ######################################

        MenuItem item_prep=menu.findItem(R.id.search_food_prepared);

        SearchView searchViewPrep=(SearchView)item_prep.getActionView();

        int searchImgIdPrep = getResources().getIdentifier("android:id/search_button", null, null);
        ImageView v1 = (ImageView) searchView.findViewById(searchImgIdPrep);
        v1.setImageResource(R.drawable.baseline_access_time_24);

        searchViewPrep.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearchprep(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearchprep(s);
                return false;
            }
        });

//        ******************************************************

        MenuItem item_quan=menu.findItem(R.id.search_quantity);

        SearchView searchViewQuan=(SearchView)item_quan.getActionView();

        int searchImgIdQuan = getResources().getIdentifier("android:id/search_button", null, null);
        ImageView v2 = (ImageView) searchView.findViewById(searchImgIdQuan);
        v2.setImageResource(R.drawable.baseline_people_24);

        searchViewQuan.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearchquan(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearchquan(s);
                return false;
            }
        });

//        ******************************************************

        MenuItem item_cat=menu.findItem(R.id.search_category);

        SearchView searchViewCat=(SearchView)item_cat.getActionView();

        int searchImgIdCat = getResources().getIdentifier("android:id/search_button", null, null);
        ImageView v3 = (ImageView) searchView.findViewById(searchImgIdCat);
        v3.setImageResource(R.drawable.baseline_flatware_24);

        searchViewCat.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearchcat(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearchcat(s);
                return false;
            }
        });

//        ******************************************************



        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(s).endAt(s+"\uf8ff"), model.class)
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(9).endAt(12), model.class)
                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("food_name").startAt(s).endAt(s+"\uf8ff"), model.class)

                        .build();

        adapter=new MainAdapter(options, this);
        adapter.startListening();
        recview.setAdapter(adapter);

    }

// ##########################################################################

    private void processsearchprep(String s)
    {
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(s).endAt(s+"\uf8ff"), model.class)
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(9).endAt(12), model.class)
                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("food_prepared").startAt(s).endAt(s+"\uf8ff"), model.class)

                        .build();

        adapter=new MainAdapter(options, this);
        adapter.startListening();
        recview.setAdapter(adapter);

    }

    // ##########################################################################

    private void processsearchquan(String s)
    {
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(s).endAt(s+"\uf8ff"), model.class)
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(9).endAt(12), model.class)
                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(s).endAt(s+"\uf8ff"), model.class)
                        .build();

        adapter=new MainAdapter(options, this);
        adapter.startListening();
        recview.setAdapter(adapter);

    }

    // ##########################################################################

    private void processsearchcat(String s)
    {
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(s).endAt(s+"\uf8ff"), model.class)
//                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("quantity").startAt(9).endAt(12), model.class)
                        .setQuery(FirebaseDatabase.getInstance("https://nutrineed-83fdb-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Restaurants").orderByChild("category").startAt(s).endAt(s+"\uf8ff"), model.class)

                        .build();

        adapter=new MainAdapter(options, this);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}

