package ca.bytetube._00_CCC._01_list;

public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
