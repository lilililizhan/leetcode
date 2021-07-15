package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t8 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String str = sc.next();
//        int[] nums = new int[n];
//        for(int i = 0;i<n;i++){
//            nums[i] = str.charAt(i)-'0';
//        }
        int n =5;
//        int[] nums2 = {0,1,2,1,2};
        int[] nums2 = {2,1,2,0,2};
        System.out.println(Arrays.toString(nums2));
        int r = skip(nums2,n);
        System.out.print(r);
    }
    public static int skip(int[] nums,int n){
        int[] dp = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for(int i =0;i<n;i++){
            if(map.containsKey(nums[i])){
                dp[i]=dp[map.get(nums[i])]+1;
            }
            else{
                dp[i]=dp[i-1]+1;
                map.put(nums[i],i);
            }
        }
        return dp[n-1];
    }
}
