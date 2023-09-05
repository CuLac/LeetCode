package Question_Interview.Stack.Hard;

/*

224. Basic Calculator
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note: bai toan chi co cac phep + va -

Solution:
--> cach xu ly chi phu hop voi bai toan ma cac toan tu tinh toan co do uu tien giong nhau (+ và - hoăc * và /)

Simple iterative solution by identifying characters one by one. One important thing is that the input is valid,
which means the parentheses are always paired and in order.

Only 5 possible input we need to pay attention:

digit: it should be one digit from the current number

'+': number is over, we can add the previous number and start a new number

'-': same as above

'(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.

')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis,
second is the temporary result before this pair of parenthesis. We add them together.

Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.

 */


import java.util.Stack;

public class Q224_Basic_Calculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0; // dai dien cho cac toan tu so hoc trong bieu thuc
        int sign = 1; // dai dien cho bieu thuc (1=add, -1: minus)
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //xu ly nay tuong tu bai toan dao nguoc so(Ex: n = 123 => res += res * 10 + n/10)
                number = 10 * number + (c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                /*
                    truong hop dau ngoac thi phai xu ly bieu thuc trong ngoac truọc
                    --> luu gia tri res phia truoc dau ngoac vao stack
                    --> luu toan tu tinh toan phia truoc dau ngoac vao stack
                    --> tinh toan gia tri trong ngoac dau tien
                 */
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                /*
                    ket thuc bieu thuc trong ngoac
                    --> lay duoc gia tri cua bieu thuc trong ngoac
                    --> nhan voi' he so sign trong stack (-1: neu phia truoc bieu thuc trong ngoac la dau -;
                                                            1: neu phia truoc bieu thuc trong ngoac la dau +)
                    --> cong voi gia tri tinh toan thu duoc truoc bieu thuc trong ngoac
                 */
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        //cong gia tri cua toan tu so hoc cuoi cung trong bieu thuc
        if(number != 0) result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
