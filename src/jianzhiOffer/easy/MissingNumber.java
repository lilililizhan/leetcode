package jianzhiOffer.easy;

import java.util.ArrayList;

public class MissingNumber {
    /*
    首先考虑二分查找，由于数据分布非常均匀，可以考虑插值查找
    判断索引值和当前的值是否相等，
    应该判断索引差和值差是否相等
    最初的方法一直不对，换一种思路

    这么简单的题，做了这么久，最后在return加一个判断即可，方法2时间100%，空间45%
    尝试一下递归，
    还是不用递归了，因为存在[1,2,3]的问题

     */
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] nums1 = {0,1,2,3,4,5,6,7,9};
        int[] nums2 = {0,1,3};
        int[] nums3 = {0};
        int[] nums4 = {1,2};
        int[] nums5 = {0,2,3};
        int[] nums6 = {0,1,2,4,5,6,7,8,9};
        int[] nums7 = {0,1};
        int[] nums8 = {1,2,3};
        list.add(nums1);
        list.add(nums2);
        list.add(nums3);
        list.add(nums4);
        list.add(nums5);
        list.add(nums6);
        list.add(nums7);
        list.add(nums8);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(missingNumber2(list.get(i)));
        }
        System.out.println(missingNumber2(nums8));

    }
    public static int missingNumber(int[] nums) {
        if(nums[nums.length-1]==nums.length-1)return nums.length;
        if(nums[0] != 0 )return 0;
        int start = 0;
        int end = nums.length-1;
        int mid ;
        while(start<end){
            mid = (start+end)/2;
            if(end - mid == nums[end]- nums[mid]){
                end = mid-1;
            }
            else if(mid-start == nums[mid]-nums[start]){
                start = mid+1;
            }
            else {
                start = mid;
//                end = mid;
            }
        }
        return start;
    }
    public static int missingNumber2(int[] nums){
        if(nums[nums.length-1]==nums.length-1)return nums.length;
        int low = 0;
        int high = nums.length-1;
        int mid =0;
        while(low < high){
            mid = (low+high)/2;
            if(mid == nums[mid]){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return nums[low]== low  ? low+1:low;
    }

    public static int missingNumber3(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        mid = (low+high)/2;
//        if()
        return 0;
    }
}
