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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int remainder = 0;

        ListNode ans = new ListNode();
        ListNode ans_temp = ans;
        while(l1!=null && l2!=null)
        {
           int val = remainder + l1.val + l2.val;
           remainder = val /10;
           
           ans_temp.next = new ListNode(val%10);
           ans_temp = ans_temp.next;
           l1 = l1.next;
           l2 = l2.next;

        }

        while(l1!=null)
        {
            
            int val = l1.val + remainder;
            remainder = val /10;
            ans_temp.next = new ListNode(val%10);
            l1 = l1.next;
            ans_temp  = ans_temp.next;
        }
        while(l2!=null)
        {
            int val = l2.val + remainder;
            remainder = val /10;
            ans_temp.next = new ListNode(val%10);
            l2 = l2.next;
            ans_temp  = ans_temp.next;
        }
        
        if(remainder == 1)
        {
            ans_temp.next = new ListNode(1);
        }
        return ans.next;
    }
}