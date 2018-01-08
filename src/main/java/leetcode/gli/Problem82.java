package leetcode.gli;

import com.fishercoder.common.classes.ListNode;

public class Problem82 {

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // use two pointers, slow - track the node before the dup nodes,
            // fast - to find the last node of dups.
            ListNode dummy = new ListNode(0), fast = head, slow = dummy;
            slow.next = fast;
            while(fast != null) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;    //while loop to find the last node of the dups.
                }
                if (slow.next != fast) { //duplicates detected.
                    slow.next = fast.next; //remove the dups.
                    fast = slow.next;     //reposition the fast pointer.
                } else { //no dup, move down both pointer.
                    slow = slow.next;
                    fast = fast.next;
                }

            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
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
