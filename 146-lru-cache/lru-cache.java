class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key,int val)
    {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer,Node> hmap;
    Node left;
    Node right;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        hmap = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;

    }

    public void remove(Node node)
    {
        Node previous = node.prev;
        Node after = node.next;
        previous.next = after;
        after.prev = previous;
    }

    public void insert(Node node)
    {
        Node previous = this.right.prev;
        previous.next = node;
        node.prev = previous;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key))
          return -1;
        
        Node node = hmap.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key))
        {
            remove(hmap.get(key));
        }
        Node node = new Node(key,value);
        insert(node);
        hmap.put(key,node);

        if(hmap.size() > capacity)
        {
            hmap.remove(this.left.next.key);
            remove(this.left.next);
        
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */