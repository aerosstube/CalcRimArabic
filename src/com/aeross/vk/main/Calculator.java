package com.aeross.vk.main;

public class Calculator implements CalculatorPres {
    private String input;
    private int[] numbers = new int[2];

    public Calculator(String input) {
        this.input = input;
    }


    public String getInput() {
        return input;
    }

    public static boolean isRimNumberIf(String el) {
        return el.equals("I") || el.equals("II") || el.equals("III") || el.equals("IV") || el.equals("V") ||
                el.equals("VI") || el.equals("VII") || el.equals("VIII") || el.equals("VIV") || el.equals("X");
    }

    public static boolean isArabicNumberIf(String el) {
        if(Integer.parseInt(el) < 0) throw new IllegalArgumentException("Число не может быть отрицательным!");


        return el.equals("1") || el.equals("2") || el.equals("3") || el.equals("4") || el.equals("5") ||
                el.equals("6") || el.equals("7") || el.equals("8") || el.equals("9") || el.equals("10");

    }

    @Override
    public boolean isRimNumber() {
        String[] numbersString = input.split(" ");
        for (String el : numbersString) {
            if (isRimNumberIf(el)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isArabicNumber() {
        String[] numbersString = input.split(" ");
        for (String el : numbersString) {
            if (isArabicNumberIf(el)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] rimIntoArabic() {
        String[] numbersString = input.split(" ");
        int[] res = new int[2];

        switch (numbersString[0]) {
            case "I":
                res[0] = 1;
                break;
            case "II":
                res[0] = 2;
                break;
            case "III":
                res[0] = 3;
                break;
            case "IV":
                res[0] = 4;
                break;
            case "V":
                res[0] = 5;
                break;
            case "VI":
                res[0] = 6;
                break;
            case "VII":
                res[0] = 7;
                break;
            case "VIII":
                res[0] = 8;
                break;
            case "VIV":
                res[0] = 9;
                break;
            case "X":
                res[0] = 10;
                break;
            default:
                throw new IllegalArgumentException("Вводимые числа не могут быть больше X либо отрицательными");
        }

        switch (numbersString[2]) {
            case "I":
                res[1] = 1;
                break;
            case "II":
                res[1] = 2;
                break;
            case "III":
                res[1] = 3;
                break;
            case "IV":
                res[1] = 4;
                break;
            case "V":
                res[1] = 5;
                break;
            case "VI":
                res[1] = 6;
                break;
            case "VII":
                res[1] = 7;
                break;
            case "VIII":
                res[1] = 8;
                break;
            case "VIV":
                res[1] = 9;
                break;
            case "X":
                res[1] = 10;
                break;
            default:
                throw new IllegalArgumentException("Вводимые числа не могут быть больше X либо отрицательными");
        }

        return res;
    }

    @Override
    public int[] arabicIntoArr() {
        String[] numbersString = input.split(" ");

        for (int i = 0; i < numbersString.length; i++) {
            if (numbersString[i].contains(".")) {
                throw new IllegalArgumentException("Нельзя использовать числа с плавующей точкой");
            }

        }

        return new int[]{Integer.parseInt(numbersString[0]), Integer.parseInt(numbersString[2])};
    }

    @Override
    public int[] stringIntoNumbers() {

        if (isRimNumber() && isArabicNumber()) {
            throw new IllegalArgumentException("Нельзя использовать одновременно разные системы счисления");
        }


        if (isArabicNumber()) {
            return arabicIntoArr();
        }

        return rimIntoArabic();
    }

    @Override
    public int addition() {
        return numbers[0] + numbers[1];
    }

    @Override
    public int subtraction() {
        return numbers[0] - numbers[1];
    }

    @Override
    public int division() {
        return numbers[0] / numbers[1];
    }

    @Override
    public int multiplication() {
        return numbers[0] * numbers[1];
    }

    @Override
    public String calculation() {
        if (input.split(" ").length <= 1) {
            throw new IllegalArgumentException("Это не является математической операцией");
        } else if (input.split(" ").length > 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (isArabicNumber() && (Integer.parseInt(input.split(" ")[0]) > 10 || Integer.parseInt(input.split(" ")[2]) > 10)) {
                throw new IllegalArgumentException("Вводимые числа не могут быть больше 10");
        }


        String sign = input.split(" ")[1];
        numbers = stringIntoNumbers();
        int res = 0;

        if(numbers[0] < 0 || numbers[1] < 0) throw new IllegalArgumentException("Число не может быть отрицательным!");


        switch (sign) {

            case "+":
                res = addition();
                break;
            case "-":
                res = subtraction();
                break;

            case "/":
                res = division();
                break;

            case "*":
                res = multiplication();
                break;

            default:
                throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        };



        if (isRimNumber()) {
            if (res == 0) {
                throw new IllegalArgumentException("Римское число не может быть нулем!");
            }

            return RomanNumeral.arabicToRoman(res);
        }

        return String.valueOf(res);
    }


}
