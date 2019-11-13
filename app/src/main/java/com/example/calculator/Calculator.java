package com.example.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Calculator {
    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.##", otherSymbols);

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

    public String squareRoot(float x){
        double newX = (float) Math.sqrt(x);
        String result = Double.toString(newX);
        return result;
    }

    public String mod(int mod1, int mod2){
        return Integer.toString(mod1 % mod2);
    }

    public String cosine(float theta){
        double newTheta = (float) Math.cos(theta);
        String result = Double.toString(newTheta);
        return result;
    }

    public String sine(float theta){
        double newTheta = (float) Math.sin(theta);
        String result = Double.toString(newTheta);
        return result;
    }

    public String tan(float theta){
        double newTheta = (float) Math.tan(theta);
        String result = Double.toString(newTheta);
        return result;
    }

    public String arccos(double x1, double x2){
        return Double.toString(Math.acos(x1/x2));
    }

    public String arcsin(double x1, double x2){
        return Double.toString(Math.asin(x1/x2));
    }

    public String arctan(double x1, double x2){
        return Double.toString(Math.atan(x1/x2));
    }

    public String arctanDegrees(double x){
        return Double.toString(Math.atan(x));
    }

    public String returnFloat(float x){
        return df.format(x);
    }


}
