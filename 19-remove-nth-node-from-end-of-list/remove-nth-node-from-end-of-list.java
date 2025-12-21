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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 1;
        while(fast.next!=null && fast.next.next!=null)
        {
            cnt++;
            slow = slow.next;
            fast = fast.next.next;
        }

        int size = cnt*2;
        if(fast.next == null)
         size--;

        ListNode temp = head;
        int ind = size - n;
        if(ind == 0)
        return head.next;
        while(temp!=null){
            ind--;
            if(ind == 0){
                if(temp.next.next == null)
                {
                    temp.next = null;
                }else{
                    temp.next = temp.next.next;
                }
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}