package jianzhiOffer.easy;

import java.util.Arrays;

public class TwoSum {
    /*
    无意间看到解答，说用双指针，一个指头，一个指尾，太机智了吧
    和小于的话头指针后移，和大于的话尾指针前移
    还有别的可能吗，似乎是没有了
    [1,3,4,8,14]
    数组是升序的，
    时间34%，空间75%

    按我的笨方法，写两层循环，但是两层循环的起点和终点不好判断

     */
    public static void main(String[] args) {
//        int[] nums  = {2,7,11,15};
//        int target = 9;

        int[] nums  = {10,26,30,31,47,60};
        int target = 40;
        int[] r = twoSum(nums,target);
        System.out.println(Arrays.toString(r));

    }
    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            if(nums[start]+nums[end] == target){
                return new int[]{nums[start],nums[end]};
            }
            else if(nums[start]+nums[end] < target){
                start++;
            }
            else end--;
        }
        return null;
    }
}
