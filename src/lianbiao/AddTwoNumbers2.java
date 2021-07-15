package lianbiao;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
//        ListNode2 node1 = new ListNode2(9);
//        ListNode2 node2 = new ListNode2(9);
//        ListNode2 node3 = new ListNode2(9);
//        ListNode2 node4 = new ListNode2(9);
//        ListNode2 node5 = new ListNode2(9);
//        ListNode2 node6 = new ListNode2(9);
//        ListNode2 node7 = new ListNode2(9);
//        ListNode2 node8 = new ListNode2(9);
//        ListNode2 node9 = new ListNode2(9);
//
//
//        ListNode2 node21 = new ListNode2(9);
//        ListNode2 node22 = new ListNode2(9);
//        ListNode2 node23 = new ListNode2(9);
//        ListNode2 node24 = new ListNode2(9);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//
//
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
        ListNode2 node1 = new ListNode2(9);


        ListNode2 node21 = new ListNode2(9);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//
//
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
        System.out.println(Strings(node1));
        System.out.println(Strings(node21));
        ListNode2 r = addTwoNumbers(node1,node21);
        System.out.println(Strings(r));




    }
    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        /*
        考虑到位数太多的情况，不把链表转换为数字进行相加，而是直接相加，需要考虑到进位及某一个链表结束的情况
         */
        ListNode2 cur1 = l1;
        ListNode2 cur2 = l2;
        ListNode2 head = new ListNode2();
        ListNode2 cur = new ListNode2();
        int gewei = 0;
        int jinwei = 0;
        int temp = cur1.val +cur2.val +jinwei;
        gewei = temp%10;
        jinwei = temp/10;
        head.val=gewei;
        cur =head;
        cur1 = cur1.next;
        cur2 = cur2.next;
        while((cur1 !=null) ||(cur2 != null)){
            if(cur1 == null){
                if(jinwei ==0){
                    cur.next = cur2;
                    break;
                }
                else {
                    temp = cur2.val +jinwei;
                    gewei = temp%10;
                    jinwei = temp/10;

                    ListNode2 tempnode = new ListNode2(gewei);
                    cur.next =tempnode;
                    cur = cur.next;
                    cur2 = cur2.next;
                }

            }
            else if(cur2 == null){

                if(jinwei ==0){
                    cur.next = cur1;
                    break;
                }
                else {
                    temp = cur1.val +jinwei;
                    gewei = temp%10;
                    jinwei = temp/10;

                    ListNode2 tempnode = new ListNode2(gewei);
                    cur.next =tempnode;
                    cur = cur.next;
                    cur1 = cur1.next;
                }
            }
            else {
                temp = cur1.val +cur2.val +jinwei;

                gewei = temp%10;
                jinwei = temp/10;
//                System.out.println("gewei: "+gewei+" jiwnei: "+jinwei);
                ListNode2 tempnode = new ListNode2(gewei);
//                System.out.println(Strings(tempnode));
                cur.next = tempnode;
                cur = cur.next;
//            System.out.println("head  "+Strings(cur));
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

        }if(jinwei !=0){
            ListNode2 tempnode = new ListNode2(jinwei);
            cur.next = tempnode;
        }
        return head;
    }
    public static  String Strings(ListNode2 node){
        String s = "";
        while(node !=null){
            s = s +node.val;
            node = node.next;
        }
        return s;
    }
}
