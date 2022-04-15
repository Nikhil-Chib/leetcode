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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode list1 = head;
        ListNode list2 = slow.next;
        list2 = reverseList(list2);
        
        int max = Integer.MIN_VALUE;
        while(list1 != null && list2 != null) {
            int currSum = list1.val+list2.val;
            max = Math.max(currSum, max);
            
            list1 = list1.next;
            list2 = list2.next;
        }
        
        return max;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}