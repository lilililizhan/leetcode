package easy;

import java.util.ArrayList;

public class ClimbStairs {
    /*
    这题看着一点都不简单啊，
    可以看作，任意的相邻两数的结合，
    感觉也需要调用自身啊，这里的问题是结果如何保存。

    当剩下的台阶数大于等于2时才有选择的权力,剩下的台阶数为0或1时代表一种途径达到了
    n=44时，1134903170次，换一种思路，

    当n=n+1时，可能的情况增加了

    意外发现是那个斐波那契数列，2-3-5-8-13-21-34
    想不通是为什么，算了，直接写这个吧,
    climbStairs2依然超出时间限制

    看了官方的回答，最后一步可能跨了一级台阶或两级台阶，所以f(n)=f(n-1)+f(n-2),恍然大悟
     */
    public static void main(String[] args) {
//        int n = 2;
//        int n = 3;
        int n = 44;
        int r = climbStairs3(n);
        System.out.println(r);


    }
    public static int climbStairs(int n) {
        int[] num ={0};
        climb(n,num);
        return num[0];
    }
    public  static  void climb(int n,int[] num){
        if(n>1){
            climb(n-1,num);
            climb(n-2,num);
        }
        if(n==0 || n==1) num[0]+=1;
    }
    public static int climbStairs2(int n) {
        if(n>=2){
            return climbStairs2(n-1)+climbStairs2(n-2);
        }
        else return 1;
    }
    public static int climbStairs3(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        if(n==1)return 1;
        int r= 0;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = list.get(i-2)+list.get(i-1);
            list.add(temp);
        }
        return list.get(n);
    }
}
