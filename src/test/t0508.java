package test;

import java.util.ArrayList;

public class t0508 {
    public static void main(String[] args) {
//        String inputStr = "abbaca";
//        char[] clist = {'b','x'};
        String inputStr = "aba";
        char[] clist = {'c'};
        int res  = specialStr(inputStr,clist);
        System.out.println(res);

//        String s = "a";
//        System.out.println(longest(s));

    }
    public static int specialStr (String inputStr, char[] cList) {
        ArrayList<String> slist = del(inputStr,cList);
        int maxlen = 0;
        for (int i = 0; i < slist.size(); i++) {
//            System.out.println(slist.get(i));
            int temp = longest(slist.get(i));
            maxlen = Math.max(maxlen,temp);
        }
        return maxlen;
    }
    public static ArrayList<String> del(String inputStr,char[] cList){
        ArrayList<String> slist= new ArrayList<>();
        StringBuilder  sb = new StringBuilder();
        String ch = new String(cList);
        for (int i = 0; i < inputStr.length(); i++) {
            if(ch.contains(inputStr.charAt(i)+"")){
                if(sb.length() !=0){
                    slist.add(sb.toString());
                    sb= new StringBuilder();
                }
            }
            else sb.append(inputStr.charAt(i));
        }
        if(sb.length() !=0) slist.add(sb.toString());
        return slist;
    }
    public static int specialStr2 (String inputStr, char[] cList) {
        // write code here
        String ch = cList.toString();
        if(inputStr.length()==0)return 0;
        int maxlen = 0;
        int templen;
        for (int i = 0;i<inputStr.length()-1;i++){
            for (int j = i+1; j < inputStr.length(); j++) {
                if(huiwei2(inputStr,i,j,ch)){
                    templen = j-i+1;
                    maxlen = Math.max(templen,maxlen);
                }
            }
        }
        return maxlen;
    }
    public static boolean huiwei2(String s, int i, int j,String ch){
        while(i<j){
            if(ch.contains(s.charAt(i)+"") || ch.contains(s.charAt(j)+""))return false;
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
    public static int longest(String s){
        if(s.length()<=1)return s.length();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >=0 ; i--) {
            dp[i][i] =1;
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] +2;
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }

        }
        return dp[0][n-1];
    }
}
