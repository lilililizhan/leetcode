package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class a04091 {
    /*
    对每组暑假单独进行处理，在处理的时候需要定义一个计时器
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<int[]> r = new ArrayList<>();
//        while(sc.hasNext()){
//            operate[i][0] = sc.nextInt();
//            operate[i][1] = sc.nextInt();
//            i++;
//        }
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] numall = new int[n][2];
            for (int j = 0; j < n; j++) {
                numall[j][0] = sc.nextInt();
                numall[j][1] =sc.nextInt();
            }
            r.add(t(numall));
        }
        for (int i = 0; i < r.size(); i++) {
            System.out.println(Arrays.toString(r.get(i)));
        }
//        int[][] numall ={{1,3},{1,4}};
//        int[] r = t(numall);
//        System.out.println(Arrays.toString(r));
//
//        int[][] numall2 ={{1,1},{1,1},{2,3}};
//        int[] r2 = t(numall2);
//        System.out.println(Arrays.toString(r2));
    }
    public static int[] t(int[][] numall){
        int[] r = new int[numall.length];
        int time =1;
        for (int i = 0; i <numall.length ; i++) {
            r[i] = t2(numall[i], time);
            if(r[i] !=0)time++;
        }
        return r;
    }
    public static int t2(int[] num,int time){
        if(time <= num[1])return time;
        return 0;
    }
}
