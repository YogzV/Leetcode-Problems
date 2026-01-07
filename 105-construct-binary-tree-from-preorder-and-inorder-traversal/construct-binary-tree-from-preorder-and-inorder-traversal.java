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
    int pind = 0;
    HashMap<Integer,Integer> hmap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     for(int i = inorder.length-1;i>=0;i--){
      hmap.put(inorder[i],i);
     }

     return helper(preorder,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorder,int left,int right){

        if(left > right) 
         return null;

        TreeNode root = new TreeNode(preorder[pind]);
        int ind = hmap.get(preorder[pind++]);
        root.left = helper(preorder,left,ind-1);
        root.right = helper(preorder,ind+1,right);

        return root;
    }
}