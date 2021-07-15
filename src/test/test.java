package test;

import java.util.*;

public class test {
    /*
   集合中的数是一一对应的，
   所以应该比较数的个数，而不是数的大小,
   最简单是通过个数映射，建立两个map

   首先统计出来每个数各有多少个，然后移动，看个数是否能对的上

   有一个答案是直接看，小于小美的人数是多少，然后循环/2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
//        int[] a = {1,1,4,5,1,4};
////        int[] b = {3,0,4,0,3,0};
//        int[] b = {7,7,7,2,2,3};
//
////        int[] a = {2,2,4,6,2,5};
////        int[] b = {3,0,4,0,3,0};
//        int m = 8;
//        int n = 6;
        int r = t3(a,b,m);
        System.out.println(r);
    }
    public static int t(int[] a,int[] b,int n,int m){
        Arrays.sort(a);
        Arrays.sort(b);
        HashMap<Integer,Integer> mapa1 = new HashMap<>();
        HashMap<Integer,Integer> mapa2 = new HashMap<>();
        int f =a[0];
        int num = 1;
        int i =0;
        while(i<n){
            if(a[i]==f)num++;
            else {
                mapa1.put(a[i-1],num);
                num=1;
                f=a[i];
            }
            i++;
        }
        mapa1.put(a[n-1],num);
//        for (int i = 1; i < a.length; i++) {
//            if(a[i]==f)num++;
//            else {
//                mapa1.put(a[i-1],num);
//                num=1;
//                f=a[i];
//            }
//        }
        for (Integer in:mapa1.keySet()
             ) {
            mapa2.put(mapa1.get(in),in);
        }
        HashMap<Integer,Integer> mapb1 = new HashMap<>();
        HashMap<Integer,Integer> mapb2 = new HashMap<>();
        f =b[0];
        num = 1;
        int j =0;
        while(j<n){
            if(b[j]==f)num++;
            else {
                mapb1.put(b[j-1],num);
                num=1;
                f=b[j];
            }
            j++;
        }
        mapb1.put(b[n-1],num);
        for (Integer in:mapb1.keySet()
        ) {
            mapb2.put(mapb1.get(in),in);
        }
        int r = Math.floorMod(b[0]+m-a[0],m);

        return r;
//        return Math.floorMod(a[0]-b[0],m);
//        return (a[0]-b[0]).mod(m);
    }

    public static int t2(int[] a,int[] b, int n, int m){
        Arrays.sort(a);
        Arrays.sort(b);
//        LinkedHashMap<Integer,Integer> amap = new LinkedHashMap<>();
//        LinkedHashMap<Integer,Integer> bmap = new LinkedHashMap<>();
//        for (int i = 0; i < n; i++) {
//            amap.put()
//
//        }
        ArrayList<Integer> anum = new ArrayList<>();
        ArrayList<Integer> anum2 = new ArrayList<>();
        ArrayList<Integer> bnum = new ArrayList<>();
        ArrayList<Integer> bnum2 = new ArrayList<>();

        int f =a[0];
        int num = 1;
        int i =1;
        while(i<n){
            if(a[i]==f)num++;
            else {
                anum.add(num);
                anum2.add(f);
                num=1;
                f=a[i];
            }
            i++;
        }
        anum.add(num);
        anum2.add(f);

        f =b[0];
        num = 1;
        int j =1;
        while(j<n){
            if(b[j]==f)num++;
            else {
                bnum.add(num);
                bnum2.add(f);
                num=1;
                f=b[j];
            }
            j++;
        }
        bnum.add(num);
        bnum2.add(f);
        int r = m;
        for (int k = 0; k < anum.size(); k++) {
            boolean bool =true;
            for (int l = 0; l < anum.size(); l++) {
                if(anum.get(Math.floorMod(l+k,anum.size()))!=bnum.get(l)){
                    bool = false;
                    break;
                }
            }
            if(bool)return Math.min(r,Math.floorMod(bnum2.get(0)+m-anum2.get(k),m));

        }
        return m;
    }

    public static int t3(int[] a,int[] b, int m){
        Arrays.sort(a);
        Arrays.sort(b);
        int sub = b[0]-a[0];
        if(sub == 0)return 0;
        if(sub>0)return sub;
        while (sub<0)sub+=m;
        return sub;
//        return 0;
    }
}
