package writeenExam;

public class listnode {
    /*
    快手测开笔试题，判断一个链表是否是循环列表

     */


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next =node3;
        node3.next =node4;
        node4.next =node1;

        boolean b= t(node1);
        System.out.println(b);
    }
    public static boolean t(Node head){
        Node temp= head;
        while (temp != null){
            temp = temp.next;//注意这里，开头temp和head是一样的
            if(temp == head)return true;

        }
        return false;
    }
}

class Node{
    int val;
    Node next;
    Node(){}
    Node(int val){
        this.val  = val;
    }
}