package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Scanner;

public class CalculatorActivity extends AppCompatActivity {

    //Results
    EditText resultShow;
    String resultString;
    float x;
    float y;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultShow = findViewById(R.id.calcResult);
        resultShow.setText(resultString);

        Calculator calc = new Calculator();


        //Inputs characters into result string
        linkButtonsForAppend();

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
                resultShow.append("-");
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
            }
        });

        parensBtn = findViewById(R.id.calcParens);
        parensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("()");
            }
        });

        expBtn = findViewById(R.id.calcExponents);
        expBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultShow.append("^");
            }
        });

        equalsBtn = findViewById(R.id.calcEquals);
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            Calculator calc = new Calculator();
            @Override
            public void onClick(View view) {
                if(resultShow.getText().toString().contains("+")){
                    Scanner scanner = new Scanner(resultShow.getText().toString());
                    scanner.useDelimiter("\\+");
                    x = Float.parseFloat(scanner.next());
                    y = Float.parseFloat(scanner.next());
                    resultShow.setText(calc.add(x, y));
                }
                if(resultShow.getText().toString().contains("-")){
                    Scanner scanner = new Scanner(resultShow.getText().toString());
                    scanner.useDelimiter("\\-");
                    x = Float.parseFloat(scanner.next());
                    y = Float.parseFloat(scanner.next());
                    resultShow.setText(calc.subtract(x, y));
                }
                if(resultShow.getText().toString().contains("*")){
                    Scanner scanner = new Scanner(resultShow.getText().toString());
                    scanner.useDelimiter("\\*");
                    x = Float.parseFloat(scanner.next());
                    y = Float.parseFloat(scanner.next());
                    resultShow.setText(calc.multiply(x, y));
                }
                if(resultShow.getText().toString().contains("/")){
                    Scanner scanner = new Scanner(resultShow.getText().toString());
                    scanner.useDelimiter("\\/");
                    x = Float.parseFloat(scanner.next());
                    y = Float.parseFloat(scanner.next());
                    resultShow.setText(calc.divide(x, y));
                }
                if(resultShow.getText().toString().contains("^")){
                    Scanner scanner = new Scanner(resultShow.getText().toString());
                    scanner.useDelimiter("\\^");
                    x = Float.parseFloat(scanner.next());
                    y = Float.parseFloat(scanner.next());
                    resultShow.setText(calc.exponent(x, y));
                }
            }
        });


    }
}
