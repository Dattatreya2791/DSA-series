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
public class ReverseNodes_in_Kgroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseInGroups(head,k);
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode reverseInGroups(ListNode head,int k){
        if(head == null) return null;

        ListNode curr = head;
        int curr_len = 1;
        while(curr.next != null && curr_len < k){
            curr = curr.next;
            curr_len++;
        }
        if(curr_len < k) return head;
        ListNode tempNode = curr.next;
        curr.next = null;

        ListNode temp_list = reverseInGroups(tempNode,k);
        ListNode prev = reverseList(head);
        head.next = temp_list;
        return prev;
    }
}
