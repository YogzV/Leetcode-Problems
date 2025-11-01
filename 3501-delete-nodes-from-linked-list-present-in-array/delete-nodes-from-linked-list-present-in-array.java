/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums)
        {
           hmap.put(i,1);
        }
        ListNode temp = head;
        ListNode prev = new ListNode();
        ListNode temp2 = prev;
        while(temp!=null)
        {
           if(!hmap.containsKey(temp.val))
           {
               prev.next = temp;
               prev = prev.next;
           }
           temp = temp.next;
        }
        prev.next = null;
        return temp2.next;



    }
}