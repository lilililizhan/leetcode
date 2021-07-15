package easy;

import java.util.ArrayList;

public class CountAndSay {
    /*
    本来以为是一个递归，从N开始往前到1，但是发现理解错了
    就是一个简单的从1开始，直到N为止，
    只要定义好一个函数，然后一直调用就可以了
    同时，N<=30,所以算法不简便也可以

    根据提示，定义两个列表，一个存当前字符，一个存相同字符的个数，然后字符拼接即可
    对n=1进行特殊处理
     */
    public static void main(String[] args) {
//        String s ="3322251";
//        String r = count(s);
//        System.out.println(r);
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String s0 = "1";
        if(n==1)return s0;
        String s = s0;
        for (int i = 1; i < n; i++) {
            s = count(s);
            System.out.println(s);
        }
        return s;
    }
    public static String count(String s){
        StringBuilder sb = new StringBuilder();
        int times = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==c){
                times++;
            }
            else {
                sb.append(""+times);
                sb.append(""+c);
                c = s.charAt(i);
                times = 1;
            }
        }
        sb.append(""+times);
        sb.append(""+c);
        return sb.substring(0);

    }
}
