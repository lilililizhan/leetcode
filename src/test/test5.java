package test;

import java.util.*;

public class test5 {
    /*
    先对数组对6进行取模，然后看模的和是否等于6的倍数，不对啊这
    还是得排序，
     */
    public static void main(String[] args) {
        int tar = 6;
        int[] num = {6,8,4,3};
        combinationSum2(num,6);

    }

//    public static int

    //给定一个数组candidates 和一个目标数target，找出candidates中所有可以使数字和targe的组合。
    //candidates中的每个数字在每个组合中只能使用一次。
    //且数字存在重复

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] candidate2 = new int[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            candidate2[i] = Math.floorMod(candidates[i],6);
        }
        System.out.println(Arrays.toString(candidate2));
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
//        Arrays.sort(candidates);
        if (length == 0)
            return res;

        dfsCombinationSum2(candidates, length, 0, target, path, res);
        return res;
    }

    private static void dfsCombinationSum2(int[] candidates, int length, int begin,
                                    int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            if (target - candidates[i] < 0)
                continue;
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfsCombinationSum2(candidates, length, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        int length = candidates.length;
//        List<List<Integer>> res = new ArrayList<>();
//        Deque<Integer> path = new ArrayDeque<>();
//        Arrays.sort(candidates);
//        if (length == 0)
//            return res;
//        dfsCombinationSum2(candidates, length, 0, target, path, res);
//        return res;
//    }

//    private void dfsCombinationSum2(int[] candidates, int length, int begin,
//                                    int target, Deque<Integer> path, List<List<Integer>> res) {
//        if (target < 0)
//            return;
//        if (target == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = begin; i < length; i++) {
//            if (target - candidates[i] < 0)
//                continue;
//            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
//            if (i > begin && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
//            path.add(candidates[i]);
//            dfsCombinationSum2(candidates, length, i + 1, target - candidates[i], path, res);
//            path.removeLast();
//        }
//    }
}
