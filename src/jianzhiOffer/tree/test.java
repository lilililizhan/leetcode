package jianzhiOffer.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
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

//        System.out.println(node3.height());

        int[] rlist = {3, 9, 20, 0, 0, 15, 7};
        TreeNode root = TreeNode.create(rlist);
//        int[] r = root.cengorder();
//        System.out.println(Arrays.toString(r));

        int h = maxDepth(root);
        System.out.println(h);

    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
//        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        List<TreeNode> queue = new LinkedList<>() ;
        queue.add(root);
        List<TreeNode> tmp = new LinkedList<>() ;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
