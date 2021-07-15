package jianzhiOffer.middle;

public class StrToInt {
    /*
   题目好长啊，大概意思是，
   去掉前面无用的空格，
   如果第一个非空字符不是数字或正负号，则不需要转换
   数字的范围不超过2*31

   函数分为两步，第一步是获得合理的字符串，第二步是将字符串转为int
   考虑到范围，使用long类型
   注意：当出现+/-后，不能再出现+/-
   使用flag来标记符号位

   做题过程还算顺利，但时间9%，空间12%

   官方的解答是直接在获取合理字符串的时候就开始计算结果，并根据结果的大小及时退出

   有一个比较好的方法，使用while循环直接得到开始的地方，计算结果的时候也直接从结束的地方开始
   while循环和for循环的差别是，局部变量和全局变量

   修改之后时间99%，空间78%
   bndry = Integer.MAX_VALUE / 10;这个应该挺好用的
    */
    public static void main(String[] args) {
//        String s = "42";
//        String s = "     -42";
//        String s = "4193 with words";
//        String s = "words and 987";
//        String s = "-91283472332";
//        String s = "";
        String s = " ";
//        String s = "9223372036854775808";
        int r = strToInt2(s);
        System.out.println(r);

    }
    public static int strToInt(String str) {
        boolean s = false;
        long r = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(!s){
                if(str.charAt(i)==' ')continue;
                if(str.charAt(i)=='+' || str.charAt(i)=='-' || (str.charAt(i)>='0' && str.charAt(i)<='9')){
                    s=true;
                    sb.append(str.charAt(i));
                }
                else return 0;
            }
            else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                sb.append(str.charAt(i));
            }
            else break;
        }
        if(sb.length()==0)return 0;
        for (int i = 0; i < sb.length(); i++) {
            if(r>=Integer.MAX_VALUE)break;
            if(sb.charAt(i)=='-' ||sb.charAt(i)=='+')continue;
            else r = r*10 + Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        if(sb.charAt(0)=='-')r = -r;
        if(r<0)return r > Integer.MIN_VALUE ? (int) r :Integer.MIN_VALUE;
        if(r>0)return r < Integer.MAX_VALUE ? (int) r :Integer.MAX_VALUE;

        return (int) r;
    }

    public static int strToInt2(String str) {
        int f = 1;
        int i =0;
        long r= 0;
        if(str.length()==0)return 0;
        while(i<str.length()){
            if(str.charAt(i)!=' '){
                break;
            }
            i++;
        }
        if(i<str.length() &&(str.charAt(i)=='-' || str.charAt(i)=='+')){
            f = str.charAt(i)=='-'? -1:1;
            i++;
        }
        for (int j = i; j <str.length() ; j++) {
            if(r>Integer.MAX_VALUE)break;
            if(str.charAt(j)>='0' && str.charAt(j)<='9'){
                r = r*10 +str.charAt(j)-'0';
            }
            else break;
        }
        r = r*f;
        if(f<0)return r > Integer.MIN_VALUE ? (int) r :Integer.MIN_VALUE;
        else return r < Integer.MAX_VALUE ? (int) r :Integer.MAX_VALUE;
    }
}
