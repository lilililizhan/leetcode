package greedy;

public class lemonadeChange {
    /*
860，easy
 在柠檬水摊上，每一杯柠檬水的售价为5美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回true，否则返回 false。
输入：[5,5,5,10,20]
输出：true
解释：
前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
由于所有客户都得到了正确的找零，所以我们输出 true。

注意这里是按顺序的，
感觉比较简单，就直接计算即可，
需要维护零钱序列，并且找零时从最大开始找，或者用三维数组来保存零钱
时间25%，空间75%
     */

    public static void main(String[] args) {
//        int[] bills = {5,5,5,10,20};//true
//        int[] bills = {5,5,10};//true
//        int[] bills = {10,10};//false
//        int[] bills = {5,5,10,10,20};//false
//        int[] bills = {5,5,5,5,20,20,5,5,20,5};//false
        int[] bills = {5,5,20,5,5,10,5,10,5,20};//false
        boolean r = lemonadeChange(bills);
        System.out.println(r);

    }
    public static boolean lemonadeChange(int[] bills) {
        int[] chaege = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5)chaege[0]++;
            else if(bills[i]==10){
                if(chaege[0]>0){
                    chaege[0]--;
                    chaege[1]++;
                }
                else return false;
            }
            else {
                if(chaege[1]>0 && chaege[0]>0){
                    chaege[0]--;
                    chaege[1]--;
                    chaege[2]++;
                }
                else if(chaege[1]==0 && chaege[0]>2){
                    chaege[0] -=3;
                    chaege[2]++;
                }
                else return false;
            }
        }
        return true;
    }
}
