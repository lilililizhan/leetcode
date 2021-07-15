package lianbiao;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePrint {
    /*
    不能使用字符串，因为值可能是多位数，可以加入分隔符其实
    官方使用栈的思想，
    有一种方法，先遍历获得长度，并不保存数值，再遍历一遍把数值存入数组，时间复杂度100%
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node5.next = node6;
        System.out.println(ListNode.Strings(node1));
        int[] r = reversePrint(node1);
        System.out.println(Arrays.toString(r));
    }
    public static int[] reversePrint(ListNode head) {
//        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur ;
        cur = head;
        while (cur != null){
            list.add(0,cur.val);
            cur = cur.next;
        }
        int[] r = new int[list.size()];
        for (int i = 0; i < r.length; i++) {
            r[i]  = list.get(i);
        }
        return r;
    }
}
