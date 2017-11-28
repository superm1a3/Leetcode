package leetcode.gli;

import com.fishercoder.common.classes.ListNode;

public class Problem2 {

    // This solution is not correct because it can cause overflow:
    // e.g. 9 + 9,999,999,991
    static class Solution0 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return toListNode(toInt(l1) + toInt(l2));
        }

        public int toInt(ListNode listNode) {
            int num = 0;
            int scale = 1;
            ListNode current = listNode;
            while (current != null) {
                num += current.val * scale;
                scale *= 10;
                current = current.next;
            }

            return num;
        }

        public ListNode toListNode(int num) {
            int i = num;
            ListNode head = new ListNode(i % 10);
            ListNode pre = head;
            i /= 10;

            while (i > 0) {
                ListNode current = new ListNode(i % 10);
                pre.next = current;
                pre = current;
                i /= 10;
            }

            return head;
        }
    }

    static class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = l1.val + l2.val;
            int carry = 0;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            }
            ListNode result = new ListNode(sum);
            ListNode pre = result;

            ListNode c1 = l1.next;
            ListNode c2 = l2.next;

            while (c1 != null || c2 != null || carry != 0) {
                int v1 = c1 == null ? 0 : c1.val;
                int v2 = c2 == null ? 0 : c2.val;

                int s = v1 + v2 + carry;
                if (s >= 10) {
                    s %= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }

                ListNode current = new ListNode(s);
                pre.next = current;
                pre = current;

                if (c1 != null) {
                    c1 = c1.next;
                }
                if (c2 != null) {
                    c2 = c2.next;
                }
            }

            return result;
        }
    }

    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode result = new ListNode(0);
            ListNode pre = result;

            while (l1 != null || l2 != null || carry != 0) {
                int v1 = l1 == null ? 0 : l1.val;
                int v2 = l2 == null ? 0 : l2.val;

                int s = v1 + v2 + carry;
                if (s >= 10) {
                    s %= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }

                ListNode current = new ListNode(s);
                pre.next = current;
                pre = current;

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            return result.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        ListNode l1_1 = new ListNode(4);
//        ListNode l1_2 = new ListNode( 3);
//        l1.next = l1_1;
//        l1_1.next = l1_2;

        ListNode l2 = new ListNode(1);
        ListNode l2_1 = new ListNode(9);
        ListNode l2_2 = new ListNode( 9);
        l2.next = l2_1;
        l2_1.next = l2_2;

        System.out.println(l1);
        System.out.println(l2);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.addTwoNumbers(l1, l2));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.addTwoNumbers(l1, l2));
    }
}
