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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideView(root, 0, ans);
        
        return ans;
    }
    
    public void rightSideView(TreeNode root, int height, List<Integer> ans) {
        if(root == null) return;
        if(height == ans.size()) {
            ans.add(root.val);
        }
        
        rightSideView(root.right, height+1, ans);
        rightSideView(root.left, height+1, ans);
    }
}