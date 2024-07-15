package Daily.Easy;

/*

338. Counting Bits
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10


Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

 */

import com.google.gson.Gson;

public class Q338_Counting_Bits {
    public static int[] countBits(int n) {
        /*

            When it comes to even numbers, i.e, 2,4,6,8, their binary should be like '10', '100', '110', '1000'
            so one notable difference is their unit digit is always 0, which means when you call >> 1- shift one bit rightwards
            and also means dividing by 2- would cause no change to the count of '1' in the binary string.

            Vice versa, when you meet odd numbers, shifting one bit rightwards always eliminates one '1' digit from original binary string,
            that is why we should "compensate" one '1' character to the count.

            To sum up, when you meet even number the count of '1's is always the same as its half number, on the other hand,
            remember to plus one to the odds' half number.

         */
        int[] f = new int[n + 1];
        for (int i=1; i<=n; i++) {
            int temp = i >> 1;
            f[i] = f[i >> 1] + (i & 1);
            System.out.println("F[i]=" + f[i]);
        }
        return f;
    }
}
