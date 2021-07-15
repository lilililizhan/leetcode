package test;


import java.util.*;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public  static TreeNode create(int[] r){
        TreeNode root = new TreeNode(r[0]);
        create2(r,0,root);
        return root;
    }
    public static void create2(int[] r, int num, TreeNode tem){
        if(num*2+1<r.length){
            if(r[num*2+1] >=0){
                TreeNode l = new TreeNode(r[num*2+1]);
                tem.left = l;
                create2(r,num*2+1,l);}
        }
        if(num*2+2<r.length){
            if(r[num*2+2] <0)return;
            TreeNode ri = new TreeNode(r[num*2+2]);
            tem.right = ri;
            create2(r,num*2+2,ri);
        }
    }

}

public class t0429 {
    public static void main(String[] args) {
        int[] arr = {5,3,7,2,4,6,8};
        TreeNode root = TreeNode.create(arr);
        TreeNode r = KthNode(root,3);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i).val);
//        }
        System.out.println(r.val);

    }
    static TreeNode KthNode(TreeNode pRoot, int k) {
        kthNode3(pRoot);

        for(int i =0;i<res.size();i++){
            // System.out.println(res.get(i).val);
            if(i == k-1){
                return res.get(i);
            }
        }
        return null;

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

    static TreeNode kthNode2(TreeNode root, int k,int[] index){
        if(root.left != null){
            if(kthNode2(root.left,k,new int[]{index[0]+1}) != null)
                return kthNode2(root.left,k,new int[]{index[0]+1});
        }
        if(index[0] == k ){
            System.out.println(root.val);
            return root;
        }
        else{
            index = new int[]{index[0]+1};
        }
        if(root.right != null){
            if(kthNode2(root.right,k,new int[]{index[0]+1})!= null)
                return kthNode2(root.right,k,new int[]{index[0]+1});
        }
        return null;
    }


}