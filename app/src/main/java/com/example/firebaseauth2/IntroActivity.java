package com.example.firebaseauth2;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    Button donor,recipient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        donor=findViewById(R.id.donor);
        recipient=findViewById(R.id.recipient);

        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,MainActivity.class));
            }
        });

        recipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,NgoPageActivity.class));
            }
        });

    }
}
