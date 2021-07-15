package backtrack;

import javax.swing.*;
import java.util.*;

public class permute {
    private static Set<Integer> settemp;

    /*
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。

        回溯问题，middle，46
        似曾相识，感觉像回溯+剪枝，每次判断temp的长度，然后添加到结果列表中
        时间10%，空间36%

        官方使用回溯的算法，并且进行了换位操作，感觉比较神奇
        官方的写法真妙,时间52%，空间97%
        记住官方的题解

        剪枝是这样的：
        由于回溯算法的时间复杂度很高，因此在遍历的时候，如果能够提前知道这一条分支不能搜索到满意的结果，就可以提前结束，这一步操作称为 剪枝。
         */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        List<List<Integer>> rlist = permute(nums);
        List<List<Integer>> rlist = bpermute(nums);
        System.out.println(rlist);

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rlist = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            settemp.add(nums[i]);
//        }
        permute3(rlist,temp,settemp,nums);
        return rlist;
    }

    public static List<List<Integer>> bpermute(int[] nums) {
        List<List<Integer>> rlist = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        backtrack(rlist,nums.length,temp,0);
        return rlist;
    }
    public static void permute2(List<List<Integer>> rlist, LinkedList<Integer> temp, Set<Integer> set, int length) {
        if(temp.size() == length){
            rlist.add(temp);
            return;
        }
//这个地方出错了，不知道为啥，循环的地方吧，容易出错，换个循环的方式
        for (Integer i:set
             ) {
            temp.add(i);
            set.remove(i);
            permute2(rlist,temp,set,length);
            set.add(i);
            temp.removeLast();
        }
    }
    public static void permute3(List<List<Integer>> rlist, LinkedList<Integer> temp, Set<Integer> set, int[] nums) {
        if(temp.size() == nums.length){
            rlist.add(new ArrayList<>(temp));
//            rlist.add(temp);//这里的add会出错，一定要new一个新的,否则更改temp,rlist也会更改
            return;
        }
//这个地方出错了，不知道为啥，循环的地方吧，容易出错，换个循环的方式
        for (int i = 0; i < nums.length; i++) {
            if( !set.contains(nums[i])){
                set.add(nums[i]);
                temp.add(nums[i]);
                permute3(rlist,temp,set,nums);
                temp.removeLast();
                set.remove(nums[i]);
            }
        }
    }
    public static void backtrack(List<List<Integer>> rlist, int length, List<Integer> num, int first){
        if(first == length){
            rlist.add(new ArrayList<Integer>(num));
            return;
        }
        for (int i = first; i < length; i++) {
            Collections.swap(num,first,i);
            backtrack(rlist,length,num,first+1);
            Collections.swap(num,first,i);
        }
    }

}
