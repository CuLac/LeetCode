package Daily.Medium;

/*

316. Remove Duplicate Letters
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order among all possible results.



Example 1:

Input: s = "bcabc"
Output: "abc"


Example 2:

Input: s = "cbacdcbc"
Output: "acdb"

 */

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Q316_Remove_Duplicate_Letters {
    public static String removeDuplicateLetters(String s) {
        if (s.length() < 2) {
            return s;
        }
        int [] lastIndex = new int[26];
        char [] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            lastIndex[arr[i] - 'a'] = i;
        }
        boolean [] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int curr = arr[i] - 'a';
            if (seen[curr]) continue; //neu character da ton tai trong stack (do yeu cau moi ki tu chi xuat hien 1 lan)
            // kiem tra de lay ra string có thứ tự nhỏ nhất theo alphabet
            while (!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek()] > i) {
                seen[stack.pop()] = false;
            }
            stack.push(curr);
            seen[curr] = true;
        }
        StringBuilder stb = new StringBuilder();
        while (!stack.isEmpty()) {
            int val = stack.pop() + 'a';
            char c = (char) val;
            stb.append(c);
        }
        return stb.reverse().toString();
    }
}
