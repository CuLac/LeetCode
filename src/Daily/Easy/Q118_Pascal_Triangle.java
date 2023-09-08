package Daily.Easy;

/*

118. Pascal's Triangle
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]



Example 2:

Input: numRows = 1
Output: [[1]]

 */

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Q118_Pascal_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int idx = 1;
        while (idx <= numRows) {
            int numb = 1;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= idx; i++) {
               list.add(numb);
               numb = numb * (idx - i) / i;
            }
            res.add(list);
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
