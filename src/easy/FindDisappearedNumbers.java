package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    /*
    不使用额外的空间，只使用最后的数组？初始化为含有所有值的List，然后出现了就删除
    最简单的方法超出了时间限制
    尝试第二种，先对数组排序，设置索引，并更新索引，直接使用索引进行删除

    时间：5.35%,内存85%

    官方的解答厉害，直接在nums上统计出现过的情况，若某一x出现过，mums[x-1]+=n,注意取模操作，对原数组进行还原，充分发挥nums的价值
     */
    public static void main(String[] args) {
//        int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums = {};
        List<Integer> r = findDisappearedNumbers2(nums);
        System.out.println(r.toString());


    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rlist = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            rlist.add(i);
        }
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = rlist.indexOf(nums[i]);
            if(index != -1)rlist.remove(index);
        }
        return rlist;
    }
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> rlist = new ArrayList<>();
        if(nums.length==0)return rlist;
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            rlist.add(i);
        }
        int index =nums[0]-1;
        rlist.remove(index);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1] != 0 ){
//                if (nums[i] - nums[i-1] >1){
                    index += nums[i] - nums[i-1]-1;
//                }
                rlist.remove(index);
            }
        }
        return rlist;
    }
}
