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
        while(true)
        {
          if(hmap.containsKey(head.val))
           head = head.next;
          else
           break;
        }

        ListNode temp = head.next;
        ListNode prev = head;
        while(temp!=null)
        {
           if(!hmap.containsKey(temp.val))
           {
               prev.next = temp;
               prev = temp;
           }
           temp = temp.next;
        }
        prev.next = null;
        return head;



    }
}