package Question_Interview.Math.Medium;

/*

172. Factorial Trailing Zeroes
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.



Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.



Example 2:

Input: n = 5
Output: 1



Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0

 */


/*

    Solution

    - Số 0 ở cuối: 5 * số chẵn
    - Do trong 1 giai thừa số lượng số chẵn luôn lớn hơn số chia hết cho 5

    ----> Tìm số lượng thừa số 5 trong giai thừa

    Do cứ 5 phần tử lại có 1 thừa số 5 ----> lấy n chia cho 5 để ra số lượng số 0 cần tìm

    Do có 1 số phần tử như 25, 125... có nhiều hơn 1 phần tử 5 nên cần phải duyệt tiếp cho đến khi n = 0

 */

public class Q172_Factorial_Trailing_Zeroes {
    public static int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }
}
