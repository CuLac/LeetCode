package Topic.SlidingWindow.Easy;

/*
2269. Find the K-Beauty of a Number
The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

It has a length of k.
It is a divisor of num.
Given integers num and k, return the k-beauty of num.

Note:

Leading zeros are allowed.
0 is not a divisor of any value.
A substring is a contiguous sequence of characters in a string.



Example 1:

Input: num = 240, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "24" from "240": 24 is a divisor of 240.
- "40" from "240": 40 is a divisor of 240.
Therefore, the k-beauty is 2.
Example 2:

Input: num = 430043, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "43" from "430043": 43 is a divisor of 430043.
- "30" from "430043": 30 is not a divisor of 430043.
- "00" from "430043": 0 is not a divisor of 430043.
- "04" from "430043": 4 is not a divisor of 430043.
- "43" from "430043": 43 is a divisor of 430043.
Therefore, the k-beauty is 2.

 */

public class Q2269_Find_the_K_Beauty_of_a_Number {
    public static int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        if (str.length() < k) {
            return 0;
        }
        int res = 0;
        StringBuilder div = new StringBuilder();
        div.append(str, 0, k);
        int divisor = 0;
        for (int i = k; i < str.length(); i++) {
            divisor = Integer.parseInt(div.toString());
            if (divisor != 0 && num % divisor == 0) {
                res++;
            }
            div.deleteCharAt(0);
            div.append(str.charAt(i));
        }
        divisor = Integer.parseInt(div.toString());
        res += (num % divisor == 0) ? 1 : 0;
        return res;
    }
}
