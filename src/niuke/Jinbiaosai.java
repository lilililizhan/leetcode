package niuke;

import java.util.Arrays;

public class Jinbiaosai {
    /*
    跟具体的分数没有什么关系，有关系的是比小美分高的人数和比小美分低的人数
    为保证能多活几场，尽可能让分高的出去，分高的和分高的比，由于分数一样的话会随机出局，可以任务分数也是低于小美，
    若是bigger的数是奇数，就让bigger和small,当small没有且bigger还有的时候，就败了
    使用递归的思想
     */
    public static void main(String[] args) {
//        int n =4;
//        int[] score = {4,1,2,3};
        int n =8;
        int[] score = {4,1,2,3,5,7,8,2};
        int r = bisai(score,n);
        System.out.println(r);
    }
    public static int bisai(int[] score,int n){
        int bigger = 0;
        int target = score[0];
        int i = 0;
        Arrays.sort(score);
        while(i<n){
            if(score[i]==target)break;
            i++;
        }
        int[] num = {n-i-1,1,i,0};
        return bi(num,n);
    }
    public static int bi(int[] num,int n){
        int bigger = num[0];
        int smaller = num[2];
        if(bigger ==0)return (int) (Math.log(n)/Math.log(2));
        else {
            if(smaller ==0)return num[3];
            else {
                bigger = (int)Math.ceil((double)bigger/2);
                smaller = (int)Math.ceil((double)smaller/2-1);
                num[0] = bigger;
                num[2]=smaller;
                num[3]++;
                return bi(num,n);
            }
        }
    }
}
