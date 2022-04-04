package com.aeross.vk.main;

import java.util.Arrays;
import java.util.List;

enum RomanNumeral {
    M(1000), CM(900), D(500), CD(400),
    C(100), XC(90), L(50), XL(40),
    X(10), IX(9), V(5), IV(4), I(1);

    private final int value;
    RomanNumeral(int value) {
        this.value = value;
    }



    public static String arabicToRoman(int number) {

        if(number < 0) {
            throw new IllegalArgumentException( '[' + number + ']' + " В римской системе нет отрицательных чисел");
        }

        List<RomanNumeral> romanNumerals = Arrays.asList(RomanNumeral.values());

        int i = 0;
        StringBuilder result = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (symbol.value <= number) {
                result.append(symbol);
                number -= symbol.value;
            } else {
                i++;
            }
        }

        return result.toString();
    }




}