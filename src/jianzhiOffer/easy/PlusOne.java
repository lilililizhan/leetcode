package jianzhiOffer.easy;

import java.util.Arrays;

public class PlusOne {
    /*
    思路一：先变成字符串，再变成整数，再变成字符串，再变成数组
    思路二：构建一个数组，存储是否有进位的情况，当首位有进位时，需要新建一数组
          有一个需要注意的点，对于首位需要进1的情况，只有9，99，999才会有，此时只需第一位为1即可，
          也不需要进位的数组，直接判断即可，只要循环到i时，就代表需要进位
     */
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
        int[] digits = {0};
//        int[] digits = {9};
        int[] r = plusOne2(digits);
        System.out.println(Arrays.toString(r));
    }
    public static int[] plusOne(int[] digits) {
        int[] jinwei  = new int[digits.length+1];
        jinwei[digits.length] =1;
        for (int i = digits.length-1; i >=0 ; i--) {
            if(jinwei[i+1] != 1)return digits;
            else {
                jinwei[i] = (digits[i]+1)/10;
                digits[i] = (digits[i]+1)%10;
            }
        }
        if(jinwei[0]==0)return digits;
        else{
            int[] r = new int[digits.length+1];
            r[0] =1;
            for (int i = 1; i < digits.length+1; i++) {
                r[i]  = digits[i-1];
            }
            return r;
        }
    }
    public static int[] plusOne2(int[] digits){
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]++;
            if(digits[i]>9) digits[i]=0;
            else return digits;
        }
        int[] r = new int[digits.length+1];
        r[0] = 1;
        return r;
    }
}
