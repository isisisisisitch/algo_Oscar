package ca.bytetube._14_queue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 *
 * Prepare 2 stacks：inStack、outStack
 * When adding elements to the queue，push to inStack
 * When removing elements from the queue
 * ✓ If outStack is empty，pop all the elements in inStack one by one, push to outStack, and pop the
 * top element of outStack
 * ✓ If outStack is not empty，pop the top element of outStack
 * ■ Assume the following operations: 11 enqueue, 22 enqueue, dequeue, 33 enqueue, dequeue
 */
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
         inStack = new Stack<>();
         outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();

    }

    public int peek() {
        int top = pop();
        outStack.push(top);
        return top;
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
