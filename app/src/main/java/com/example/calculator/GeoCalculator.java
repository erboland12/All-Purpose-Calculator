package com.example.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GeoCalculator {
    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#####", otherSymbols);

    public String SquareArea(float a){
        return df.format(a * a);
    }

    public String TriangleArea(float b, float h){
        float result = (float) (0.50 * (b * h));
        return df.format(result);
    }

    public String RectangleArea(float b, float h){
        return df.format(b * h);
    }

    public String TrapezoidArea(float h, float b1, float b2){
        float result = (h/2) * (b1 + b2);
        return df.format(result);
    }

    public String CircleArea(float r){
        float result = (float) (Math.PI * (r * r));
        return df.format(result);
    }

    public String EllipseArea(float r1, float r2){
        float result = (float) (Math.PI * (r1 * r2));
        return df.format(result);
    }

    public String CubeSA(float a){
        return df.format(6 * (a * a));
    }

    public String RectPrismSA(float l, float w, float h){
        float result = (2 * l * w) + (2 * l * h) + (2 * w * h );
        return df.format(result);
    }

    public String SphereSA(float r){
        return df.format(4 * Math.PI * (r * r));
    }

    public String CylinderSA(float r, float h){
        float result = (float) ((2 * Math.PI * (r * r)) + (2 * Math.PI * (r * h)));
        return df.format(result);
    }

    public String ConeSA(float r, float h){
        float result = (float) ((Math.PI * (r * r)) + ((Math.PI * r) * Math.sqrt((h * h) + (r * r))));
        return df.format(result);
    }

    public String PyramidSA(float s, float l){
        float result = (s * s) + (2 * s * l);
        return df.format(result);
    }

    public String CubeVolume(float a){
        return df.format(a * a * a);
    }

    public String RectPrismVolume(float l, float w, float h){
        return df.format(l * w * h);
    }

    public String CylinderVolume(float r, float h){
        float result = (float) (Math.PI * (r * r) * h);
        return df.format(result);
    }

    public String PyramidVolume(float b, float h){
        return df.format((1/3) * b * h);
    }

    public String ConeVolume(float r, float h){
        float result = (float) ((1/3) * Math.PI * (r * r) * h);
        return df.format(result);
    }

    public String SphereVolume(float r){
        float result = (float) ((4/3) * Math.PI * (r * r * r));
        return df.format(result);
    }

    public String EllipsoidVolume(float r1, float r2, float r3){
        float result = (float) ((4/3) * Math.PI * (r1 * r2 * r3));
        return df.format(result);
    }
}