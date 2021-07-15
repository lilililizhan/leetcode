package backtrack;

import java.util.*;

public class subsets {
    /*
    回溯，middle，题号78
    数组中的元素互不相同，所以子集的个数是确定的，即2^n
    如何添加呢，首先，元素不往回走，依次求出以每个元素开头的子集，每次都添加至结果集，然后记得回溯
    递归函数需要记下索引
    想法不对，还有[1,3]的结果
    可以选择对当前进行跳过，但这样的话会有重复，

    其实，这道题是分治算法，将数组分为更小的集合，
    回溯还是适合连续的情况，
    尝试将set转为list,时间11%，空间34%

    尝试一下分治,分治的时候temp=res.get(i),容易出错，要对temp新建，否则会使两者指同样的地址
    时间81%，空间40%

    回溯算法官方答案那里，也是分为两种情况，当前取或不取，不同的是index==length时，才将其加入结果集，避免了重复
    官方还给了二进制法，来表示每一个元素是否加入
         */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        int[] nums = {0};
//        List<List<Integer>> r = subsets30(nums);
        List<List<Integer>> r = subsets(nums);
        System.out.println(r);

    }
    public static List<List<Integer>> subsets30(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        subsets3(nums,0,res);
        return res;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<List<Integer>> r = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        res.add(new ArrayList<>());
        subsets2(nums,0,res,path);
        for (int i = 0; i < nums.length; i++) {
            subsets2(nums,i,res,path);
        }
        for (List<Integer> l:res
             ) {
            r.add(l);
        }

        return  r;
    }
    public static void subsets2(int[] nums,int index,HashSet<List<Integer>> res, Deque<Integer> path) {
        if(path.size() !=0){
            res.add(new ArrayList<>(path));//注意这里的类型转换
//            return;
        }
        if(index >= nums.length)return;
        subsets2(nums,index+1,res,path);
        path.add(nums[index]);
        subsets2(nums,index+1,res,path);
//        subsets2(nums,index+2,res,path);
        path.removeLast();
    }

    public static void subsets3(int[] nums,int index,List<List<Integer>> res) {
       if(index >= nums.length)return;
       if(index ==0){
           res.add(new ArrayList<>());
           res.add(new ArrayList<Integer>(){
               {
                   add(nums[0]);
               }
           });
       }
       else {
           List<Integer> temp = new ArrayList<>();
           for (int i = 0; i < Math.pow(2,index); i++) {
               temp = new ArrayList<>(res.get(i));
               temp.add(nums[index]);
               res.add(temp);
           }
       }
       subsets3(nums,index+1,res);
    }
}
