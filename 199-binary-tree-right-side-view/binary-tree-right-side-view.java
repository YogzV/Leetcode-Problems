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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
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
            if(arr.size() >0)
            {
                list.add(arr.get(arr.size()-1));
            }
        }
        return list;
    }
}