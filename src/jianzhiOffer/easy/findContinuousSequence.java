package jianzhiOffer.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class findContinuousSequence {
    /*
    剑指offer,57-2,easy,
    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

    输入：target = 9 输出：[[2,3,4],[4,5]]
    输入：target = 15 输出：[[1,2,3,4,5],[4,5,6],[7,8]]

    奇数，15=7+8，15/3 = 5， 15/5=3
    偶数，14/2=7，[2，3 4，5]
    感觉变成了求因子，

    这个题，动态规划？？试试,dp的代码好长啊，这是简单题吗，不觉得啊，
    50252超出内存限制，第22/32个案例

    这不是简单啊，
    官方的答案好多啊，大于targets要及时跳出

    法一：枚举+暴力，
    法二：枚举+数学优化
    法三：双指针，sum<tar,右指针移动，
        sum>tar,左指针移动，
        sum=tar,存入并右指针移动，
        时间56%，空间46%
   */

    public static void main(String[] args) {
        int target1 = 9;//
        int target2 = 15;
        int target3 = 14;
        int target4 = 20;
        int target5 = 50252;
        int target6 = 100;
        int target7 = 100;
        int[] num = new int[]{target1,target2,target3,target4,target5,target6};
        for (int i = 0; i < 6; i++) {
            int[][] res = findContinuousSequence3(num[i]);
            for (int j = 0; j < res.length; j++) {
                System.out.println(Arrays.toString(res[j]));
            }
            System.out.println("---------");
        }

    }
    //奇数和偶数要分来处理，奇数好办，至少一个结果，
    //主要是看商是偶数还是奇数，
    //20 [2,3,4,5,6],20/4=5,就是找奇数因子，也不一定，[3,4,5,6]=18,[1,2,3,4,5,6,7,8]=36,
    //感觉，只要结果是奇数就行，这个想法不对，
    //结果的排序问题，放弃

    public static  int[][] findContinuousSequence(int target) {
        ArrayList<int[]> tes = new ArrayList<>();
        int temp = 0;
        for (int i = 3; i <target/2 ; i++) {
            if(i%2==1 && target%i==0){
                temp = target/i;
                if(temp>i/2){
                    int[] t = new int[i];
                    for (int j = 0; j <i; j++) {
                        t[j]=temp-i/2+j;
                    }
                    tes.add(t);
                }

            }
        }
        if(target%2==1)tes.add(new int[]{target/2,target/2+1});
        else {
            if(target%4 !=0)tes.add(new int[]{target/4-1,target/4,target/4+1,target/4+2});
        }
        int[][] res = new int[tes.size()][];
        for (int i = 0; i < tes.size(); i++) {
            res[i] = tes.get(i);
        }
        return res;
    }
    public static  int[][] findContinuousSequence1(int target) {
        ArrayList<int[]> tes = new ArrayList<>();
        int temp = 0;
        for (int i = target/2; i >=2 ; i--) {
            if(target%i==0 ){
                if(i%2==0){
                    temp = target/i;//4*9,i=4,temp=9,
                    if(temp%2==1){//忽略了[2,3,4]的情况
                        int middle= temp/2;
                        if(middle-i+1<1)continue;
                        int[] t = new int[i*2];
                        for (int j = 0; j < i*2; j++) {
                            t[j] = middle-i+j+1;
                        }
                        tes.add(t);
                    }
                }
                else {
                    temp = target/i;//3*3
//                    if(temp%2==1){//忽略了[2,3,4]的情况
                        int[] t = new int[i];
                        if(temp-i/2<1)continue;
                        for (int j = 0; j < i; j++) {
                            t[j] = temp-i/2+j;
                        }
                        tes.add(t);
//                    }
                }

            }
        }
        if(target%2==1)tes.add(new int[]{target/2,target/2+1});
        int[][] res = new int[tes.size()][];
        for (int i = 0; i < tes.size(); i++) {
            res[i] = tes.get(i);
        }
        return res;
    }
    public static  int[][] findContinuousSequence2(int target) {
        int n = (int) Math.ceil((double)target/2);
        ArrayList<int[]> num = new ArrayList<>();
       int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = i+1;
        }
        for (int i = 1; i < n; i++) {
           dp[0][i] = dp[0][i-1]+i+1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = dp[i][j-1]+j+1;
                if(dp[i][j]==target){
                    num.add(new int[]{i,j});
                }
            }
        }
        if(num.size()==0)return new int[0][0];
        int[][] res = new int[num.size()][];
        int len = 0;
        for (int i = 0; i < num.size(); i++) {
            len = num.get(i)[1]-num.get(i)[0]+1;
            int s =num.get(i)[0];
            res[i] = new int[len];
            for (int j = 0; j < len; j++) {
                res[i][j] = s +1;
                s++;
            }
        }
        return  res;
    }


//官方双指针解法，
    public static  int[][] findContinuousSequence3(int target) {
        int l =1;
        int r =2;
        ArrayList<int[]> res = new ArrayList<>();
        int sum = 0;
        sum = l+r;
        while(l<r && r<=(target+1)/2){
            if(sum <target){
                r++;
                sum += r;
            }
            else if(sum >target){
                sum -= l;
                l++;
            }
            else {
                int[] t = new int[r-l+1];
                for (int i = 0; i < r-l+1; i++) {
                    t[i]=l+i;
                }
                res.add(t);
                sum -= l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
