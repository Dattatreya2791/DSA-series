package LinkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNode {
     public void deleteNode(ListNode node) {
        int flag = node.next.val;
        node.next = node.next.next;
        node.val = flag;
    }
}
