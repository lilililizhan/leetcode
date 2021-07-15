package middle;

public class Divide {
    public static void main(String[] args) {
        System.out.println(2<<1);
    }
    public static int divide(int dividend, int divisor) {
        /*
        不让使用乘法和除法可以理解，为什么不让使用模运算呢
        最初的想法，整数嘛，就直接以1为单位一个一个移，但是这里的复杂度，
        注意：
            正负数的情况
            商为0的情况
        之前加法用的二进制运算，这里是否可以呢，而且还和32位的数字范围一致
            感觉可以借鉴，考虑到借位，移位，
            负数怎么办呢
        感觉得使用迭代的思想啊
            迭代的跳出条件是余数小于除数
            从开头开始，不够除就往右移
            如何取32位中的几位数呢，用&操作，但是获得的数后面有一堆零，通过右移吧
         */
        return 0;
    }
    public static int qushu(int n){
        int temp =0;
        for (int i = 0; i < n; i++) {
            temp = (int) (temp+Math.pow(2,30-i));
        }
        return temp;
    }
    public static int getDiv(int dividend,int qushu ,int n){
        int temp = dividend & qushu;
        temp = temp>>n;
        return temp;
    }
}
