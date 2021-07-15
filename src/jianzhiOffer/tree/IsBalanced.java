package jianzhiOffer.tree;

public class IsBalanced {
    /*
    从下往上递归，
    从叶子节点开始，保留每一个节点的深度，使用数组来保存
    或者直接将节点的值修改为节点的深度，但是不太行，修改的话需要从下到上先遍历一遍才行，
    也可以通过之前的求深度的函数来完成，但调用的次数太多了，
    感觉，这像是一个后序遍历

    怎么测试用例不对呢，
    这题是简单题吗，不像啊
    发现了，是树的构造方法不同，

    看不懂树的构造方法了

    更换了
     */
    public static void main(String[] args) {
//        int[] num = {3,9,20,0,0,15,7};
//        int[] num = {1,2,2,3,3,0,0,4,4};
//        int[] num = {1};
        int[] num = {1,2,2,3,0,0,3,4,0,0,0,0,0,0,4};//换成这种树，就对了，不懂为什么
//        int[] num = {1,2,2,3,0,0,3,4,0,0,4};
        TreeNode root = TreeNode.create(num);
        boolean r = isBalanced(root);
        System.out.println(r);

    }
    public static boolean isBalanced(TreeNode root) {
//        return isbalanced2(root)!= -1;
        if(root == null)return true;
        isbalanced(root);
        if(root.left==null){
            if(root.right ==null)return true;
            else return root.right.val<=1;
        }
        else if(root.right==null)return root.left.val<=1;
        return Math.abs(root.left.val -root.right.val)<=1;

//        return true;
    }
    public static int isbalanced(TreeNode root){
        if(root == null)return 0;
        if(root.left ==null)root.val=isbalanced(root.right)+1;
        else {
            if(root.right == null)root.val = isbalanced(root.left)+1;
            else{
                root.val = Math.max(isbalanced(root.left),isbalanced(root.right))+1;
            }
        }
        return root.val;
    }

    public static int isbalanced2(TreeNode root){
        if(root==null)return 0;
        if(isbalanced2(root.left)== -1)return -1;
        if(isbalanced2(root.right)== -1)return -1;
        if(Math.abs(isbalanced2(root.left)-isbalanced2(root.right))<=1){
            return Math.max(isbalanced2(root.left),isbalanced2(root.right))+1;
        }
        return -1;

    }
}
