package com.example.firebaseauth2;



import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

class MainAdapter extends FirebaseRecyclerAdapter<model,MainAdapter.myviewholder>
{
    private Context context;
    public MainAdapter(@NonNull FirebaseRecyclerOptions<model> options, Context context) {
        super(options);
        this.context = context;
    }

    //    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
//        ImageView imageView;
//        public DownloadImageFromInternet(ImageView imageView) {
//            this.imageView=imageView;
////            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...",Toast.LENGTH_SHORT).show();
//        }
//        protected Bitmap doInBackground(String... urls) {
//            String imageURL=urls[0];
//            Bitmap bimage=null;
//            try {
//                InputStream in=new java.net.URL(imageURL).openStream();
//                bimage= BitmapFactory.decodeStream(in);
//            } catch (Exception e) {
//                Log.e("Error Message", e.getMessage());
//                e.printStackTrace();
//            }
//            return bimage;
//        }
//        protected void onPostExecute(Bitmap result) {
//            imageView.setImageBitmap(result);
//        }
//    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
        holder.food_name.setText(model.getFood_name());
        holder.food_prepared.setText(model.getFood_prepared());
        holder.quantity.setText(model.getQuantity());
        holder.category.setText(model.getCategory());
        holder.rest_name.setText(model.getRest_name());

//        Glide.with(holder.img.getContext()).load(model.getPurl()).placeholder(R.drawable.baseline_image_24).circleCrop().error(R.drawable.baseline_image_24).into(holder.img);
//        new ImageActivity.DownloadImageFromInternet((ImageView) findViewById(R.id.image_view)).execute("https://static.toiimg.com/thumb/msid-78767001,width-1280,resizemode-4/78767001.jpg");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item data if needed (in this case, it's 'model')
                String clickedRestName = model.getRest_name();
                String clickedFoodName = model.getFood_name();
                String clickedCat = model.getCategory();
                String clickedPrep = model.getFood_prepared();
                String clickedAdd = model.getAddress();
                String clickedPh = model.getPhone();
                String clickedPrice = model.getPrice();
                String clickedImg = model.getUrl();

                Log.d("TAG", "Item Name: " + model.getFood_name());
                // Start the next activity here
                Intent intent = new Intent(context,CartActivity.class);
                // Pass any data to the next activity if needed
                intent.putExtra("EXTRA_KEY_REST", clickedRestName);
                intent.putExtra("EXTRA_KEY_FOOD", clickedFoodName);
                intent.putExtra("EXTRA_KEY_CAT", clickedCat);
                intent.putExtra("EXTRA_KEY_PREP", clickedPrep);
                intent.putExtra("EXTRA_KEY_ADD", clickedAdd);
                intent.putExtra("EXTRA_KEY_PH", clickedPh);
                intent.putExtra("EXTRA_KEY_PRICE", clickedPrice);
                intent.putExtra("EXTRA_KEY_IMG", clickedImg);
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mainadopter,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        //        CircleImageView img;
        TextView food_name,food_prepared,quantity, category, rest_name;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
//            img=(CircleImageView)itemView.findViewById(R.id.img1);
            food_name=(TextView)itemView.findViewById(R.id.food_name);
            food_prepared=(TextView)itemView.findViewById(R.id.food_prepared);
            quantity=(TextView)itemView.findViewById(R.id.quantity);
            category=(TextView)itemView.findViewById(R.id.category);
            rest_name=(TextView)itemView.findViewById(R.id.rest_name);
        }
    }
}