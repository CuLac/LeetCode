package Question_Interview.HashMap.Easy;

/*

202. Happy Number
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1


Example 2:

Input: n = 2
Output: false


---> phương pháp tối ưu cho các bài toán sử dụng circle: thuật toán FLOYD'S TORTOISE AND HARE

 */

import java.util.HashSet;
import java.util.Set;

public class Q202_Happy_Number {
    /*
        Cách bình thường sử dụng HashSet
        - Lưu các giá trị tổng chữ số trong 1 hashSet
        - Nếu sum đã tồn tại trong hashSet --> vào vòng circle --> false
     */
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        while (true) {
            int sum = square(n);
            if (sum == 1) {
                return true;
            } else {
                if (map.contains(sum)) {
                    return false;
                } else {
                    map.add(sum);
                    n = sum;
                }
            }
        }
    }


    //cách tối ưu sử dụng thuật toán floyd's tortoise and hare
    public boolean isHappy_v2(int n) {
        int slow = n;
        int fast = n;
        //while loop is not used here because initially slow and
        //fast pointer will be equal only, so the loop won't run.
        do {
//slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        //if a cycle exists, then the number is not a happy number
        //and slow will have a value other than 1

        return slow == 1;
    }

    private int square(int n) {
        int sum = 0;

        while (n != 0) {
            int mod = n%10;
            sum += mod*mod;
            n = n/10;
        }

        return sum;
    }
}
