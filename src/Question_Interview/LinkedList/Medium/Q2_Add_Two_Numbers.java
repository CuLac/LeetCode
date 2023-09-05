package Question_Interview.LinkedList.Medium;

/*

2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */

public class Q2_Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //taken head to put this pointer on l1
        ListNode head = l1;
        //prev is used  for case when l1!=l2
        ListNode prev = null;

          /*this loop add the numbers from both the list
            and work until one of the  list is exhausted */
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;

            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;


        }
        //Below Loop is to add the remaining node of l1 CASE:(l2<l1)
        while (l1 != null) {
            int sum = l1.val + carry;

            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;

        }

        //Below Loop is to add the remaining node of l2 CASE:(l2>l1)
        while (l2 != null) {

            int sum = l2.val + carry;


            l2.val = sum % 10;
            prev.next = l2;
            prev = l2;
            l2 = l2.next;


            carry = sum / 10;

        }
        //below if is used for if there is carry left to be added
        if (carry > 0) {
            ListNode temp = new ListNode();

            temp.val = carry;
            prev.next = temp;
            temp.next = null;
        }

        return head;
    }
}
