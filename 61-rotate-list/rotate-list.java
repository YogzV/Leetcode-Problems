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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        int nodes = 0;
        while(temp != null){
          nodes++;
          temp = temp.next;
        }

        k = (nodes - (k % nodes)) % nodes;
        if(k == 0) return head;
        ListNode prev  = head;
        ListNode curr = head.next;
        
        while(--k > 0){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;

        temp = curr;
        while(temp.next!= null){
            temp = temp.next;
        }

        temp.next = head;

        return curr;
        
    }
}