package Question_Interview.Arrays_String.Easy;

/*

58. Length of Last Word
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 */

public class Q58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String [] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    public int lengthOfLastWord_v2(String s) {
        int lenthOfLastWord = 0;

        // we need last word so let traverse from last to first
        for(int i=s.length()-1;i>=0;i--) {
            // if our char is not space then it will defenately a word
            if(s.charAt(i)!=' ') {
                //counting the length
                lenthOfLastWord++;
            }else{
                // if " " space comes after word we only need to return the length of the word
                if(lenthOfLastWord>0) return lenthOfLastWord;
            }
        }
        // if string contains only single word then this return works...
        return lenthOfLastWord;
    }
}
