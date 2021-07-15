package dp;

public class CanPartition {
    /*
    动态规划，middle,416
    又是，数组若干元素的和等于某数，
    尝试一下动态规划，参考494
    但单个元素小于100，总元素<200,和就20000了，除以2就10000了，太长了吧，

    第一次尝试，失败，这种写法要求必须是连续的，
    进行第二次尝试，
    第115/116个测试用例出错，
    [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,97,95,99,99]输出应为true
    数组太长，不知道哪里错了，看答案吧

    官方解答是用boolean类型，应该是一样的啊，为什么要分两种情况呢，
    有点印象，要看是否跳过，

   呜呜呜终于有点看懂了，重点是某一个词是否跳过
   最后100为什么又错了呢,
   dp[nums.length-1][tar]的值为-1515254800，可能是溢出，所以还是用boolean不会溢出,把它换为！=0，或者类型

   [100]时出错，所以还是要和答案一样，判断最大值及数组个数
   [9,5]出错，要提前判断最大值

   时间57%，空间5%

   看一下空间优化，每一行的dp值都只与上一行的dp值有关
   dp[j]=dp[j] ∣ dp[j−nums[i]]
   空间优化不是很懂，好像是，只看最后的结果就可以了？？
     */
    public static void main(String[] args) {
//        int[] nums = {1,5,11,5};
//        int[] nums = {1,2,3,5};
//        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,97,95,99,99};

//        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
//                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
//                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
//                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        boolean bool = canPartition(nums);
        System.out.println(bool);
    }
    public static boolean canPartition(int[] nums) {
        int sum =0;
        int max = 0;;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        if(sum%2 !=0)return false;
        int tar = sum/2;
        if(nums.length<2 || max >tar)return false;
        int[][] dp = new int[nums.length][tar+1];
        dp[0][nums[0]]=1;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= tar; j++) {//两种情况，是否选择该节点
//                if(dp[i-1][j] >0){
//                    dp[i][j+nums[i]] +=dp[i-1][j];//选择这个点
//                }
//                if(nums[i]>tar)return false;
                if(j>=nums[i]) dp[i][j]=dp[i-1][j] +dp[i-1][j-nums[i]];//不选这个点，和选这个点
                else dp[i][j] = dp[i-1][j];//不选这个点
            }
        }
//        for (int i = 0; i < nums.length; i++) {
        System.out.println(dp[nums.length-1][tar]);
        if(dp[nums.length-1][tar] != 0)return true;
//        }
        return false;
    }

    //对上面的进行空间优化
    public static boolean canPartition1(int[] nums) {
        int sum =0;
        int max = 0;;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        if(sum%2 !=0)return false;
        int tar = sum/2;
        if(nums.length<2 || max >tar)return false;
        int[]dp = new int[tar+1];
        dp[nums[0]]=1;
        for (int i = 0; i < nums.length; i++) {
            dp[0]=1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = tar; j >=nums[i] ; j++) {
                dp[j] = dp[j] +dp[j-nums[i]];
            }
        }
//        for (int i = 0; i < nums.length; i++) {
        System.out.println(dp[tar]);
        if(dp[tar] != 0)return true;
//        }
        return false;
    }
    public static boolean canPartition2(int[] nums) {
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2 !=0)return false;
        int tar = sum/2;
        int[][] dp = new int[nums.length][sum+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][nums[i]]=1;
        }
        for (int i = 1; i < nums.length; i++) {//每次新加入一个数，对之前不为0的元素进行判断
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < sum; k++) {
                    if(dp[j][k] >0){
//                        System.out.println("----------");
//                        System.out.println(i);
//                        System.out.println(j);
//                        System.out.println(nums[i]);
//                        System.out.println(k);
                        dp[i][nums[i]+k] += dp[j][k];
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(dp[i][tar] >0)return true;
        }
        return false;
    }
}
