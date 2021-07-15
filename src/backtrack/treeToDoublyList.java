package backtrack;

import java.util.ArrayList;
import java.util.List;

public class treeToDoublyList {
    /*
    回溯问题，剑指36题，难度middle
    将一棵二叉搜索树转为一个排序的循环双向链表，要求不能创建任何新的节点
    树的左指针指向前驱，右指针指向后继
    将每一个子树转为链表，然后依次，
    关键在于右子节点和父节点位置的互换
    分为三种情况，无叶子节点，仅有左子节点，仅有右子节点，同时有左右子节点
    迭代的过程需要有返回值类型,返回需要两个节点，前面的和后面的，

    出错，The linked list [1,2,3,4,5] is not a valid circular doubly linked list.
    不知道为什么错了

    官方题解没看太懂，
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        Node r  = treeToDoublyList(node4);
        System.out.println(r);
    }
    public static Node treeToDoublyList(Node root) {
        Node head = root;
        Node end = root;
        if(root.left != null){
            Node ltemp1  = treeToDoublyList2(root.left).get(0);
            Node ltemp2  = treeToDoublyList2(root.left).get(treeToDoublyList2(root.left).size()-1);
            head = ltemp1;
            ltemp2.right = root;
        }
        if(root.right != null){
            Node rtemp1 = treeToDoublyList2(root.right).get(0);
            Node rtemp2 = treeToDoublyList2(root.right).get(treeToDoublyList2(root.right).size()-1);
            end = rtemp2;
            rtemp1.left =root;
        }
        head.left =end;
        end.right =head;
        return head;
    }
    public static List<Node> treeToDoublyList2(Node root) {
        List<Node> r = new ArrayList<Node>();
        if(root.left ==null && root.right == null){
            r.add(root);
            return r;
        }
        if(root.left != null && root.right==null){
            root.left.right =root;
            r.add(root.left);
            r.add(root);
            return r;
        }
        if(root.left == null && root.right != null){
            root.right.left =root;
            r.add(root);
            r.add(root.right);
            return r;
        }
        else {
            root.left.right = root;
            root.right.left =root;
            r.add(root.left);
            r.add(root.right);
            return r ;
        }
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}