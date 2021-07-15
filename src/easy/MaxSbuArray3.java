package easy;

import java.util.Arrays;

public class MaxSbuArray3 {
    /*
    放弃简单的方法，直接最基础的两层循环
    官方的动态规划+分治的算法，看不懂
     */
    public static void main(String[] args) {
//                int[] nums =  {0,0,3,3,0,-2,3,-2,-1,-1,2,1};
//        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums =  {1,-1,1};
//        int[] nums =  {-3,1,-2,2};
//        int[] nums =  {2,-1,-1,2,0,-3,3};
//        int[] nums =  {3,1,-3,-3,2,1};
//        int[] nums =  {-9,-3,2,8,-6,5,2,-3,-9,5,-5,-1,9,-7,4,0,1,7,-4};
        int[] nums =  {-1,0,-2};
        int r = maxSubArray(nums);
        System.out.println(r);
    }
    public static int maxSubArray(int[] nums) {
        int sum =nums[0];
        int sumtemp = 0;
        for (int i = 0; i < nums.length; i++) {
            sumtemp = nums[i];
            sum = sum>= sumtemp?sum:sumtemp;
            for (int j = i+1; j < nums.length; j++) {
                sumtemp += nums[j];
                sum = sum>= sumtemp?sum:sumtemp;
            }
        }
        return sum;
    }
}
