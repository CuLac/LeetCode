package Daily.Easy;

/*
232. Implement Queue using Stacks
Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively.
You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

 */

import java.util.Stack;

public class Q232_Implement_Queue_using_Stacks {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public Q232_Implement_Queue_using_Stacks() {
        input = new Stack();
        output = new Stack();
    }

    public void push(int x) {
        if (input.isEmpty()) {
            input.add(x);
        } else {
            while (!output.isEmpty()) {
                output.pop();
            }
            while (!input.isEmpty()) {
                output.add(input.pop());
            }
            input.add(x);
            while (!output.isEmpty()) {
                input.add(output.pop());
            }
        }
    }

    public int pop() {
        if (input.isEmpty()) {
            return 0;
        } else {
            return input.pop();
        }
    }

    public int peek() {
        if (input.isEmpty()) {
            return 0;
        } else {
            return input.peek();
        }
    }

    public boolean empty() {
        return input.isEmpty();
    }

    public static void main(String[] args) {
        String [] action = {"MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"};
        Q232_Implement_Queue_using_Stacks queue = new Q232_Implement_Queue_using_Stacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
