package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class monotoneIncreasingDigits {
    /*
    给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
    （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
    输入: N = 10
    输出: 9

    输入0，返回0
    首先从当前数字开始，依次进行判断，
    332的结果为299，而不是222，所以不能直接生成而是要判断
    难点是判断每一位的数字，
    担心时间复杂度，
    777616726超出时间限制，第212/303，699999999
    777616，699999
    需要考虑自己构造，

    如果本身不符合的话，就从9开始构造，
    不能这样，
    120,输出119，而不是99，
    放弃了，花费的时间太长了
    官网的也太简单了，
    官方的时间95%，空间15%
     */
    public static void main(String[] args) {
        int N = 10;//9
//        int N = 1232;//1229
//        int N = 1234;//1234
//        int N = 330;//299
//        int N = 777616726;//699999999
        int r = monotoneIncreasingDigits3(N);
        System.out.println(r);
//        System.out.println((int) ((10 - 0*Math.pow(10,0))/Math.pow(10,0+1)));

    }
    public static int monotoneIncreasingDigits(int N) {
        int res = N;
        int temp = res;
        int t1 =9;
        int t2;
        while(temp !=0){
            t2 = t1;
            t1 = temp%10;
            if(t1>t2){
                res--;
                temp =res;
                t1=9;
                continue;
            }
            temp =  ((temp - t1)/10);
        }
        return res;
    }
    public static int monotoneIncreasingDigits2(int N){
        int temp = N;
        int t1 =9;
        int t2;
        int weishu  =0;
        boolean b = true;
        while(temp !=0){
            t2 = t1;
            t1 = temp%10;
            if(t1>t2) b =false;
            temp =  ((temp - t1)/10);
            weishu ++;
        }
        if(b)return N;
        else {
            int res = t1-1;
            for (int i = 0; i < weishu-1; i++) {
                res = res*10+9;
            }
            return res;
        }
    }

    public static int monotoneIncreasingDigits3(int N){
        char[] strN  = Integer.toString(N).toCharArray();
        int i = 0;
        while(i<strN.length-1){
            if(strN[i]<=strN[i+1])i++;
            else break;
        }
        if(i==strN.length-1)return N;
        int j =i-1;
        strN[i]--;
        while(j>=0) {
            if(strN[j]>strN[j+1]){
                strN[j]--;
                j--;
            }
            else break;
        }
        for (int k = j+2; k <strN.length; k++) {
            strN[k] ='9';
        }
        return Integer.parseInt(new String(strN));
    }
}
