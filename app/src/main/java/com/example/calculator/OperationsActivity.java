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

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class OperationsActivity extends AppCompatActivity {

    public static String opTitle;
    public TextView mTitle;
    private TextView mError;
    public static EditText mResult;
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

    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;

    //Spinner arrays
    ArrayAdapter<String> adapter;
    private String[] massItems = {"mg", "g", "Kg"};
    private String[] lengthItems = {"mm", "cm", "m", "km"};
    private String[] timeItems = {"ms", "s", "mins", "hrs"};
    private String[] velocityItems = {"mm/s", "m/s", "km/s"};
    private String[] accelerationItems = {"m/s^2", "km/s^2"};
    private String[] gravity = {"m/s^2"};
    private String[] forceItems = {"N"};

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#####", otherSymbols);

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";
    public static final String MINUS = "\u2212";
    public static String PI = "\u03a0";
    public static String SQRT = "\u221a";

    private boolean isOp = false;
    private boolean isPhys = false;
    private boolean isCalc = false;
    private boolean isGeo = false;

    private static double radToDegrees = 57.295779513;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String centA = "Centripetal Acceleration (v2/r)";
        centA = superscript(centA);
        String centA2 = "Centripetal Acceleration (" + OMEGA + "2/r)";
        String ke = "mv2)";
        String ke2 = "Kinetic Energy (p2";


        if(opTitle == "Force (F = ma)" || opTitle == "Weight (W = mg)" || opTitle == "Acceleration (" + DELTA + "v/" + DELTA + "t)" ||
            opTitle == "Momentum (p = mv)" || opTitle == "Centripetal Acceleration (v2/r)" || opTitle == centA2 || opTitle == "Impulse (" + DELTA + "p = F" + DELTA + "t)" ||
            opTitle == "Kinetic Energy (1/2 * mv2)" || opTitle == "Kinetic Energy (p2/2m)" || opTitle == "Gravitation P.E (" + DELTA + "Ug = mg" + DELTA +"h)" ||
            opTitle == "Power (" + DELTA + "W/" + DELTA + "t)" || opTitle == "Hooke's Law (F = -k" + DELTA + "x)"){
            setContentView(R.layout.physics_layout);
            isPhys = true;
        }
        else if(opTitle == "Square (a2)" || opTitle == "Triangle ((1/2)bh)" || opTitle == "Rectangle (bh)" || opTitle == "Cube (lwh)" ||
                opTitle == "Trapezoid (h/2 * (b1 + b2))" || opTitle == "Circle (" + PI + "r2)" || opTitle == "Ellipse (" + PI + "r1r2)" ||
                opTitle == "Cube (6a2)" || opTitle == "Rectangular Prism (2lw + 2lh + 2wh" || opTitle == "Sphere (4" + PI + "r2)" ||
                opTitle == "Cylinder (2" + PI + "r2 + 2" + PI + "rh" || opTitle == "Cone (" + PI + "r2 + " + PI + "r(" + SQRT + "(h2 + r2)))" ||
                opTitle == "Pyramid (s2 + 2sl)" || opTitle == "Cube (a3)" || opTitle == "Rectangular Prism (lwh)" || opTitle == "Cylinder (" + PI + "r2h)" ||
                opTitle == "Pyramid ((1/3)bh)" || opTitle == "Cone ((1/3)" + PI + "r2h" || opTitle == "Sphere ((4/3)" + PI + "r3" ||
                opTitle == "Ellipsoid ((4/3)" + PI + "r1r2r3"){
            setContentView(R.layout.geo_layout);
            isGeo = true;
        }
        else if(opTitle == "Modulo"){
            setContentView(R.layout.mod_layout);
            isOp = true;
        }
        else if(opTitle == "Arccos" || opTitle == "Arcsin" || opTitle == "Arctan"){
            setContentView(R.layout.arc_layout);
            isOp = true;
        }
        else if(opTitle == "Derivative"){
            setContentView(R.layout.derivative_layout);
            isCalc = true;
        }
        else{
            setContentView(R.layout.activity_operations);
            isOp = true;
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
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);

        mTitle.setText(opTitle);

        //Link resources to front end view

        String[] items = new String[]{"Degrees", "Radians"};

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        rads.setAdapter(adapter);

        //Shows degree or radians spinner if trig operation

        checkForTrigOps();

        //Determines operation based on title
        if(isPhys) {
            checkPhys();
            setPhysicsOps();
        }
        if(isOp){
            setOperation();
        }
        if(isCalc){
            setCalcOps();
        }
        if(isGeo){
            setGeoOps();
            checkGeo();
        }
    }

    private void setGeoOps(){
        if(opTitle == "Square (a2)"){
            mTitle.setText(superscript("Square (a2)"));
            mPhysTitle1.setText("Side (a)");

            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Triangle ((1/2)bh)"){
            mPhysTitle1.setText("Base");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
    }

    private void checkGeo(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            GeoCalculator geoCalc = new GeoCalculator();
            @Override
            public void onClick(View view) {
                if(opTitle == "Square (a2)"){
                    int counter = 1;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        mResult.setText(geoCalc.SquareArea(result));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Triangle ((1/2)bh)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.TriangleArea(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }

                }
            }
        });
    }

    private boolean checkInput(int counter){
        if(counter == 1){
            if(mPhsySub1.getText().toString().isEmpty()){
                mError.setText("**Please Fill in all Fields**");
                mError.setVisibility(View.VISIBLE);
                mResult.setText("");
                return false;
            }
            else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                    mPhysSub2.getText().toString().matches("[a-zA-Z]+")){
//                (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
//                        mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                mError.setText("**Invalid Input**");
                mError.setVisibility(View.VISIBLE);
                mResult.setText("");
                return false;
            }
        }
        else if (counter == 2){
            if(mPhsySub1.getText().toString().isEmpty() || mPhysSub2.getText().toString().isEmpty()){
                mError.setText("**Please Fill in all Fields**");
                mError.setVisibility(View.VISIBLE);
                mResult.setText("");
                return false;
            }
            else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                    mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                        mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                mError.setText("**Invalid Input**");
                mError.setVisibility(View.VISIBLE);
                mResult.setText("");
                return false;
            }
        }

        return true;



    }

    private void setCalcOps(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int counter = 0;
                String[] list = new String[5];
                Derivative d = new Derivative();
                String submit = mSubmit.getText().toString();
                if(!submit.contains("+") && !submit.contains("(-)")){
                    String result = d.derivative(mSubmit.getText().toString());
                    mResult.setText("f(x') = " + result);
                }
                else{
                    for(int i = 0; i < submit.length(); i++){
                        if(submit.charAt(i) == '+' || (submit.charAt(i) == '-')){
                            list[counter] = Character.toString(submit.charAt(i));
                            counter += 1;
                        }
                    }
                    if(counter == 1){
                        Scanner scanner = new Scanner(mSubmit.getText().toString());
                        if(list[0] == "+"){
                            scanner.useDelimiter("\\+");
                        } else {
                            scanner.useDelimiter("\\s*-\\s*");
                        }
                        String x = scanner.next();
                        String y = scanner.next();
                        x = d.derivative(x);
                        y = d.derivative(y);
                        String result = x + list[0] + y;
                        mResult.setText("f(x') = " + result);
                    }
//                    else if(counter == 2){
//                        Scanner scanner = new Scanner(mSubmit.getText().toString());
//                        scanner.useDelimiter("\\+");
//                        String x = scanner.next();
//                        String y = scanner.next();
//                        String z = scanner.next();
//                        x = d.derivative(x);
//                        y = d.derivative(y);
//                        z = d.derivative(z);
//                        String result = x + "+" + y + "+" + z;
//                        mResult.setText("f(x') = " + result);
//                    }

                }


            }
        });
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
        if(mTitle.getText().toString() == "Weight (W = mg)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);
            mPhysUnits1.setSelection(2);

            mPhysSub2.setText("9.81");
            mPhysTitle2.setText("Gravity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gravity);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }
        if(mTitle.getText().toString() == "Acceleration (" + DELTA + "v/" + DELTA + "t)"){
            mPhysTitle1.setText(DELTA +"v");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, velocityItems);
            mPhysUnits1.setAdapter(adapter);
            mPhysUnits1.setSelection(1);

            mPhysTitle2.setText(DELTA + "t");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Momentum (p = mv)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);
            mPhysUnits1.setSelection(2);

            mPhysTitle2.setText("Velocity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, velocityItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Impulse (" + DELTA + "p = F" + DELTA + "t)"){
            mPhysTitle1.setText("Force");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, forceItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText(DELTA + "t");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }
    }

    private void checkPhys(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(opTitle == "Force (F = ma)"){
                    if(mPhsySub1.getText().toString().isEmpty() && mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Fields are Empty.  Please Enter in Values**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for Mass**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhysSub2.getText().toString().isEmpty()) {
                        mError.setText("**Please Enter a Value for Acceleration**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                            mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                            (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                                    mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                        mError.setText("**Invalid Input**");
                        mError.setVisibility(View.VISIBLE);
                    }
                     else{
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
                        mError.setVisibility(View.INVISIBLE);
                        mResult.setText(finalResult + "N");
                    }

                }

                if(opTitle == "Weight (W = mg)"){
                    if(mPhsySub1.getText().toString().isEmpty() && mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Fields are Empty.  Please Enter in Values**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for Mass**");
                        mError.setVisibility(View.VISIBLE);

                    }else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                            mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                            (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                                    mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                        mError.setText("**Invalid Input**");
                        mError.setVisibility(View.VISIBLE);
                    }else{
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        if(mPhysUnits1.getSelectedItem().toString() == "mg") {
                            result /= 1000000;
                        }

                        if(mPhysUnits1.getSelectedItem().toString() == "g"){
                            result /= 1000;
                        }
                        float finalResult = result * result2;
                        mError.setVisibility(View.INVISIBLE);
                        mResult.setText(finalResult + "m/s^2");
                    }

                }
                if(opTitle == "Acceleration (" + DELTA + "v/" + DELTA + "t)"){
                    if(mPhsySub1.getText().toString().isEmpty() && mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Fields are Empty.  Please Enter in Values**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for " + DELTA + "v**");
                        mError.setVisibility(View.VISIBLE);

                    } else if(mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for " + DELTA + "t**");
                        mError.setVisibility(View.VISIBLE);
                    }else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                            mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                            (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                                    mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                        mError.setText("**Invalid Input**");
                        mError.setVisibility(View.VISIBLE);
                    } else{
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        if(mPhysUnits1.getSelectedItem().toString() == "mm/s") {
                            result /= 1000;
                        }
                        if(mPhysUnits1.getSelectedItem().toString() == "km/s"){
                            result *= 1000;
                        }

                        if(mPhysUnits2.getSelectedItem().toString() == "ms") {
                            result2 /= 1000;
                        }
                        if(mPhysUnits2.getSelectedItem().toString() == "mins"){
                            result2 *= 60;
                        }
                        if(mPhysUnits2.getSelectedItem().toString() == "hours"){
                            result2 *= 3600;
                        }

                        float finalResult = result / result2;
                        String exp = "m/s2";
                        exp = superscript(exp);
                        mError.setVisibility(View.INVISIBLE);
                        mResult.setText(finalResult + exp);
                    }

                }

                if(opTitle == "Momentum (p = mv)"){
                    if(mPhsySub1.getText().toString().isEmpty() && mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Fields are Empty.  Please Enter in Values**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for Mass**");
                        mError.setVisibility(View.VISIBLE);

                    } else if(mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for Velocity**");
                        mError.setVisibility(View.VISIBLE);
                    } else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                            mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                            (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                                    mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                        mError.setText("**Invalid Input**");
                        mError.setVisibility(View.VISIBLE);
                    } else{
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        if(mPhysUnits1.getSelectedItem().toString() == "mg") {
                            result /= 1000000;
                        }
                        if(mPhysUnits1.getSelectedItem().toString() == "g"){
                            result /= 1000;
                        }

                        if(mPhysUnits2.getSelectedItem().toString() == "mm/s") {
                            result2 /= 1000;
                        }
                        if(mPhysUnits2.getSelectedItem().toString() == "km/s"){
                            result2 *= 1000;
                        }

                        float finalResult = result * result2;
                        mError.setVisibility(View.INVISIBLE);
                        mResult.setText(finalResult + "kg * m/s");
                    }

                }
                if(opTitle == "Impulse (" + DELTA + "p = F" + DELTA + "t)"){
                    if(mPhsySub1.getText().toString().isEmpty() && mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Fields are Empty.  Please Enter in Values**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for Force**");
                        mError.setVisibility(View.VISIBLE);

                    }
                    else if(mPhysSub2.getText().toString().isEmpty()){
                        mError.setText("**Please Enter a Value for " + DELTA + "t**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                            mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                            (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                                    mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
                        mError.setText("**Invalid Input**");
                        mError.setVisibility(View.VISIBLE);
                    }
                    else{
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());

                        if(mPhysUnits2.getSelectedItem().toString() == "ms") {
                            result2 /= 1000;
                        }
                        if(mPhysUnits2.getSelectedItem().toString() == "mins"){
                            result2 *= 60;
                        }
                        if(mPhysUnits2.getSelectedItem().toString() == "hrs"){
                            result2 *= 3600;
                        }

                        float finalResult = result * result2;

                        mError.setVisibility(View.INVISIBLE);
                        mResult.setText(finalResult + "kg * m/s");
                    }

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

    private void constructPhysOperation(String result, String result2, String unitType1, String unitType2){
        if(mPhsySub1.getText().toString().isEmpty() && mPhysSub2.getText().toString().isEmpty()){
            mError.setText("**Fields are Empty.  Please Enter in Values**");
            mError.setVisibility(View.VISIBLE);
        }
        else if(mPhsySub1.getText().toString().isEmpty()){
            checkForUnits(unitType1);

        } else if(mPhysSub2.getText().toString().isEmpty()){
            checkForUnits(unitType2);
        } else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                        mPhysSub2.getText().toString().matches("[a-zA-Z]+"))){
            mError.setText("**Invalid Input**");
            mError.setVisibility(View.VISIBLE);
        }
    }

    private void checkForUnits(String unitType1){
        if(unitType1 == "Mass"){
            mError.setText("**Please Enter a Value for Mass**");
            mError.setVisibility(View.VISIBLE);
        }
        if(unitType1 == "Acceleration"){
            mError.setText("**Please Enter a Value for Acceleration**");
            mError.setVisibility(View.VISIBLE);
        }
        if(unitType1 == "Force"){
            mError.setText("**Please Enter a Value for Force**");
            mError.setVisibility(View.VISIBLE);
        }
        if(unitType1 == DELTA + "t"){
            mError.setText("**Please Enter a Value for " + DELTA + "t**");
            mError.setVisibility(View.VISIBLE);
        }
        if(unitType1 == DELTA + "v"){
            mError.setText("**Please Enter a Value for " + DELTA + "v**");
            mError.setVisibility(View.VISIBLE);
        }
        if(unitType1 == "Velocity"){
            mError.setText("**Please Enter a Value for Velocity**");
            mError.setVisibility(View.VISIBLE);
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

    public static String revert(String str){
        str = str.replaceAll("⁰", "0");
        str = str.replaceAll("¹", "1");
        str = str.replaceAll("²", "2");
        str = str.replaceAll("³", "3");
        str = str.replaceAll("⁴", "4");
        str = str.replaceAll("⁵", "5");
        str = str.replaceAll("⁶", "6");
        str = str.replaceAll("⁷", "7");
        str = str.replaceAll("⁸", "8");
        str = str.replaceAll("⁹", "9");
        return str;
    }
}
