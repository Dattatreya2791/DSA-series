import java.util.Stack;

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

public class Add_TwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;

        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int val1 = 0;
            int val2 = 0;

            if(!stack1.isEmpty()) val1 = stack1.pop();
            else val1 = 0;

            if(!stack2.isEmpty()) val2 = stack2.pop();
            else val2 = 0;

            int sum = val1+val2+carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode new_node = new ListNode(digit);
            new_node.next = head;
            head = new_node;
        }

        return head;
    }
}
