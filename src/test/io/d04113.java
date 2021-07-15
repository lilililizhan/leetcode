package test.io;

import java.util.HashMap;

public class d04113 {
    /*
    暴力求解吗？？？？
    动态规划？我咋都不指导咋动态呢，
    先找结果，然后进行判断
     */
    public static void main(String[] args) {

    }
    static int[][] s1  ={{5,4,3,0,1},{8,6,7,3,10},{9,5,3,10,10},{2,6,6,8,5}};
    public static void maxscore(int[] nums,int n){
        int[][] maxS = new int[5][2];
        int minindex= 0;
        int minscore = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            maxS[i][0] = maxtemp(i)[0];
            maxS[i][1] = maxtemp(i)[1];
            if(maxS[i][1]<minscore){
                minscore  = maxS[i][1];
                minindex = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if(maxS[j][0]!=minindex){
//                    if()
                }
            }
        }


//        int minscore = Integer.MAX_VALUE;
//        int minindex = 0;
        for (int i = 0; i < 5; i++) {

        }

    }
    public static int[] maxtemp(int index){
        int max= s1[0][index];
        int tempmax = 0;
        for (int i = 1; i <s1.length ; i++) {
            if(s1[i][index]>max){
                max = s1[i][index];
                tempmax = i;
            }
        }
        return new int[]{tempmax,max};
    }



}

