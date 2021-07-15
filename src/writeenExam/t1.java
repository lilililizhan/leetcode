package writeenExam;

import java.util.HashMap;
import java.util.Map;

public class t1 {
    /*
    牛牛很喜欢在数字序列中跳跃，现在他正站在一号位置，每次跳跃，他可以向后一步(即从i跳到i+1)
    也可以跳到该位置往后的任意一个与该位置上的数字相同的位置，
    请问他最少需要跳多少补才能跳到N号位置？
    测试：
    5   01212  输出3-（1-2-3-5）
    5   21202  输出1-（2-2）
     */

    /*
    动态规划吗？dp[i]=min(dp[i-1]+1,dp[相同]+1），表示到第i个位置的最小步数
    感觉是要两层循环，
    发的链接看不懂，
    可不可以使用一个map来维护重复数值
    */
    public static void main(String[] args) {
//        int[] nums = {0,1,2,1,2};//3
        int[] nums = {2,1,2,0,2};//1
        int r = t1(nums);
        System.out.println(r);
    }
    public static int t1(int[] nums){
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] =i;
            for (int j = 0; j < i; j++) {
                if(nums[j]==nums[i]){
                    dp[i] = Math.min(dp[i],dp[j]+1 );
                }
            }
        }
        return dp[nums.length-1];
    }

    public static int skip(int[] nums, int n) {
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < n; i++) {
            if (map.containsKey(nums[i])) {
                dp[i] = dp[map.get(nums[i])] + 1;//肯定会比dp[i-1]+1小，而且map中的都是最小值，这样就少了一层循环
            } else {
                dp[i] = dp[i - 1] + 1;
                map.put(nums[i], i);
            }

        }
        return dp[n - 1];
    }

}
