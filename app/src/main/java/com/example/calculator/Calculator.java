package com.example.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Calculator {
    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#####", otherSymbols);

    public String add(float n1, float n2){
        return df.format(n1+n2);
    }

    public String subtract(float n1, float n2){
        return df.format(n1 - n2);
    }

    public String multiply(float n1, float n2){
        return df.format(n1 * n2);
    }

    public String divide(float n1, float n2){
        return df.format(n1 / n2);
    }

    public String exponent(float x, float n){
        float result = x;
        for(int i = 1; i < n; i++){
            result = result * x;
        }
        return df.format(result);
    }

    public float factorial(float x){
        if(x == 0){
            return 1;
        }
        else{
            return x * factorial(x-1);
        }
    }

    public float fibonacci(float x){
        if(x == 0){
            return 0;
        }
        else if(x == 1){
            return 1;
        }
        else{
            return fibonacci(x-1) + fibonacci(x-2);
        }
    }

    public String returnFloat(float x){
        return df.format(x);
    }


}
