package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test4 {
    /*

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = Integer.parseInt(sc.next());
        }

//        for (int i = 0; i < n; i++) {
//            b[i] = sc.nextInt();
//        }
//        int[] num = {3,1,5,2,4,4,1};
//        int tar = 8;
//        List<Integer> r =pathSum(num,0,tar);
//        List<Integer> r =pathSum(a,0,tar);
//        System.out.println(r);
    }
    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<Integer> pathSum(int[] num,int index, int sum) {

        recur2(num,index, sum);
        if(res.size()<1)return new LinkedList<>();
        else {
            int lenmin = res.get(0).size();
            int lenindex = 0;
            for (int i = 0; i < res.size(); i++) {
                if(res.get(i).size()<lenmin){
                    lenindex = i;
                    lenmin = res.get(i).size();
                }
            }
            return res.get(lenindex);
        }

//        return res;
    }

    public  static void recur2(int[] num,int index,int tar){
        if(index >= num.length)return;
        path.add(num[index]);
        tar -= num[index];
        if(tar ==0 )res.add(new LinkedList<>(path));
        recur2(num,index*2+1,tar);
        recur2(num,index*2+2,tar);
        path.removeLast();
    }
}
