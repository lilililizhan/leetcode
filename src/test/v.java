package test;

import java.util.*;
public class v {
    public static void main(String[] args) {
        Set<int []> set = new HashSet<>();
        Integer[] a = {1,2,3};
        int[] b = {1,2,3};
//        int[] b = a;
//        set.add(a);
//        System.out.println(set.contains(b));

//        System.out.println(-1);

//        Arrays.sort(new int[]{2,1,3});
        float[][] c = {{(float) 1.3, (float) 1.4},
                {(float) 1.0, (float) 1.5},
                {(float) 0.9, (float) 1.2},
                {(float) 0.8, (float) 1.2}};
        Arrays.sort(c, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                if(o2[1]-o1[1] >=0)return 1;
                else return -1;

            }
        });

        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
//        Arrays.sort(a, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        System.out.println(Arrays.toString(a));
    }
}
