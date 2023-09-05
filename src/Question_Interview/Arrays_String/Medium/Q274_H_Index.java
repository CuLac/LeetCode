package Question_Interview.Arrays_String.Medium;

/*

274. H-Index

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given
researcher has published at least h papers that have each been cited at least h times.

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1


Solution:
The citations[ ] array contains the number of citations for each paper.
The number of papers publish is citations.length.

This is actually a "counting sort", which simply counts the number of papers with x citations.
Some discussion entries call this a "bucket sort", but technically a counting sort is different in that a bucket sort
saves all of the original data. A counting sort throws out the original data, and only saves aggregate information.
Counting sorts are O(N). I don't really consider counting sorts to be real sorts, because the original data is lost.
I consider it more of a data analysis.

The h-index value cannot be higher than the total number of papers, so we only need the count sort to hold
values from 0 to the number of papers (citations.length). Papers with more citations than the number of papers,
will be counted as though they had number-of-papers citations.

 */

public class Q274_H_Index {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;

        int n = citations.length;
        int[] num = new int[n+1];

        for(int i=0; i<n; i++) {
            if(citations[i]>n) num[n]++;
            else num[citations[i]]++;
        }

        if(num[n]>=n) return n;
        for(int i=n-1; i>=0; i--) {
            num[i] += num[i+1];
            if(num[i]>=i) return i;
        }
        return 0;
    }

    public int hIndex_v2(int[] citations) {
        // Array to the contain the counts for number of papers
        // with x citations, where counts[x] will be the number of
        // papers with x citations.  Because the h value cannot be
        // larger than the number of papers, the last used count in
        // this array, count[citations.length], is a count of the
        // number of papers with citations.length or more citations.
        int[] counts = new int[citations.length + 2];

        // Build the counts of how many papers have x citations.
        // If a paper has more than citations.length citations, then
        // count it as citations.length citations.
        for (int i = citations.length - 1; i >= 0; i--)
            counts[Math.min(citations[i], citations.length)]++;

        // Go through the count[] array from last index down to 0, trying
        // successively smaller values for h.  Looping from high to low
        // possible values for h, will find the highest valid value for
        // h.  While descending through the count array, add the count
        // from the next higher index in the count array, which will
        // convert the current counts[h] value to become a count of
        // papers with h or more citations.  This is slightly confusing
        // because h is used as both an index and a value to compare to
        // the array value at that index.  The "units" for h feel
        // inconsistent.
        int h;
        for (h = citations.length; h > 0; h--) {
            counts[h] += counts[h + 1];
            if (counts[h] >= h)  break;
        }
        return h;
    }
}
