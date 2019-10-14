package com.example.hassan.toursim;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        configureAllGovsButton();
    }

    private void configureAllGovsButton() {

        Button btnAllGovs= (Button)findViewById(R.id.btnAllGovs);

        btnAllGovs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   startActivity(new Intent(TripsActivity.this, MainActivity.class));
               // finish();
                Toast.makeText(TripsActivity.this, "btnAllGovsWWWWW", Toast.LENGTH_LONG).show();
            }
        });

    }
}
