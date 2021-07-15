package lianbiao;

public class MergeTwoLists2 {
    public static void main(String[] args) {
        ListNode3 node1 = new ListNode3(1);
        ListNode3 node2 = new ListNode3(2);
        ListNode3 node3 = new ListNode3(4);
//        ListNode3 node4 = new ListNode3(-4);
//        ListNode3 node5 = new ListNode3(1);
//        ListNode3 node6 = new ListNode3(6);
//        ListNode3 node7 = new ListNode3(6);
        ListNode3 node21 = new ListNode3(1);
        ListNode3 node22 = new ListNode3(3);
        ListNode3 node23 = new ListNode3(4);
        node1.next = node2;
        node2.next = node3;
        node21.next = node22;
        node22.next = node23;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
        ListNode3 tmp = mergeTwoLists(node1,node21);
//        System.out.println("r:  "+r.val);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
    public static ListNode3 mergeTwoLists(ListNode3 l1, ListNode3 l2) {
        /*
        链表的插入需要使用node.next.val来判断
         */
        ListNode3 head = new ListNode3(0);
        head.next = l1;
        ListNode3 temp1 = new ListNode3();
        ListNode3 temp2 = new ListNode3();
        ListNode3 cur1 = head;
        ListNode3 cur2 = l2;
//        if(cur1.val<=cur2.val){
//            temp2.val = cur2.val;
//            temp1 = cur1.next;
//            cur1.next = temp2;
//            temp2.next = temp1;
//            cur2 = cur2.next;
//        }
//        else {
//            temp2.val = cur2.val;
//            head.next = temp2;
//            temp2.next = cur1;
//            cur2 = cur2.next;
//        }

        while (cur2 !=null && cur1.next!=null){
            if(cur1.next.val <= cur2.val){
                cur1 = cur1.next;
            }
            else{
                temp1 = cur1.next;
                temp2 = cur2.next;
                cur1.next = cur2;
                cur1.next.next = temp1;
                cur1 = cur1.next;
                cur2 = temp2;
            }
        }
        if(cur2!=null){
            cur1.next = cur2;
        }
        return head.next;
    }
}



class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}