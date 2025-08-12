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

public class Rotate_LinkedList {
     public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        k = k % length;
        if(k == 0) return head;

        tail.next = head;
        
        ListNode new_lastNode = nthNode(head,length - k);
        head = new_lastNode.next;
       new_lastNode.next = null;

       return head; 
    }
}
