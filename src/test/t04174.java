package test;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import java.util.*;

public class t04174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[] num = new int[k];
            for (int j = 0; j < k; j++) {
                num[j] = sc.nextInt();
            }
            res[i] = diff(num);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            int k = sc.nextInt();
//            int[] num = new int[k];
//            for (int j = 0; j < k; j++) {
//                num[j] = sc.nextInt();
//            }
////            System.out.println(Arrays.toString(num));
//            System.out.println(diff(num));
//
//        }

    }
    public static int diff(int[] num){
        HashMap<Integer,Integer> fremap = new HashMap<>();
        HashMap<Integer,Integer> indexmap = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if(!fremap.containsKey(num[i])){
                fremap.put(num[i],1);
                indexmap.put(num[i],i);
            }
            else fremap.put(num[i],fremap.get(num[i])+1);
        }
        boolean b =false;
        int minvalue = Integer.MAX_VALUE;
        for (Integer key:fremap.keySet()
             ) {
            if(key<minvalue ){
                if(fremap.get(key)==1){
                    b= true;
                    minvalue=key;
                }
            }
        }
        return b ? indexmap.get(minvalue)+1 :-1;
    }

}
