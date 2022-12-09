package ca.bytetube._00_CCC._01_list;

import java.util.Stack;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;

        while (head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }


        return newHead;

    }


    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;

        }
        ListNode newHead = new ListNode(stack.pop().val);
        cur = newHead;
        while (!stack.isEmpty()){
            cur.next = new ListNode(stack.pop().val);
            cur = cur.next;
        }
        return newHead;
    }
}
