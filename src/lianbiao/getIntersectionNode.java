package lianbiao;

import java.util.HashSet;
import java.util.Set;

public class getIntersectionNode {
    /*
    剑指offer,52,easy,
    输入两个链表，找出它们的第一个公共节点。

    被提前剧透了答案，但还是感觉不简单啊

    0
    [1]
    []
    1
    0报错，
    时间25%，空间34%

    2021-07-31
    160题，简单，想起来了之前的解法，
    可以把链表1的节点保存在set中，对链表2中的每一个节点判断是否存在，
    或者官方：链表1结束后移到链表2
     */
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);

        ListNode c1  = new ListNode(8);
        ListNode c2  = new ListNode(4);
        ListNode c3  = new ListNode(5);

        a1.next = a2;
        a2.next=c1;
        c1.next = c2;
        c2.next=c3;
        b1.next=b2;
        b2.next=b3;
//        b3.next=c1;
        ListNode r = getIntersectionNode2(a1,b1);

        ListNode d1 = new ListNode(1);
//        ListNode r = getIntersectionNode2(d1,null);
        System.out.println(ListNode.Strings(r));



    }
//    实际的思路还是一样的，，
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode tempa = headA;
        ListNode tempb = headB;
        if(tempa == null || tempb ==null)return null;
        while(  a <=1 && b<=1){
            if(tempa == tempb)return tempa;
            if(tempa.next != null){
                tempa = tempa.next;
            }
            else {
                tempa = headB;
                a++;
            }
            if(tempb.next != null){
                tempb = tempb.next;
            }
            else {
                tempb = headA;
                b++;
            }
        }
        return null;
    }

//官方解法，太简单了吧，可是，这样，只有A==B才会跳出，若没有公共节点呢，没有公共节点，也会同时为null,则跳出
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

//    时间25%，空间10%
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode t = headA;
        while(t != null){
            set.add(t);
            t = t.next;
        }
        t = headB;
        while (t != null){
            if(set.contains(t))return t;
            else t = t.next;
        }
        return null;
    }

}
