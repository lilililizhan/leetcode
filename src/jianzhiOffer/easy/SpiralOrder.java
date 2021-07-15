package jianzhiOffer.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralOrder {
    /*
    感觉这个题难点在于循环遍历的判断
    可以当成一个嵌套的，遍历完外圈，再遍历外圈
    重要的是转向问题
    递归吧，
    或者不递归，直接总结规律
        当行/列全为奇数时，会有一列或一行剩余，其他的情况不会有剩余
    时间复杂度：8%，空间复杂度45%
    官方的第一种写法没太明白
     */
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        int[][] matrix1 = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        int[][] matrix2 = {{3},
                {2}};
        int[][] matrix3 = {{2,5},
                {8,4},
                {0,-1}};
        int[][] matrix4 = {{1,2,3},
                {6,9,8},
                {7,4,5}};
        int[] r = spiralOrder(matrix3);
        System.out.println(Arrays.toString(r));

    }
    public static int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> rlist = new ArrayList();
        if(matrix.length ==0)return new int[0];
        int k = Math.min(matrix.length/2,matrix[0].length/2);
        for (int i = 0; i < k; i++) {
            for (int j = i; j < matrix[0].length-i; j++) {
                rlist.add(matrix[i][j]);
            }
            for (int j = i+1; j < matrix.length-i; j++) {
                rlist.add(matrix[j][matrix[0].length-i-1]);
            }
            for (int j = matrix[0].length-i-2; j >=i ; j--) {
                rlist.add(matrix[matrix.length-1-i][j]);
            }
            for (int j = matrix.length-i-2; j >i ; j--) {
                rlist.add(matrix[j][i]);
            }
        }
        if(matrix.length>= matrix[0].length){
            if(matrix[0].length%2 !=0){
                int t = matrix[0].length/2;
                for (int i = k; i < matrix.length-k; i++) {
                    rlist.add(matrix[i][t]);
                }
            }

        }
        else {
            if(matrix.length%2 !=0){
                int t = matrix.length/2;
                for (int i = k; i < matrix[0].length-k; i++) {
                    rlist.add(matrix[t][i]);
                }
            }
        }
        int[] r = new int[rlist.size()];
        for (int i = 0; i < rlist.size(); i++) {
            r[i] = rlist.get(i);
        }
        return r;
    }
    public static <Arraylist> void spiral(int[][] matrix, Arraylist rlist){

    }
}
