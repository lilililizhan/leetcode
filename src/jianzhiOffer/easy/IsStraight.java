package jianzhiOffer.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class IsStraight {
    /*
    首先是[1,10,11,12,13]，不是顺子，
    先排序，统计0的个数，同时判断相邻两数是否连续，不连续的话差多少
    注意[0,0,2,2,5]
    时间91%，内存53%

    官方解答：
    去点大小王，当最大值-最小值<5时，可构成顺子
     */
    public static void main(String[] args) {
        int[] nums1 ={1,2,3,4,5};
        int[] nums2 ={0,0,1,2,5};
        int[] nums3 ={1,10,11,12,13};
        int[] nums4 ={0,0,2,2,5};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(nums1);
        list.add(nums2);
        list.add(nums3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(isStraight(list.get(i)));
        }
        System.out.println(isStraight(nums4));
    }
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        int m =0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0)n++;
            else{
                if(nums[i+1]==nums[i])return false;
                m += (nums[i+1]-nums[i]-1);
            }
        }
        return n>=m ? true:false;
    }
}
