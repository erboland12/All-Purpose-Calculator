package com.example.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PhysCalcultor {
    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    // Define the maximum number of decimals (number of symbols #)
    DecimalFormat df = new DecimalFormat("#.#########", otherSymbols);

    public String KineticEnergy(float m, float v){
        float result = (1/2) * m * (v * v);
        return df.format(result);
    }
    public String KineticEnergy2(float p, float m){
        float result = (p * p) / (2 * m);
        return df.format(result);
    }
    public String GravPE(float m, float g, float h){
        return df.format(m * g * h);
    }
    public String Power(float w, float t){
        return df.format(w / t);
    }
    public String Hooke(float k, float x){
        return df.format(-k * x);
    }
    public String AngularVelocity(float theta, float t){
        return df.format(theta / t);
    }
    public String AngularAcceleration(float omega, float t){
        return df.format(omega / t);
    }
    public String AngularMomentum(float I, float omega){
        return df.format(I * omega);
    }
    public String AngularDisplacement(float r, float theta){
        return df.format(r * theta);
    }
    public String VelocityFromAngle(float r, float omega){
        return df.format (r * omega);
    }
    public String AccelerationFromAngle(float r, float alpha){
        return df.format(r * alpha);
    }
    public String CentripetalAcceleration(float v, float r){
        return df.format((v * v) / r);
    }
    public String CentripetalForce(float m, float v, float r){
        float result = (m * (v * v)) / r;
        return df.format(result);
    }
    public String RotationAngularVelocity(float omega, float alpha, float t){
        return df.format(omega + (alpha * t));
    }
    public String AverageRotationalAngularVelocity(float omega, float omegaI){
        return df.format(1/2 * (omega + omegaI));
    }
    public String RotationalWork(float tau, float theta){
        return df.format(tau * theta);
    }
    public String RotationalPower(float tau, float omega){
        return df.format(tau * omega);
    }
    public String RotationalPower2(float tau, float omega, float theta){
        float result = (float) ((tau * omega) * Math.cos(theta));
        return df.format(result);
    }
    public String RotationalKE(float I, float omega){
        float result = (1/2) * (I * (omega * omega));
        return df.format(result);
    }
    public String FluidDensity(float m, float v){
        return df.format(m / v);
    }
    public String Pressure(float f, float a){
        return df.format(f / a);
    }
    public String DeltaPressure(float p, float g, float h){
        return df.format(p * g * h);
    }
    public String DynamicPressure(float rho, float v){
        float result = (1/2) * (rho * (v * v));
        return df.format(result);
    }
    public String KinematicViscosity(float eta, float rho){
        return df.format(eta / rho);
    }
    public String SolidCylinder(float m, float r){
        float result = (1/2) * (m * (r * r));
        return df.format(result);
    }
    public String SolidSphere(float m, float r){
        float result = (float) ((0.4) * (m * (r * r)));
        return df.format(result);
    }
    public String HollowSphere(float m, float r){
        float result = (2/3) * (m * (r * r));
        return df.format(result);
    }
    public String HollowCylinder(float m, float ra, float rb){
        float result = (1/2) * (m * ((ra * ra) + (rb * rb)));
        return df.format(result);
    }
    public String RectPlateCenter(float m, float a, float b){
        float result = (1/12) * (m * ((a * a) + (b * b)));
        return df.format(result);
    }
    public String RectPlateEdge(float m, float a){
        float result = (1/3) * (m * ((a * a)));
        return df.format(result);
    }
    public String RodCenter(float m, float l){
        float result = (1/12) * (m * (l * l));
        return df.format(result);
    }
    public String RodEdge(float m, float l){
        float result = (1/3) * (m * (l * l));
        return df.format(result);
    }
    public String HarmonicPosition(float a, float omega, float t){
        float result = (float) (a * (Math.cos(omega) * t));
        return df.format(result);
    }
    public String HarmonicVelocity(float a, float omega, float t){
        float result = (float) ((-a * omega) * (Math.sin(omega) * t));
        return df.format(result);
    }
    public String HarmonicAcceleration(float a, float omega, float t){
        float result = (float) ((-a * (omega * omega)) * (Math.cos(omega) * t));
        return df.format(result);
    }
    public String HarmonicForce(float k, float x){
        return df.format(-k * x);
    }
    public String Period(float omega){
        return df.format((2 * Math.PI) / omega);
    }
    public String Celsius(float fahrenheit){
        float result = (5/9) * (fahrenheit - 32);
        return df.format(result);
    }
    public String Fahrenheit(float celsius){
        float result = ((9/5) * celsius) + 32;
        return df.format(result);
    }
    public String Kelvin(float celsius){
        float result = (float) (celsius + 273.15);
        return df.format(result);
    }
    public String HeatLost(float c, float m, float t){
        return df.format(c * m * t);
    }
    public String PressureOfIdealGas(float rho, float v){
        float result = (1/3) * (rho * (v * v));
        return df.format(rho);
    }
    public String KEIdealGas(float k, float t){
        float result = (3/2) * (k * t);
        return df.format(result);
    }

}
