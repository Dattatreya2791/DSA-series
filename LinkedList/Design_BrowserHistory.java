package LinkedList;
public class Design_BrowserHistory {
    class Node{
        Node next;
        Node prev;
        String val;

        Node(String val){
            this.val = val;
        }
    }

    private Node curr;

    public void BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node new_node = new Node(url);
        curr.next = new_node;
        new_node.prev = curr;
        curr = new_node;
    }
    
    public String back(int steps) {
        while(steps > 0){
            if(curr.prev != null){
                curr = curr.prev;
            }else{
                break;
            }
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(steps > 0){
            if(curr.next != null){
                curr = curr.next;
            }else{
                break;
            }
            steps--;
        }
        return curr.val;
    }
}
