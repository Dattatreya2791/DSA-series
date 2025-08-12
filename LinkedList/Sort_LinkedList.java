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
public class Sort_LinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null,slow = head,fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        return mergeList(list1,list2);
    }

    private ListNode mergeList(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(0), p = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 != null) p.next = list1;
        if(list2 != null) p.next = list2;

        return dummy.next;
    }
}
