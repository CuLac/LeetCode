package Topic.SlidingWindow;

/*

424. Longest Repeating Character Replacement

You are given a string s and an integer k.
You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.



Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achive this answer too.

 */

public class Q424_Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char [] arr = s.toCharArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - k - 1; i++) {
            char start = arr[i];
            int j = i+1;
            int length = 1;
            int count = k;
            while (count >= 0 && j < n) {
                System.out.println("Arr[j]=" + arr[j]);
                if (arr[j] != start) {
                    count--;
                    if (count < 0) {
                        break;
                    }
                }
                j++;
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }

    public int characterReplacement_v2(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public int characterReplacement_v3(String s, int k) {
        // Make an array of size 26...
        int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k charactres. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen;      // Return the maximum length of repeating character...
    }

    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
