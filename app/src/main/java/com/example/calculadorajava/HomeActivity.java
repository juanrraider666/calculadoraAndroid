package com.example.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.card_view1:
                        Intent goBasicCal = new Intent(HomeActivity.this, BasicCalculatorActivity.class);
                        startActivity(goBasicCal);
                        break;

                    case R.id.card_view2:
//                        Toast.makeText(HomeActivity.this, "Hola mona2", Toast.LENGTH_SHORT).show();
                        Intent goConversionUnits = new Intent(HomeActivity.this, ConversionUnitsActivity.class);
                        startActivity(goConversionUnits);
                        break;

                    case R.id.card_view4:
                        Intent goScientific = new Intent(HomeActivity.this, CientificActivity.class);
                        startActivity(goScientific);
                        break;
                }

            }


        };

        findViewById(R.id.card_view1).setOnClickListener(handler);
        findViewById(R.id.card_view2).setOnClickListener(handler);
        findViewById(R.id.card_view4).setOnClickListener(handler);
    }


}