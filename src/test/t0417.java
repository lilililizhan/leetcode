package test;

import java.util.*;

public class t0417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        String s = "12321";
//        String s = "123421";//200
//        String s = "12";//100
//        String s = "12322";//100
//        String s = "1";//100
        String s = "123221";//100
        int r = t2(s);
        System.out.println(r);

    }
    public static int t(String s){
        char[] schar = s.toCharArray();
        int price = 0;
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(schar[left]==schar[right]){
                left++;
                right--;
                continue;
            }
            else {
                if(schar[left]=='1' || schar[right]=='1'){
                    if(schar[left]=='1')left++;
                    else right--;
                    price += 100;
                    continue;
                }
                else if(schar[left]=='2' || schar[right]=='2'){
                    if(schar[left]=='2')left++;
                    else right--;
                    price += 200;
                    continue;
                }
                else if(schar[left]=='3' || schar[right]=='3'){
                    if(schar[left]=='3')left++;
                    else right--;
                    price += 200;
                    continue;
                }
                else {
                    if(schar[left]=='4')left++;
                    else right--;
                    price += 220;
                    continue;
                }

            }

        }
        return price;
    }
    public static int t2(String s){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,100);
        hashMap.put(-1,120);
        hashMap.put(2,200);
        hashMap.put(-2,350);
        hashMap.put(3,360);
        hashMap.put(-3,200);
        hashMap.put(4,220);
        hashMap.put(-4,320);
        int len = s.length();
        int[][] dp = new  int[len][len];
        for (int i = len-1; i >=0; i--) {
            for (int j = i+1; j <len ; j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else {
                    int cost1 = hashMap.get(-(s.charAt(i)-'0'));
                    cost1 += hashMap.get(s.charAt(j)-'0');
                    int cost01 = hashMap.get((s.charAt(i)-'0'));
                    cost01 += hashMap.get(-(s.charAt(j)-'0'));
                    int cost2 = hashMap.get(-(s.charAt(i)-'0'));
                    int cost02 = hashMap.get((s.charAt(i)-'0'));
                    int cost3 = hashMap.get(-(s.charAt(j)-'0'));
                    int cost03 = hashMap.get((s.charAt(j)-'0'));
                    dp[i][j] = Math.min(Math.min(dp[i+1][j-1]+cost1,dp[i+1][j-1]+cost01),
                            Math.min(dp[i][j-1] +Math.min(cost3,cost03),
                                    dp[i+1][j] +Math.min(cost2,cost02)));
                }
            }

        }
        return dp[0][len-1];
    }

}
