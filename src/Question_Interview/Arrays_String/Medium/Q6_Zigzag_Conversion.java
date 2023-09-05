package Question_Interview.Arrays_String.Medium;

/*

6. Zigzag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

 */

import java.util.HashMap;
import java.util.Map;

public class Q6_Zigzag_Conversion {
    public static String convert(String s, int numRows) {
        if (s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder stb = new StringBuilder();
        int index = 1;
        char [] arr = s.toCharArray();
        HashMap<Integer, String> map = new HashMap<>();
        boolean revert = false;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index=" + index + "|Char=" + arr[i]);
           map.put(index, map.containsKey(index) ? map.get(index) + arr[i] : String.valueOf(arr[i]));
           if (index == 1) {
               revert = false;
           }
           if (index == numRows) {
               revert = true;
           }
           if (revert) {
               index--;
           } else {
               index++;
           }
        }

        for (Map.Entry<Integer, String> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + "|" + entrySet.getValue());
            stb.append(entrySet.getValue());
        }

        return stb.toString();
    }

    public static String convert_v2(String s, int numRows) {
        if(numRows == 1)    return s;

        String ans = "";
        int step = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++)
        {
            for(int j = i; j < s.length(); j += step)
            {
                ans += s.charAt(j);
                if(i >= 1 && i <= numRows - 2 && j + (step - 2 * i) < s.length())
                {
                    ans += s.charAt(j + step - 2 * i);
                }
            }
        }
        return ans;
    }

    public static String convert_v3(String s, int rowNum) {
        if (rowNum == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowNum; i++) {
            int lastPos = -1;
            for (int j = 0; true; j++) {
                int pos = -1;
                if (i == 0) {
                    pos = j * 2 * (rowNum - 1);
                } else if (i == rowNum - 1) {
                    pos = (rowNum - 1) + j * 2 * (rowNum - 1);
                } else {
                    if (j == 0) {
                        pos = i;
                        lastPos = pos;
                    } else if (j % 2 == 1) {
                        pos = lastPos + 2 * (rowNum - 1 - i);
                        lastPos = pos;
                    } else {
                        pos = lastPos + 2 * i;
                        lastPos = pos;
                    }
                }
                if (
                        pos >= s.length()
                ) {
                    break;
                }
                sb.append(s.charAt(pos));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        convert(s, 3);
    }
}
