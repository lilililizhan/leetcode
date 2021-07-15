package former;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;

//        int[] nums = {-3,-2,-5,3,-4};
//        int target = -1;

//        int[] nums = {1,1,1,0};
//        int target = 100;
        System.out.println(threeSumClosest(nums,target));

    }
    public static int threeSumClosest(int[] nums, int target){
        /*
        思路和之前的三数之和不太一样，因为涉及到绝对值大小的问题。
        但排序依然有用，因为可以跳过相同的数字。
        定义三个指针，分别代表第一，二，三个数。当数相同时，跳过此次循环。
        三个指针都可以使用跳过的操作。
        定义变量，存储三数之和与目标的差的绝对值。
        绝对不能进行数组去操作
         */
        Arrays.sort(nums);
        int sum0 = nums[0]+nums[1]+nums[2];
        int sum = Math.abs(nums[0]+nums[1]+nums[2]-target);
//        System.out.println(sum);
        int sumtemp;
        int first ;
        int second ;
        int third ;
        first = nums[0];
        for (int i = 0; i < nums.length; i++) {//初始化sum时从0开始，这里可以从1开始。不行，万一数组只有三个元素。

            if(i>0){
                if(nums[i] == first){
                    continue;
                }
                else {
                    first = nums[i];
                }
            }

            for (int j = i+1; j < nums.length; j++) {
                second = nums[i+1];
                if(j>i+1){
                    if(nums[j] == second){
                        continue;
                    }
                    else {
                        second = nums[j];
                    }
                }

                for (int k = j+1; k < nums.length; k++) {
                    third = nums[j+1];//放在外层循环，容易出错
                    if(k>j+1){
                        if(nums[k] == third){
                            continue;
                        }
                        else {
                            third = nums[k];
                        }
                    }
                    sumtemp = Math.abs(nums[i]+nums[j ]+nums[k]-target);
                    if(sumtemp < sum){
                        sum = sumtemp;
                        sum0 = nums[i]+nums[j ]+nums[k];
                        System.out.println(first+"-"+second+"-"+third);
                    }

                }

            }

        }
        return sum0;
    }
}
