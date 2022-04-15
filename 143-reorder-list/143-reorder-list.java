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
        ListNode fast = head;
        ListNode slow = head;
        
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode list1 = head;
        ListNode list2 = slow.next;
        
        slow.next = null;
        list2 = reverseList(list2);
        
        
        while(list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;
            
            list1.next = list2;
            list2.next = next1;
            
            list1 = next1;
            list2 = next2;
        }
        
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode next  = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    } 
}