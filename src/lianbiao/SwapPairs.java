package lianbiao;
//import

public class SwapPairs {
    /*
    不交换节点的值，就是对节点本身进行交换
    循环结构：依次取出两个，当只剩下一个或者为空时不交换
        需要定义一个临时变量和一个指针变量，
        temp.next =2.next, 2.next =1.next, 1.next = temp.next, cur = temp.next
        注意不要1.next = temp,这样当temp更换时1.next也会随之更换
        不用写函数了，直接在while循环内执行，判断条件：cur != null,
        啊忘了前向的链接了
     */
    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(4);
//        ListNode2 node5 = new ListNode2(6);
//        ListNode2 node6 = new ListNode2(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(AddTwoNumbers.Strings(node1));
        ListNode2 r = swapPairs(node1);
        System.out.println(AddTwoNumbers.Strings(r));
//        node5.next = node6;

//        System.out.println(s1);
//        System.out.println(s2);

//        ListNode2 r = addTwoNumbers(node1,node4);
//        System.out.println(Strings(r));


    }
    public static ListNode2 swapPairs(ListNode2 head) {
        if(head==null || head.next==null)return head;
        ListNode2 temp = new ListNode2(0);
//        ListNode2 temp0 = new ListNode2();
//        ListNode2 cur = head;
        ListNode2 cur = new ListNode2(0);
        ListNode2 head0 = new ListNode2(0);
//        当交换1与2时，cur表示0
        cur.next = head;
//        head0.next =cur;
        head0 =cur;
        /*
        逻辑不是很清楚，可以看作先删除节点2，再插入节点2，temp指向节点3，
        temp0指向节点2，但是节点2应该是新建的，防止有next,这样逻辑就清楚了
         */
        while(cur.next.next != null){
            ListNode2 temp0 =  new ListNode2(cur.next.next.val);//新建节点暂存2的值
            temp = cur.next.next.next;//可能为null，暂存节点3
            cur.next.next = temp;//0-1-3
            temp = cur.next;//暂存1
            cur.next = temp0;
            cur.next.next = temp;
            cur = cur.next.next;
            if(cur.next ==null)break;

        }
//        return head0.next.next;
        return head0.next;

    }
}
