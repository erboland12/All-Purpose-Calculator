package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class OperationsActivity extends AppCompatActivity {

    public static String opTitle;
    public TextView mTitle;
    private TextView mError;
    private EditText mResult;
    private EditText mSubmit;
    private EditText mSubmit2;
    private Button enterBtn;
    private Spinner rads;

    private static double radToDegrees = 57.295779513;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(opTitle == "Modulo"){
            setContentView(R.layout.mod_layout);
        }
        else if(opTitle == "Arccos" || opTitle == "Arcsin" || opTitle == "Arctan"){
            setContentView(R.layout.arc_layout);
        }
        else{
            setContentView(R.layout.activity_operations);
        }
        mTitle = findViewById(R.id.ops_page_title);
        mError = findViewById(R.id.ops_page_error);
        mResult = findViewById(R.id.ops_page_result);
        mSubmit = findViewById(R.id.ops_page_submit);
        mSubmit2 = findViewById(R.id.ops_page_submit2);
        rads = findViewById(R.id.rads_or_degrees);
        mTitle.setText(opTitle);

        //Link resources to front end view

        String[] items = new String[]{"Degrees", "Radians"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        rads.setAdapter(adapter);

        //Shows degree or radians spinner if trig operation

        checkForTrigOps();

        //Determines operation based on title
        setOperation();
    }

    private void setOperation(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mSubmit.getText().toString().matches("[0-9]+")){
                    float finalSubmit = Float.parseFloat(mSubmit.getText().toString());
                    if(opTitle == "Fibonacci" && finalSubmit >= 0){
                        Calculator calc = new Calculator();
                        float result = calc.fibonacci(finalSubmit);
                        mResult.setText(calc.returnFloat(result));
                    }
                    if(opTitle == "Factorial" && finalSubmit >= 0){
                        Calculator calc = new Calculator();
                        float result = calc.factorial(finalSubmit);
                        mResult.setText(calc.returnFloat(result));
                    }
                    if(opTitle == "Modulo"){
                        Calculator calc = new Calculator();
                        int result = Integer.parseInt(mSubmit.getText().toString());
                        int result2 = Integer.parseInt(mSubmit2.getText().toString());
                        mResult.setText(calc.mod(result, result2));
                    }

                    mError.setVisibility(View.INVISIBLE);
                } else if (!(mTitle.getText().toString() == "Cosine" || mTitle.getText().toString() == "Sine" || mTitle.getText().toString() == "Tangent"
                        || mTitle.getText().toString() == "Arccos" || mTitle.getText().toString() == "Arcsin" || mTitle.getText().toString() == "Arctan")){
                    mError.setVisibility(View.VISIBLE);
                }

                if (opTitle == "Cosine") {
                    String type = rads.getSelectedItem().toString();
                    if (type == "Radians") {
                        Calculator calc = new Calculator();
                        float result = Float.parseFloat(mSubmit.getText().toString());
                        mResult.setText(calc.cosine(result));
                    }else{
                        Calculator calc = new Calculator();
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        result = Math.toRadians(result);
                        float finalResult = (float) result;
                        mResult.setText(calc.cosine(finalResult));
                    }
                }
                if (opTitle == "Sine") {
                    String type = rads.getSelectedItem().toString();
                    if (type == "Radians") {
                        Calculator calc = new Calculator();
                        float result = Float.parseFloat(mSubmit.getText().toString());
                        mResult.setText(calc.sine(result));
                    }else{
                        Calculator calc = new Calculator();
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        result = Math.toRadians(result);
                        float finalResult = (float) result;
                        mResult.setText(calc.sine(finalResult));
                    }
                }
                if (opTitle == "Tangent") {
                    String type = rads.getSelectedItem().toString();
                    if (type == "Radians") {
                        Calculator calc = new Calculator();
                        float result = Float.parseFloat(mSubmit.getText().toString());
                        mResult.setText(calc.tan(result));
                    }else{
                        Calculator calc = new Calculator();
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        result = Math.toRadians(result);
                        float finalResult = (float) result;
                        mResult.setText(calc.tan(finalResult));
                    }
                }

                if (opTitle == "Arccos") {
                    String type = rads.getSelectedItem().toString();
                    if (type == "Radians") {
                        Calculator calc = new Calculator();
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        double result2 = Double.parseDouble(mSubmit2.getText().toString());
                        mResult.setText(calc.arccos(result, result2));
                    }else{
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        double result2 = Double.parseDouble(mSubmit2.getText().toString());
                        result = Math.toRadians(result);
                        result2 = Math.toRadians(result2);
                        double res = (result/result2);
                        mResult.setText(Double.toString(Math.acos(res) * radToDegrees));
                    }
                }
                if (opTitle == "Arcsin") {
                    String type = rads.getSelectedItem().toString();
                    if (type == "Radians") {
                        Calculator calc = new Calculator();
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        double result2 = Double.parseDouble(mSubmit2.getText().toString());
                        mResult.setText(calc.arcsin(result, result2));
                    }else{
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        double result2 = Double.parseDouble(mSubmit2.getText().toString());
                        result = Math.toRadians(result);
                        result2 = Math.toRadians(result2);
                        double res = (result/result2);
                        mResult.setText(Double.toString(Math.asin(res) * radToDegrees));
                    }
                }
                if (opTitle == "Arctan") {
                    String type = rads.getSelectedItem().toString();
                    if (type == "Radians") {
                        Calculator calc = new Calculator();
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        double result2 = Double.parseDouble(mSubmit2.getText().toString());
                        mResult.setText(calc.arctan(result, result2));
                    }else{
                        double result = Double.parseDouble(mSubmit.getText().toString());
                        double result2 = Double.parseDouble(mSubmit2.getText().toString());
                        result = Math.toRadians(result);
                        result2 = Math.toRadians(result2);
                        double res = (result/result2);
                        mResult.setText(Double.toString(Math.atan(res) * radToDegrees));
                    }
                }

            }
        });
    }

    private void setTrigOps(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void checkForTrigOps(){
        if(mTitle.getText().toString() == "Cosine" || mTitle.getText().toString() == "Sine" || mTitle.getText().toString() == "Tangent"
        || mTitle.getText().toString() == "Arccos" || mTitle.getText().toString() == "Arcsin" || mTitle.getText().toString() == "Arctan"){
            rads.setVisibility(View.VISIBLE);
        }
    }
}
