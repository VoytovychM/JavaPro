package start.additional;

import javax.sound.midi.Soundbank;

public class BigDecimal {
    public static void main(String[] args) {
        double d = 117;
            if (d < Double.MAX_VALUE){
            d++;

        }
            System.out.println(d);
        double value = .012;
        double prSum = value + value + value;
        System.out.println(prSum);

        String strValue = Double.toString(value);
        System.out.println(strValue);
        java.math.BigDecimal bigValue = new java.math.BigDecimal(strValue);
        java.math.BigDecimal bSum = bigValue.add(bigValue).add(bigValue);
        System.out.println(bSum.toString());

        int int1 = 56;
        int int2 = int1;
        System.out.println("The int value is: " + int2);

        long longValue = int1;
        System.out.println("The long value is: " + longValue);

        short shortValue = (short) int1;
        System.out.println("The short value is: " + shortValue);

        int intValue3 = 1024;
        byte byteValue = (byte) intValue3;
        System.out.println("The byte value is: " + byteValue);

        double doubleValue = 3.999999d;
        int intValue4 = (int) doubleValue;
        System.out.println("The byte value is: " + intValue4);

        int sum1 = 56;
        int sum2 = 42;
        int result1 = sum1 + sum2;
        System.out.println("Addition: " + result1);
        int result2 = sum1 - sum2;
        System.out.println("Subtraction: " + result2);
        int result3 = sum1 * sum2;
        System.out.println("Multiplication: " + result3);
        double result4 = (double) sum1 / sum2;
        System.out.println("Devision: " + result4);
        double result5 = (double) sum1 % sum2;
        System.out.println("Remainder: " + result5);

        double double1 = -3.99999;
        long rounded = Math.round(double1);
        System.out.println("Rounded: " + rounded);
        double doubleAbs = Math.abs(double1);
        System.out.println("Absolute: " + doubleAbs);

    }
    }

