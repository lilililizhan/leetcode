package jianzhiOffer.tree;

public class lowestCommonAncestor {
    /*
    剑指offer,68-1,easy
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先
    且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

    定义一个函数，判断root是否是某一结点的祖先，从最底层开始，依次往上,
    题目是二叉搜索树。。没注意到

     */
    public static void main(String[] args) {
        int[] num = {6,2,8,0,4,7,9,0,0,3,5,0,0,0,0};
        TreeNode root = TreeNode.create(num);
        int  p = 2;
        int q = 8;
        TreeNode r = lowestCommonAncestor(root,p,q);
        System.out.println(r);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root==null)return null;
        if(lowestCommonAncestor3(root,p,q)){
            if(lowestCommonAncestor3(root.left,p,q))return lowestCommonAncestor(root.left,p,q);
            if(lowestCommonAncestor3(root.right,p,q))return lowestCommonAncestor(root.right,p,q);
            else return root;
        }
        return null;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p) {
        if(root == null)return null;
        if(root == p)return root;
        if(lowestCommonAncestor2(root.left,p) != null)return root.left;
        if(lowestCommonAncestor2(root.right,p) != null)return root.right;
        return null;
    }

    public static boolean lowestCommonAncestor3(TreeNode root, int p, int q) {
        if(root == null)return false;
        if(root.val ==p){
            return lowestCommonAncestor3(root,root.val,q);
        }
        else if(root.val==q){
            return lowestCommonAncestor3(root,p,root.val);
        }
        else return lowestCommonAncestor3(root.left,p,q) || lowestCommonAncestor3(root.right,p,q);
    }
}
