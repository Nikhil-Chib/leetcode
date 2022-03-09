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
    public void recoverTree(TreeNode root) {
	SwapNodes nodesToBeSwapped = new SwapNodes();
	inOrder(root, nodesToBeSwapped);
	
	int temp = nodesToBeSwapped.maximaNode.val;
	nodesToBeSwapped.maximaNode.val = nodesToBeSwapped.minimaNode.val;
	nodesToBeSwapped.minimaNode.val = temp;
	
}

// Logic : 
// 1. Inorder - Increasing for BST.
// 2. If Nodes swapped : there will be a maxima [ because the greater value would be put in a position before it's actual position ]
// 3. Now 2 cases - there will be a minima just after maxima or another one can be there [ if node swapped with is further in the array ] - need to swap with the last minima founf.
public void inOrder(TreeNode node, SwapNodes nodesToBeSwapped) {
	if(node == null) return;
	
	inOrder(node.left, nodesToBeSwapped);
	if(nodesToBeSwapped.prevNode != null && nodesToBeSwapped.prevNode.val > node.val && nodesToBeSwapped.maximaNode == null) {
		nodesToBeSwapped.maximaNode = nodesToBeSwapped.prevNode;
		nodesToBeSwapped.minimaNode = node;
	}
	
	if(nodesToBeSwapped.minimaNode != null && nodesToBeSwapped.minimaNode.val >= node.val) {
		nodesToBeSwapped.minimaNode = node;
	}
	
	
	nodesToBeSwapped.prevNode = node;
	inOrder(node.right, nodesToBeSwapped);
}



private class SwapNodes {
    TreeNode prevNode;
	TreeNode maximaNode;
	TreeNode minimaNode;
}
}