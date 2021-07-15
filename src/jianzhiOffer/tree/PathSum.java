package jianzhiOffer.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    /*
    和刚做的Exist比较相似，不同的是，这个树，不用考虑回溯的情况

    是否要返回类型呢？

    难题又是不知道如何回溯，

    第一种写法，由于判断了子节点是否为空，会造成结果是双份的，重新修改

    看错了题，需要遍历至叶子节点

    我不想写了


    （果然当天的状态不行）
    有案例如下：
    [-2,null,-3]
    -5

    [0,1,1] 1

    在这个题中，多次递归，通过引用类型而不是return传参，太容易出错了

    时间8.61%，空间5.02%

     */
    public static void main(String[] args) {
//        int[] num = {5,4,8,11,0,13,4,7,2,0,0,0,0,5,1};
//        int target = 22;
        int[] num = {1,-2,-3,1,3,-2,0,-1};
        int target = -1;
//        int[] num = {0,1,1};
//        int target = 1;
        TreeNode root = TreeNode.create(num);
        pathSum(root,target);

//        System.out.println(Arrays.toString(root.cengorder()));
    }
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root ==null)return new ArrayList<>();
        List<List<Integer>> rlist = new ArrayList<>();
        List<List<Integer>> r= new ArrayList<>();
        ArrayList<Integer> alist = new ArrayList<>();
        path3(rlist,alist,root,target);
//        for (int i = 0; i < rlist.size(); i++) {
//            if(i%2==0){
//                if((rlist.get(i)).size()!= 0){
//                r.add(rlist.get(i));
//                System.out.println(rlist.get(i));
//                }
//            }
//        }
        for (int i = 0; i < rlist.size(); i++) {
            System.out.println(rlist.get(i));
        }
        return null;
    }
    public static boolean path(List<List<Integer>> rlist,ArrayList<Integer> alist,TreeNode root,int target){
        if(target==0 && root.left ==null && root.right == null){
            rlist.add(alist);
            return true;
        }
        if(root == null)return false;
        if(target <0)return false;
        ArrayList<Integer> blist = new ArrayList<>();
        for (int i = 0; i < alist.size(); i++) {
            blist.add(alist.get(i));
        }
        blist.add(root.val);
//        path(rlist,alist,root.left,target-root.val);
//        path(rlist,alist,root.right,target-root.val);
        boolean bool1 =path(rlist,blist,root.left,target-root.val);
        boolean bool2 =path(rlist,blist,root.right,target-root.val);
        return bool1 || bool2;
    }

    public static boolean path2(List<List<Integer>> rlist,ArrayList<Integer> alist,TreeNode root,int target){
        if(target==root.val){
            alist.add(root.val);
            rlist.add(alist);
            return true;
        }
        if(target < root.val)return false;
        ArrayList<Integer> blist = new ArrayList<>();
        for (int i = 0; i < alist.size(); i++) {
            blist.add(alist.get(i));
        }
        blist.add(root.val);
//        path(rlist,alist,root.left,target-root.val);
//        path(rlist,alist,root.right,target-root.val);
//        if(root.left != null){
//
//        }
        boolean bool1 =root.left != null? path(rlist,blist,root.left,target-root.val) :false;
        boolean bool2 =root.right != null ? path(rlist,blist,root.right,target-root.val):false;
        return bool1 || bool2;
    }

    public static void path3(List<List<Integer>> rlist,ArrayList<Integer> alist,TreeNode root,int target){
        if(root ==null)return;
        ArrayList<Integer> blist = new ArrayList<>();
        for (int i = 0; i < alist.size(); i++) {
            blist.add(alist.get(i));
        }
        if(target==root.val){
            if(root.left == null && root.right ==null){
                blist.add(root.val);
                rlist.add(blist);
                return;
            }

        }
//        if(target < root.val)return;
        blist.add(root.val);
        path3(rlist,blist,root.left,target-root.val);
        path3(rlist,blist,root.right,target-root.val);
    }


}
