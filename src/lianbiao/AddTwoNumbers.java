package lianbiao;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(2);
        ListNode2 node2 = new ListNode2(4);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(5);
        ListNode2 node5 = new ListNode2(6);
        ListNode2 node6 = new ListNode2(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        String s1= Strings(node1);
        System.out.println(s1);
        String s2= Strings(node4);
        System.out.println(s2);

        ListNode2 r = addTwoNumbers(node1,node4);
        System.out.println(Strings(r));


    }


    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        String s1 = Strings(l1);
        String s2 = Strings(l2);
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();
        Double i1 = Double.parseDouble(String.valueOf(sb1));
        Double i2 = Double.parseDouble(String.valueOf(sb2));
//        long i1 = Long.parseLong(String.valueOf(sb1));
//        long i2 = Long.parseLong(String.valueOf(sb2));
//        int i1 = Integer.parseInt(String.valueOf(sb1));
//        int i2 = Integer.parseInt(String.valueOf(sb2));
        Double sum = i1+i2;
        System.out.println("sum:  "+sum);
        String s = sum+"";
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        s = String.valueOf(sb);
        System.out.println("s:  "+s);
        System.out.println("s.len:"+s.length());
        ListNode2 head = new ListNode2(s.charAt(0)-48);
        ListNode2 cur = head;
        System.out.println("0----"+Strings(head));
        for (int i = 1; i <s.length(); i++) {
            ListNode2 temp = new ListNode2(s.charAt(i)-48);
            cur.next = temp;
            cur = cur.next;
            System.out.println(i+"----"+Strings(head));
        }
        return head;

    }
    public static  String Strings(ListNode2 node){
        String s = "";
        while(node !=null){
            s = s +node.val+"-";
            node = node.next;
        }
        return s;
    }

}
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
    public static  String Strings(ListNode2 node){
        String s = "";
        while(node !=null){
            s = s +node.val;
            node = node.next;
        }
        return s;
    }
}
