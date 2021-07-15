package lianbiao;

public class RemoveNthFromEnd {
    /*
    因为只有next属性所以只能从前往后查，
    所以必须得先找到链表的长度，所以怎么才能实现一趟扫描呢

    注意：head0.next = head,cur.next = head这并不能代表着cur = head0,大多数情况下不会出错，但这里就出错了（当删去head节点时）。
    链表问题依然在head前加一head0节点

    官方有一种解法是使用栈，是先入栈，然后出栈的时候统计，来获得需要删除嗯对节点，然后进行节点的删除


    最合适的方法，使用两个指针，first 和second，first比second超前n个节点，当first的下一节点为空时，second即为需要删除的节点，这个方法太妙了，实现了节点的一次遍历
     */
    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(4);
        ListNode2 node5 = new ListNode2(5);
//        ListNode2 node6 = new ListNode2(4);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode2 r = removeNthFromEnd(node1,1);
        String s = r.Strings(r);
        System.out.println(s);
//        node5.next = node6;
    }
    public static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        int len = 0;
        ListNode2 node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        System.out.println(len);
        int index  = len -n;
        int indextemp = 0;
        ListNode2 cur = new ListNode2();
        ListNode2 head0 = new ListNode2(0);
        head0.next =head;
        cur=head0;
//        cur.next = head;
        while (true){
            if(indextemp != index){
                cur = cur.next;
                indextemp++;
            }
            else {
                cur.next = cur.next.next;
                break;
            }
        }
//        System.out.println(index);

        return head0.next;
    }
}
