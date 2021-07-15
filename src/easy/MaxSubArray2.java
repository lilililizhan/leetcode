package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArray2 {
    /*
    减少数组的长度，相邻的>0或<0的替换为一个
    再次选择放弃，
     */
    public static void main(String[] args) {
//        int[] nums =  {0,0,3,3,0,-2,3,-2,-1,-1,2,1};
//        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums =  {1,-1,1};
//        int[] nums =  {-3,1,-2,2};
//        int[] nums =  {2,-1,-1,2,0,-3,3};
//        int[] nums =  {3,1,-3,-3,2,1};
        int[] nums =  {-9,-3,2,8,-6,5,2,-3,-9,5,-5,-1,9,-7,4,0,1,7,-4};
//        int[] nums =  {0,0,3,3,0,-2,3,-2,-1,-1,2,1};//出粗
        System.out.println(maxSubArray(nums));


    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int max = Arrays.stream(nums).max().getAsInt();
//        System.out.println(max);
        if(max<=0)return max;
        int[] r = maxSub(nums);
        int max2 = Arrays.stream(r).max().getAsInt();

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
//        System.out.println("---------");
        int[] temp =r;
        while(r.length>=2){
            temp = maxSub2(r);
            if(temp.length<2){
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
        return Math.max(sum,max)>= max2?Math.max(sum,max):max2;

    }
//    public static int maxSubArray(int[] nums) {
//        if(nums.length==1)return nums[0];
//        int max = Arrays.stream(nums).max().getAsInt();
////        System.out.println(max);
//        if(max<=0)return max;
//        int[] r = maxSub(nums);
//        int max2 = Arrays.stream(r).max().getAsInt();
//
////        for (int i = 0; i < nums.length; i++) {
////            System.out.println(nums[i]);
////        }
////        System.out.println("---------");
//        int[] temp =r;
//        while(r.length>=2){
//            temp = maxSub2(r);
//            if(temp.length == r.length || temp.length<=2){
//                break;
//            }
//            r = temp;
//        }
//        int sum =0;
//        System.out.println("----------");
//        for (int i = 0; i <temp.length ; i++) {
//            sum+=temp[i];
//            System.out.println(temp[i]);
//        }
//        return Math.max(sum,max)>= max2?Math.max(sum,max):max2;
//
//    }

    public static int[] maxSub(int[] nums){
        ArrayList<Integer> tempList  =new ArrayList<>();
//        System.out.println(nums.get(0));
        boolean b = (nums[0])>=0;
        boolean btemp;
        int sumtemp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            btemp = nums[i] >=0 ;
            if(!b^btemp){
                sumtemp +=nums[i];
            }
            else {
                tempList.add(sumtemp);
                b = nums[i]>=0 ;
                sumtemp = nums[i];
            }
        }
        tempList.add(sumtemp);
        int[] r = new int[tempList.size()];
        for (int i = 0; i < tempList.size() ; i++) {
            r[i] = tempList.get(i);
        }
        return r;
    }
    public static int[] maxSub2(int [] nums) {
        int starttemp=0;
        int start = 0;
        int end = nums.length-1;
        int endtemp = nums.length-1;
        //从0开始，到下正数为止
        int startsum = nums[0];
        int endsum = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {//数组长度大于等于2
            if (nums[i] > 0){
                if(startsum>0){
                    start = starttemp;
                    nums[i]=startsum+nums[i];
                }
                else {
                    start =i;

                }
                break;
            }
            startsum += nums[i];
        }
        for (int i = nums.length-2; i >=start; i--) {//数组长度大于等于2
            if (nums[i] > 0){
                if(endsum>0){
                    end = endtemp;
                    nums[i]=endsum+nums[i];
                }
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
