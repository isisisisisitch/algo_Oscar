package ca.bytetube._00_CCC._01_list;

public class LinkedListCycle {

    public static void main(String[] args) {
        //[3,2,0,-4]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }


    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
//            for (int i = 0; i < 2; i++) {
//                if (fast.next == null){
//                    return false;
//                }
//                fast = fast.next;
//
//            }
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;

    }

    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode tag = new ListNode(0);
        ListNode n = head;
        while (true) {
            ListNode last = n;
            n = n.next;
            last.next = tag;
            if (n.next == null) {
                return false;
            } else if (n.next.equals(tag)) {
                return true;
            }
        }
    }


}
