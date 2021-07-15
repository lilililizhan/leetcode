package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumEquivDominoPairs {
    /*
    目前除了递归两两比较外，想不到别的方法了
    看样子，只包含二维的数组吧，
    数组的长度有点大啊，
    果然数组太长了
    考虑对数组进行排序
    排序之后，直接从i+1位开始比较，比较完直接break
    180度的情况比较难搞，

    最后一个案例，显示超出时间限制
    决定换一种思路，总共9*9=81中组合，去掉重复的，9+8+7+6+5+4+3+2+1 = 45种组合，采用字典的方法
    原本想使用map,但map的话key值为数组不好查找，因此key值为int,大小为9*9=81

    官方的解法太秒了，数组每加一，总个数加上数组的值

     */
    public static void main(String[] args) {
//        int[][] dominoes= {{1,2},{5,6},{1,1},{2,1},{3,4},{5,6}};
        int[][] dominoes= {{2,1},{1,2},{1,2},{1,2},{2,1},{1,1},{1,2},{2,2}};
//        Arrays.sort(dominoes);
//        Arrays.sort(dominoes, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b){
//                if(a[1]==b[1]){
//                    return a[0] - b[0];
//                }else {
//                    return a[1] - b[1];
//                }
//            }
//        });
//        for(int i=0;i<dominoes.length; i++){
//            System.out.println(Arrays.toString(dominoes[i]));
//        }
//        System.out.println(dominoes);
        System.out.println(numEquivDominoPairs(dominoes));

    }
    public static int numEquivDominoPairs(int[][] dominoes) {
        /*
        int num = 0;
        for (int i = 0; i < dominoes.length-1; i++) {
            for (int j = i+1; j < dominoes.length; j++) {
                if((dominoes[i][0] == dominoes[j][0] &&dominoes[i][1] == dominoes[j][1] ) ||
                        (dominoes[i][0] == dominoes[j][1] &&dominoes[i][1] == dominoes[j][0] )){
                    num++;
                }
            }
        }
        return num;
         */

        //想法舍弃
       /* Arrays.sort(dominoes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });
        int num1 = 0;
        //完成一次正对着排序
        for (int i = 0; i < dominoes.length-1; i++) {
            for (int j = i+1; j < dominoes.length; j++) {
                if(dominoes[i][0] == dominoes[j][0]){
                    if(dominoes[i][1] == dominoes[j][1]){
                        num1++;
                    }
                    if(dominoes[i][1] < dominoes[j][1] || dominoes[i][0] < dominoes[j][0]){
                        break;
                    }
                }

            }
        }
        int[][] d2 = new int[dominoes.length][2];
        for (int i = 0; i < dominoes.length; i++) {
            d2[i][0] = dominoes[i][1];
            d2[i][1] = dominoes[i][0];
        }
        //进行180旋转后对比，注意[1,1]的情况，这种情况不比
        int num2= 0;
        Arrays.sort(d2, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });
        boolean b = true;
        for (int i = 0; i < d2.length; i++) {
            b = true;
            if(b == false)continue;
            for (int j = 0; j < d2.length; j++) {
                if(d2[i][0] == dominoes[j][0]){
                    if(d2[i][1] == dominoes[j][1]){
                        if(d2[i][0] != d2[i][1]) num2++;
                    }
                    if(d2[i][1] < dominoes[j][1] || d2[i][0] < dominoes[j][0]){
                        b = false;
                        break;
                    }
                }

            }
        }
        System.out.println("num1:  "+num1);
        System.out.println("num2:  "+num2);
        return num1+num2/2;*/
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                map.put((i-1)*9+j,0);
            }

        }
//        for (Integer a: map.keySet()
//             ) {
//            System.out.println(a);
//        }
        for (int i = 0; i < dominoes.length; i++) {
            int min = Math.min(dominoes[i][0],dominoes[i][1]);
            int max = Math.max(dominoes[i][0],dominoes[i][1]);
            map.put((min-1)*9+max,map.get((min-1)*9+max)+1);
        }
        int num = 0;
        int temp = 0;
        for (Integer a: map.keySet()
        ) {
            temp = map.get(a);
            if(temp != 0 ){
                System.out.println(a+":  "+temp);
            }
            num = num +(temp-1)*temp/2;
        }
        return num;
    }
}
