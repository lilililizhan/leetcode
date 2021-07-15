package test;

import java.util.*;
public class m{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int temp = in.nextInt();
            int[][] array = new int[temp][5];
            for (int j = 0; j < temp; j++) {
                for (int i1 = 0; i1 < 5; i1++){
                    array[j][i1] = in.nextInt();
                }
            }
            int[] result = getResult(array);
            System.out.println(result[0] + " " + result[1] );
        }
    }

    public static int[] getResult(int[][] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = getValue(nums,i,j);
                map.put(temp,new int[]{i,j});
            }
        }
        int max = 0;
        for (Integer integer : map.keySet()) {
            max = Math.max(integer, max);
        }
        return map.get(max);
    }
    public static int getValue(int[][] nums, int a, int b) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            min = Math.min(Math.max(nums[a][i],nums[b][i]),min);
        }
        return min;
    }
}