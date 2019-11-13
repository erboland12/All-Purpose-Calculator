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

import static com.example.calculator.PhysicsActivity.ALPHA;

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
    private String[] angularVelocityItems = {"rad/s"};
    private String[] accelerationItems = {"m/s^2", "km/s^2"};
    private String[] thetaItems = {"Radians", "Degrees"};
    private String[] gravity = {"m/s^2"};
    private String[] forceItems = {"N"};
    private String[] work = {"J"};
    private String[] torque = {"N*m"};
    private String[] angularFrequency = {"Hz"};
    private String[] amplitude = {"m"};
    private String[] springConstant = {"kg * m/s^2"};
    private String[] densityItems = {"g/cm^3, kg/cm^3"};

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#####", otherSymbols);

    //Unicode declerations
    public static final String DELTA = "\u0394";
    public static final String OMEGA = "\u03c9";
    public static final String MINUS = "\u2212";
    public static final String THETA = "\u03b8";
    public static final String ALPHA = "\u03b1";
    public static final String PI = "\u03c0";
    public static final String SQRT = "\u221a";
    public static final String TAU = "\u03c4";
    public static final String RHO = "\u03c1";
    public static final String ETA = "\u037b";


    private boolean isOp = false;
    private boolean isPhys = false;
    private boolean isCalc = false;
    private boolean isGeo = false;

    private static double radToDegrees = 57.295779513;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String centA2 = "Centripetal Acceleration (" + OMEGA + "2/r)";

        if(opTitle == "Force (F = ma)" || opTitle == "Weight (W = mg)" || opTitle == "Acceleration (" + DELTA + "v/" + DELTA + "t)" ||
            opTitle == "Momentum (p = mv)" || opTitle == "Centripetal Acceleration (v2/r)" || opTitle == centA2 || opTitle == "Impulse (" + DELTA + "p = F" + DELTA + "t)" ||
            opTitle == "Kinetic Energy (1/2 * mv2)" || opTitle == "Kinetic Energy (p2/2m)" || opTitle == "Gravitational P.E (" + DELTA + "Ug = mg" + DELTA +"h)" ||
            opTitle == "Power (" + DELTA + "W/" + DELTA + "t)" || opTitle == "Hooke's Law (F = -k" + DELTA + "x)" || opTitle == "Angular Velocity (" + DELTA + THETA + "/" + DELTA + "t)" ||
            opTitle == "Angular Acceleration (" + DELTA + OMEGA + "/" + DELTA + "t)" || opTitle == "Angular Momentum (I" + OMEGA + ")" || opTitle == "Displacement (r" +  THETA + ")" ||
            opTitle == "Velocity (r" + OMEGA + ")" || opTitle == "Acceleration (r" + ALPHA + ")" || opTitle == "Centripetal Acceleration (v2/r)" ||
            opTitle == "Centripetal Acceleration (" + OMEGA + "2/r)" || opTitle == "Centripetal Force (mv2/r)" || opTitle == "Angular Velocity (" + OMEGA + "0 + " + ALPHA + "t)" ||
            opTitle == "Average Angular Velocity (1/2(" + OMEGA + "+" + OMEGA + "0))" || opTitle == "Rotational Work (" + TAU + DELTA + THETA + ")" ||
            opTitle == "Rotational Power (" + TAU + OMEGA + ")" || opTitle == "Rotational Power (" + TAU + OMEGA + "cos(" + THETA + "))" ||
            opTitle == "Rotational K.E (K = 1/2 * I" + OMEGA + "2)" || opTitle == "Density (p = m/v)" || opTitle == "Pressure (P = F/A)" ||
            opTitle == "Change of Pressure (" + DELTA + "P = pgh)" || opTitle == "Dynamic Pressure (q = 1/2" + RHO + "v2)" || opTitle == "Kinematic Viscosity (v = " + ETA + "/" + RHO + ")" ||
            opTitle == "Bernoulli's Equation (Constant = P + 1/2" + RHO + "v2 + " + RHO + "pgh)" || opTitle == "Solid Sphere (I = 2/5 * MR2)" || opTitle == "Hollow Sphere (I = 2/3 * MR2)" ||
            opTitle == "Solid Cylinder (I = 1/2 * MR2)" || opTitle == "Hollow Cylinder (I = 1/2 *  M(Ra2 + Rb2))" || opTitle == "Rect. Plate, Center Axis (I = 1/12 * M(a2 + b2))" ||
            opTitle == "Rect. Plate, Edge Axis (I = 1/3 * Ma2)" || opTitle == "Slender Rod, Center Axis (I = 1/12 * ML2)" || opTitle == "Slender Rod, Edge Axis (I = 1/3 * ML2)" ||
            opTitle == "Position (x = A*cos(" + OMEGA + ")t)" || opTitle == "Velocity (v = -A" + OMEGA + "*sin(" + OMEGA + ")t)" || opTitle == "Acceleration (a = -A" + OMEGA + "2 * cos(" + OMEGA + ")t)" ||
            opTitle == "Force (F = -kx)" || opTitle == "Period (2" + PI + "/" + OMEGA + ")" || opTitle == "Celsius (C = 5/9(F - 32))" || opTitle == "Fahrenheit (F = 9/5*C + 32)" ||
            opTitle == "Kelvin (K = C + 273.15)" || opTitle == "Heat Lost in Water (" + DELTA + "Q = cm" + DELTA + "T)" || opTitle == "Pressure of Ideal Gas (p = 1/3 * " + RHO + "v2)" ||
            opTitle == "K.E of Ideal Gas (3/2 * kT)"){
            setContentView(R.layout.physics_layout);
            isPhys = true;
        }
        else if(opTitle == "Square (a2)" || opTitle == "Triangle ((1/2)bh)" || opTitle == "Rectangle (bh)" || opTitle == "Cube (lwh)" ||
                opTitle == "Trapezoid (h/2 * (b1 + b2))" || opTitle == "Circle (" + PI + "r2)" || opTitle == "Ellipse (" + PI + "r1r2)" ||
                opTitle == "Cube (6a2)" || opTitle == "Rectangular Prism (2lw + 2lh + 2wh)" || opTitle == "Sphere (4" + PI + "r2)" ||
                opTitle == "Cylinder (2" + PI + "r2 + 2" + PI + "rh)" || opTitle == "Cone (" + PI + "r2 + " + PI + "r(" + SQRT + "(h2 + r2)))" ||
                opTitle == "Pyramid (s2 + 2sl)" || opTitle == "Cube (a3)" || opTitle == "Rectangular Prism (lwh)" || opTitle == "Cylinder (" + PI + "r2h)" ||
                opTitle == "Pyramid ((1/3)bh)" || opTitle == "Cone ((1/3)" + PI + "r2h)" || opTitle == "Sphere ((4/3)" + PI + "r3)" ||
                opTitle == "Ellipsoid ((4/3)" + PI + "r1r2r3)"){
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
        if(opTitle == "Rectangle (bh)"){
            mPhysTitle1.setText("Base");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Trapezoid (h/2 * (b1 + b2))"){
            mPhysTitle1.setText("Height");
            mPhysTitle2.setText("Upper Base");
            mPhysTitle3.setText("Lower Base");
        }
        if(opTitle == "Circle (" + PI + "r2)"){
            mTitle.setText("Circle (" + PI + superscript("r2)"));
            mPhysTitle1.setText("Radius");

            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Ellipse (" + PI + "r1r2)"){
            mPhysTitle1.setText("Radius 1");
            mPhysTitle2.setText("Radius 2");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Cube (6a2)"){
            mTitle.setText("Cube (6" + superscript("a2)"));
            mPhysTitle1.setText("Side (a)");

            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Rectangular Prism (2lw + 2lh + 2wh)"){
            mPhysTitle1.setText("Length");
            mPhysTitle2.setText("Width");
            mPhysTitle3.setText("Height");
        }
        if(opTitle == "Sphere (4" + PI + "r2)"){
            mTitle.setText("Sphere (4" + PI + superscript("r2)"));
            mPhysTitle1.setText("Radius");

            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Cylinder (2" + PI + "r2 + 2" + PI + "rh)"){
            mTitle.setText("Cylinder (2" + PI + superscript("r2") + " + 2" + PI + "rh)");
            mPhysTitle1.setText("Radius");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Cone (" + PI + "r2 + " + PI + "r(" + SQRT + "(h2 + r2)))"){
            mTitle.setText("Cone (" + PI + superscript("r2 + ") +  PI + "r(" + SQRT + superscript("h2 + r2)))"));
            mPhysTitle1.setText("Radius");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Pyramid (s2 + 2sl)"){
            mTitle.setText("Pyramid (" + superscript("s2") + " + 2sl)");
            mPhysTitle1.setText("Side");
            mPhysTitle2.setText("Length");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Cube (a3)"){
            mTitle.setText(superscript("Cube (a3)"));
            mPhysTitle1.setText("Side (a)");

            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Rectangular Prism (lwh)"){
            mPhysTitle1.setText("Length");
            mPhysTitle2.setText("Width");
            mPhysTitle3.setText("Height");
        }
        if(opTitle == "Cylinder (" + PI + "r2h)"){
            mTitle.setText("Cylinder (" + PI + superscript("r2h)"));
            mPhysTitle1.setText("Radius");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if (opTitle == "Pyramid ((1/3)bh)"){
            mPhysTitle1.setText("Base");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Cone ((1/3)" + PI + "r2h)"){
            mTitle.setText("Cone ((1/3)" + PI + superscript("r2h)"));
            mPhysTitle1.setText("Radius");
            mPhysTitle2.setText("Height");

            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Sphere ((4/3)" + PI + "r3)"){
            mTitle.setText("Sphere ((4/3)" + PI + superscript("r3)"));
            mPhysTitle1.setText("Radius");

            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(View.INVISIBLE);
        }
        if(opTitle == "Ellipsoid ((4/3)" + PI + "r1r2r3)"){
            mPhysTitle1.setText("Radius 1");
            mPhysTitle2.setText("Radius 2");
            mPhysTitle3.setText("Radius 3");
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
                if(opTitle == "Rectangle (bh)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.RectangleArea(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Trapezoid (h/2 * (b1 + b2))"){
                    int counter = 3;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        float result3 = Float.parseFloat(mPhysSub3.getText().toString());
                        mResult.setText(geoCalc.TrapezoidArea(result, result2, result3));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Circle (" + PI + "r2)"){
                    int counter = 1;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        mResult.setText(geoCalc.CircleArea(result));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Ellipse (" + PI + "r1r2)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.EllipseArea(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Cube (6a2)"){
                    int counter = 1;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        mResult.setText(geoCalc.CubeSA(result));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Rectangular Prism (2lw + 2lh + 2wh)"){
                    int counter = 3;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        float result3 = Float.parseFloat(mPhysSub3.getText().toString());
                        mResult.setText(geoCalc.RectPrismSA(result, result2, result3));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Sphere (4" + PI + "r2)"){
                    int counter = 1;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        mResult.setText(geoCalc.SphereSA(result));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Cylinder (2" + PI + "r2 + 2" + PI + "rh)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.CylinderSA(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Cone (" + PI + "r2 + " + PI + "r(" + SQRT + "(h2 + r2)))"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.ConeSA(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Pyramid (s2 + 2sl)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.PyramidSA(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Cube (a3)"){
                    int counter = 1;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        mResult.setText(geoCalc.CubeVolume(result));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Rectangular Prism (lwh)"){
                    int counter = 3;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        float result3 = Float.parseFloat(mPhysSub3.getText().toString());
                        mResult.setText(geoCalc.RectPrismVolume(result, result2, result3));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Cylinder (" + PI + "r2h)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.CylinderVolume(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Pyramid ((1/3)bh)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.PyramidVolume(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Cone ((1/3)" + PI + "r2h)"){
                    int counter = 2;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        mResult.setText(geoCalc.ConeVolume(result, result2));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Sphere ((4/3)" + PI + "r3)"){
                    int counter = 1;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        mResult.setText(geoCalc.SphereVolume(result));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
                if(opTitle == "Ellipsoid ((4/3)" + PI + "r1r2r3)"){
                    int counter = 3;
                    if(checkInput(counter)){
                        float result = Float.parseFloat(mPhsySub1.getText().toString());
                        float result2 = Float.parseFloat(mPhysSub2.getText().toString());
                        float result3 = Float.parseFloat(mPhysSub3.getText().toString());
                        mResult.setText(geoCalc.EllipsoidVolume(result, result2, result3));
                        mError.setVisibility(View.INVISIBLE);
                    }
                    else{
                        return;
                    }
                }
            }
        });
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

        if(mTitle.getText().toString() == "Kinetic Energy (1/2 * mv2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, velocityItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Kinetic Energy (p2/2m)"){
            mPhysTitle1.setText("Momentum");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Gravitational P.E (" + DELTA + "Ug = mg" + DELTA +"h)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysSub2.setText("9.81");
            mPhysTitle2.setText("Gravity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gravity);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Height");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Power (" + DELTA + "W/" + DELTA + "t)"){
            mPhysTitle1.setText("Work");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, work);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }
        if(mTitle.getText().toString() == "Hooke's Law (F = -k" + DELTA + "x)"){
            mPhysTitle1.setText("Constant (k)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, springConstant);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }
        if(mTitle.getText().toString() == "Angular Velocity (" + DELTA + THETA + "/" + DELTA + "t)"){
            mPhysTitle1.setText("Theta");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Angular Acceleration (" + DELTA + OMEGA + "/" + DELTA + "t)"){
            mPhysTitle1.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Angular Momentum (I" + OMEGA + ")"){
            mPhysTitle1.setText("Inertia");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Displacement (r" +  THETA + ")"){
            mPhysTitle1.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Theta");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Velocity (r" + OMEGA + ")"){
            mPhysTitle1.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Acceleration (r" + ALPHA + ")"){
            mPhysTitle1.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Acceleration (" + ALPHA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Centripetal Acceleration (v2/r)"){
            mPhysTitle1.setText("Velocity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, velocityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Centripetal Acceleration (" + OMEGA + "2/r)"){
            mPhysTitle1.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Centripetal Force (mv2/r)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, velocityItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            mPhysTitle3.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);
            mPhysUnits2.setSelection(1);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Angular Velocity (" + OMEGA + "0 + " + ALPHA + "t)"){
            mPhysTitle1.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Average Angular Velocity (1/2(" + OMEGA + "+" + OMEGA + "0))"){
            mPhysTitle1.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Initial Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Rotational Work (" + TAU + DELTA + THETA + ")"){
            mPhysTitle1.setText("Torque");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, torque);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Theta");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Rotational Power (" + TAU + OMEGA + ")"){
            mPhysTitle1.setText("Torque");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, torque);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Rotational Power (" + TAU + OMEGA + "cos(" + THETA + "))"){
            mPhysTitle1.setText("Torque");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, torque);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Theta");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Rotational K.E (K = 1/2 * I" + OMEGA + "2)"){
            mPhysTitle1.setText("Inertia");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Density (p = m/v)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularVelocityItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Pressure (P = F/A)"){
            mPhysTitle1.setText("Force");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, forceItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Acceleration");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, accelerationItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Change of Pressure (" + DELTA + "P = pgh)"){
            mPhysTitle1.setText("Density (p)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, densityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysSub2.setText("9.81");
            mPhysTitle2.setText("Gravity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gravity);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Height");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Dynamic Pressure (q = 1/2" + RHO + "v2)"){
            mPhysTitle1.setText("Density (" + RHO + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, densityItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Velocity");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, velocityItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Solid Sphere (I = 2/5 * MR2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Hollow Sphere (I = 2/3 * MR2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Solid Cylinder (I = 1/2 * MR2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Radius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Hollow Cylinder (I = 1/2 *  M(Ra2 + Rb2))"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Radius 1");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Radius 2");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Rect. Plate, Center Axis (I = 1/12 * M(a2 + b2))"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Side 1 (A)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Side 2 (B)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Rect. Plate, Edge Axis (I = 1/3 * Ma2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Side (A)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Slender Rod, Center Axis (I = 1/12 * ML2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Length");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Slender Rod, Edge Axis (I = 1/3 * ML2)"){
            mPhysTitle1.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Length");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.GONE);
        }

        if(mTitle.getText().toString() == "Position (x = A*cos(" + OMEGA + ")t)"){
            mPhysTitle1.setText("Amplitude");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, amplitude);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Omega");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Velocity (v = -A" + OMEGA + "*sin(" + OMEGA + ")t)"){
            mPhysTitle1.setText("Amplitude");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, amplitude);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Omega");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Acceleration (a = -A" + OMEGA + "2 * cos(" + OMEGA + ")t)"){
            mPhysTitle1.setText("Amplitude");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, amplitude);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Omega");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, thetaItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits3.setAdapter(adapter);
        }

        if(mTitle.getText().toString() == "Force (F = -kx)"){
            mPhysTitle1.setText("Constant (k)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Displacement");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthItems);
            mPhysUnits2.setAdapter(adapter);

            linearLayout3.setVisibility(View.INVISIBLE);
        }

        if(mTitle.getText().toString() == "Period (2" + PI + "/" + OMEGA + ")"){
            mPhysTitle1.setText("Angular Frequency (" + OMEGA + ")");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, angularFrequency);
            mPhysUnits1.setAdapter(adapter);

            linearLayout2.setVisibility(View.INVISIBLE);

            linearLayout3.setVisibility(View.INVISIBLE);
        }

        if(mTitle.getText().toString() == "Celsius (C = 5/9(F - 32))"){
            mPhysTitle1.setText("Degrees in Fahrenheit");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
            mPhysUnits1.setAdapter(adapter);

            linearLayout2.setVisibility(View.INVISIBLE);

            linearLayout3.setVisibility(View.INVISIBLE);
        }

        if(mTitle.getText().toString() == "Fahrenheit (F = 9/5*C + 32)"){
            mPhysTitle1.setText("Degrees in Celsius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
            mPhysUnits1.setAdapter(adapter);

            linearLayout2.setVisibility(View.INVISIBLE);

            linearLayout3.setVisibility(View.INVISIBLE);
        }

        if(mTitle.getText().toString() == "Kelvin (K = C + 273.15)"){
            mPhysTitle1.setText("Degrees in Celsius");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
            mPhysUnits1.setAdapter(adapter);

            linearLayout2.setVisibility(View.INVISIBLE);

            linearLayout3.setVisibility(View.INVISIBLE);
        }

        if(mTitle.getText().toString() == "Heat Lost in Water (" + DELTA + "Q = cm" + DELTA + "T)"){
            mPhysTitle1.setText("Specific Heat Capacity (c)");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, amplitude);
            mPhysUnits1.setAdapter(adapter);

            mPhysTitle2.setText("Mass");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, massItems);
            mPhysUnits2.setAdapter(adapter);

            mPhysTitle3.setText("Time");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeItems);
            mPhysUnits3.setAdapter(adapter);
        }

    }

    private void checkPhys(){
        enterBtn = findViewById(R.id.ops_page_enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(opTitle == "Force (F = ma)"){
                    int counter = 2;
                    if(checkInput(counter)){
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
                     else{
                        return;
                    }

                }

                if(opTitle == "Weight (W = mg)"){
                    int counter = 2;
                    if(checkInput(counter)){
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
                        mResult.setText(finalResult + superscript("kg*m/s2"));
                    } else{
                        return;
                    }

                }
                if(opTitle == "Acceleration (" + DELTA + "v/" + DELTA + "t)"){
                    int counter = 2;
                    if(checkInput(counter)){
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
                        if(mPhysUnits2.getSelectedItem().toString() == "hrs"){
                            result2 *= 3600;
                        }

                        float finalResult = result / result2;
                        String exp = "m/s2";
                        exp = superscript(exp);
                        mError.setVisibility(View.INVISIBLE);
                        mResult.setText(finalResult + exp);
                    } else{
                        return;
                    }

                }

                if(opTitle == "Momentum (p = mv)"){
                    int counter = 2;
                    if(checkInput(counter)){
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
                        mResult.setText(finalResult + superscript("kg * m/s"));
                    } else{
                        return;
                    }

                }
                if(opTitle == "Impulse (" + DELTA + "p = F" + DELTA + "t)"){
                    int counter = 2;
                    if(checkInput(counter)){
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
                    else{
                        return;
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
        else if (counter == 3){
            if(mPhsySub1.getText().toString().isEmpty() || mPhysSub2.getText().toString().isEmpty() ||
                    mPhysSub3.getText().toString().isEmpty()){
                mError.setText("**Please Fill in all Fields**");
                mError.setVisibility(View.VISIBLE);
                mResult.setText("");
                return false;
            }
            else if(mPhsySub1.getText().toString().matches("[a-zA-z]+") ||
                    mPhysSub2.getText().toString().matches("[a-zA-Z]+") ||
                    mPhysSub3.getText().toString().matches("[a-zA-Z]+") ||
                    (mPhsySub1.getText().toString().matches("[a-zA-z]+") &&
                            mPhysSub2.getText().toString().matches("[a-zA-Z]+") &&
                            mPhysSub3.getText().toString().matches("[a-zA-Z]+"))){
                mError.setText("**Invalid Input**");
                mError.setVisibility(View.VISIBLE);
                mResult.setText("");
                return false;
            }
        }

        return true;



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
