package lianbiao;

public class GetKthFromEnd {
    /*
    用两个指针，第一个指针先行
    为什么时间11%，空间36%
    一样的思路，咋人家就100%
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode r = getKthFromEnd(node1,2);
        String s = ListNode.Strings(r);
        System.out.println(s);
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode sec = head;
        int n =0;
        while (n<k){
            first = first.next;
            n++;
        }
        System.out.println(first.val);
        while (first != null){
            first = first.next;
            sec = sec.next;
        }
//        System.out.println(first.val);
        System.out.println(sec.val);

        return sec;
    }
}
