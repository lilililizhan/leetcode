package test;

import java.util.*;

public class t04044 {
    // 走方格
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[][] arr = new int[n][n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scan.nextInt();
                set.add(arr[i][j]);
            }
        }

        int res = getNum(n,k,arr);
        System.out.println(res);
    }
    public static int getNum(int n,int k,int[][] arr){

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(arr[i][j])){
                    List<Integer> list = map.get(arr[i][j]);
                    list.add(i*n+j);
                    map.put(arr[i][j],list);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i*n+j);
                    map.put(arr[i][j],list);
                }
            }
        }
        if(map.size()<k) return -1;
        int res = 0;
        for(int i=0;i<k-1;i++){
            int temp = Integer.MAX_VALUE;
            int p = map.get(i+1).size();
            int q = map.get(i+2).size();
            int[][] dp = new int[p][q];
            for(int j=0;j<p;j++){
                for(int w=0;w<q;w++){
                    int wei_i = map.get(i+1).get(j);
                    int wei_ii = map.get(i+2).get(w);
                    dp[j][w] = Math.abs(wei_i%n - wei_ii%n) + Math.abs(wei_i/n - wei_ii/n);
                    if(temp>dp[j][w]) temp = dp[j][w];
                }
            }
            res += temp;
        }
        return res;
    }

    public static int getNum2(int n,int k,int[][] arr,HashSet<Integer> set){
        for (int i = 0; i < k; i++) {
            if(!set.contains(i)){
                return -1;
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(arr[i][j])){
                    List<Integer> list = map.get(arr[i][j]);
                    list.add(i*n+j);
                    map.put(arr[i][j],list);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i*n+j);
                    map.put(arr[i][j],list);
                }
            }
        }
        if(map.size()<k) return -1;
        int res = 0;
        for(int i=0;i<k-1;i++){
            int temp = Integer.MAX_VALUE;
            int p = map.get(i+1).size();
            int q = map.get(i+2).size();
            int[][] dp = new int[p][q];
            for(int j=0;j<p;j++){
                for(int w=0;w<q;w++){
                    int wei_i = map.get(i+1).get(j);
                    int wei_ii = map.get(i+2).get(w);
                    dp[j][w] = Math.abs(wei_i%n - wei_ii%n) + Math.abs(wei_i/n - wei_ii/n);
                    if(temp>dp[j][w]) temp = dp[j][w];
                }
            }
            res += temp;
        }
        return res;
    }
}




