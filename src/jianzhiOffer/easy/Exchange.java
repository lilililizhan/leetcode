package jianzhiOffer.easy;

import java.util.Arrays;

public class Exchange {
    /*
    只要求技术偶数分开，并没有要求奇数和偶数内部有顺序
    奇数在前，偶数在后
    定义索引start++,end--,
    循环，交换位置

    官方的解法，没看太懂
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] r = exchange(nums);
        System.out.println(Arrays.toString(r));

    }
    public static int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int temp = 0;
        while(start < end){
            if(nums[start]%2 ==0){
                temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end --;
            }
            else{
                start ++;
            }
        }
        return nums;
    }
}
