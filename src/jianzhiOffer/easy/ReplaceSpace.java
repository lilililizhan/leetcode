package jianzhiOffer.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ReplaceSpace {
    /*
    不能用for循环，因为字符串的长度是变化的
    foreach不能适用于String
    有现成的函数replace,
    再自己手动写一种方法

    如果不用replace,只能使用数组了,split方法无法处理多个空格连在一起的情况
     */
    public static void main(String[] args) {
//        String s ="We are happy.";
        String s ="    ";
//        String r = replaceSpace(s);
        String r = replaceSpace3(s);
        System.out.println(r.toString());
    }
    public static String replaceSpace(String s) {
//        String r = s.replace(" ","%20");
//        System.out.println(r.toString());
        return s.replace(" ","%20");
    }

    //该方法不行
    public static String replaceSpace2(String s) {
        String[] sl =s.split(" ");
        String r = "";
        if(s.length()==0)return r;
        for (int i = 0; i < sl.length; i++) {
          r = r+sl[i]+"%20";
        }
        if(s.charAt(0)==' ')r = ' '+r;
        if(s.charAt(s.length()-1)!=' ')r = r.substring(0,r.length()-3);
//        String r = s.replace(" ","%20");
//        System.out.println(r.toString());
        return r;
    }

    public static String replaceSpace3(String s){
        char[] cl = s.toCharArray();
        String r = "";
        for (int i = 0; i < cl.length; i++) {
            if(cl[i]==' ')r += "%20";
            else r += cl[i];

        }
        return r;
    }
}
