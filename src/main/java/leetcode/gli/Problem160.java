package leetcode.gli;

import com.fishercoder.common.classes.ListNode;

public class Problem160 {

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            int lenA = 0;
            int lenB = 0;

            ListNode nodeA = headA;
            while (nodeA != null) {
                lenA++;
                nodeA = nodeA.next;
            }

            ListNode nodeB = headB;
            while (nodeB != null) {
                lenB++;
                nodeB = nodeB.next;
            }

            nodeA = headA;
            nodeB = headB;

            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; i++) {
                    nodeA = nodeA.next;
                }
            } else if (lenA < lenB) {
                for (int i = 0; i < lenB - lenA; i++) {
                    nodeB = nodeB.next;
                }
            }

            while (nodeA != null) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode headA = new ListNode(5);
        ListNode headB = new ListNode(5);
        System.out.println(solution.getIntersectionNode(headA, headB));
    }
}
