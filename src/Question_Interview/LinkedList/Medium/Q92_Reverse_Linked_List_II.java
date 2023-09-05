package Question_Interview.LinkedList.Medium;

/*

92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.

 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q92_Reverse_Linked_List_II {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        Queue<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();
        int leftCounter=1;
        ListNode root = head;
        while (root!=null){
            if(leftCounter<left){
                queue.add(root);
            } else if (left<=leftCounter && leftCounter<=right) {
                stack.add(root);
            }else {
                queue.add(root);
            }
            leftCounter++;
            root=root.next;
        }
        ListNode result;
        ListNode temp;
        if(left==1){
            result=stack.pop();
            temp=result;
            while(!stack.isEmpty()){
                temp.next=stack.pop();
                temp=temp.next;
            }
            while (!queue.isEmpty()){
                temp.next=queue.poll();
                temp=temp.next;
            }
        }else {
            int counter=2;
            result=queue.poll();
            temp=result;
            while (counter<left){
                temp.next=queue.poll();
                temp=temp.next;
                counter++;
            }
            while (!stack.isEmpty()){
                temp.next=stack.pop();
                temp=temp.next;
            }
            while (!queue.isEmpty()){
                temp.next=queue.poll();
                temp=temp.next;
            }

        }
        temp.next=null;
        return result;
    }
}
