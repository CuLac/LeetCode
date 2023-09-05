package Daily.Easy;

/*

225. Implement Stack using Queues
Implement a last-in-first-out (LIFO) stack using only two queues.
The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively.
You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.


Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False

 */

import java.util.LinkedList;
import java.util.Queue;

public class Q225_Implement_Stack_using_Queues {
    Queue<Integer> q0;
    Queue<Integer> q1;
    int head;
    public Q225_Implement_Stack_using_Queues() {
        q0 = new LinkedList<>();
        q1 = new LinkedList<>();
        head = 0;
    }

    public void push(int x) {
        if (head == 0) {
            if (!q1.isEmpty()) {
                q0.add(q1.poll());
            }
            q1.add(x);
        } else {
            if (!q0.isEmpty()) {
                q1.add(q0.poll());
            }
            q0.add(x);
        }
    }

    public int pop() {
        int retVal = 0;
        if (head==0) {
            while (q0.size()>1) q1.add(q0.poll());
            retVal = q1.poll();
            head = 1;
        } else {
            while (q1.size()>1) q0.add(q1.poll());
            retVal = q0.poll();
            head = 0;
        }
        return retVal;
    }

    public int top() {
        int result = 0;
        if (head == 0) {
            if (!q1.isEmpty()) {
                result = q1.peek();
            } else {
                result = q0.peek();
            }
        } else {
            if (!q0.isEmpty()) {
                result = q0.peek();
            } else {
                result = q1.peek();
            }
        }
        return result;
    }

    public boolean empty() {
        return q0.isEmpty() && q1.isEmpty();
    }
}
