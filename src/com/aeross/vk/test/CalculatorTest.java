package com.aeross.vk.test;


import com.aeross.vk.main.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;




public class CalculatorTest {

    @Test
    public void testIsRimNumberIf() {
        Assertions.assertFalse(Calculator.isRimNumberIf("1"));
        Assertions.assertTrue(Calculator.isRimNumberIf("I"));
        Assertions.assertTrue(Calculator.isRimNumberIf("II"));
        Assertions.assertTrue(Calculator.isRimNumberIf("III"));
        Assertions.assertTrue(Calculator.isRimNumberIf("IV"));
        Assertions.assertTrue(Calculator.isRimNumberIf("V"));
        Assertions.assertTrue(Calculator.isRimNumberIf("VI"));
        Assertions.assertTrue(Calculator.isRimNumberIf("VII"));
        Assertions.assertTrue(Calculator.isRimNumberIf("VIII"));
        Assertions.assertTrue(Calculator.isRimNumberIf("VIV"));
        Assertions.assertTrue(Calculator.isRimNumberIf("X"));
    }
    @Test
    public void testIsArabicNumberIf() {
        Assertions.assertTrue(Calculator.isArabicNumberIf("1"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("2"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("3"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("4"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("5"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("6"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("7"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("8"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("9"));
        Assertions.assertTrue(Calculator.isArabicNumberIf("10"));
        Assertions.assertFalse(Calculator.isArabicNumberIf("X"));
    }


    @Test
    public void testIsArabicNumber() {
        Assertions.assertTrue(new Calculator("1 + 2").isArabicNumber());
        Assertions.assertTrue(new Calculator("I + 2").isArabicNumber());
        Assertions.assertFalse(new Calculator("").isArabicNumber());
    }

    @Test
    public void testIsRimNumber() {
        Assertions.assertFalse(new Calculator("1 + 2").isRimNumber());
        Assertions.assertTrue(new Calculator("I + 2").isRimNumber());
        Assertions.assertFalse(new Calculator("").isRimNumber());
    }


    @Test
    public void testRimToArabic() {
        Calculator calculator = new Calculator("I + I");
        Assertions.assertArrayEquals(new int[]{1, 1}, calculator.rimIntoArabic());
    }

    @Test
    public void testArabicToArr() {
        int[] temp = {1, 1};
        Calculator calculator = new Calculator("1 + 1");
        Assertions.assertArrayEquals(new int[]{1, 1}, calculator.arabicIntoArr());
    }

    @Test
    public void testCalculation(){
        Assertions.assertEquals("2", new Calculator("1 + 1").calculation());
        Assertions.assertEquals("4", new Calculator("2 + 2").calculation());
        Assertions.assertEquals("20", new Calculator("10 + 10").calculation());

        Assertions.assertEquals("V", new Calculator("I + IV").calculation());
        Assertions.assertEquals("VI", new Calculator("II + IV").calculation());
        Assertions.assertEquals("XX", new Calculator("X + X").calculation());

        Assertions.assertEquals("I", new Calculator("X / X").calculation());
        Assertions.assertEquals("II", new Calculator("V / II").calculation());
        Assertions.assertEquals("I", new Calculator("I / I").calculation());

        Assertions.assertEquals("1", new Calculator("10 / 10").calculation());
        Assertions.assertEquals("2", new Calculator("5 / 2").calculation());
        Assertions.assertEquals("1", new Calculator("1 / 1").calculation());


        Assertions.assertEquals("C", new Calculator("X * X").calculation());
        Assertions.assertEquals("XII", new Calculator("VI * II").calculation());
        Assertions.assertEquals("I", new Calculator("I * I").calculation());

        Assertions.assertEquals("100", new Calculator("10 * 10").calculation());
        Assertions.assertEquals("12", new Calculator("6 * 2").calculation());
        Assertions.assertEquals("1", new Calculator("1 * 1").calculation());

    }

}
