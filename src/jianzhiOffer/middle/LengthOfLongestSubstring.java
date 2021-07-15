package jianzhiOffer.middle;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    /*
    感觉这道题之前做过，已经忘了之前是怎么做的了
    用map来存储，或者长度为26的数组来存储，当没有出现字符串时为-1，出现字符串时为索引值，
    变量max来存储最大长度，当temp>max时替换max
    现在的问题是，当找到重复字符，如何对数组的值进行修改，
    对abcefdc,当循环至第2个c,将e前的a,b，c置为-1,但是这些不是按顺序的，

    测试案例还有“ ”的情况
    "aabaab!bb"所以包含各种字符，
    放弃使用数组或者map了，直接通过sub.contains看是否包含某一字符
    时间：91%，内存12%，看来最直接的方法竟然最好

    官方的代码没太看懂，可以是使用哈希表存储128个字符的ASCII
     */
    public static void main(String[] args) {
//        String s  = "abcabcbb";
//        String s  = "bbbbb";
//        String s  = "pwwkew";
//        String s  = " ";
        String[] s  = {"abcabcbb","bbbbb","pwwkew"," ","nfpdmpi","aabaab!bb",};
//        System.out.println(s[4]+":   "+lengthOfLongestSubstring2(s[4]));
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]+":   "+lengthOfLongestSubstring2(s[i]));
        }
//        int r = lengthOfLongestSubstring2(s);
//        System.out.println(r);
//        int[] num = new int[26];
//        fuwei(num,s,2,3);
//        System.out.println(Arrays.toString(num));

    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int temp = 0;
        int[] num = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1};
        int start=0;
        int c;
//        System.out.println(Arrays.toString(num));
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                c = 26;
            }
            else c = s.charAt(i)-'a';
            if(num[c] ==-1){
                num[c] = i;
                temp ++;
            }
            else {
                max = temp>max?temp:max;
                fuwei(num,s,start,num[c]-1);
                start = num[c]+1;
                temp = i -start+1;
                num[c] = i;
            }
        }
        return max>temp?max:temp;
    }
    public static void fuwei(int[] num, String s,int start, int end){
        for (int i = start; i <= end; i++) {
            num[s.charAt(i)-'a']=-1;
        }
    }

    public static int lengthOfLongestSubstring2(String s){
        int start=0,end = 0;
        int max=0,temp = 0;
        String t;
        for (int i = 0; i < s.length(); i++) {
            t = s.substring(start,i);
            if(t.indexOf(s.charAt(i)) ==-1){
                temp++;
            }
            else {
                start += t.indexOf(s.charAt(i)-0)+1;
                max = max>temp?max:temp;
                temp = i - start+1;
            }
        }
        return max>temp?max:temp;
    }
}
