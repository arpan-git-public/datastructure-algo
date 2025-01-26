package org.example.Strings;

public class LT415AddStrings {
    /**
     * Given two non-negative integers, num1 and num2 represented as string,
     * return the sum of num1 and num2 as a string.
     * <p>
     * You must solve the problem without using any built-in library for handling
     * large integers (such as BigInteger). You must also not convert the inputs
     * to integers directly.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: num1 = "11", num2 = "123"
     * Output: "134"
     * Example 2:
     * <p>
     * Input: num1 = "456", num2 = "77"
     * Output: "533"
     * Example 3:
     * <p>
     * Input: num1 = "0", num2 = "0"
     * Output: "0"
     */

    public String addStrings(String num1, String num2) {

        StringBuilder builder = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int numI = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int numJ = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = numI + numJ + carry;
            int digit = sum % 10;
            carry = sum / 10;

            builder.append(digit);
            i--;
            j--;
        }

        return builder.reverse().toString();

    }

    public static void main(String[] args) {

        LT415AddStrings lt = new LT415AddStrings();
        System.out.println(lt.addStrings("9990", "1"));


    }
}
