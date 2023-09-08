package Topic.Math;

/*

43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

 */

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q43_Multiply_Strings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int [] dp = new int[n+m];
        Arrays.fill(dp, 0);

        //thực hiện phép nhân từng đơn vị của num1 cho num2
        /*
            Example:
                10
              * 10
              -----
                 0
             + 10
              -----
               100
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');  //chuyen string -> integer
                //tao 2 bien luu gia tri cua phep tinh tren dong thoi luu phan du cho don vi tiep theo
                int p1 = i + j;
                int p2 = i + j + 1;
                sum = sum + dp[p2];
                dp[p1] += sum / 10;
                dp[p2] = sum % 10;
            }
        }
        StringBuilder stb = new StringBuilder();
        for (int i : dp) {

            //xét điều kiện để loại bỏ các giá trị 0 ở đầu
            if (!(stb.length() == 0 && i == 0)) {
                stb.append(i);
            }
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        System.out.println(multiply(a, b));
    }
}
