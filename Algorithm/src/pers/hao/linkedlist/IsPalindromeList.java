package pers.hao.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hao
 */
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 空间复杂度O(n)
     * @param head
     * @return
     */
    public static boolean isPalindromeList(Node head) {
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    /**
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public static boolean isPalindromeList2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        /**
         * 迭代终止条件：n2.next != null && n2.next.next != null
         * 节点个数为奇数：n1位于中间的节点位置
         * 节点个数为偶数：n1位于中间节点的左边位置
         */
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next; //n2 -> 右侧部分第一个节点
        n1.next = null; // mid.next = null
        Node n3 = null;
        while (n2 != null) {
             n3 = n2.next;
             n2.next = n1;
             n1 = n2;
             n2 = n3;
        }

        n3 = n1; // 保存最后的节点
        n2 = head; // 左侧第一个节点
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }
}
