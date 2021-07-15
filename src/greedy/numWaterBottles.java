package greedy;

public class numWaterBottles {
    /*
    1518，换酒问题，easy,greedy
    小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
    如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。请你计算 最多 能喝到多少瓶酒。

    numBottles = 9, numExchange = 3
   输出：13
   解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
   所以最多能喝到 9 + 3 + 1 = 13 瓶酒。

   递归吧，记下每次的余数，商，和,使用数组传递参数
   总把参数更新搞错
   时间100%，空间13%，
   官方解法一，思路一样，但用的while循环
   第二种解法，数学方法，
     */
    public static void main(String[] args) {
//        int numBottles=9;
//        int numExchange =3;//13
//        int numBottles=15;
//        int numExchange =4;//19
//        int numBottles=5;
//        int numExchange =5;//6
        int numBottles=2;
        int numExchange =3;//2
        int r = numWaterBottles(numBottles,numExchange);
        System.out.println(r);

    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int[] num = new int[3];
        num[0]=numBottles;
        num[1] = numBottles;
        num[2]=numExchange;
        numWaterBottles2(num);
        return num[0];
    }

    public static void numWaterBottles2(int[] num) {
        if(num[1] < num[2])return;
        num[0] += num[1]/num[2];
        num[1] = num[1]%num[2]+num[1]/num[2];
        numWaterBottles2(num);
    }
}
