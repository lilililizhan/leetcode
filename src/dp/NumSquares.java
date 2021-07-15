package dp;

import java.util.Arrays;

public class NumSquares {
    /*
    dp,middle,279题数组是啥
    有点难度了啊，想想dp
    注意，1也是完全平方数，
    在想，是不是动态规划呢，dp的主要点在于和之前的状态有关，
    使用一个数组，dp[j],表示和为j所需的完全平方数的最小数量，
    那么下一个数呢，

    空间13%，时间51%，
    我自己作对的莫名其妙的,感觉这个题有规律啊，
    先找到最接近的n^2，但不对，12的话找9，找3，就4个了，
    dp的写法和官方的答案一致，

    官方的解答还有贪心算法，广度优先，数学公式等，先不看了，这道题先这样吧
     */
    public static void main(String[] args) {
        int n = 13;
        int r = numSquares(n);
        System.out.println(r);

    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i]=i;
        }
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            dp[(int)Math.pow(i,2)] =1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (int)(Math.sqrt(i)); j++) {
                if(dp[(int) (i-Math.pow(j,2))]>0){
//                    System.out.println("----------");
//                    System.out.println(i);
//                    System.out.println(dp[i]);
//                    System.out.println(dp[(int) (i-Math.pow(j,2))]+1);
                    dp[i] = Math.min(dp[i],dp[(int) (i-Math.pow(j,2))]+1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
