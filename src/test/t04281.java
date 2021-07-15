package test;

import java.util.Scanner;

import java.util.*;
public class t04281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }

        }
        System.out.println(getRes(arr));
    }
    public  static  int getRes(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = arr[i][0];
        }
        for (int i = 1; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = getMin(arr,i,j,dp);
            }
        }
        return dp[arr.length-1][arr[0].length-1];
    }
    public static int getMin(int[][] arr, int i, int j, int[][] dp){
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 5; k++) {
            int temp = getSum(arr,i,j,k,dp);
            min = Math.min(min,temp);
        }
        return min;
    }
    public static int getSum(int[][] arr,int i,int j, int k ,int[][] dp){
        switch (k){
            case 0:{
                if(arr[i][j] == arr[i-1][j-1])
                    return arr[i][j] -1 + dp[i-1][j-1];
                else return  arr[i][j]  + dp[i-1][j-1];
            }
            case 1:{
                if(arr[i][j] == arr[i][j-1])
                    return arr[i][j] -1 + dp[i][j-1];
                else return  arr[i][j]  + dp[i][j-1];
            }
            case 2:{
                if(arr[i][j] == arr[i-1][j])
                    return arr[i][j] -1 + dp[i-1][j];
                else return  arr[i][j]  + dp[i-1][j];
            }
            case 3:{
                if(i+1< arr.length){
                    if(arr[i][j] == arr[i+1][j-1])
                        return arr[i][j] *2 -1;
                    else return  arr[i][j]  + arr[i+1][j-1];
                }
                else return getSum(arr,i,j,0,dp);

            }
            case 4:{
                if(j+1< arr[0].length){
                    if(arr[i][j] == arr[i-1][j+1])
                        return arr[i][j] *2 -1;
                    else return  arr[i][j]  + arr[i-1][j+1];
                }
                else return getSum(arr,i,j,0,dp);
            }

            default:return 0;
        }
    }
}
