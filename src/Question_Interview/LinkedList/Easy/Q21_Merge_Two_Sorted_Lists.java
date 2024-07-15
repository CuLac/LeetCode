package Question_Interview.LinkedList.Easy;

/*

21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q21_Merge_Two_Sorted_Lists {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }

        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        ListNode head = new ListNode();
        ListNode currentNode = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((listNode, t1) -> listNode.val - t1.val);
        queue.offer(list1);
        queue.offer(list2);

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            currentNode.next = new ListNode(node.val);
            currentNode = currentNode.next;
            if (node.next != null){
                queue.offer(node.next);
            }
        }
        return head.next;
    }

    public static ListNode mergeTwoLists_v2(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists_v2(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists_v2(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }


    //best solution
    public static ListNode mergeTwoLists_v3(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists_v3(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists_v3(l1, l2.next);
            return l2;
        }
    }
}
