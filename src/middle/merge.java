package middle;
/*
56,合并区间，中等

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

感觉不难，先排序，然后看上一个的末尾和下一个的开端是否重合，重合则合并，去上一个的start和两个end中较大的end,
对数组遍历一遍即可。
也可以连续多个，完成合并，
当下一个无法合并时，再将结果存入list
定义一个函数，完成合并

时间96%，空间98%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge {
    public static void main(String[] args) {
        int[][] interval1 = {{1,3},
                {2,6},
                {8,10},
                {15,18}};

        int [][] interval2 = {{1,4},{4,5}};
        int[][] res1 = merge(interval1);
        int[][] res2 = merge(interval2);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(Arrays.toString(res1[i]));
        }
        for (int i = 0; i < res2.length; i++) {
            System.out.println(Arrays.toString(res2[i]));
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> rlist = new ArrayList<>();
        int index = 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        while(index <intervals.length){
            if(intervals[index][0] <= end){
                end = Math.max(end,intervals[index][1]);
            }
            else {
                rlist.add(new  int[]{start,end});
                start = intervals[index][0];
                end = intervals[index][1];
            }
            index++;
        }
        rlist.add(new  int[]{start,end});
        return rlist.toArray(new int[rlist.size()][2]);
    }
}
