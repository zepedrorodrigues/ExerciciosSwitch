package org.example;

public class Ex10 {
    public static boolean checkIfValidCurrency(String Currency) {
        boolean option = false;
        String[] valid_currencies = {"D", "L", "I", "C", "F"};
        for (int i = 0; i < valid_currencies.length; i++)
            if (valid_currencies[i] == Currency)
                option = true;
        return option;
    }

    public static double currencyConverter(double value, String Currency) {
        boolean valid = checkIfValidCurrency(Currency);
        if (valid == false || value < 0)
            return -1;
        switch (Currency) {
            case "D":
                return value * 1.534;
            case "L":
                return (value * 0.774);
            case "I":
                return value * 161.480;
            case "C":
                return value * 9.593;
            default:
                return value * 1.601;
        }

    }
}
