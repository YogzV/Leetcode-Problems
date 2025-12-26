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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(root == null) return false;
        if(root.val == subroot.val){
            if(same(root,subroot))
            {
                return true;
            }
        }

        return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
    }


    public boolean same(TreeNode p,TreeNode q){
        if(p==null){
            return (q==null)? true : false;
        }
        
        if(p!=null && q==null || p.val != q.val)
          return false;
        

        return same(p.left,q.left) && same(p.right,q.right);
    }
}