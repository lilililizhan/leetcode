package jianzhiOffer.middle;

import java.util.Arrays;
import java.util.HashMap;

public class singleNumbers {
    /*
    剑指offer,56-1,middle,
    一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
    请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

    时间复杂度容易实现，空间复杂度，用map吗，
    可以用set吗，感觉不太行，新加入时存在则不符合，需要用一个list维护？？？
    还是map吧，唉我太菜了也，
    时间7%，空间16%

    或者依次依次加入，再remove？
    这个题，用到了位运算和异或，不太懂？？？？

     */
    public static void main(String[] args) {
//        int[] nums = {4,1,4,6};
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] res  = singleNumbers(nums);
        System.out.println(Arrays.toString(res));

    }
    public static int[] singleNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] res = new int[2];
        int index = 0;

        for (Integer key:map.keySet()
             ) {
            if(map.get(key)==1){
                res[index] =key;
                index++;
            }
        }
        return res;
    }

}
