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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root,subRoot);
    }

    public boolean helper(TreeNode root,TreeNode subroot){
        if(root == null) return false;
        if(root.val == subroot.val){
            if(same(root,subroot))
            {
                return true;
            }
        }

        return helper(root.left,subroot) || helper(root.right,subroot);

    }

    public boolean same(TreeNode p,TreeNode q){
        if(p == null && q== null)
         return true;
        else if(p==null && q!=null)
         return false;
        else if(p!=null && q==null)
         return false;
        else if(p.val != q.val)
         return false;

        return same(p.left,q.left) && same(p.right,q.right);
    }
}