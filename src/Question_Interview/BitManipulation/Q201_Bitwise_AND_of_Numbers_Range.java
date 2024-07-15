package Question_Interview.BitManipulation;

/*

201. Bitwise AND of Numbers Range
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.



Example 1:

Input: left = 5, right = 7
Output: 4


Example 2:

Input: left = 0, right = 0
Output: 0


Example 3:

Input: left = 1, right = 2147483647
Output: 0

 */

public class Q201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) right &= right - 1;
        return right;
    }
}
