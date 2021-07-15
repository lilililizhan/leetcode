package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    /*
    这个题是广度遍历，简单级别的，编号101，这道题真的是简单吗。。

    第一种，先按层遍历，然后判断每一层是否对称
        存在的一个问题是，最终得到的每层数组是对称的，但数组不对称，如[0,3],[0,3]
    第二种，直接判断是否对称，
        对每一层，从两端开始遍历判断，同时将节点加入queue

    之前官方对树的遍历，很好的地方是没有使用递归

    这个题关键的地方是，对queue啥时候变化搞不清,
    迭代的最后代码跑通了，时间6%，空间5%，迭代的算法定义了太多的临时变量

    尝试一下递归的算法，
    递归的话，从上到下吧，只对非叶子节点进行判断，对两个非叶子子节点进行判断

    递归的代码，对叶子节点甚至空节点也进行判断，时间100%，空间46%

    官方迭代的也好简单啊，再尝试一下。不尝试了，官方迭代的时候也用了两个参数


     */
    public static void main(String[] args) {

//        int[] num = {1,2,2,3,4,4,3};//true
//        int[] num = {1,2,2,0,3,3};//true
//        int[] num = {1,2,2,0,3,0,3};//false
//        int[] num = {2,3,3,0,5,5,4};//false
        int[] num = {2,3,3,4,5,5,4,6,0,8,9,9,8,0,6};//true
        TreeNode root = TreeNode.create(num);
//        boolean r  = isSymmetric(root);
//        System.out.println(r);

        boolean r  = isSymmetric2(root);
        System.out.println(r);


    }
    public static boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queuetempl = new LinkedList<>();
        LinkedList<TreeNode> queuetempr = new LinkedList<>();
        if(root != null)queue.add(root);
        while(! queue.isEmpty()){
            if(queue.size() %2 !=0 && queue.size() >1)return false;
            if(queue.size() ==1){
                if(queue.get(0) ==root){
                    queue.poll();
                    if(root.left != null)queue.add(root.left);
                    if(root.right != null)queue.add(root.right);
                }
                else return false;
            }
            queuetempl.clear();
            queuetempr.clear();
            int len = queue.size();
            for (int i = 0; i < len/2; i++) {
                TreeNode nodel = queue.pollFirst();
                TreeNode noder = queue.pollLast();

                if(nodel.val != noder.val)return false;
                else {
                    if(nodel.left != null){
                        if(noder.right == null)return false;
                        queuetempl.add(nodel.left);
                        queuetempr.addFirst(noder.right);
                    }
                    else if(nodel.left == null){
                        if(noder.right != null)return false;
                    }
                    if(nodel.right != null){
                        if(noder.left == null)return false;
                        queuetempl.add(nodel.right);
                        queuetempr.addFirst(noder.left);
                    }
                    else if(nodel.right == null){
                        if(noder.left != null)return false;
                    }
                }

            }
            queue.addAll(queuetempl);
            queue.addAll(queuetempr);
        }
        return true;
    }


//节点可以为空
    public static boolean isSymmetric2(TreeNode root){
        if(root ==null)return true;
        return isSymmetric3(root.left,root.right);
    }
    public static boolean isSymmetric3(TreeNode nodel,TreeNode noder) {
        if((nodel == null && noder != null) ||(nodel !=null) && noder ==null )return false;
        else if(nodel ==null && noder ==null)return true;
        if(nodel.val != noder.val)return false;
        return isSymmetric3(nodel.left,noder.right) && isSymmetric3(nodel.right,noder.left);
    }


    //尝试迭代的算法
    public static boolean isSymmetric4(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null)queue.add(root);
        while(! queue.isEmpty()) {

        }
        return true;
    }
}
