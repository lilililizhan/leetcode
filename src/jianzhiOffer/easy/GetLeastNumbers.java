package jianzhiOffer.easy;

import java.util.Arrays;

public class GetLeastNumbers {
    /*
    数组的长度是10000，不知道使用sort的时间复杂度如何，估计不行，
    其他想法，先初始化结果，然后依次比较并替换，但初始化的数组最好也是有序才好进行替换
    有一个问题，重复数字如何处理
    直接arrays.sort,时间71%，空间66%
    尝试一下不适用sort,
    时间9%，空间12%

    官方思路一：大根堆，不懂
    官方思路二：快排序，算法我已经忘记了
     */
    public static void main(String[] args) {
//        int[] arr = {4,5,1,6,2,7,3,8};
        int[] arr = {0,0,0,2,0,5};
        int[] r = getLeastNumbers2(arr,0);
        System.out.println(Arrays.toString(r));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0)return new int[0];
        int[] r = Arrays.copyOf(arr,k);
        Arrays.sort(r);
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < r[k-1]){
                exchange(r,arr[i]);
            }
        }
        return r;
    }
    public static  void exchange(int[] r, int n){
        int i = r.length-1;
        r[i] = n;
        i--;
        while(i>=0 && r[i] >n  ){
            r[i+1] = r[i];
            r[i] = n;
            i--;
        }
    }
}
