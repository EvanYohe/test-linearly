package com.linearly.model;

public class Fraction {

    /**
     * Takes a double and returns a string representation of the mixed fraction.
     * 
     * @param value
     * @return String 
     */
    public static String asFraction(double value) {
        int num = 1;
        int den = 1;
        while (Math.abs(value - (double) num / den) > 0.000001) {
            if (value > (double) num / den) {
                num++;
            } else {
                den++;
            }
        }
        return num + "/" + den;
    }

    /**
     * Takes a string representation of a mixed fraction and returns a double.
     * 
     * @param fraction
     * @return double
     */
    public static double asDecimal(String fraction) {
        String[] parts = fraction.split("/");
        return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
    }
}
