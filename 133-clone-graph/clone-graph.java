/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
         return null;

       HashMap<Node,Node> hmap = new HashMap<>();
       return dfs(hmap,node);
    }


    public Node dfs(HashMap<Node,Node> hmap,Node node){

        if(hmap.containsKey(node)){
           return hmap.get(node);
        }

        Node copy = new Node(node.val);
        hmap.put(node ,copy);
        
        for(Node n : node.neighbors){
            copy.neighbors.add(dfs(hmap,n));
        }
        return copy;
    }
}