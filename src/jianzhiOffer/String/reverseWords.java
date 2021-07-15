package jianzhiOffer.String;

import java.util.ArrayList;

public class reverseWords {
    /*
    双指针问题，

    输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
    例如输入字符串"I am a student. "，则输出"student. a am I"。

    剑指58题，easy，
    使用split函数会存在多个空格的问题，所以问题主要存在于字符串的拆分
    忽略了为空的情况，但不应该在开头判断，而是对slist进行判断
    时间5%，空间5%，

    官方的第一种方法，双指针，找到每一个单词的索引范围，然后添加
    第二种，先使用split进行分割，再对空字符串进行处理，

     */
    public static void main(String[] args) {
        String s = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";
        String s4 = "";
        String[] slist = new String[]{s, s2, s3,s4};
        for (int i = 0; i < slist.length; i++) {
            System.out.println(reverseWords(slist[i]));
        }

    }
    public static String reverseWords(String s) {
        if(s.length() ==0)return new String("");
        ArrayList<String> slist = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ')sb.append(s.charAt(i));
            else {
                if(sb.length()==0)continue;
                slist.add(String.valueOf(sb));
                sb.setLength(0);
            }
        }
        if(sb.length() !=0)slist.add(String.valueOf(sb));
        String res = "";
        if(slist.size()==0)return res;
        for (int i = slist.size()-1; i >0; i--) {
            res = res+slist.get(i)+" ";
        }
        res += slist.get(0);
        return res;
    }
}
