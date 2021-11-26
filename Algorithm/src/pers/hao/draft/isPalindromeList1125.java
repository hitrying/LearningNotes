package pers.hao.draft;

public class isPalindromeList1125 {
    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindromeList(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        //使n1移动到链表的中点位置
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        //将链表右侧部分反转
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        //判断链表左右两侧是否对称
        n3 = n1; //保留最后位置的节点
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //翻转回之前的顺序
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

    public static void printLink(Node head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(1);
        head1.next.next.next.next.next = new Node(9);
        head1.next.next.next.next.next.next = new Node(7);
        System.out.println(isPalindromeList(head1));
        printLink(head1);
    }
}
