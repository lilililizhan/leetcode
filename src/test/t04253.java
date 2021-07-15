package test;

import java.util.Scanner;

import java.util.*;
public class t04253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(-1);
        }
        int[] arr = {1,3,4,2,5};
        System.out.println(rev(arr)) ;

    }
    public static int rev(int[] arr){
        int res = 0 ;
        int left = 1;
        int right =0;
        int i =0;
        while(i<=arr.length){
            if(arr[i] == i+1){
                i++;
            }
            else break;
        }
        left = i;
        while(i<=arr.length){
            if(arr[i]!=i+1){
                i++;
            }
            else break;
        }
        right = i;
        int length= right-left;
        res=  length-(length-(arr[left]-left));
        for (int j = left+1; j <=right ; j++) {
            int t0 = arr[j] -left;
            int t1 = j+1-left;
            int temp = Math.floorMod(t1-t0+length,length);
            if(temp != res)return -1;

        }
        return res;
    }
}
