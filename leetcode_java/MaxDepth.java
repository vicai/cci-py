package leetcode_140;

import java.util.Stack;

public class MaxDepth {
	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(0);
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused
		// by each test case.
		int maxdepth = 0;
        if (root==null) return maxdepth;
        maxdepth++;
        maxdepth = inorder(root.left, maxdepth);
        maxdepth = inorder(root.right, maxdepth);
        return maxdepth;
	}

	private static int inorder(TreeNode node, int maxdepth) {
		int depth = maxdepth;
		Stack parentStack = new Stack();
		while (!parentStack.isEmpty() || node != null) {
			if (node != null) {
				parentStack.push(node);
				depth++;
				node = node.left;
			} else {
				node = (TreeNode) parentStack.pop();
				if (depth > maxdepth) {
					maxdepth = depth;
				}
				depth--;
				node = node.right;
			}
		}
		return maxdepth;
	}
}
