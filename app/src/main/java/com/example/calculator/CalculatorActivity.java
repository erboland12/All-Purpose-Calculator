package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.CalculatorClasses.Calculator;
import com.example.calculator.RecyclerViewActivities.ChemActivity;
import com.example.calculator.RecyclerViewActivities.GeoActivity;
import com.example.calculator.RecyclerViewActivities.MiscellaneousActivity;
import com.example.calculator.RecyclerViewActivities.PhysicsActivity;
import com.example.calculator.RecyclerViewActivities.TrigActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Results
    EditText resultShow;
    String resultString;
    float x;
    float y;
    String test;

    //Calc Buttons
    Button oneBtn;
    Button twoBtn;
    Button threeBtn;
    Button fourBtn;
    Button fiveBtn;
    Button sixBtn;
    Button sevenBtn;
    Button eightBtn;
    Button nineBtn;
    Button negBtn;
    Button zeroBtn;
    Button dotBtn;
    Button plusBtn;
    Button minusBtn;
    Button timesBtn;
    Button divBtn;
    Button clearBtn;
    Button parensBtn;
    Button expBtn;
    Button equalsBtn;
    Button backBtn;

    //Constants
    public static final String SQRT = "\u221a";
    public static final String MINUS = "\u2212";

    //Drawer layout initialization
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //setNavigationViewListener();

        //Sets up DrawerLayout and ActionBar
//        mDrawerLayout = findViewById(R.id.drawer_layout2);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);
//
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();


        parensBtn = findViewById(R.id.calcParens);
        parensBtn.setText(SQRT);

        minusBtn = findViewById(R.id.calcMinus);
        minusBtn.setText(MINUS);

        resultShow = findViewById(R.id.calcResult);
        resultShow.setText(resultString);

        //Inputs characters into result string
        linkButtonsForAppend();

        resultShow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(resultShow.getText().toString().contains("+") ||
                        resultShow.getText().toString().contains("-") ||
                        resultShow.getText().toString().contains("*") ||
                        resultShow.getText().toString().contains("/") ||
                        resultShow.getText().toString().contains("^")){
                    plusBtn.setEnabled(false);
                    minusBtn.setEnabled(false);
                    divBtn.setEnabled(false);
                    timesBtn.setEnabled(false);
                    expBtn.setEnabled(false);
                }

                if(resultShow.getText().toString().length() > 1){
                    if (resultShow.getText().toString().charAt(0) == '0'){
                        resultShow.setText(resultShow.getText().toString().substring(1));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            //Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.menu_Geometry: {
                MovePage m = new MovePage();
                m.moveActivity(CalculatorActivity.this, GeoActivity.class);
                break;
            }
            case R.id.menu_Chem: {
                MovePage m = new MovePage();
                m.moveActivity(CalculatorActivity.this, ChemActivity.class);
                break;
            }
            case R.id.menu_Trig: {
                MovePage m = new MovePage();
                m.moveActivity(CalculatorActivity.this, TrigActivity.class);
                break;
            }
            case R.id.menu_Phys: {
                MovePage m = new MovePage();
                m.moveActivity(CalculatorActivity.this, PhysicsActivity.class);
                break;
            }
            case R.id.menu_Misc: {
                MovePage m = new MovePage();
                m.moveActivity(CalculatorActivity.this, MiscellaneousActivity.class);
                break;
            }
            case R.id.settings:{
                MovePage m = new MovePage();
                m.moveActivity(CalculatorActivity.this, CalculatorActivity.class);
            }
            case R.id.quit_app:{
                finish();
                System.exit(0);
            }
        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void linkButtonsForAppend(){
        oneBtn = findViewById(R.id.calc1);
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("1");
            }
        });

        twoBtn = findViewById(R.id.calc2);
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("2");
            }
        });

        threeBtn = findViewById(R.id.calc3);
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("3");
            }
        });

        fourBtn = findViewById(R.id.calc4);
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("4");
            }
        });

        fiveBtn = findViewById(R.id.calc5);
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("5");
            }
        });

        sixBtn = findViewById(R.id.calc6);
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("6");
            }
        });

        sevenBtn = findViewById(R.id.calc7);
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("7");
            }
        });

        eightBtn = findViewById(R.id.calc8);
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("8");
            }
        });

        nineBtn = findViewById(R.id.calc9);
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("9");
            }
        });

        negBtn = findViewById(R.id.calcNeg);
        negBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("-");
            }
        });


        zeroBtn = findViewById(R.id.calc0);
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("0");
            }
        });

        dotBtn = findViewById(R.id.calcDot);
        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append(".");
            }
        });

        plusBtn = findViewById(R.id.calcPlus);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("+");
            }
        });

        minusBtn = findViewById(R.id.calcMinus);
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append(MINUS);
            }
        });

        timesBtn = findViewById(R.id.calcTimes);
        timesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("*");
            }
        });

        divBtn = findViewById(R.id.calcDiv);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("/");
            }
        });

        clearBtn = findViewById(R.id.calcClear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.setText("");
                enableBtns();
            }
        });

        parensBtn = findViewById(R.id.calcParens);
        parensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append(SQRT);
            }
        });

        expBtn = findViewById(R.id.calcExponents);
        expBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("^");
            }
        });

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(resultShow.getText().toString().length() <= 0){
                    resultShow.setText("");
                }
                else if(resultShow.getText().toString().length() <= 1){
                    enableBtns();
                }
                else{
                    String edit = resultShow.getText().toString();
                    String finalEdit = edit.substring(0, edit.length() - 1);
                    resultShow.setText(finalEdit);
                }

            }
        });
        equalsBtn = findViewById(R.id.calcEquals);
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            Calculator calc = new Calculator();
            @Override
            public void onClick(View view) {
                test = "0";
                if(resultShow.getText().toString().contains("+")){
                    try{
                        Scanner scanner = new Scanner(resultShow.getText().toString());
                        scanner.useDelimiter("\\+");

                        x = Float.parseFloat(scanner.next());
                        test = scanner.next();
                    } catch(NoSuchElementException err){
                        resultShow.setText("");
                    }

                    if(test.contains(SQRT)){
                        y = Float.parseFloat(test.replace(SQRT, ""));
                        float newY = (float) Math.sqrt(y);
                        resultShow.setText(calc.add(x, newY));
                    } else{
                        y = Float.parseFloat(test);
                        resultShow.setText(calc.add(x, y));
                    }

                }
                if(resultShow.getText().toString().contains(MINUS)){
                    try{
                        Scanner scanner = new Scanner(resultShow.getText().toString());
                        scanner.useDelimiter("\\u2212");

                        x = Float.parseFloat(scanner.next());
                        test = scanner.next();
                    } catch(NoSuchElementException err){
                        resultShow.setText("");
                    }
                    if(test.contains(SQRT)){
                        y = Float.parseFloat(test.replace(SQRT, ""));
                        float newY = (float) Math.sqrt(y);
                        resultShow.setText(calc.subtract(x, newY));
                    } else{
                        y = Float.parseFloat(test);
                        resultShow.setText(calc.subtract(x, y));
                    }
                }
                if(resultShow.getText().toString().contains("*")){
                    try{
                        Scanner scanner = new Scanner(resultShow.getText().toString());
                        scanner.useDelimiter("\\*");

                        x = Float.parseFloat(scanner.next());
                        test = scanner.next();
                    } catch(NoSuchElementException err){
                        resultShow.setText("");
                    }
                    if(test.contains(SQRT)){
                        y = Float.parseFloat(test.replace(SQRT, ""));
                        float newY = (float) Math.sqrt(y);
                        resultShow.setText(calc.multiply(x, newY));
                    } else{
                        y = Float.parseFloat(test);
                        resultShow.setText(calc.multiply(x, y));
                    }
                }
                if(resultShow.getText().toString().contains("/")){
                    try{
                        Scanner scanner = new Scanner(resultShow.getText().toString());
                        scanner.useDelimiter("\\/");

                        x = Float.parseFloat(scanner.next());
                        test = scanner.next();
                    } catch(NoSuchElementException err){
                        resultShow.setText("");
                    }
                    if(test.contains(SQRT)){
                        y = Float.parseFloat(test.replace(SQRT, ""));
                        float newY = (float) Math.sqrt(y);
                        resultShow.setText(calc.divide(x, newY));
                    } else{
                        y = Float.parseFloat(test);
                        resultShow.setText(calc.divide(x, y));
                    }
                }
                if(resultShow.getText().toString().contains("^")){
                    try{
                        Scanner scanner = new Scanner(resultShow.getText().toString());
                        scanner.useDelimiter("\\^");

                        x = Float.parseFloat(scanner.next());
                        test = scanner.next();
                    } catch(NoSuchElementException err){
                        resultShow.setText("");
                    }
                    if(test.contains(SQRT)){
                        y = Float.parseFloat(test.replace(SQRT, ""));
                        float newY = (float) Math.sqrt(y);
                        resultShow.setText(calc.exponent(x, newY));
                    } else{
                        y = Float.parseFloat(test);
                        resultShow.setText(calc.exponent(x, y));
                    }
                }
                if(resultShow.getText().toString().contains(SQRT)){
                    try {
                        Scanner scanner = new Scanner(resultShow.getText().toString());
                        scanner.useDelimiter("\\u221a");
                        test = scanner.next();
                    } catch(NoSuchElementException err){
                        resultShow.setText("");
                    }
                    if(test.charAt(0) == '-'){
                        resultShow.setText("");
                    }
                    else{
                        x = Float.parseFloat(test);
                        resultShow.setText(calc.squareRoot(x));
                    }
                }
                enableBtns();
            }

        });
    }


    private void enableBtns(){
        plusBtn.setEnabled(true);
        minusBtn.setEnabled(true);
        divBtn.setEnabled(true);
        timesBtn.setEnabled(true);
        expBtn.setEnabled(true);
    }
}
