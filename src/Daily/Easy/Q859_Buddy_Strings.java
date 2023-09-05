package Daily.Easy;

//859. Buddy Strings

//Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

//Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].


import java.util.HashSet;
import java.util.Set;

public class Q859_Buddy_Strings {
    public static boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (s.equals(goal)) {
            Set<Character> temp = new HashSet<>();
            for (char c : s.toCharArray()) {
                temp.add(c);
            }
            return temp.size() < goal.length(); // Swapping same characters
        }

        int i = 0;
        int j = n - 1;

        while (i < j && s.charAt(i) == goal.charAt(i)) {
            i++;
        }

        while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
            j--;
        }

        if (i < j) {
            char[] sArr = s.toCharArray();
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            s = new String(sArr);
        }

        return s.equals(goal);
    }

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ab";
        System.out.println(buddyStrings(s, goal));
    }
}
