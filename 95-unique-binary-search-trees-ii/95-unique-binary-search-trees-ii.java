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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> currAns = new ArrayList<>();
        if(start > end) {
            currAns.add(null);
            return currAns;
        }

        for(int i=start; i<=end; i++) {
            List<TreeNode> leftNodes = generateTrees(start, i-1);
            List<TreeNode> rightNodes = generateTrees(i+1, end);

            for(TreeNode left : leftNodes) {
                for(TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    currAns.add(node);
                }
            }
        }

        return currAns;
    }
}