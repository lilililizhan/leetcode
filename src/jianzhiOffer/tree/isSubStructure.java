package jianzhiOffer.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class isSubStructure {
    /*
    剑指offer,26,middle,
    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    B是A的子结构， 即 A中有出现和B相同的结构和节点值。

    两层循环，外层A,内层B，依次判断,
    怎么循环呢，递归吧，
   递归的起点呢，先存入所有节点，

  [3,4,5,1,2][4,1]true;
  时间5%，空间5%

  官方的答案，太多递归了吧，我感觉思路基本上是一致的，
  官方写法太高级了，
     */
    public static void main(String[] args) {
//        int[] a = {3,4,5,1,2};
//        int[] b = {4,1};//true

        int[] a = {1,2,3};
        int[] b = {3,1};//true
        TreeNode A  = TreeNode.create(a);
        TreeNode B = TreeNode.create(b);
        boolean r = isSubStructure(A,B);
        System.out.println(r);
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B ==null)return false;
        Queue<TreeNode> list = new LinkedList<>();
        TreeNode temp = A;
        list.add(temp);
        boolean r;
        while(!list.isEmpty()){
            temp = list.poll();
            if(temp.left != null)list.add(temp.left);
            if(temp.right != null)list.add(temp.right);
            if(temp.val == B.val){
                r = isSubStructure1(temp,B);
                if(r)return true;
            }

        }
        return false;
    }


    public static boolean isSubStructure1(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }
        else {
            if(A==null)return false;
            else return A.val == B.val && isSubStructure1(A.left,B.left)&& isSubStructure1(A.right,B.right);
        }
    }


    //官方写法
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }
        boolean recur(TreeNode A, TreeNode B) {
            if(B == null) return true;
            if(A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }

}
