package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test3 {
    /*

     */
    public static void main(String[] args) {
//        int[] num = {3,1,5,2,4,4,1};
        ArrayList num = new ArrayList();
        num.add(3);
        num.add(1);
        num.add(5);
        num.add(2);
        num.add(4);
        num.add(4);
        num.add(1);
//        = {3,1,5,2,4,4,1};
        int tar = 8;
        List<Integer> r =pathSum(num,0,tar);
        System.out.println(r);

    }
    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<Integer> pathSum(ArrayList num,int index, int sum) {

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

    public  static void recur2(ArrayList num,int index,int tar){
        if(index >= num.size() || num.get(index)==null)return;
        path.add((Integer) num.get(index));
        tar -= (Integer)num.get(index);
        if(tar ==0 )res.add(new LinkedList<>(path));
        recur2(num,index*2+1,tar);
        recur2(num,index*2+2,tar);
        path.removeLast();
    }
}
