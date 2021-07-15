package jianzhiOffer.middle;

public class MaxValue {
    /*
    感觉比较像之前视频中讲到的那个算法题，迭代的思想
    最小的单元是2*2的矩阵，向下向右-向右向下能回到同一个位置，这种说法感觉也不太对
    java不能表示数组的子数组，就很麻烦，需要自己构造一个函数，但这样内存开销太大了，
    所以新定义一个函数，参数包括数组和索引

    结果是正确的，但有一个18*16的矩阵，超出时间限制，需要一种更简单的方法
    对m*n的矩阵，经过的节点数为 m+n-1,路径数为 m+n-2，m-1次向下，n-1次向右，
    可能的路径数为 m+n-2 次中选出 m-1

    或者换一种思路，先找最大值，再找次大值，看是否符合要求，但这种情况不适合，
    {1,3,4},
    {1,2,3},
    {5,1,1}
    我想不到别的方法了，看答案吧，唉败下来了

    看了以下答案，想法是一样的，但答案使用的是两层for循环
    想法还是不一样的，官方答案的想法是从[0,0]开始，记录到当前点的最大值，
    而使用递归方法的话是有很多的步骤是重复的了，官方答案有效避免了步骤的重复
    官方说这是动态规划，不懂啥是动态规划
     */
    public static void main(String[] args) {
        int[][] grid = {
                    {1,3,1},
                    {1,5,1},
                    {4,2,1} };
        System.out.println(maxValue2(grid,0,0));

    }
    public static int maxValue(int[][] grid) {
        return maxValue2(grid,0,0);
    }
    public static int maxValue2(int[][] grid, int r,int c) {
        int temp = grid[r][c];
        if(r ==grid.length-1){//只有一行
            if(c == grid[0].length-1 )//只有一列
            {
                return temp;
            }
            else return temp + maxValue2(grid,r,c+1);
        }
        else{//多行
            if(c == grid[0].length-1){//只有一列
                return temp +maxValue2(grid,r+1,c);
            }
            else {//多行多列
                int temp1 = temp +maxValue2(grid,r,c+1);
                int temp2 = temp+maxValue2(grid,r+1,c);
                return temp1>=temp2 ? temp1:temp2;
            }
        }
    }
    public static int maxValue3(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }

        }
        return grid[r-1][c-1];
    }
}
