package jianzhiOffer.tree;

public class isSymmetric {
    /*
    剑指offer,28,简单
    请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

    递归，注意左子树等于右子树，又不像递归，
    那一层一层判断吧，
    还是要递归，递归函数的入口是两个节点,
    时间100%，空间93%
    写法已经很简单了，官方的写法更简单
     */
    public static void main(String[] args) {
//        int[] nums = {1,2,2,3,4,4,3};//true
        int[] nums = {1,2,2,0,3,0,3};//false
        TreeNode root  = TreeNode.create(nums);
        boolean r = isSymmetric(root);
        System.out.println(r);
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        else return isSymmetric2(root.left,root.right);
    }
    public static boolean isSymmetric2(TreeNode left,TreeNode right) {
        if(left == null)return right==null ? true:false;
        if(right == null)return false;
        else {
            if(left.val == right.val)
                return isSymmetric2(left.left,right.right)&&isSymmetric2(left.right,right.left);
            else return false;
        }
    }
}
