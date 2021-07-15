package test;

import java.util.*;

public class t05082 {
    /*
    网格化二叉树
    先计算出二叉树的坐标，再进行排序，
    再对结果进行输出
     */
    public static void main(String[] args) {
//        int[] arrroot= {0,1,2,3,4,5,-10,-10,6};
//        int[] arrroot= {-10};

//        TreeNode root = TreeNode.create(arrroot);
//        TreeNode root = null;
//        int[] res = getColMax(root);
//        System.out.println(Arrays.toString(res));
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int k =1;
        int res = max(arr,k);
        System.out.println(res);
    }
    public static int[] getColMax (TreeNode root){
        ArrayList<int[]> arrlist = getColMax2(root);
        if(arrlist ==null)return new int[0];
        Collections.sort(arrlist, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return o1[1]-o2[1];
                else return o1[0]-o2[0];
            }
        });
        ArrayList<Integer> resarr = new ArrayList<>();
        int temp1 = Integer.MIN_VALUE;
        int tempx= Integer.MAX_VALUE;
        for (int i = 0; i < arrlist.size(); i++) {
            int x = arrlist.get(i)[0];
            int y = arrlist.get(i)[1];
            if(x == tempx)temp1 = Math.max(y,temp1);
            else {
                if(temp1 != Integer.MIN_VALUE)resarr.add(temp1);
                tempx = x;
                temp1 = y;
            }
        }
        if(temp1 != Integer.MIN_VALUE) resarr.add(temp1);
        int[] res = new int[resarr.size()];
        for (int i = 0; i < resarr.size(); i++) {
            res[i] = resarr.get(i);
        }
        return res;
    }
    public static ArrayList<int[]> getColMax2 (TreeNode root) {
        // write code here
        if(root==null)return null;
        ArrayList<int[]> arrlist = new ArrayList<>();
        Deque<int[]> nodearr = new LinkedList<>();
        Deque<TreeNode> nodequeue = new LinkedList<TreeNode>();
        nodearr.add(new int[]{0,0});
        nodequeue.add(root);
        arrlist.add(new int[]{0,0});
        while(!nodequeue.isEmpty()){
            TreeNode temp = nodequeue.pop();
            int[] arrtemp = nodearr.pop();
            if(temp.left !=null){
                nodequeue.add(temp.left);
                nodearr.add(new int[]{arrtemp[0]-1,temp.left.val});
                arrlist.add(new int[]{arrtemp[0]-1,temp.left.val});
            }
            if(temp.right !=null){
                nodequeue.add(temp.right);
                nodearr.add(new int[]{arrtemp[0]+1,temp.right.val});
                arrlist.add(new int[]{arrtemp[0]+1,temp.right.val});
            }
        }
        return arrlist;
    }

    public static int max(int[] arr,int k){
        int t  = k*2+1;
        Arrays.sort(arr);
        int sum = 0;
        int index = arr.length-1;
        for (int i = 0; i < t*4; i++) {
            sum += arr[index];
            index--;
        }
        return sum;
    }
}

