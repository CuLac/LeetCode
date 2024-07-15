package Question_Interview.Math.Easy;

/*

69. Sqrt(x)
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.



Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

 */

public class Q69_Sqrt_X {
    public static int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long ans = 0;
        long l = 0;
        long h = x;
        while (l <= h) {
            long mid = (l + h) / 2;
            long res = mid * mid;
            if (res > x) {
                h = mid - 1;
            } else if (res < x) {
                l = mid + 1;
                ans = mid;
            } else
                return (int) mid;
        }
        return (int) ans;
    }

    //phương pháp sử dụng thuật toán tính căn bậc 2 Newton-Raphson (x[n+1] = 1 / 2 * (x[n] + S / x[n]))
    public int mySqrt_v2(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
