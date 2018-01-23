package leetcode.gli;

public class Problem138 {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    static class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) {
                return null;
            }

            RandomListNode cloneHead = new RandomListNode(head.label);
            RandomListNode current = head;
            RandomListNode cloneCurrent = cloneHead;
            while (current.next != null) {
                cloneCurrent.next = new RandomListNode(current.next.label);
                current = current.next;
                cloneCurrent = cloneCurrent.next;
            }

            current = head;
            cloneCurrent = cloneHead;
            while (current.next != null) {
                
            }

            return cloneHead;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
