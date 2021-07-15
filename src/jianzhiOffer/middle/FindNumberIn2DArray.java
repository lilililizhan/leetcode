package jianzhiOffer.middle;

public class FindNumberIn2DArray {
    /*
    由于每一行和每一列都是递增的，
    以行为单位开始查找，当在第一行找到7>5时，即可认为以7为顶点的5行3列都不复合要求
    本质是循环的嵌套，但两层循环的终点是变化的

    还有一种方法，转为一维数组并排序，需要遍历一遍，并没有什么意义

    看了官方的解答，
    从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
    如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     */
    public static void main(String[] args) {
        int[][] matrix = {
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}};
        int target = 31;
        System.out.println(findNumberIn2DArray2(matrix,target));
    }
    public static  boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean b = false;
        if(matrix.length ==0)return false;
        int index = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j>=index)break;
                if(matrix[i][j] == target){
                    return true;
                }
                else if(matrix[i][j] >target){
                    index = j;
                    break;
                }
            }
        }
        return b;
    }

    public static  boolean findNumberIn2DArray2(int[][] matrix, int target) {
        boolean b = false;
        if(matrix.length ==0)return false;
        int r = 0;
        int c = matrix[0].length-1;
        while(c>=0 && r <matrix.length){
            if(matrix[r][c] ==target)return true;
            else if(matrix[r][c] > target){
                c= c -1;
            }
            else r = r+1;
        }
        return b;
    }
}
