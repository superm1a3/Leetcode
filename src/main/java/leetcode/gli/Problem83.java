package leetcode.gli;

import com.fishercoder.common.classes.ListNode;

public class Problem83 {

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;
            int current;
            while (node != null) {
                current = node.val;
                ListNode nextUnique = node.next;
                while (nextUnique != null && nextUnique.val == current) {
                    nextUnique = nextUnique.next;
                }

                node.next = nextUnique;
                node = node.next;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        ListNode.printList(head);
        ListNode.printList(solution.deleteDuplicates(head));
    }
}
