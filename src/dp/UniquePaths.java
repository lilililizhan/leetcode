package dp;

public class UniquePaths {
    /*
    分类为dp,middle
    每次只能向下或向右
    画图之后发现很简单，
    dp[m][n]=dp[m-1][n]+dp[m][n-1]
    一行一行或者一列一列遍历都可以
    时间100%，空间21%
    还可以通过数学组合的方式，共向下移动m-1次，向右移动n-1次，

    如果不懂动态规划的话，会用迭代的算法，如课件里的迷宫问题，
     */
    public static void main(String[] args) {
//        int m  = 3;
//        int n = 7;
        int m  = 3;
        int n = 2;
        int r = uniquePaths(m,n);
        System.out.println(r);

    }
    public static int uniquePaths(int m, int n) {
        int[][] num = new int[m][n];
        //矩阵初始化
        for (int i = 0; i < m; i++) {
            num[i][0] =1;
        }
        for (int i = 1; i < n; i++) {
            num[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
                num[i][j] =num[i-1][j] +num[i][j-1];
            }
        }
        return num[m-1][n-1];
    }
}
