package tree;

import lianbiao.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    //感觉需要写一个根据数组构造的方法，和遍历的方法，感觉和完全二叉树有点类似

    //遍历的方法，和高度有关，记住每一层是多少高度
//    需要使用递归的方法吗，不用吧
//    先找到高度，构造完全二叉树的数组，然后依次对数组进行修改
    public int height(){
        return Math.max(left != null ? left.height()+1:1,right != null?right.height()+1:1);
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
        if(r.length==0)return null;
        TreeNode root = new TreeNode(r[0]);
        create2(r,0,root);
        return root;
    }



    public static void create2(int[] r, int num, TreeNode tem){
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
//使用队列实现,层序遍历
    public static  void cengxu(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode t = deque.removeFirst();
            System.out.println(t.val);
            if (t.left != null) deque.addLast(t.left);
            if (t.right != null) deque.addLast(t.right);
        }
    }

//    实现层序遍历，按层打印,记录每层的个数
//    只使用一个变量，记录当前行的个数，当前行结束后，剩余即为下一行的个数
    public static void cengxu2(TreeNode root){
        if(root == null)return;
        int n =1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            if(n !=0){
                n -=1;
            }
            else {
                n = deque.size()-1;
                System.out.println();
            }
            TreeNode t = deque.removeFirst();
            System.out.print(t.val+"--");
            if (t.left != null) deque.addLast(t.left);
            if (t.right != null) deque.addLast(t.right);
        }

    }

}
