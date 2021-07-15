package easy;

import java.util.Arrays;
import java.util.Collections;

public class MaxSubArray {
    /*
    最简单的：两层嵌套
    似乎做过类似的，想起来了不一样，那个是注水最多，
    思路：从第一个正数开始，到下一个正数为止，这一小段的和如果小于等于0，则舍去（同时保留此段的最大值），否则保留
        特殊情况：单个数字时最大的情况，
        考虑到全为负数的情况
    感觉这个思路不太对啊、
    换个思路：只标记正数的位置，并根据中间的负数，判断该段是否保留，只对前面的段进行抛弃的操作，
    上面的思路还是比较糊涂
    新的思路：从两端对数组进行判断，正数负数和大于0则保留，小于则舍弃，迭代的思想,结束的标志是减枝后不变

    各种问题一直出错，换一种思路
     */
    public static void main(String[] args) {
//        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums =  {1,-1,1};
//        int[] nums =  {-3,1,-2,2};
//        int[] nums =  {2,-1,-1,2,0,-3,3};
        int[] nums =  {0,0,3,3,0,-2,3,-2,-1,-1,2,1};//出粗
        System.out.println(maxSubArray(nums));
//        int[] r = nums;
//        r = maxSub(nums);
//        for (int j = 0; j < r.length; j++) {
//            System.out.println(r[j]);
//        }
//        int temp[];
//        while(true){
//           temp = maxSub(r);
//           if(temp.length == r.length || temp.length<=2){
//               break;
//           }
//           r = temp;
//        }
//        for (int i = 0; i <temp.length ; i++) {
//            System.out.println(temp[i]);
//        }
////        for (int i = 0; i < 5; i++) {
////           r = maxSub(r);
////           for (int j = 0; j < r.length; j++) {
////                System.out.println(r[j]);
////            }
////           System.out.println("-------------");
////        }


    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int max = Arrays.stream(nums).max().getAsInt();
//        System.out.println(max);
        if(max<=0)return max;
        int[] r = nums;
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
//        System.out.println("---------");
        int[] temp =r;
        while(r.length>=2){
            temp = maxSub(r);
            if(temp.length == r.length || temp.length<=2){
                break;
            }
            r = temp;
        }
        int sum =0;
        System.out.println("----------");
        for (int i = 0; i <temp.length ; i++) {
            sum+=temp[i];
            System.out.println(temp[i]);
        }
        return Math.max(sum,max);

    }
    public static int[] maxSub(int [] nums) {
        int starttemp=0;
        int start = 0;
        int end = nums.length-1;
        int endtemp = nums.length-1;
        //从0开始，到下正数为止
        int startsum = nums[0];
        int endsum = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {//数组长度大于等于2
            if (nums[i] > 0){
                if(startsum>0){start = starttemp;}
                else {
                    start =i;
                }
                break;
            }
            startsum += nums[i];
        }
        for (int i = nums.length-2; i >=start; i--) {//数组长度大于等于2
            if (nums[i] > 0){
                if(endsum>0){end = endtemp;}
                else {
                    end =i;
                }
                break;
            }
            endsum += nums[i];
        }
        return Arrays.copyOfRange(nums,start,end+1);
    }
}
