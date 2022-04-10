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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        pathSum(root, targetSum, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    public void pathSum(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> ans) {
        if(root == null) return;
        
        currPath.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            ans.add(currPath);
            return;
        }
        
        
        pathSum(root.left, targetSum-root.val, new ArrayList<Integer>(currPath), ans);
        pathSum(root.right, targetSum-root.val, new ArrayList<Integer>(currPath), ans);
    }
}