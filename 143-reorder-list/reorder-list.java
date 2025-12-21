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
    public void reorderList(ListNode head) {

        if(head.next == null || head.next.next == null)
         return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp1 = head;
        ListNode curr = slow.next;
        slow.next = null;

        
        ListNode prev = null;
        while(curr!=null)
        {
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        ListNode temp2 = prev;
        ListNode next1 = temp1.next;
        ListNode next2 = temp2.next;
        while(temp1!=null && temp2!=null)
        {

            temp1.next = temp2;
            temp2.next = next1; 
            
            temp1 = next1;
            temp2 = next2;
            if(temp1 == null || temp2 == null)
             break;
            next1 = temp1.next;
            next2 = temp2.next;
            
        }

    }
}