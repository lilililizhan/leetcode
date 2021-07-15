package test;

import java.util.*;
public class t04172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        System.out.println(s);
        long r = count(s);
        System.out.println(r);
    }
    public static long count(String s){
        int count =0;
        int mod = 1000000007;
        long ans = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)=='b')count++;
            else {
                ans = (ans + count)%mod;
                count = (count *2)%mod;
            }
        }
        return ans;

    }
}
