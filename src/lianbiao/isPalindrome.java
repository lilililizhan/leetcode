package lianbiao;

import java.util.Stack;

/*
234,判断是否是回文链表，简单
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

可以先把val值记在数组中，判断数组是否回文
可以通过一个栈实现倒序，看看是否一致，循环两次
时间43%，空间47%

官方解法一：将val复制到数组中，双指针比较数组是否为回文
官方解法二：递归，没看懂，
官方解法三：快慢指针，找到链表的中间节点，将后半部分反转，判断两个链表是否相同，
快慢指针：快指针走两步，慢指针走一步，当快指针为null时慢指针为中点，注意奇偶数的情况


 */
public class isPalindrome {
    public static void main(String[] args) {
//        int[] num = {1,2,2,1};//true
        int[] num = {1,2};//false
        ListNode head = ListNode.create(num);

        System.out.println(isPalindrome(head));

    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;
        Stack<ListNode> stack  = new Stack<>();
        ListNode t=  head;
        while(t != null){
            stack.push(t);
            t = t.next;
        }
        ListNode t2 = head;
        while(!stack.isEmpty()){
            t = stack.pop();
            if(t.val != t2.val)return false;
            t2 = t2.next;
        }

        return true;
    }
}
