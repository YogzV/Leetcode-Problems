/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String stringBFS(TreeNode root){

        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            str.append("#");
            
            if(node!= null){
                str.append(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                str.append("n");
            }
        }
        return str.toString();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return stringBFS(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("#");
        if(nodes[1].equals("n")){
              return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
    
        int sp = 2;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        queue.offer(root);
        while(sp < nodes.length){

            TreeNode temp = queue.poll();
           
            if(nodes[sp].equals("n")){
                
               temp.left = null;
            }else{
               temp.left = new TreeNode(Integer.parseInt(nodes[sp]));
               queue.offer(temp.left);
            }
            sp++;

            if(nodes[sp].equals("n")){
              temp.right = null;
            }else{
               temp.right = new TreeNode(Integer.parseInt(nodes[sp]));
               queue.offer(temp.right);
            }
            sp++;
           
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));