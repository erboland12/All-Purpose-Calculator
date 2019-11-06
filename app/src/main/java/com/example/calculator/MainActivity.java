package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calculatorBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorBtn = findViewById(R.id.calcBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, CalculatorActivity.class);
            }
        });
    }
}
