package jianzhiOffer.String;

public class reverseLeftWords {
    /*、
    左旋转字符串，
    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

    剑指58-2，easy,
    时间100%，空间77%，感觉不太对劲，可官方的答案也是这样的，

     */
    public static void main(String[] args) {
//        String s = "abcdefg";
//        int n =2;

        String s = "lrloseumgh";
        int  n =6;
        String r = reverseLeftWords(s,n);
        System.out.println(r);
    }
    public static String reverseLeftWords(String s, int n) {
        String res = s.substring(n)+s.substring(0,n);
        return res;
    }
}