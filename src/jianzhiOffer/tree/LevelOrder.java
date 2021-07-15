package jianzhiOffer.tree;

import java.lang.reflect.Array;
import java.util.*;

public class LevelOrder {
    /*
    类似于前序遍历，可是我已经忘了前序遍历的过程了天呐
    不同的是需要每层打印，
    构造树也好难啊，
    [3,9,20,null,null,15,7],测试用例是这样写的，所以我需要写一个构造树的函数，似乎讲过
    思路：
    依然采用递归的方法，但是需要定义好层数，
    没有考虑根节点为空的情况，空时返回[]
    时间93%，空间41%

    官方的题解使用一个队列来维护当前节点，类似图的广度优先，但代码没看太明白
    明白了，一层一层的将节点存入队列，再对每一层进行子树的遍历，并push/pop节点
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
        List<List<Integer>> rlist = levelOrder(node3);
        System.out.println(rlist.toString());


    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> rlist = new ArrayList<>();
        levelOrder2(root,1,rlist);
//        System.out.println(rlist.toString());
        return rlist;
    }
//    height从1开始
    public static void levelOrder2(TreeNode root, int height,List<List<Integer>> listList) {
        if (listList.size() < height){
            listList.add(new ArrayList<Integer>());
        }
        listList.get(height-1).add(root.val);
        if(root.left != null)levelOrder2(root.left,height+1,listList);
        if(root.right != null)levelOrder2(root.right,height+1,listList);
    }
}
