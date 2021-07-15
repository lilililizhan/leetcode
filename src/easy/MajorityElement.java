package easy;

import java.util.Arrays;

public class MajorityElement {
    /*
    先排序,
    既然一定存在多数元素，所以排序后的数组，
        如果数组奇数个元素，中间的数一定是多数元素，
        如果偶数个元素，中间的数也一定是多数元素，因为多数元素的次数大于length/2
    使用sort函数，时间复杂度和空间复杂度会超出题目的要求
     */
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};
        int r = majorityElement(nums);
        System.out.println(r);

    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int times  = nums.length/2;
//        boolean b = false;
//        int n = nums[0];
        return nums[times];
    }
}
