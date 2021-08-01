package lianbiao;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }


    public static  String Strings(ListNode node){
        String s = "";
        while(node !=null){
            s = s +node.val +'-';
            node = node.next;
        }
        return s;
    }

    public static ListNode create(int[] num){
        if(num.length==0)return null;
        ListNode head = new ListNode(num[0]);
        ListNode temp = new ListNode();
        temp = head;
        for (int i = 1; i < num.length ; i++) {
            ListNode t = new ListNode(num[i]);
            temp.next = t;
            temp = temp.next;
        }
        return head;
    }

}
