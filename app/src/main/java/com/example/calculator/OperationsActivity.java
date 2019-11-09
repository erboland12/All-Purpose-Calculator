package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

    //Physics operations front-end
    private TextView mPhysTitle1;
    private TextView mPhysTitle2;
    private TextView mPhysTitle3;
    private EditText mPhsySub1;
    private EditText mPhysSub2;
    private EditText mPhysSub3;
    private Spinner mPhysUnits1;
    private Spinner mPhysUnits2;
    private Spinner mPhysUnits3;

    private LinearLayout linearLayout3;

    //Spinner arrays
    ArrayAdapter<String> adapter;
    private String[] massItems = {"mg", "g", "Kg"};
    private String[] lengthItems = {"mm", "cm", "m", "km"};
    private String[] velocityItems = {"ms", "s", "mins", "hrs"};
    private String[] accelerationItems = {"m/s^2", "km/s^2"};

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";

    private static double radToDegrees = 57.295779513;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String centA = "Centripetal Acceleration (v2/r)";
        centA = superscript(centA);
        String centA2 = "Centripetal Acceleration (" + OMEGA + "2/r)";
        centA2 = superscript(centA2);

        if(opTitle == "Force (F = ma)" || opTitle == "Weight (W = mg)" || opTitle == "Velocity (" + DELTA + "v/" + DELTA + "t)" ||
            opTitle == "Momentum (p = mv)" || opTitle == centA || opTitle == centA2 || opTitle == "Impulse (" + DELTA + "p = F" + DELTA + "t)"){
            setContentView(R.layout.physics_layout);
        }
        else if(opTitle == "Modulo"){
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

        mPhysTitle1 = findViewById(R.id.ops_page_sub_title_1);
        mPhysTitle2 = findViewById(R.id.ops_page_sub_title_2);
        mPhysTitle3 = findViewById(R.id.ops_page_sub_title_3);
        mPhsySub1 = findViewById(R.id.ops_page_sub1);
        mPhysSub2 = findViewById(R.id.ops_page_sub2);
        mPhysSub3 = findViewById(R.id.ops_page_sub3);
        mPhysUnits1 = findViewById(R.id.ops_page_units);
        mPhysUnits2 = findViewById(R.id.ops_page_units2);
        mPhysUnits3 = findViewById(R.id.ops_page_units3);
        linearLayout3 = findViewById(R.id.linearLayout3);

        mTitle.setText(opTitle);

        //Link resources to front end view

        String[] items = new String[]{"Degrees", "Radians"};

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        rads.setAdapter(adapter);

        //Shows degree or radians spinner if trig operation

        checkForTrigOps();

        //Determines operation based on title
        setPhysicsOps();
        setOperation();
        checkPhys();

    }

    private void setPhysicsOps(){
        if(mTitle.getText().toString() == "Force (F = ma)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);
            mPhysUnits1.setSelection(2);

            mPhysTitle2.setText("Acceleration");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, accelerationItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);

        }
    }

    private void checkPhys(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(opTitle == "Force (F = ma)"){
                    float result1 = Float.parseFloat(mPhsySub1.getText().toString());
                    float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                    //Conversion based on units
                    float finalResult = result1 * result2;
                    if(mPhysUnits1.getSelectedItem().toString() == "mg") {
                        finalResult /= 1000;
                    }

                    if(mPhysUnits1.getSelectedItem().toString() == "Kg"){
                        finalResult *= 1000;
                    }

                    if(mPhysUnits2.getSelectedItem().toString() == "m/s^2"){
                        finalResult /= 1000;
                    }

                    mResult.setText(finalResult + "N");
                }
            }
        });

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

    private void checkForTrigOps(){
        if(mTitle.getText().toString() == "Cosine" || mTitle.getText().toString() == "Sine" || mTitle.getText().toString() == "Tangent"
        || mTitle.getText().toString() == "Arccos" || mTitle.getText().toString() == "Arcsin" || mTitle.getText().toString() == "Arctan"){
            rads.setVisibility(View.VISIBLE);
        }
    }

    public static String superscript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }
}
