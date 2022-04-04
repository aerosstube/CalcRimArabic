package com.aeross.vk.startProject;

import com.aeross.vk.main.Calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите числа для подсчитывания (пример ввода: '1 + 2' (P.S. НЕ ЗАБЫВАЙТЕ ПРО ПРОБЕЛ МЕЖДУ ЧИСЛОМ И ОПЕРАТОРОМ!!!) ): ");
        String input = in.nextLine();

        Calculator calculator = new Calculator(input);
        System.out.printf("Результат: %s", calculator.calculation());

        in.close();
    }
}
