package lianbiao;

public class ListNode {
    int val;
    ListNode next;

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
}
