package com.example.firebaseauth2;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class CartActivity extends AppCompatActivity {
    //    TextView FoodName;
//    TextView FoodPrepared;
//    TextView Category;
//    TextView Prep;
//    TextView Add;
//    TextView Phone;
    private Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_page);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Added to cart!", Toast.LENGTH_SHORT).show();
            }
        });


        String clickedRestName = getIntent().getStringExtra("EXTRA_KEY_REST");
        String clickedFoodName = getIntent().getStringExtra("EXTRA_KEY_FOOD");
        String clickedCat = getIntent().getStringExtra("EXTRA_KEY_CAT");
        String clickedPrep = getIntent().getStringExtra("EXTRA_KEY_PREP");
        String clickedAdd = getIntent().getStringExtra("EXTRA_KEY_ADD");
        String clickedPh = getIntent().getStringExtra("EXTRA_KEY_PH");
        String clickedPrice = getIntent().getStringExtra("EXTRA_KEY_PRICE");
        String clickedImg = getIntent().getStringExtra("EXTRA_KEY_IMG");

        // Get reference to the TextView in the layout
        TextView RestName = findViewById(R.id.RestName);
        TextView FoodName = findViewById(R.id.FoodName);
        TextView Category = findViewById(R.id.Category);
        TextView Prep = findViewById(R.id.FoodPrepared);
        TextView Add = findViewById(R.id.Address);
        TextView Phone = findViewById(R.id.Phone);
        TextView Price = findViewById(R.id.Price);

        // Set the name to the TextView
        RestName.setText(clickedRestName);
        FoodName.setText(clickedFoodName);
        Category.setText(clickedCat);
        Prep.setText(clickedPrep);
        Add.setText(clickedAdd);
        Phone.setText(clickedPh);
        Price.setText(clickedPrice);


        // Image link from internet
//        new DownloadImageFromInternet((ImageView) findViewById(R.id.image_view)).execute("https://static.toiimg.com/thumb/msid-78767001,width-1280,resizemode-4/78767001.jpg");
        new DownloadImageFromInternet((ImageView) findViewById(R.id.image_view)).execute(clickedImg);


    }
    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;
            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...",Toast.LENGTH_SHORT).show();
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}

