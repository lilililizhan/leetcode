package tree;

import lianbiao.ListNode;

/*
226,翻转二叉树，简单

层序遍历，左右翻转，递归调用
时间100%，空间26%

官方的答案，只用了一个函数，写的很巧妙，
 */
public class invertTree {
    public static void main(String[] args) {
        int[] num  ={4,2,7,1,3,6,9};
        TreeNode root = TreeNode.create(num);
        TreeNode.cengxu2(root);
        System.out.println("----------");
        TreeNode res = invertTree(root);
        TreeNode.cengxu2(root);

    }
    public static TreeNode invertTree(TreeNode root) {
        invertTree2(root);
        return root;
    }
    public static void invertTree2(TreeNode root) {
        if(root == null)return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree2(root.left);
        invertTree2(root.right);

    }

    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
