package dp;

import java.util.*;

public class FindTargetSumWays {
    /*
    动态规划，中等，题号494
    将数组分为两部分，一部分加，一部分减
    先进行排序，
    某些数的组合等于另外一些数吗？？？？不懂，
    可以这样理解，先求出所有数的和，然后相减，求某些数的和等于差
    sum = zheng + fu;
    zheng-fu = target

    没有用到动态规划，用到了减枝
    [1,0]
    1
    忽略了0的情况,n个零，则组合情况有：2^n-1，不对，这个问题的关键在于，tar=0,则可以不用操作
    [9,7,0,3,9,8,6,5,7,6] 2
    这个错了，预期40，输出41

    [1] 1,这个也错了，增加一个判断，path不为空
    [0,0,0,0,0,0,0,0,1]1，预期结果256，还是要对0进行判断，结果是264，差了8，正好是0的个数,一直是零出错，这样吧，值为零时跳过

    时间15%，空间5%
    答案用了动态规划的做法，

    背包问题，不是很懂，
    哦我懂了，相当于，每移动一步，把带来的影响都记录下来，
    时间69%，空间25%

    空间优化：使用两个数组，完成，没有尝试

     */
    public static void main(String[] args) {
//        int[] nums  ={1,1,1,1,1};
//        int target = 3;
//        int[] nums  ={1,0};
//        int target = 1;
//        int[] nums  ={9,7,0,3,9,8,6,5,7,6};
//        int target = 2;//40
//        int[] nums  ={1};
//        int target = 1;
        int[] nums  ={0,0,0,0,0,0,0,0,1};
//        int[] nums  ={1};
        int target = 1;//256
//        int[] nums  ={0,4,6,0,3,2,6,9,4,1};
//        int target = 3;//60
        int r = findTargetSumWays3(nums,target);
        System.out.println(r);

    }
    public static int findTargetSumWays(int[] nums,int target) {
        Arrays.sort(nums);
        int zeronum=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)zeronum++;
            else break;
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if((sum -target)%2 !=0)return 0;
        int tar = (sum -target)/2;
        findTargetSumWays2(nums,0,tar,path,res);
//        System.out.println(res);
//        return res.size() + (int)Math.pow(2,zeronum)-1;
//        return tar==0 ? res.size()+1+ (int)Math.pow(2,zeronum)-1-zeronum: res.size()+ (int)Math.pow(2,zeronum)-1-zeronum;
        System.out.println(res.size());
        return res.size()*((int)Math.pow(2,zeronum));
    }

    public static void findTargetSumWays2(int[] nums, int index,int tar,Deque<Integer> path, List<List<Integer>> res) {
        if(tar <0)return;
//        if(tar ==0 && path.size() !=0){
        if(tar ==0 ){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(tar -nums[i]<0)continue;
//            if(i>index && nums[i]==nums[i-1])continue;
            if(nums[i]!=0){
                path.add(nums[i]);
                findTargetSumWays2(nums,i+1,tar-nums[i],path,res);
                path.removeLast();
            }

        }
    }

    public static int findTargetSumWays3(int[] nums,int S){
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0]+1000]=1;
        dp[0][-nums[0]+1000] +=1;//这个地方，有可能，第一个数是0
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <=1000 ; j++) {
                if(dp[i-1][j+1000]>0){
                    dp[i][j+1000+nums[i]] +=dp[i-1][j+1000];
                    dp[i][j+1000-nums[i]] +=dp[i-1][j+1000];
                }
            }

        }
        return S>1000 ? 0:dp[nums.length-1][S+1000];
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
//
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
