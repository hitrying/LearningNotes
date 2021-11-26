package pers.hao.draft;

public class ReverseList1125 {
    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
             next = head.next;
             head.next = pre;
             pre = head;
             head = next;
        }
        return pre;
    }
}
