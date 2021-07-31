package tree;

/*
0729，连中序遍历都不记得了
94,二叉树的中序遍历，简单
先考虑用递归的方法

试一下非递归的方法，中序遍历，应该是用while循环吧，
三个遍历一个都不会写了，
需要使用while循环，且因为有回退的操作，所以需要有一个临时变量，不停更新节点
非递归太难了访放弃

不知道原来的递归为什么错了，
官方答案使用栈的思想，太巧妙了吧也，

 */
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class inorderTraversal {
    public  static void main(String[] args) {
        int[] num1 = {1,0,2,0,0,3};//1,3,2
        int[] num2 = {};//[]
        int[] num3 = {1};//1
        List<int[]> intlist = new ArrayList<>();
        intlist.add(num1);
        intlist.add(num2);
        intlist.add(num3);
        for (int i = 0; i < intlist.size(); i++) {
            TreeNode root = TreeNode.create(intlist.get(i));
            List<Integer> r = inorderTraversal2(root);
            for (Integer in:r
            ) {
                System.out.println(in);
            }
            System.out.println("-----------");
        }

    }
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        middlebianli(root);
        return res;
    }

    public static void middlebianli(TreeNode root){
        if(root == null)return;
        middlebianli(root.left);
        res.add(root.val);

        middlebianli(root.right);
    }

    /**
     * 非递归的形式实现中序遍历
     * @param root
     * @return
     */
//    从父节点到左节点，需要再回到父节点，因此temp = left，left.left = root,
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || ! stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;
    }
}
