/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int right = -1;
            int size = queue.size();
            while(size-- > 0)
            {
                TreeNode node = queue.poll();
                if(node!=null)
                {
                    right = node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(right != -1)
              list.add(right);
        }
        return list;
    }
}