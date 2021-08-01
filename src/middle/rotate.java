package middle;

import java.util.ArrayList;

/*
48,旋转图像，中等
矩阵大小为n*n,分n/2层，每一层先用一个list维护一个边，再把对应的边旋转过来，
或者，有没有什么公式，公式不太行，要根据所处的位置进行不同策略的移动，

时间100%，空间65%
主要出错为，下标的写错

官方一：
规律：对于矩阵中第 ii 行的第 jj 个元素，在旋转后，它出现在倒数第 ii 列的第 jj 个位置。
使用另外一个数组存储元素，
官方二和官方三太难看懂了，放弃
 */
public class rotate {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},
//                {4,5,6},
//                {7,8,9}};
        int[][] matrix = {{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }


    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            rotate2(matrix,i);
        }

    }
    public static void rotate2(int[][] matrix, int n) {
        int up =n;
        int left= n;
        int down= matrix.length-1-n;
        int right = matrix.length-1-n;
        if(up==down)return;
        int len = down-up;
        ArrayList<Integer> tempList= new ArrayList<>();
        for (int i = left; i < right; i++) {
            tempList.add(matrix[up][i]);
        }
//      左边的移到上边
        for (int i = 0; i < len; i++) {
            matrix[up][left+i]= matrix[down-i][left];
        }
//      下边的移到左边
        for (int i = 0; i < len; i++) {
            matrix[down-i][left]= matrix[down][right-i];

        }
//        右边的移到下边
        for (int i = 0; i < len; i++) {
            matrix[down][right - i] = matrix[up + i][right];
        }
//      上边的移到右边
        for (int i = 0; i < tempList.size(); i++) {
            matrix[up+i][right] =tempList.get(i);
        }

    }
}
