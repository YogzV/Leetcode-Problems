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
    int count = 0;
    public int goodNodes(TreeNode root) {
        totalNodes(root,root.val);
        return this.count;
    }

    public void totalNodes(TreeNode root,int max)  {
       if(root == null)
        return;
        
       if(root.val >= max)
        this.count++;

       max = Math.max(root.val,max);

       totalNodes(root.left,max);
       totalNodes(root.right,max);
       return;
    }
}