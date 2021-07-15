package test;

import java.util.Arrays;

public class test2 {
    /*
    每次尽可能使两个的差小，
     */
    public static void main(String[] args) {
        int n = 6;
//        int[] num = {6,2,3,4,5,5};
        int[] num = {6};//找到问题所在了
        int r = test(num);
        System.out.println(r);

    }
    public static  int test(int[] num){
        if(num.length==1)return 0;
        int sum = sum(num);
        int gap = sum;
        int tmp = gap;
        int former = 0;
        int  i =0;
        while(i<num.length){
            former += num[i];
            gap = Math.abs(former-(sum-former));
            if(gap > tmp)break;//使前后两个数组的差最小
            tmp = gap;
            i++;
        }
        former = former-num[i];
        if(former<=sum-former)return former+test(Arrays.copyOfRange(num,0,i));
        else return (sum-former)+test(Arrays.copyOfRange(num,i,num.length));
    }
    //计算数组的和
    public static int sum(int[] num){
        int r = 0;
        for (int i = 0; i < num.length; i++) {
            r += num[i];
        }
        return r;
    }

}
