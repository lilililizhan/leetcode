package test;

public class t0414 {
    /*
    dp，很熟悉的一道题，感觉做过
    [2,3,1,1]  2次,2-3-1
    [2,5,1,1,1,1] 2次，2-5-1
    每次要记住最大值,和题目不一样的是需要记下跳跃的次数
     */
    public static void main(String[] args) {
//        int[] num = {2,5,1,1,1,1};//2
//        int[] num = {2,1,1,1,1,1};//4
//        int[] num = {2,3,1,1};//2
//        int[] num = {2,3,1,1,1};//2
        int[] num = {1};//0
        int r= t(num);
//        int r = jump(num);
        System.out.println(r);

    }
    public static int t(int[] num){
        int[] dp = new int[num.length];
        int max = 1;
        dp[0]=0;
        for (int i = 0; i <num.length ; i++) {
            max = Math.max(max,i+num[i]);
            if(max >= num.length-1)return dp[i]+1;
            for (int j = i+1; j <=max; j++) {
                if(dp[j]==0)dp[j] = dp[i]+1;
                else dp[j] = Math.min(dp[j],dp[i]+1);
            }
        }
        return dp[num.length-1];
    }
    public static int jump(int[] arr){
        int end= 0;
        int mp =0 ;
        int step = 0;
        for (int i = 0; i < arr.length-1; i++) {
            mp = Math.max(mp,i+arr[i]);
            if(i==end){
                end= mp;
                step++;
            }
        }
        return step;
    }
}
