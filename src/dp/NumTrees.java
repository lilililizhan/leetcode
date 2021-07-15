package dp;

public class NumTrees {
    /*
    动态规划，中等，题号96
    杨兵有句话说的很对，动态规划，就是找规律，先自己找规律，
    dp1 =1；
    dp2,比1小的数0个，比1大的1个，以1为根节点的1种
        比2小的1个，比2大的0个，以2为根节点1种
        共2种
    dp3，比1大的2个，以1为根节点2种
        比2小的一个，比2大的一个，以2为根节点2种
        比3小的2个，以3为根节点2种，
        共5种，

    时间100%，空间59%

     */
    public static void main(String[] args) {
        for (int i = 0; i <= 19; i++) {
            System.out.println(numTrees(i));
        }

    }
    public static int numTrees(int n) {
        if(n==1 || n==0)return 1;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        int temp;
        int left =0;
        int right =0;
        for (int i = 1; i <= n; i++) {
            temp =0;
            for (int j = 1; j <= i; j++) {
                left = j-1;
                right = i-j;
                temp += dp[left]*dp[right];
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
