package dp;

public class MinPathSum {
    /*
    dp,middle,64题
    这个题是比较好理解的dp题
    只能向下或向右移动,
    dp记下到当前位置的最小路径，因为只能向下或向右，所以在两个路径中选最小值即可
    可以在原grid数组上修改
    时间86%，空间37%
     */
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},
                {1,5,1},
                {4,2,1}};
        int r  = minPathSum(grid);
        System.out.println(r);

    }
    public static int minPathSum(int[][] grid) {
//        int[][] dp =new int[grid.length][grid[0].length];
//        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] =grid[i-1][0] +grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] +=  grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
