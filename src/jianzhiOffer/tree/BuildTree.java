package jianzhiOffer.tree;

import java.util.Arrays;

public class BuildTree {
    /*
    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
    首先，前序的第一个节点是root,中序中3前的9是左子树，后面的是右子树，
    每次对数组进行三等分，分出根节点，左子树和右子树，递归进行构建
    递归结束的标志是数组内仅有一个node

    []时出错
    时间8%，空间20%
    除了没判断为空外，一次通过，
    我感觉主要的时间花在数组的拆分上

    官方的答案没有递归构造数组，而是通过下标表示，同时对inorder使用了哈希表来实现快速查找
    其他的基本一致
     */
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        System.out.println(Arrays.toString(root.cengorder()));

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rindex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                rindex = i;
                break;
            }
        }
        int[] lp = new int[rindex],li = new int[rindex];
        int[] rp = new int[preorder.length-rindex-1],ri = new int[preorder.length-rindex-1];
        for (int i = 1; i < preorder.length; i++) {
            if(i<rindex+1)lp[i-1]=preorder[i];
            else if(i>rindex)rp[i-rindex-1]=preorder[i];
        }
        for (int i = 0; i < inorder.length; i++) {
            if(i<rindex)li[i]=inorder[i];
            else if(i>rindex)ri[i-rindex-1]=inorder[i];
            
        }
        if(lp.length!=0)root.left= buildTree(lp,li);
        if(rp.length!=0)root.right=buildTree(rp,ri);
        return root;
    }
}
