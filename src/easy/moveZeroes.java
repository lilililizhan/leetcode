package easy;

import java.util.Arrays;

/*
283,移动零，简单，在原数组的基础上移动，
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

两个指针，一个指向零，一个指向非零的，
指向非零的要在指向零的后面
时间12%，空间15%

官方解法：使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
只需要把非零的移过来，零的全部补0即可
 */
public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,1};
        moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void moveZeroes(int[] nums) {
        int index0 =  0;
        int index1 = 0;
        while(index1 <nums.length){
            while(index0 < nums.length && nums[index0] !=0)index0++;
            index1 = index0+1;//保证index1在index0的后面
            while(index1 < nums.length && nums[index1] ==0)index1++;
            if(index1>=nums.length)break;
            nums[index0] = nums[index1];
            nums[index1] = 0;
            index0 += 1;
        }
    }

//    错误的解法
    public static void moveZeroes2(int[] nums) {
        int index0 =  0;
        int index1 = 0;
        while(index1 <nums.length){
            while(index0 < nums.length && nums[index0] !=0)index0++;
            while(index1 < nums.length && nums[index1] ==0)index1++;
            if(index1>=nums.length || index0 >= nums.length )break;
            nums[index0] = nums[index1];
            nums[index1] = 0;
        }
    }

    public static void moveZeroes3(int[] nums){
        int fast = 0, slow =0;
        while(fast < nums.length){
            if(nums[fast] !=0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
