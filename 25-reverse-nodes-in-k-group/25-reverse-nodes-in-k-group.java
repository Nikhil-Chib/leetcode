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
        ListNode prev = null;
        int i=k;
        
        ListNode curr = head;
        while(curr != null ) {
            if(i == 0) break;
            curr = curr.next;
            i--;
        }
        
        if(i >0) return head;
        
        curr = head;
        while(curr != null && i<k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        
        head.next = reverseKGroup(curr, k);
        return prev;
        
    }
}