package com.example.calculator.CalculatorClasses;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ChemCalculator {
    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#########", otherSymbols);

    public String Density(float m, float v){
        return df.format(m / v);
    }
    public String NumMoles(float g, float m){
        return df.format(g / m);
    }
    public String Molarity(float n, float l){
        return df.format(n / l);
    }
    public String PercError(float m, float a){
        float result = ((m - a) / a) * 100;
        return df.format(result);
    }
    public String PercComp(float p, float w){
        float result = (p / w) * 100;
        return df.format(result);
    }
    public String RateOfReaction(float q, float t){
        return df.format(q / t);
    }
    public String Broglie(float h, float m, float v){
        float result = h / (m*v);
        return df.format(result);
    }
    public String EnergyOfWave(float h, float v){
        return df.format(h * v);
    }
    public String WaveRelation(float lambda, float v){
        return df.format(lambda * v);
    }
    public String Quantization(float n, float h, float u){
        return df.format(n * h * u);
    }
    public String Coulombs(float k, float q1, float q2, float r){
        float result = k * ((q1 * q2)/ (r * r));
        return df.format(result);
    }
    public String pH(float h){
        return df.format(-Math.log10(h));
    }
    public String pOH(float oh){
        return df.format(-Math.log10(oh));
    }
    public String PressureConcentration(float k, float r, float t, float n){
        float result = (float) (k * (Math.pow((r * t), n)));
        return df.format(result);
    }
    public String BPElevation(float k, float m){
        return df.format(k * m);
    }
    public String FPDepression(float k, float m){
        return df.format(k * m);
    }
    public String IdealGasPressure(float n, float r, float t, float v){
        float result = (n * r * t) / v;
        return df.format(result);
    }
    public String IdealGasVolume(float n, float r, float t, float p){
        float result = (n * r * t) / p;
        return df.format(result);
    }
    public String HeatReleased(float c, float m, float t){
        return df.format(c * m * t);
    }
    public String HeatTransfer(float m, float c, float t){
        return df.format(m * c * t);
    }
    public String Enthalpy(float p, float r){
        return df.format(p - r);
    }
    public String Entropy(float p, float r){
        return df.format(p - r);
    }
    public String FreeEnergy(float h, float t, float s){
        float result = h - (t * s);
        return df.format(result);
    }

}
