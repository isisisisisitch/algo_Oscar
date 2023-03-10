package ca.bytetube._13_stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    boolean q1;

    public MyStack() {
        q1 = true;
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
//        if (q1) queue1.add(x);
//        else queue2.add(x);
        queue1.offer(x);
    }

    public int pop() {
//        if (q1) {
//            q1 = false;
//            while (queue1.size() > 1) queue2.add(queue1.poll());
//            return queue1.poll();
//        }
//        q1 = true;
//        while (queue2.size() > 1) queue1.add(queue2.poll());
//        return queue2.poll();

        while (queue1.size() > 1) queue2.add(queue1.poll());
        Integer poll = queue1.poll();

        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;

        return poll;

    }

    public int top() {
//        int top = pop();
//        if (q1) queue1.add(top);
//        else queue2.add(top);
//        return top;
        while (queue1.size() > 1) queue2.add(queue1.poll());
        Integer poll = queue1.poll();
        queue2.offer(poll);

        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;


        return poll;

    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
