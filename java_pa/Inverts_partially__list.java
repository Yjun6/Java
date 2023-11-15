import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static class Node{
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    static Node head = null;//头结点
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int n = in.nextInt();//长度
            Node tmp = null;
            for (int i = 0; i < n; i++) {
                Node r = new Node(in.nextInt());               
                if (head == null) {
                    head = new Node(0);
                    head.next = r;
                } else {
                    tmp.next = r;
                }
                tmp = r;
            }
            tmp.next = new Node(0);//尾结点
            int l = in.nextInt();
            int r = in.nextInt();
            //翻转
            func1(head,l,r);
            head = head.next;
            for (;head.next != null; head = head.next) {
                //输出
                System.out.print(head.val);
                if (head.next.next != null) {
                    System.out.print(" ");
                }
            }
        }
    }
    public static Node func1(Node head, int l, int r) {
        //翻转
        //找到l的前一个结点位置
        Node cur = head;
        for (int i = 0; i < l - 1; i++) {
            cur = cur.next;
        }
        //进行翻转
        Node lNode = cur.next;
        for (int i = l; i < r; i++) {
            Node lNode_next = lNode.next;
            lNode.next = lNode_next.next;
            lNode_next.next = cur.next;
            cur.next = lNode_next;
        }
        return head;
    }
}