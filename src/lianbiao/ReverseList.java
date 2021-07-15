package lianbiao;

import java.util.List;

public class ReverseList {
    /*
    206,简单级别，写过之后再写一次，
    方法二使劲按100%，空间80%（还是有进步的，只写错了一句，调试也很快）
     */
    public static void main(String[] args) {
        ListNode mode1 = new ListNode(1);
        ListNode mode2 = new ListNode(2);
        ListNode mode3 = new ListNode(3);
        ListNode mode4 = new ListNode(4);
        ListNode mode5 = new ListNode(5);

        SingleLList singlelist = new SingleLList();
        singlelist.add(mode1);
        singlelist.add(mode2);
//        singlelist.add(mode3);
//        singlelist.add(mode4);
//        singlelist.add(mode5);

//        System.out.println(singlelist);
//        ListNode r = reverseList(mode1);
        ListNode r2 = reverseList2(mode1);
        ListNode tmp = r2;
//        System.out.println("r:  "+r.val);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
//        System.out.println(r);


    }
    public static ListNode reverseList(ListNode head) {
//                ListNode cur = head, pre = null;
//                while(cur != null) {
//                    ListNode tmp = cur.next; // 暂存后继节点 cur.next
//                    cur.next = pre;          // 修改 next 引用指向
//                    pre = cur;               // pre 暂存 cur
//                    cur = tmp;               // cur 访问下一节点
//                }
//                return pre;


//        需要两个临时变量，一个遍历原来的链表，一个当中间变量
//
        /*
        要注意，当把cur = head时，两者就是相同的了，一定要记得把head后面的连接断开
         */
        ListNode cur = null;
        ListNode temp= null;
        ListNode newhead = new ListNode(0);
        cur = head;
        while(cur!=null){
            temp = cur.next;
//            System.out.println(temp.val);
            cur.next = newhead.next;
//            System.out.println(temp.next.val);
            newhead.next = cur;
//            System.out.println(newhead.next.val);
//            System.out.println("head之后的:  "+cur.val);
            cur = temp;

        }
////        head.next = null;
//
////        ListNode c =
////        while (c.next != null){
////
////        }
//        System.out.println(newhead);
//        ListNode tmp2 = newhead;
//        System.out.println("---------");
//        while(tmp2 != null){
//            System.out.println(tmp2.val);
//            tmp2 = tmp2.next;
//        }
        return newhead.next;
    }

    /*
    1-2-3-4-5反转为5-4-3-2-1
    法一：读入stack，然后创建节点，连接为链表
    法二：原地进行修改
    1 2-3-4-5
    1-2 3-4-5
    1-2-3 4-5
    1-2-3-4 5
     */
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next ==null)return head;
        ListNode left = head;
        ListNode right = head.next;
        head.next = null;
        ListNode temp;
        while(right != null){
            temp = right;
            right = right.next;
            temp.next  = left;
            left = temp;
//            left.next = null;
        }
        return left;
    }
}


class SingleLList{
    private ListNode head = new ListNode(0);
    public void add(ListNode node){
        ListNode temp = head;
        //遍历链表，找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = node;
    }

    @Override
    public String toString() {
        ListNode n = head;
        String s = " ";
        while (n != null) {
//            System.out.print(n.val + "---");
            s=s+n.val + "---";
            n = n.next;
        }
        return s;

    }



}

