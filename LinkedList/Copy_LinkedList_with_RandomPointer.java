/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import org.w3c.dom.Node;

public class Copy_LinkedList_with_RandomPointer {
     public Node copyRandomList(Node head) {
        // if(head == null) return null;

        // Map<Node,Node> map = new HashMap<>();
        // Node temp = head;

        // while(temp != null){
        //     Node new_node = new Node(temp.val);
        //     map.put(temp,new_node);
        //     temp = temp.next;
        // }
        // temp =  head;
        // while(temp != null){
        //     Node newNode = map.get(temp);
        //     newNode.next = map.get(temp.next);
        //     newNode.random = map.get(temp.random);
        //     temp = temp.next;
        // }
        // return map.get(head);

        Node temp = head;
        while(temp != null){
            Node new_node = new Node(temp.val);
            new_node.next = temp.next;
            temp.next = new_node;
            temp = temp.next.next;
        }

        Node temp1 = head;
        while(temp1 != null){
            Node copyNode = temp1.next;
            if(temp1.random != null){
                copyNode.random = temp1.random.next;
            }else{
                copyNode.random = null;
            }
            temp1 = temp1.next.next;
        }

        Node temp2 = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp2 != null){
            res.next = temp2.next;
            temp2.next = temp2.next.next;

            res = res.next;
            temp2 = temp2.next;
        }

        return dummy.next;
    }
}
