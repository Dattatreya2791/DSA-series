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

public class Reverse_LinkedList-2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode leftPrev = dummy;
        ListNode curr = head;

        for(int i=0;i<left-1;i++){
            leftPrev = leftPrev.next;
            curr = curr.next;
        }

        ListNode subHead = curr;

        ListNode prev = null;
        for(int i=0;i<right-left+1;i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        leftPrev.next = prev;
        subHead.next = curr;

        return dummy.next;
    }
}
