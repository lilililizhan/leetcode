package jianzhiOffer.middle;

public class IsNumber {
    /*
    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
    但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。

    0-9：48-57， E：69 e：101 .：46  +：43  -：45

    定义规则：
    1.字母只能出现E，e，后面只能跟带符号的整数
    2. 只能有一个小数点
    3.正负号开头有且只有一个
    思路：从第一位开始循环，定义Boolean类型变量标识正负号和小数点，当出现E/e后，判断最后的数是否是整数
        对正负号，判断第一个并将f改为true,
        对E以后的段，单独定义一个函数

    "1 "也是数字，".1"," 0也是"
    " .不是"
    "3."是数字
    “1  ”也是数字
    ".e1"不是数字
    改到这里我放弃了，边界条件太多了，这才1387/1480个案例，打算换一种思路，
    还是不换思路了，再加点约束条件吧

    可算通过了，特殊情况太多了，而且时间复杂度67%，空间复杂度45%，还不错，好奇官方的答案

    官方的回答是有限状态机，感觉方法挺好的，但我没仔细看没看懂

     */

    public static void main(String[] args) {
        String[] s1  = {"+100","5e2","-123","3.1416","-1E-16","0123"};
        String[] s2  ={"12e","1a3.14","1.2.3","+-5","12e+5.4"};
//        String s = s1[1];
//        System.out.println(isNumber(s));
//        for (int i = 0; i < s1.length; i++) {
//            System.out.print(s1[i]+":    ");
//            System.out.println(isNumber(s1[i]));
//        }
//
        for (int i = 0; i < s2.length; i++) {
            System.out.print(s2[i]+":    ");
            System.out.println(isNumber(s2[i]));
        }

////        String s = "1 ";
////        String s = ".1";
////        String s = ".";
////        String s = " 0";
//        String s = " .";
        String s = ".e1";
        System.out.println(isNumber(s));

    }
    public static boolean isNumber(String s) {
        boolean e = false;
        boolean dot = false;
        boolean r = true;
        boolean num = false;
        int start = 0;
        int end = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != 32){
                start = i;
                break;
            }
        }
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) !=32 ){
                end = i;
                break;
            }

        }
        s = s.substring(start,end+1);
        if(s.charAt(0) == 43 || s.charAt(0) == 45 ){
        }
        else if(s.charAt(0)>= 48 && s.charAt(0)<= 57){
            num = true;
        }
        else if(s.charAt(0)==46) {
            if(s.length() ==1)return false;
            else dot = true;
        }
        else {
            return  false;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 46){
                if(!dot ) dot = true;
                else return false;
            }
            else if(c >= 48 && c <= 57)num = true;
            else if( c == 69 || c == 101){
                if( !e) {
                    e = true;
                    if(!num)return false;
                    r = isNumber2(s.substring(i+1));
                    return r;
                }
                else return false;
            }
            else return false;
        }
        if(num == false)return false;
        return true;
    }
    public static boolean isNumber2(String s){
        boolean r = true;
        if(s.length()==0)return false;
        if(s.charAt(0) == 43 || s.charAt(0) == 45){
            if(s.length() ==1) return false;
        }
        else if(s.charAt(0)>= 48 && s.charAt(0)<= 57){
        }
        else {
            return  false;
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)<48 || s.charAt(i)>57)return false;
        }
        return r;
    }

    public static boolean isNumber3(String s){
        /*
        首先必须要有数字，e后面必须跟整数
        字符串首尾可以有空格，首空格可以跳过，尾空格呢
         */
        return true;
    }
}
