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
    int max;

    public int maxPathSum(TreeNode root) {
        this.max = root.val;
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root == null)
         return 0;
          
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        this.max = Math.max(root.val + left + right , this.max);

        return root.val + Math.max(left,right);
    }
}