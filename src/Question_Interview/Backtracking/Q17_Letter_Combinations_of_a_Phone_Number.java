package Question_Interview.Backtracking;

/*

17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]



Example 2:

Input: digits = ""
Output: []



Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 */

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Q17_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }

        //khoi tao mang du lieu chua cac ki tu tren ban phim dien thoai
        String [] arr = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            //lay gia tri number cua ki tu thu i trong string digits
            int numb = Character.getNumericValue(digits.charAt(i));
            int j = 0;

            // vong lap do do dai cua chuoi digit se tuong ung do dai cua 1 gia tri bat ki trong list
            // quet toan bo du lieu trong list
            while (list.size() == 0 || list.get(0).length() == i) {
                String t = "";
                if (list.size() > 0) {
                    t = list.get(0);    // lay ra gia tri dau tien trong chuoi
                    list.remove(0); // remove gia tri dau tien trong chuoi de thuc hien xu ly
                }

                // vong for de map cac gia tri cua numb tai vi tri i voi chuoi thu duoc tu vi tri 0 --> i - 1
                // dung vong for de lay het cac gia tri co the
                for (char c : arr[numb].toCharArray()) {
                    String value = t + c;
                    list.add(value);
                }
            }
        }
        return list;
    }
}
