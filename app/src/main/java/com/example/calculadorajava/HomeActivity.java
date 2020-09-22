package com.example.calculadorajava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                        Toast.makeText(HomeActivity.this, "Bienvenido a Calculadora Basica", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.card_view2:
                        Intent goConversionUnits = new Intent(HomeActivity.this, ConversionUnitsActivity.class);
                        startActivity(goConversionUnits);
                        Toast.makeText(HomeActivity.this, "Bienvenido a Calculadora Converion de unidades", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.card_view4:
                        Intent goScientific = new Intent(HomeActivity.this, CientificActivity.class);
                        Toast.makeText(HomeActivity.this, "Bienvenido a Calculadora Cientifica", Toast.LENGTH_SHORT).show();
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