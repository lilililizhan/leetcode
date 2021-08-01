package lianbiao;

/*
141,判断链表是否有环，简单
-10^5 <= Node.val <= 10^5

set集合存储链表，可不可以，修改val的值，来标记是否访问过
时间100%，空间9%

官方方法一：哈希表
方法二：快慢指针
定义两个指针，一快一满。慢指针每次只移动一步，而快指针每次移动两步。
初始时，慢指针在位置 head，而快指针在位置 head.next。
这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。
否则快指针将到达链表尾部，该链表不为环形链表。

 */
public class hasCycle {
    public static void main(String[] args) {
        int [] n1 = {3,2,0,-4};
        ListNode head = ListNode.create(n1);

    }
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;
        ListNode temp = head;
        while (temp != null){
            if(temp.val != Integer.MAX_VALUE){
                temp.val = Integer.MAX_VALUE;
                temp = temp.next;
            }
            else return true;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null)return false;
        ListNode first = head.next;
        ListNode sec = head;
        while(first != sec){
            if(first == null || first.next == null)return false;
            first = first.next.next;
            sec = sec.next;
        }
        return true;
    }
}
