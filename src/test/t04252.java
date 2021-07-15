package test;

import java.util.Scanner;

import java.util.*;
public class t04252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int[][] opreas = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                opreas[i][j] = sc.nextInt();
            }
//            System.out.println(Arrays.toString(opreas[i]));
        }
        char[] arr = str.toCharArray();
        for (int i = n-1; i >=0 ; i--) {
            reverse(arr,opreas[i]);
        }
        System.out.println(arr);

//        String str = "abcdefg";
//        char[] arr = str.toCharArray();
//        int[][] operas  = {{1,3,1},{2,4,1},{3,5,2}};
//        int[] opera = {3,5,2};
//        for (int i = 2; i >=0; i--) {
//            System.out.println(reverse(arr,operas[i]));
//        }
//        System.out.println(reverse(arr,opera));

    }
    public static char[] reverse(char[] arr,int[] opera){
        int left = opera[0];
        int right = opera[1];
        int len = 26-Math.floorMod(opera[2],26);
//        System.out.println(len);
        for (int i = left-1; i < right; i++) {
//            int c0 = arr[i]-'a';
//            int c1 = c0 +len;
//            int c2 = Math.floorMod(c1,26);
//            int c3 = c2 +97;
//            char c4 = (char)c3;
//            arr[i] = c4;
            arr[i] = (char)(Math.floorMod(arr[i]-'a'+len,26)+97);
        }
        return arr;
    }
}
