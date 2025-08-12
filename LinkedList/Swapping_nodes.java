package LinkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Swapping_nodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;

        for(int i=0;i<k-1;i++){
            fast = fast.next;
            first = fast;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        int first_val = slow.val;
        slow.val = first.val;
        first.val = first_val;

        return head;
    }
}
