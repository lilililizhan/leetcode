package jianzhiOffer.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x) { val = x; }
    TreeNode(int _val,TreeNode _left,TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    //感觉需要写一个根据数组构造的方法，和遍历的方法，感觉和完全二叉树有点类似

    //遍历的方法，和高度有关，记住每一层是多少高度
//    需要使用递归的方法吗，不用吧
//    先找到高度，构造完全二叉树的数组，然后依次对数组进行修改
    public int height(){
        return Math.max(left != null ? left.height()+1:1,right != null?right.height()+1:1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        System.out.println(node.val);
    }

    public int maxDepth(TreeNode root) {
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
    public int[] cengorder(){
        int h = 1;
        boolean b = true;
        int height = height();
        int[] r = new int[(int) Math.pow(2,height)-1];
        cengorder1(this,r,0);
        return r;
    }
    public void cengorder1(TreeNode root, int[] r,int num){
        r[num] = root.val;
        if(root.left != null)cengorder1(root.left,r, 2*num+1);//这里是乘号，不是幂
        if(root.right != null)cengorder1(root.right,r, (int) (2*num+2));
    }

    //构造树的方法
//    感觉因为要同时处理左子树和右子树，所以必须得使用递归了
    public  static TreeNode create(int[] r){
        TreeNode root = new TreeNode(r[0]);
        create2(r,0,root);
        return root;
    }
    public static void create2(int[] r, int num,TreeNode tem){
        if(num*2+1<r.length){
            if(r[num*2+1] !=0){
            TreeNode l = new TreeNode(r[num*2+1]);
            tem.left = l;
            create2(r,num*2+1,l);}
        }
        if(num*2+2<r.length){
            if(r[num*2+2]==0)return;
            TreeNode ri = new TreeNode(r[num*2+2]);
            tem.right = ri;
            create2(r,num*2+2,ri);
        }
    }
}
