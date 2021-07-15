package test;

import java.util.*;

public class t041731 {
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
    }
    public static long loca2(int n ,int m,int row,int col){
//        long r0 = row <= (n+1)/2 ? 2*row-1:(n-row+1)*2;
//        return (r0-1)*m+col;
        long r0;
        long r =0;
        long rowreal =0;
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

        }
        else {
            if(row <= n/2){
                rowreal = row*2-1;
            }

            else {
                rowreal = 2*(n+1-row);
            }

        }
        r0 = m*(rowreal-1);
        r = r0 + col;
        return r;
    }
}
