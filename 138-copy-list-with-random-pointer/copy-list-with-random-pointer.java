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

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hmap = new HashMap<>();
        Node temp = head;
        Node copy = new Node(0);

        Node temp2 = copy;
        int ind = 0;
        while(temp!=null){
            
            Node curr = new Node(temp.val);
            hmap.put(temp,curr);
            temp2.next = curr;
            temp = temp.next;
            temp2 = temp2.next;
        }

        
        temp = head;
        temp2 = copy.next;
        
        while(temp!=null)
        {
            if(temp.random != null)
            {
               temp2.random = hmap.get(temp.random);
            }
            temp2 = temp2.next;
            temp = temp.next;
        }

        return copy.next;
    }
}