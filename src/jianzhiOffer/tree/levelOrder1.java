package jianzhiOffer.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrder1 {
    /*
    这个不用按行打印，但是难度是中等？按行打印的难度是简单？？？？
    这样的话就不能用height这个参数了，按照官方老老实实用队列吧
    尽管昨天看过答案了，但还是不会写
    时间25%，空间8%
    这段代码的queue那里，既参与循环，又添加，比较神奇

    官方的直接一个while循环
    删除多余的for循环，25%，39%

    从Arraylist转int[],似乎不太行

    咋相同原理的代码，如3所示，就可以时间99%，试一试变量名，时间仍是25%
    不知道是不是queue的poll操作和element的区别,果然是，太神奇了
    */
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
//        TreeNode node6 = new TreeNode(3);
        node3.left=node9;
        node3.right=node20;
        node20.left=node15;
        node20.right=node7;
        int[] r = levelOrder2(node3);
        System.out.println(Arrays.toString(r));
    }
    public static int[] levelOrder(TreeNode root) {
        if(root ==null)return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> rlist = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                rlist.add(queue.element().val);
                if (queue.element().left != null){
                    queue.add(queue.element().left);
                }
                if (queue.element().right != null){
                    queue.add(queue.element().right);
                }
                queue.remove(queue.element());
            }
        }
        int[] r = new int[rlist.size()];
        for (int i = 0; i < rlist.size(); i++) {
            r[i] = rlist.get(i);
        }
        return r;
    }
    public static int[] levelOrder2(TreeNode root) {
        if(root ==null)return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> rlist = new ArrayList<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()){
            cur = queue.poll();
            rlist.add(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        int[] r = new int[rlist.size()];
        for (int i = 0; i < rlist.size(); i++) {
            r[i] = rlist.get(i);
        }
        return r;

    }
    public int[] levelOrder3(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curRoot = queue.poll();
            if (curRoot.left != null) {
                queue.offer(curRoot.left);
            }
            if (curRoot.right != null) {
                queue.offer(curRoot.right);
            }
            list.add(curRoot.val);
        }

        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
