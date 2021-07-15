package jianzhiOffer.tree;

public class MaxDepth {
    /*
    忽然发现自己曾经写过这个函数，一行代码，自己之前好厉害啊，
    但是这个题是在深度优先遍历的代码里的

    时间100%，空间5%
     */
    public static void main(String[] args) {
        int[] num = {3,9,20,0,0,15,7};
        TreeNode root = TreeNode.create(num);
        int d = maxDepth(root);
        System.out.println(d);

    }
    public static int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(root.left == null ? 1 : maxDepth(root.left)+1, root.right==null? 1: maxDepth(root.right)+1);
//        return 0;
    }

//    public int maxDepth2(TreeNode root) {
//
//    }
}
