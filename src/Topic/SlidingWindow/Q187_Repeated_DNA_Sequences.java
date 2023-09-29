package Topic.SlidingWindow;

/*

187. Repeated DNA Sequences
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
You may return the answer in any order.



Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> resset = new HashSet<>();
        if (s == null || s.length() <= 10) {
            return res;
        }
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                resset.add(sub);
            }
        }
        res.addAll(resset);
        return res;
    }
}
