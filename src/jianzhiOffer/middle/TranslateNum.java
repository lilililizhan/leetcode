package jianzhiOffer.middle;

import java.util.Arrays;

public class TranslateNum {
    /*
    实际上是如何划分的问题，两个数一组还是一个数一组，有点像爬楼梯，但是两个数的时候需要判断是否在范围内
    num的最大值为2^31=2 147 483 648,有什么特殊含义吗，怕是没有，正好是int的最大范围，
    因此最大位数是10位，完全可以使用递归的思想，
    是否可以像爬楼梯一样的思路呢，不行吧，因为不确定是否可以一次两个，其实也可以用，待会尝试一下

    一直不对，换一种做法，正序着来,按照爬楼梯的思路来
    f(n) = a*f(n-1) +b*f(n-2) a =1, 当n和n-1能合并时，b = 1
    递归的可以了，换一种写法,
    看了官方的，思路是一样的，但没有转化为数组，直接用字符串
    1.如何排除0的情况，组合的数>=10且<=25
    2.对称的，从左到右和从右到左是一样的
    3.如何获得每一位，%10，

     */
    public static void main(String[] args) {
//        int num = 12258;
//        int num = 25;
//        int num = 26;
//        int num = 506;//结果是1，06不是数字
        int num = 18822;
        int r = translateum(num);
        System.out.println(r);
//        int r2 = translateNum(num);


    }
    public static int translateum(int num) {
        String s  = num+"";
        int[] n  = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            n[i] = s.charAt(i)-48;
        }
        if(n.length==1)return 1;
        int sum =0;
        int temp1 = 1;
        int temp2 = 1;
        for (int i = 1; i < n.length; i++) {
            if(n[i]+n[i-1]*10 <=25 && n[i-1]!=0){
                sum = temp1+temp2;
            }
            else {
                sum = temp2;
            }
            temp1 = temp2;
            temp2 = sum;
        }
        return sum;
    }
    public static int translateNum(int num) {
        String s  = num+"";
//        System.out.println(s);
        int[] n  = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            n[i] = s.charAt(i)-48;
        }
        int r = translateNum4(n);
//        System.out.println(Arrays.toString(n));

        return  r;
    }
    public static int translateNum2(int num[],int index) {
        if(index == 0){
            return 1;
        }
        else if(num[index]+num[index-1]*10<=25 && num[index-1]!=0){
            if(index==1){
//                if(num[index-1]+num[index]*10>25)
                    return (translateNum2(num,index-1)+1);
            }
            System.out.println(num[index-1]+"  "+ num[index]);
//            if()
            return translateNum2(num,index-1)*2-1;
        }
        else return translateNum2(num,index-1);
    }

    public static int translateNum3(int num[], int index){
        if(index ==0){
            return 1;
        }
        if(index ==1){
            if(num[1]+num[0]*10 <=25)return 2;
            else return 1;
        }
        if(num[index]+num[index-1]*10<=25 && num[index-1]!=0)return translateNum3(num,index-1)+translateNum3(num,index-2);
        else return translateNum3(num,index-1);
    }
    public static int translateNum4(int num[]){
       if(num.length==1)return 1;
       int sum =0;
       int temp1 = 1;
       int temp2 = 1;
        for (int i = 1; i < num.length; i++) {
            if(num[i]+num[i-1]*10 <=25 && num[i-1]!=0){
                sum = temp1+temp2;
            }
            else {
                sum = temp2;
            }
            temp1 = temp2;
            temp2 = sum;
        }
        return sum;
    }
}
