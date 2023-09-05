package Daily.Medium;

/*

86. Partition List
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]


Example 2:

Input: head = [2,1], x = 2
Output: [1,2]

 */

import com.google.gson.Gson;

public class Q86_Partition_List {
    public static class ListNode {
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

    public static ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode before_curr = before;
        ListNode after_curr = after;

        while(head != null) {
            if(head.val < x) {
                before_curr.next = head;
                before_curr = before_curr.next;
            } else {
                after_curr.next = head;
                after_curr = after_curr.next;
            }
            head = head.next;
        }

        after_curr.next = null;
        before_curr.next = after.next;

        return before.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode head = null;
        node.next = node2;
        node2.next = node3;
        System.out.println(new Gson().toJson(node));
        while (node.next != null) {
            if (node.val >= 20) {
                head = node;
            }
            node = node.next;
        }
        System.out.println(new Gson().toJson(node));
        System.out.println(new Gson().toJson(head));

        ListNode nodeTest = new ListNode(10);
    }
}
