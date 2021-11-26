package pers.hao.draft;

public class CopyListWithRandom1126 {
    public static class Node {
        public int val;
        public Node next;
        public Node rand;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node copyListWithRand1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        //copy next node
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        //copy rand link
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = next;
        }
        //split
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }
}
