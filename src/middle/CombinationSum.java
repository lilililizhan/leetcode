package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
    因为都是正数，所以可以先排列，删除比它大的，
    数组的长度在30以内，每个元素可以被无限次使用
    要定义一个组合的规则，
    感觉这是一个迭代的过程，list中较大的数是否可以拆分为更小的数，

    震惊，十分的震惊，我竟然，一次出来了，看来这种递归的题目，我还可以嘛

    看到官方的答案，什么回溯、减枝、树，都看不懂
     */
    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> r = combinationSum(candidates,target);
        System.out.println(r.toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = candidates.length-1; i >=0 ; i--) {
            int max = candidates[i];
            if(max == target){
                List<Integer> listTemp = new ArrayList<>();
                listTemp.add(max);
                list.add(listTemp);
            }
            if(target - max >= max){
                List<List<Integer>> listTemp = combinationSum(Arrays.copyOfRange(candidates,0,i+1),target-max);
                if(listTemp != null){
                    for (List<Integer> l:listTemp
                         ) {
                        l.add(max);
                        list.add(l);
                    }
                }
            }
            else if(target - max >= candidates[0]){
                List<List<Integer>> listTemp = combinationSum(Arrays.copyOfRange(candidates,0,i),target-max);
                if(listTemp != null){
                    for (List<Integer> l:listTemp
                    ) {
                        l.add(max);
                        list.add(l);
                    }
                }

            }

        }
        return list;
    }
}
