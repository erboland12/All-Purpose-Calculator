package com.example.calculator.CalculatorClasses;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

import static com.example.calculator.RecyclerViewActivities.OperationsActivity.superscript;

public class Derivative {


    public String deriveConstant() {
        return "";
    }

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#####", otherSymbols);

    public String derivative(String submit) {
        if (submit.matches("[0-9]+") && !submit.matches("[a-zA-z]+")) {
            return "";
        } else if (!submit.contains("^")) {
            return submit.substring(0, submit.length() - 1);
        } else {
            Scanner scanner = new Scanner(submit);
            scanner.useDelimiter("\\^");
            String x = scanner.next();
            float y = Float.parseFloat(scanner.next());
            if (y < -1){
                float newX = Float.parseFloat(x.substring(0, x.length() - 1));
                String end = superscript(df.format(-y + 1));
                String finalX = df.format(newX * y) + "/x" + end;
                return finalX;
            }
            if (y == 1) {
                return x.replace("x", "");
            }

            if (y == 2) {
                float newX = Float.parseFloat(x.substring(0, x.length() - 1));
                String finalX = df.format(newX * y) + "x";
                return finalX;
            }
            if (y >= 3) {
                float newX = Float.parseFloat(x.substring(0, x.length() - 1));
                String start = df.format(newX * y);
                String end = superscript(df.format(y - 1));
                String finalX = start + "x" + end;
                return finalX;
            }
        }
        return null;
    }
}

