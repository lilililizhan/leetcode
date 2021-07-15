package lianbiao;

public class MergeTwoLists {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(4);
//        ListNode node21 = new ListNode(1);
//        ListNode node22 = new ListNode(3);
//        ListNode node23 = new ListNode(4);
////        node1.next = node2;
////        node2.next = node3;
//
//        node21.next = node22;
//        node22.next = node23;

//        ListNode tmp = node1;
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-10);
        ListNode node3 = new ListNode(-9);
        ListNode node4 = new ListNode(-4);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(6);
        ListNode node21 = new ListNode(-7);
        ListNode node23 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;


        ListNode tmp = mergeTwoLists(node1,node21);
//        System.out.println("r:  "+r.val);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }



    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        这种和链表有关的问题还是先new一个新的头节点再说
         */
        if(l1 ==null){
            return l2;
        }
        ListNode tempk = new ListNode(-10000);
        tempk.next = l1;
        ListNode temp2 = l2;
        ListNode temp;
        while(temp2 !=null){
            ListNode temp1 = new ListNode(0);
            temp1.next = tempk;
            boolean add = false;
            while(temp1.next !=null){
                if(temp1.next.val<= temp2.val){
                    temp1 = temp1.next;
                }
                else{
                    temp = temp1.next;
                    temp1.next = new ListNode(temp2.val);
                    temp1.next.next =temp;
                    add = true;
                    break;
                }
            }
            if(add ==false){
                temp1.next = new ListNode(temp2.val);
            }
            temp2 = temp2.next;
        }
        return tempk.next;
    }


}
