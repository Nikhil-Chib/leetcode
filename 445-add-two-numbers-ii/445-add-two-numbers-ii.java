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
        ListNode l1Rev = reverseList(l1);
        ListNode l2Rev = reverseList(l2);
        
        ListNode ans = addListNode(l1Rev, l2Rev, 0);
        
        return reverseList(ans);
    }
    
    public ListNode addListNode(ListNode l1, ListNode l2, int carryOver) {
        if(l1 == null && l2 == null && carryOver == 0) {
            return null;
        }
        
        int currSum = carryOver;
        
        if(l1 != null) {
            currSum += l1.val;
            l1 = l1.next;
        }
        
        if(l2 != null) {
            currSum += l2.val;
            l2 = l2.next;
        }
            
        
        ListNode ansNode = new ListNode(currSum%10);
        ansNode.next = addListNode(l1, l2, currSum/10);
        
        return ansNode;
    }
    
    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        return prev;
    }
}