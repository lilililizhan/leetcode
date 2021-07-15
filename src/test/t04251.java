package test;

/*
题目本身不难，71/5 = 14-1
首先判断商，其次判断余数，同时要对商取24的模，
A的ascii码是65
 */
import java.util.*;
public class t04251 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int c = sc.nextInt();
//        int[] arr = new int[num];
//        for (int i = 0; i < num; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int[] arr = {71,28,120,30,1};
//        int num = 5;
//        int c = 5;
        int[] arr = {52,53,54};
        int num = 3;
        int c = 2;
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < num; i++) {
            System.out.println(test(arr[i],c));
        }

    }
    public static String test(int n,int c){
        String res;
        char c0 =0 ;
        int ch = Math.floorMod(n/c,26);
        int yushu = n%c;
        System.out.println(n +"  " +ch + "  "+yushu);
        System.out.println((char)(Math.floorMod(ch+1,26)+65));


        if(yushu==0)res = (char)(ch+65) +String.valueOf(c);
        else res = (char)(Math.floorMod(ch+1,26)+65) +String.valueOf(yushu);
//        if(yushu==0)res = (char)((Math.floorMod(ch,27)+64)) +String.valueOf(c);
//        else res = (char)(Math.floorMod(ch,27)+64) +String.valueOf(yushu);
        return res;
    }
}
