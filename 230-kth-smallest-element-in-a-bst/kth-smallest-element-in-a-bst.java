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
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> pqueue = new PriorityQueue<>();
        queue.offer(root);
        while(!queue.isEmpty()){
             TreeNode node = queue.poll();
             if(node!=null){
                pqueue.offer(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
             }
        }

        while(k-- > 1){
            pqueue.poll();
        }
        return pqueue.poll();
    }
}