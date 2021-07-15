package jianzhiOffer.dp;

public class MaxSubArray2 {
    /*
    这个动态规划的好简单啊
     */
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int [] nums = {1};
//        int [] nums = {0};
//        int [] nums = {-2,1};
//        int [] nums = {-1,-2};
//        int [] nums = {-1};
        int r = maxSubArray(nums);
        System.out.println(r);
    }
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]>0)nums[i]=nums[i]+nums[i-1];
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
