package lianbiao;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode mode1 = new ListNode(4);
        ListNode mode2 = new ListNode(5);
        ListNode mode3 = new ListNode(1);
        ListNode mode4 = new ListNode(9);
        ListNode mode5 = new ListNode(5);

        SingleLList singlelist = new SingleLList();
        singlelist.add(mode1);
        singlelist.add(mode2);
        singlelist.add(mode3);
        singlelist.add(mode4);
//        singlelist.add(mode5);
        ListNode r = deleteNode(mode1,1);
        ListNode tmp = r;
//        System.out.println("r:  "+r.val);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }



    }
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode temp = head;
        while(temp !=null){
            if(head.val == val){
                return head.next;
            }
            else{
                if(temp.next.val ==val){
                    temp.next = temp.next.next;
                    return head;
                }
                else {
                    temp = temp.next;
                }
            }
        }
        return head;

    }
}
