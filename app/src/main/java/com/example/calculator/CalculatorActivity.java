package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
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
