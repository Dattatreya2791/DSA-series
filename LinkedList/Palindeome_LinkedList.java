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

public class Palindeome_LinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;
        ListNode mid = midNode(head);
        ListNode l2 = mid.next;
        l2 = reverseList(l2);

        return compare(head,l2);

    }

    boolean compare(ListNode l1,ListNode l2){
        while(l1 != null && l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    private ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
