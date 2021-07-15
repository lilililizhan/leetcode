package test;

public class Main {
    /**
     * create by: soldierbupt
     * description: 给定一个数组，找出一个子集，集合中的数字的和能被6整除，且和是所有满足要求的子集合的最大值，找不到返回-1
     * create time: 2021-3-29 20:34
     *
     * @Param: n 数组大小 int[] nums 数组
     * @return： int
     */

    public static int divideby6(int n, int[] nums) {
        int sum = 0;
        //求出数组所有数的和
        for (int num : nums) {
            sum += num;
        }
        //求出小于和但能被6整除的最大的值
        sum = sum - sum % 6;

        //如果sum<6 返回-1
        if (sum < 6) return -1;

        boolean[][] dp = new boolean[nums.length][sum + 1];
        //将dp[i][0]设为true
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        //将dp[0][nums[0]]设为true,其他dp[0][j]无所谓
        dp[0][nums[0]] = true;

        //求出dp[i][j]
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i] <= j)
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        //找到dp[nums.length-1]里为true的值里最大的且能被6整除的
        int k = dp[0].length - 1;
        while (k > 0) {
            if (dp[dp.length - 1][k] == true)
                return k;
            else
                k -= 6;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(divideby6(2, new int[]{1, 3}));

    }
}
