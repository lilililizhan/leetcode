package test;

import java.util.*;

public class t04173 {
    /*
    是个数学题吧，最好是先构建矩阵，再求值，但构建矩阵时间复杂度
    感觉，问题的关键在于找到是第几行的，
    1
    3
    5
    7
    6
    4
    2
    前半部分，i = r*2-1
    后半部分： i= 2*（8-1）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int a= sc.nextInt();
            int b = sc.nextInt();
            System.out.println(loca2(n,m,a,b));
        }
//        int n =4;
//        int m =4;
        int[][] loc = {{1,1},{4,4},{2,2},{3,3}};
//        for (int i = 0; i < loc.length; i++) {
//            System.out.println(loca2(n,m,loc[i][0],loc[i][1]));
//        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(loca2(3,4,i+1,j+1));
            }
        }
//        System.out.println(loca2(3,4,1,3));
    }
    public static int[][] loca(int row,int col){
        int[][] digit = new int[row][col];
        int num =1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
            }
        }
        return null;
    }
    public static int loca2(int n ,int m,int row,int col){
        int r0;
        int r =0;
        int rowreal =0;
        if(n%2==1){
            if(row <= n/2){
                rowreal = row*2-1;
            }
            else if(row == n/2+1){
                rowreal =n;
            }
            else{
                rowreal = 2*(n+1-row);
            }
            r0 = m*(rowreal-1);
            r = r0 + col;
        }
        else {
            if(row <= n/2){
                rowreal = row*2-1;
            }

            else {
                rowreal = 2*(n+1-row);
            }
            r0 = m*(rowreal-1);
            r = r0 + col;
        }
        return r;
    }
}
