package middle;

import java.util.Arrays;

public class NextPermutation {
    /*
    对[1,6,3,1]而言，就是找到[6,3,1]降序排列的前一位1，然后将[6,3,1]中的最小值1移到1的位置，剩下的三位升序排列
    对[1,6,1,3]而言，有升序[1,3]，就修改为降序
    对[1,6,2,5,4]而言，[5,4]降序，对[2,5,4],用4替换2，并升序

    即找到升序的位置，然后替换（最小值替换）并排序,即后面的都是降序的
     */
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        int[] nums = {3,2,1};
//        int[] nums = {1,1,5};
//        int[] nums = {1};
//        int[] nums = {1,3,2};
//        int[] nums = {2,3,1};
        int[] nums = {1,5,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void nextPermutation(int[] nums) {
        int index = -1;
        for (int i =nums.length-1; i >=1 ; i--) {
            if(nums[i]>nums[i-1]){
               index = i-1;
               break;
            }
        }
        if(index ==-1) Arrays.sort(nums);
        else {
//            这里要找下一个比nums[index]大的数，不是最小数也不是最大数
            int temp = 0;
            temp = nums[index];
//            nums[index] = nums[nums.length-1];
//            nums[index+1] = temp;
//            index+1 的值肯定是最大值，就是不知道index和其他位置的值，先将index和index+1的值交换，剩下的排序
//            问题变为如何排序，直接首位换位置吧
//            1-5-4-3-2
            for (int i = nums.length-1; i >index; i--) {
                if(nums[i]<=temp){
//                    nums[i] = nums[i-1];//前移
                }
                else {
                    nums[index] = nums[i];
                    nums[i] = temp;
                    break;
                }

            }
            for (int i = 1; i <= (nums.length-index)/2; i++) {
                temp = nums[index+i];
                nums[index+i] = nums[nums.length-i];
                nums[nums.length-i] = temp;
            }
        }

    }
}
