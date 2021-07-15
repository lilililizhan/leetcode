package test;

import java.util.Arrays;
import java.util.Scanner;

public class t7 {
    /*
    跟概率没有关系，主要还是如何使最小值最大，使大值尽可能的跟大值比，不对，还是看概率，
    大于50，尽量大的数
    小于50，尽量小的数，
    排序，
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] nums = new int[n+n];
        for (int i = 0; i < n+n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(n);
        System.out.println(p);
        System.out.println(Arrays.toString(nums));
//        int[] nums = {1,3,3,2,2,3};
//        int p =60;
        int r = t(nums,60);
        System.out.println(r);
        int res = 0;
        if(p>=50)res=t(nums,p);
        else{
            res= t2(nums,p);
        }
//        int res = t2(nums,p);
        if(res%100==0){
            System.out.println(res/100);
        }
        else{
            String s = res+"";
            System.out.println(s+"%");
        }
    }
    public static int t(int[] num,int p){
        Arrays.sort(num);
        //考虑大于0的情况
        int sumtemp = 0;
        for (int i = num.length/2; i < num.length; i++) {
            System.out.println(i);
            sumtemp += num[i];
        }
        int sumtemp1 = 0;
        for (int i = 0; i < num.length/2; i++) {
            System.out.println(i);
            sumtemp1 += num[i];
        }
        System.out.println(sumtemp+"  "+sumtemp1);
        return p*sumtemp + (100-p)*sumtemp1;
    }
    public static int t2(int[] num,int p){
        Arrays.sort(num);
        //考虑大于0的情况
        int sumtemp = 0;//大数
        int sumtemp1 = 0;//小数
        for (int i = 0; i < num.length; i+=2) {
            sumtemp1 += num[i];
            sumtemp += num[i+1];
        }
        System.out.println(sumtemp+"  "+sumtemp1);
//        long[] s = new long[];
        return p*sumtemp + (100-p)*sumtemp1;
    }
}
