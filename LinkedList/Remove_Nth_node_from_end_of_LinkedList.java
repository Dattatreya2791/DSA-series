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
public class Remove_Nth_node_from_end_of_LinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;

        while(temp != null){
            length++;
            temp = temp.next;
        }

        int nth_node = length - n;
        if(n == length){
            return head.next;
        }else{
            ListNode temp1 = head;
            for(int i=0;i<nth_node-1;i++){
                temp1 = temp1.next;
            }
            temp1.next = temp1.next.next;
        }
        return head;
    }
}
