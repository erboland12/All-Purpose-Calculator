package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calculatorBtn;
    Button miscBtn;
    Button trigBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MovePage m = new MovePage();

        calculatorBtn = findViewById(R.id.calcBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, CalculatorActivity.class);
            }
        });

        miscBtn = findViewById(R.id.miscButton);
        miscBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, MiscellaneousActivity.class);
            }
        });

        trigBtn = findViewById(R.id.trigBtn);
        trigBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, TrigActivity.class);
            }
        });

    }
}
