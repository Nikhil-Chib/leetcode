/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode node, int currNumber) {
        if(node == null) return 0;
        
        
        // currNumber *= 10;
        // currNumber += node.val;
        
        currNumber = currNumber*10+node.val;
        
        if(node.left == null && node.right == null) return currNumber;
        
        return sumNumbers(node.left, currNumber) + sumNumbers(node.right, currNumber);
    }
}