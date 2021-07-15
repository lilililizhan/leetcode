package middle;

import java.util.Arrays;

public class Search {
    /*
    终于看懂题目了，就是在一个已知的数组中寻找target，但该数组是经过有序数组旋转得到的，有一定规律
    所以难点在于如何快速查找到
    对旋转数组，若在0处旋转，结果为1-2-3-4-5-6-7-0，先升再降
              若在length-1处旋转，结果为7-0-1-2-3-4-5-6先降再升
              若在中间旋转，结果为4-5-6-7-0-1-2-3先升再降
     大概是二分查找算法，首先用二分查找找到两段有序的数组，关键在于转折点
                     接着在有序数组内使用二分查找找到数
     如何判断在一段内有序，
     长度小于5的就直接比较吧，省的考虑边界

     新的想法：找到拐点后直接排序，并二分查找，对二分查找的结果进行处理

     官方的方法：直接在二分查找的过程中筛选，少用了一次二分查找，
     */
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5,6,7,0};
//        int a =1;
//        int a = 7;
//        int a = 0;
//        int a = 5;
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int[] nums = new int[]{4,5,6,7,0,1,2,3};
//        int[] nums = new int[]{7,0,1,2,3,4,5,6};
//        int a =3;
//        int a =7;
//        int a =6;
//        int a =0;
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1,2,3,4,5,6};
        int a = 5;
//        int[] nums = new int[]{2,3,4,5,6,7,1};
//        int a = 1;
//        int a =0;
        int r = search(nums,a);
        System.out.println("r:  "+r);
//        System.out.println(se(nums,a));

    }
    public static int search(int[] nums, int target) {
        int index = -1;
        if(nums.length <=5){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == target){
                    index = i;
                }
            }
            return index;
        }
        int start  = 0 ;
        int end  = nums.length-1;
        int middle = (start+end)/2;
        int middle1 ,middle2 = -1;
        while(end - start >1){
            middle = (start+end)/2;
            middle1 = (start+middle)/2;
//            middle2 = (end+middle)/2;
            if((nums[start]-nums[middle1])*(nums[middle1]-nums[middle])>0){//通过画图，这一句判断是正确的,=0时说明start+1 = middle
                start = middle;
            }
            else if((nums[start]-nums[middle1])*(nums[middle1]-nums[middle])==0){
                if(nums[start]<nums[middle])start = middle;
                else end = middle;
            }
            else end = middle;
        }
        int[] num1,num2;
            num1 = Arrays.copyOfRange(nums,0,start);
            num2 = Arrays.copyOfRange(nums,end,nums.length);
        if(nums[start]==target)return start;
        if(end == nums.length-1 && nums[start]<nums[end])return se(nums,target);
        if(num2[num2.length-1]>=target){
            int r = se(num2,target);
            if(r!=-1){
                if(start==end)return r+start;
                else return r+start+1;
            }
            else return -1;
        }
        else return se(num1,target);
//        return -1;
    }
    public static int se(int[] a, int tar){
        int start = 0;
        int end = a.length-1;
        int middle;
        while (end - start>1){
            middle = (start+end)/2;
            if(a[middle]<tar){
                start = middle;
            }
            else{
                end = middle;
            }
        }
        if(a[start] ==tar)return start;
        else if (a[end] ==tar)return end;
        else return -1;
    }
}
