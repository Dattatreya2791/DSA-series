package LinkedList;
import java.util.*;

public class LRUCache {
     class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> mpp = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode){
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode){
        Node beforeNode = delNode.prev;
        Node afterNode = delNode.next;

        beforeNode.next = afterNode;
        afterNode.prev = beforeNode;
    }
    
    public int get(int key) {
        if(mpp.containsKey(key)){
            Node resNode = mpp.get(key);
            int resNodeVal = resNode.value;

            mpp.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            mpp.put(key,head.next);
            return resNodeVal;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node curr = mpp.get(key);
            mpp.remove(key);
            deleteNode(curr);
        }

        if(mpp.size() == cap){
            mpp.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key,value));
        mpp.put(key,head.next);
    }
}
