package tree;

import java.util.ArrayList;

public class kthSmallest {
    /*
    一样的代码，在leetcode上自测和提交的结果不一样
     */
    public static void main(String[] args) {
//        int[] arr = {5,3,7,2,4,6,8};
        int[] arr = {4,2,5,0,3};
        TreeNode root = TreeNode.create(arr);
        int r = kthSmallest(root,1);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i).val);
//        }
        System.out.println(r);
    }

    public static int kthSmallest(TreeNode root, int k) {
//        kthNode3(root);
//
//        for(int i =0;i<res.size();i++){
//            if(i == k-1){
//                return res.get(i).val;
//            }
//        }
//        return 0;
        return kthNode(root,new int[]{0},k);


    }
    static ArrayList<TreeNode> res = new ArrayList<>();
    static void kthNode3(TreeNode root){
        if(root.left != null){
            kthNode3(root.left);
        }
        res.add(root);
        if(root.right != null){
            kthNode3(root.right);
        }
    }

    //这个地方容易出错在于，多写了一次kthNode(root.left,num,k)，导致num多更新了一次
    //但是还是出错了
    static int kthNode(TreeNode root, int[] num,int k){
        if(root.left != null){
            int t = kthNode(root.left,num,k);
            if( t !=0)return t;
        }
        if(num[0]==k-1)return root.val;
        else num[0] += 1;
        if(root.right != null){
            int t = kthNode(root.right,num,k);
            if(t != 0)return t;
        }
        return 0;
    }
}
