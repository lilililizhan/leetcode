package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class t04183 {
    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[][] time = {{1,4},{1,3},{2,3},{3,2},{3,4}};
//        int[][] time = {{1,4},{1,3},{2,3},{3,2},{3,4}};
//        int[][] time = new int[k][2];
//        for (int i = 0; i < k; i++) {
//            time[i][0] =i;
//            time[i][1] = sc.nextInt();
//        }
//        order(time,0);
        int[] time = {3,6,9};
        int k =3;
        int[] res = order2(time,k);
        System.out.println(Arrays.toString(res));
    }
//    public static int[] order(int[][] time, int k){
//        int[] res = new int[k];
////        Arrays.sort(time, new Comparator<int[]>() {
////            @Override
////            public int compare(int[] o1, int[] o2) {
////                if(o1[1] < o2[1])return o1[1]-o2[1];
////                else return o1[0]-o2[0];
////            }
////        });
//        int m = Integer.MAX_VALUE;
//        for (int i = 0; i < time.length; i++) {
//            if(m<time[i][1])m=time[i][1];
//        }
//        int timeMax = m*k;
//        int adNUm = 0;
//        for (int i = 1; i <= timeMax; i++) {
//            for (int j = 0; j < time.length; j++) {
//
//            }
//        }
//        for (int i = 0; i < time.length; i++) {
//            System.out.println(Arrays.toString(time[i]));
//        }
//        return res;
//    }

    public static int[] order2(int[] time, int k){
        int[] res = new int[k];
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            if(m<time[i])m=time[i];
        }
        int timeMax = m*k;
        int adNUm = 0;
        for (int i = 1; i <= timeMax; i++) {
            for (int j = 0; j < time.length; j++) {
                if(adNUm==k)return res;
                if(i%time[j]==0){
                    adNUm++;
                    res[adNUm-1] = j+1;
                }
            }
        }
        return res;
    }
}
