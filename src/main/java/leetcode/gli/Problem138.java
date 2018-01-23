package leetcode.gli;

import java.util.HashMap;
import java.util.Map;

public class Problem138 {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    static class Solution1 {
        public RandomListNode copyRandomList(RandomListNode head) {
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode current = head;
            while (current != null) {
                map.put(current, new RandomListNode(current.label));
                current = current.next;
            }

            for (RandomListNode n : map.keySet()) {
                map.get(n).next = map.get(n.next);
                map.get(n).random = map.get(n.random);
            }

            return map.getOrDefault(head, null);
        }
    }

    static class Solution2 {
        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode iter = head, next;

            // First round: make copy of each node,
            // and link them together side-by-side in a single list.
            while (iter != null) {
                next = iter.next;

                RandomListNode copy = new RandomListNode(iter.label);
                iter.next = copy;
                copy.next = next;

                iter = next;
            }

            // Second round: assign random pointers for the copy nodes.
            iter = head;
            while (iter != null) {
                if (iter.random != null) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }

            // Third round: restore the original list, and extract the copy list.
            iter = head;
            RandomListNode pseudoHead = new RandomListNode(0);
            RandomListNode copyIter = pseudoHead;

            while (iter != null) {
                next = iter.next.next;

                // extract the copy
                copyIter.next = iter.next;
                copyIter = iter.next;

                // restore the original list
                iter.next = next;

                iter = next;
            }

            return pseudoHead.next;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.copyRandomList(null));
    }
}
