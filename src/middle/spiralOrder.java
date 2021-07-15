package middle;

import java.util.ArrayList;
import java.util.List;
/*
题号54，middle
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

想法：定义一个函数，从起点，依次从四个方向开始读取，并修改四个边界
 */

public class spiralOrder {
    public static void main(String[] args) {
//        int[][] matrix ={{1,2,3},
//                {4,5,6},
//                {7,8,9}};
        int[][] matrix ={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
//        int[][] matrix ={{6,7,9}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        spiralOrder2(res,matrix,0,matrix[0].length-1,0,matrix.length-1);
        return res;
    }

    //x和l是一样的
    public static void  spiralOrder2(List<Integer> res,int[][] matrix,int l,int r ,int u,int d) {
        //是否向右
        if(l<=r){
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u +=1;
        }
        if(u<=d){
            for (int i = u; i <= d ; i++) {
                res.add(matrix[i][r]);
            }
            r -=1;
        }
        if(u<=d){
            for (int i = r; i >=l ; i--) {
                res.add(matrix[d][i]);
            }
            d -=1;
        }
        if(l<=r){
            for (int i = d; i >=u ; i--) {
                res.add(matrix[i][l]);
            }
            l +=1;
        }
        if(l<= r && u <= d) spiralOrder2(res,matrix,l,r,u,d);
    }
}
