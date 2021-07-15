package jianzhiOffer.tree;

import java.util.Arrays;

public class mirrorTree {
    /*
    剑指offer，27，easy
    请完成一个函数，输入一个二叉树，该函数输出它的镜像。

    第一感觉不难，新建一个树，依次进行节点的添加
    []出错
    时间100%，空间73%
    还可以原地修改，更简单，递归
    原地修改时间100%，空间49%

    官方还有一种方法，使用队列
     */
    public static void main(String[] args) {
        int[] num = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.create(num);
        TreeNode rootnew = mirrorTree2(root);
        int[] r = rootnew.cengorder();
        System.out.println(Arrays.toString(r));

    }
    public static TreeNode mirrorTree(TreeNode root) {
        if(root ==null)return null;
        TreeNode rootnew = new TreeNode(root.val);
        mirrorTree2(root,rootnew);
        return rootnew;

    }
    public static void mirrorTree2(TreeNode root, TreeNode newroot) {
        if(root.left != null){
            TreeNode ri = new TreeNode(root.left.val);
            newroot.right = ri;
            mirrorTree2(root.left,newroot.right);
        }
        if(root.right != null){
            TreeNode le = new TreeNode(root.right.val);
            newroot.left = le;
            mirrorTree2(root.right,newroot.left);
        }
    }
//原地修改
    public static TreeNode mirrorTree2(TreeNode root){
        mirrorTree3(root);
        return root;
    }
    public static void mirrorTree3(TreeNode root) {
        if(root ==null)return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree3(root.left);
        mirrorTree3(root.right);
    }
}
