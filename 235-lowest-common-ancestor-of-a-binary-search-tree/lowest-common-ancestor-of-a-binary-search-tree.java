/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ances;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(singleFind(p.left,q) || singleFind(p.right,q)) 
          return p;
        
        if(singleFind(q.left,p) || singleFind(q.right,p))
          return q;
 
        find(root,p,q);
        return this.ances;
        
    }

    public boolean singleFind(TreeNode root,TreeNode find)
    {
        if(root == null) return false;
        if(root == find) return true;

        return singleFind(root.left,find) || singleFind(root.right,find);
    }

    public boolean find(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return false;

         if(root == p || root==q)
         {
            return true;
         }

         boolean left = find(root.left,p,q);
         boolean right = find(root.right,p,q);

         if(left == true && right==true){
            this.ances = root;
            return true;
         }else if(left || right){
            return true;
         }
         return false;
    }
}