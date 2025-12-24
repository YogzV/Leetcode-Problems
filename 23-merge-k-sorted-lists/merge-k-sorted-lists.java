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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = new ListNode();
        int size = lists.length;
        for(int i=0;i<size;i++)
        {
            ListNode temp2 = new ListNode();
            ListNode res = temp2;
            ListNode ans = head.next;
            ListNode temp = lists[i];
            while(temp!=null && ans!=null)
            {
                if(temp.val < ans.val)
                {
                   temp2.next = temp;
                   temp = temp.next;
                }else{
                    temp2.next = ans;
                    ans = ans.next;
                }
                temp2 = temp2.next;
            }
            if(temp!=null){
                temp2.next = temp;
                
            }
            if(ans!=null)
            {
                temp2.next = ans;
            }

            head = res;
        }
        return head.next;
    }
}