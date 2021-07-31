package tree;
/*
104,二叉树的最大深度，简单

尝试一下非递归的方法，这是粉笔的现场面试题啊
 */
public class maxDepth {
    public static void main(String[] args) {
        int[] tree = {3,9,20,0,0,15,7};
        TreeNode root = TreeNode.create(tree);
        int height  = maxDepth(root);
        System.out.println(height);
    }
    public static int maxDepth(TreeNode root) {
        if(root ==null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
