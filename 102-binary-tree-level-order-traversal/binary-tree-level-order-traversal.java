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
        List<Integer> arr;
        int size;
        TreeNode node;
        while(!queue.isEmpty())
        {
            arr = new ArrayList<>();
            size = queue.size();
            while(size-- > 0)
            {
                node = queue.poll();
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