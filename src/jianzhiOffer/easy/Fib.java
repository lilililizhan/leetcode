package jianzhiOffer.easy;

public class Fib {
    /*
    首先，不要使用数组存储结果，直接用int临时变量就可以
    其次，要对结果取模，比较好奇的是 加法操作对取模有影响吗，应该没影响，

    时间复杂度：100%，空间复杂度33.31%
    看官方的解答，该题递归的方法其实并不太好，
    还有一个动态规划的解法，没看懂
     */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(n));
    }
    public static int fib(int n) {
        if(n==0 || n==1)return n;
        int k =1;
        int i=0 ,j =1;
        int f = 0;
        int mod = (int) (7+Math.pow(10,9));
        while(k< n){
            f = i+j;
            i = j%mod;
            j = f%mod;
            k++;
        }
        return f%mod;
    }
}
