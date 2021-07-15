package jianzhiOffer.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
剑指offer03，简单，
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

第一反应用set存储,时间29%，空间38%
官方：因为数的范围确定，所以用大小一定的数组进行存储，看某处是否有值
官方二：原地交换，数组的索引和值是一一对应的，
第一次遇到数字 xx 时，将其交换至索引 xx 处；
而当第二次遇到数字 xx 时，一定有 nums[x] = xnums[x]=x ，此时即可得到一组重复数字。
时间84%，空间71%

难点：如何遍历，可以用索引年里吗？可以


 */

public class FindRepeatNumber {
    /*
    先排序，再查找
     */
    public static void main(String[] args) {
        int[] nums ={2, 3, 1, 0, 2, 5, 3};
        int r = findRepeatNumber3(nums);
        System.out.println(r);

    }
    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){

                return nums[i];
            }
        }
        return -1;
    }
    public static int findRepeatNumber2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))return nums [i];
            else set.add(nums[i]);
        }
        return -1;
    }

    public static int findRepeatNumber3(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] == i )continue;
            if(nums[nums[i]] == nums[i])return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
//            极其容易出错的一步，nums[i]是在不停变化的，所以需要temp固定值来存储
//            int temp = nums[i];
//            nums[i] = nums[nums[i]];
//            nums[nums[i]] = temp;
        }
        return -1;
    }
}
