package test;

import java.util.ArrayList;

public class t0507 {
    /*
    最长回文子序列
    先暴力吧
     */
    public static void main(String[] args) {
//        String s1 = "abcbaaaa";
//        String s2 = "a";
//        String s3 = "";
//        String s4 = "aaaaa";
        String[] sarr = {"abcbaaa","a","","aaaa","abcde","abcbabc","abababa","bbbaaa"};
        for (int i = 0; i < sarr.length; i++) {
            System.out.println(sarr[i]+":   "+huiwen(sarr[i]));
        }
//        int res = huiwen(s);
//        System.out.println(res);
    }
    public static int huiwen(String s){
        if(s.length()==0)return 0;
        int maxlen = 0;
        int templen;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(huiwei2(s,i,j)){
                    templen = j-i+1;
                    maxlen = Math.max(templen,maxlen);
                }
            }

        }
        return maxlen > 1 ? maxlen :1;
    }

    //字串偶数和奇数的情况
    public static boolean huiwei2(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}
