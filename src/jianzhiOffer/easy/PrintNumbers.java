package jianzhiOffer.easy;

import java.util.Arrays;

public class PrintNumbers {
    /*
    也没有说明n的范围，先不考虑那么多,
    这个题才是真正的简单
    时间复杂度100%，空间复杂度51%

    难点的话，是大数的存储，大数的存储使用字符串来解决，记得有个StringBuilder的变量，似乎很重要但我忘记了
     */
    public static void main(String[] args) {
        int n =1;
        int[] r = printNumbers(n);
        System.out.println(Arrays.toString(r));
    }
    public static int[] printNumbers(int n) {
        int num = (int) (Math.pow(10,n)-1);
        int [] r = new int[num];
        for (int i = 0; i < num; i++) {
            r[i] = i+1;
        }
        return r;
    }
}
