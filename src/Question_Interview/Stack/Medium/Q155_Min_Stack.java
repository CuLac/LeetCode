package Question_Interview.Stack.Medium;

/*

155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

- MinStack() initializes the stack object.
- void push(int val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

 */

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q155_Min_Stack {
    LinkedList<Integer> list = new LinkedList<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int min = 0;
    int index = -1;
    int minIdx = 0;

    public Q155_Min_Stack() {

    }

    public void push(int val) {
        list.push(val);
        queue.add(val);
        index++;
        if (val < min) {
            min = val;
            minIdx = index;
        }
    }

    public void pop() {
        if (!list.isEmpty()) {
            int remove = list.pop();
            queue.remove(remove);
        }
    }

    public int top() {
        if (!list.isEmpty()) {
            list.getFirst();
        }
        return 0;
    }

    public int getMin() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return 0;
    }
}
