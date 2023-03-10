package ca.bytetube._13_stack;

import java.util.Stack;

import java.util.LinkedList;

public class MinStack {

    Stack<ListNode> stack;
    LinkedList<ListNode> list;

    public MinStack() {
        list = new LinkedList<>();
        stack = new Stack<>();

    }

    public void push(int val) {
        ListNode node = new ListNode(val);
        stack.push(node);
        addtoList(node);

    }

    public void pop() {
        list.remove(stack.pop());
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return list.get(0).val;
    }

    private void addtoList(ListNode node) {
        int index = 0;
        if (list.size() == 0) {
            list.add(0, node);
            return;
        }
        for (ListNode element : list) {

            if (element.val > node.val) {
                list.add(index, node);
                break;

            }
            index++;

        }

    }

}
