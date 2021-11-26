package pers.hao.linkedlist;

/**
 * 分别实现反转单向链表、双向链表
 * @author hao
 */
public class ReverseList {
    public static class Node {
        public int val;
        public Node next;

        public Node (int data) {
            this.val = data;
        }
    }

    /**
     * 反转单向链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            //pre、head->右移
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode (int data) {
            this.value = data;
        }
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
