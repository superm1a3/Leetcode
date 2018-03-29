package com.fishercoder.solutions;

import com.fishercoder.common.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
  \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
 2     1         2                 3*/
public class _95 {

	public static class Solution1 {
		public List<TreeNode> generateTrees(int n) {
			List<TreeNode> result = new ArrayList();
			if (n == 0) {
				return result;
			}
			return generateTrees(1, n);
		}

		private List<TreeNode> generateTrees(int start, int end) {
			List<TreeNode> result = new ArrayList();
			if (start > end) {
				result.add(null);
				return result;
			}
			if (start == end) {
				result.add(new TreeNode(start));
				return result;
			}

			for (int i = start; i <= end; i++) {
				List<TreeNode> leftList = generateTrees(start, i - 1);
				List<TreeNode> rightList = generateTrees(i + 1, end);
				for (TreeNode left : leftList) {
					for (TreeNode right : rightList) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						result.add(root);
					}
				}
			}
			return result;
		}
	}
}
