package easy;

import java.util.ArrayList;
import java.util.List;

/*
121,买卖股票的最佳时机，简单
输入：[7,1,5,3,6,4]
输出：5。在1时买入，在6时卖出

暴力法匹配？记得有遍历一次的做法，
记下最小值和最大值？还需要最大值在后面，
两个临时变量，一个记录最最小值，一个记录利润

 */
public class maxProfit {
    public static void main(String[] args) {
        int[] p1 = {7,1,5,3,6,4};
        int[] p2 = {7,6,4,3,1};
        List<int []> intlist = new ArrayList<>();
        intlist.add(p1);
        intlist.add(p2);
        for (int i = 0; i < intlist.size(); i++) {
            System.out.println(maxProfit(intlist.get(i)));
        }

    }
    public static int maxProfit(int[] prices) {
        if(prices.length <2)return 0;
        int pri = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] - min > pri) pri = prices[i] - min;
            if(prices[i] < min)min = prices[i];
        }
        return pri;
    }
}
