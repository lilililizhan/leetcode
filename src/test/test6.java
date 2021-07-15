package test;

import java.util.*;

public class test6 {
    public static void main(String[] args) {
        int target = 100;
        int discount= 10;
        int[] pric = {47,59,42,54};
        System.out.println(combinationSum2(pric,target,discount));
    }
    public static int combinationSum2(int[] candidates, int target,int discount) {
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        if (length == 0)
            return 0;
        dfsCombinationSum2(candidates, length, 0, target, path, res);
        if(res.size()==0)return 0;
        int min = sum(res.get(0));
        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            if(sum(res.get(i))<min)
                min = sum(res.get(i));
        }
        return min-discount;
    }

    public static void dfsCombinationSum2(int[] candidates, int length, int begin,
                                           int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target <= 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            path.add(candidates[i]);
            dfsCombinationSum2(candidates, length, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }
    public static int sum(List<Integer> num){
        int res = 0;
        for (int i = 0; i < num.size(); i++) {
            res += num.get(i);
        }
        return res;
    }
}
