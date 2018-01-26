package leetcode.gli;

import com.fishercoder.common.classes.ListNode;

public class Problem147 {

    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode nodeBefore = head;
            ListNode node = head.next;

            while (node != null) {
                ListNode pre = dummy;
                ListNode next = dummy.next;

                while (node.val >= next.val && next != node) {
                    pre = pre.next;
                    next = next.next;
                }

                if (next != node) {
                    pre.next = node;
                    nodeBefore.next = node.next;
                    node.next = next;

                    node = nodeBefore.next;
                } else {
                    node = node.next;
                    nodeBefore = nodeBefore.next;
                }
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(5);
        ListNode next = new ListNode(5);
        head.next = next;
        System.out.println(solution.insertionSortList(head));
    }
}
