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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ans = new ListNode();
        ListNode ans_temp = ans;
        int cnt = 0;
        ListNode temp = head;
        while(head!=null)
        {
           cnt++;
           
           if(cnt == k)
           {
            cnt = 0;
            ListNode start = temp;
            temp = head.next;
            head.next = null;
            ListNode dummy = reverse(start);
            
            ans_temp.next = dummy;
            ans_temp = start;   
            head = temp;
           }else{
            head = head.next;
           }
           
        }
        ans_temp.next = temp;
        return ans.next;     
        
    }

    public static ListNode reverse(ListNode head){
        
        ListNode prev = null;
    
        while(head!=null)
        {
            ListNode after = head.next;
            head.next = prev;
            prev = head;
            head = after;

        }
        return prev;

    }
}