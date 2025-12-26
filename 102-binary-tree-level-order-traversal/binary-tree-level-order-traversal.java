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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
       
        while(!queue.isEmpty())
        {
            List<Integer> arr = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0)
            {
                TreeNode node = queue.poll();
                if(node!=null)
                {
                    arr.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(arr.size() > 0)
              list.add(arr);
        }
        return list;
    }
}