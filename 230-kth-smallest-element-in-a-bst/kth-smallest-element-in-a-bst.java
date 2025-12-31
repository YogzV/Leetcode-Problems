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
    int cnt = 0;
    TreeNode node;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return node.val;
    }

    public void inOrder(TreeNode root,int k)
    {
        if(root ==null)
          return;

        if(root.left!=null)
         inOrder(root.left,k);
          
          this.cnt++;
        
        if(this.cnt == k){
         this.node = root;
         return;
        }
        
        if(root.right!=null)
         inOrder(root.right,k);

        
    }
}