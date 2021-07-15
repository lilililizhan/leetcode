package jianzhiOffer.dp;

public class MaxProfit {
    /*
    之前做过这个题，但是已经没印象了，动态规划的题，
    设dp[i]为当前卖出的利润，
    当dp[i-1]<0且dp[i-1]+dp[i]<0时，选择在i买入，当>=0时，表示继续持有，在原数组上进行修改
    注意，没有交易完成的情况
    使用两个数组来维护

    [7,1,5,3,6,4]
    时间66%，空间31%

    官方的解答更好，只遍历一遍，遍历过程中标记出价格最低点和当天利润，更容易理解了
    官方的答案，时间97%，空间70%
     */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};//5
//        int[] prices = {7,6,4,3,1};
        int r = maxProfit2(prices);
        System.out.println(r);

    }
    public static int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int[] prof = new int[prices.length];
        prof[0] = -prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
           if(prof[i-1]>0){
               if(prices[i]>prices[i-1])prof[i] = prof[i-1]+prices[i]-prices[i-1];
               else prof[i] = Math.max(-prices[i],prof[i-1]+prices[i]-prices[i-1]);
           }
           else {//当前一天为负时，肯定是前一天刚买入的，
//               prof[i] = Math.max(-prices[i],prof[i-1]+prices[i]-prices[i-1]);
               prof[i] = Math.max(-prices[i],prices[i]-prices[i-1]);
           }
           res = Math.max(prof[i],res);
        }
        return res;
    }

    public static int maxProfit2(int[] prices) {
        if(prices.length==0)return 0;
        int minpoint = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<minpoint)minpoint=prices[i];
            res=Math.max(res,prices[i]-minpoint);
        }
        return res;
    }
}
