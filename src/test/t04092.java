package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class t04092 {
    /*
    暴力法不知道行不，先试一下吧，
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int[][] operate = new int[k][2];
        for (int i = 0; i < k; i++) {
            operate[i][0] = sc.nextInt();
            operate[i][1] = sc.nextInt();
        }
        ArrayList<int[]> r = new ArrayList<>();
//        while(sc.hasNext()){
//            operate[i][0] = sc.nextInt();
//            operate[i][1] = sc.nextInt();
//            i++;
//        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < k; i++) {
            r.add(operate[i]);
        }
        for (int i = 0; i < r.size(); i++) {
            System.out.println(Arrays.toString(r.get(i)));
        }
//        System.out.println(Arrays.toString(operate));
//        int[] nums = {1,2,3,4,5};
//        int[][]  operate = {{1,3},{2,4},{2,5}};
//        for (int i = 0; i < operate.length; i++) {
//            reverse(nums,operate[i][0]-1,operate[i][1]-1);
//        }

    }
    public static int[] reverse(int[] nums, int l,int r){
        int k = (r-l+1)/2;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[l+i];
            nums[l+i] = nums[r-i];
            nums[r-i]=temp;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
