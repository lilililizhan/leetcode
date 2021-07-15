package test;

import java.util.Scanner;

public class t04046 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        System.out.println(masxSubArray(a) + masxSubArray(b));
    }

    public static int masxSubArray(int[] nums) {
        //相加的临时和 每次比较当前值 tmpSum + num 以及 num 的大小
        int tmpSum = 0;
        //用于返回最大值的结果
        int res = nums[0];
        //遍历循环
        for (int num : nums) {
            tmpSum = Math.max(tmpSum + num, num);
            res = Math.max(tmpSum, res);
        }
        return res;
    }
}
