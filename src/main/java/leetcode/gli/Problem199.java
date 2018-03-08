package leetcode.gli;

import com.fishercoder.common.classes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem199 {

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                boolean firstProcessed = false;
                List<TreeNode> nodesNextDepth = new ArrayList<>();

                while (!queue.isEmpty()) {
                    TreeNode current = queue.remove();
                    if (!firstProcessed) {
                        result.add(current.val);
                        firstProcessed = true;
                    }

                    if (current.right != null) {
                        nodesNextDepth.add(current.right);
                    }
                    if (current.left != null) {
                        nodesNextDepth.add(current.left);
                    }
                }

                queue.addAll(nodesNextDepth);
            }

            return result;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rightSideView(null));
    }
}
