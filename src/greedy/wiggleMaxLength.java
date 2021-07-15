package greedy;

public class wiggleMaxLength {
    /*
    376,middle
    如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
    例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
    给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

    难点在于可以删除一些元素，
    当不符合情况时，有两种可能：删除当前元素和删除后一位元素，
    [1,17,5,10,13,15,10,5,16,8]，在10-13-15出错，那我觉得应该舍13选15，这样后面的可能性最大，
    能不能分治，我甚至还想用动态规划，
    有个想法，找到递增和递减的序列，然后取1，如[5,10,13,15],[15,10,5],是三个数，加上1，17，16，8，共7个数，这样的话其实留下的数是几不重要，只要有这个
    [10,13,15][15,10],不能留下10，要留最大的数15，
    还需要处理相等的情况，

    最后的思路是定义三个索引，依次往前挪，时间100%,空间34%
    忘了记录时间了，

    官方解法好多，
    动态规划和贪心算法，但已经看不懂了，

    文档里比较简单的一种方法是，统计其波峰和波谷的个数
     */
    public static void main(String[] args) {
//        int[] nums = {1,7,4,9,2,5};//6
//        int[] nums = {1,17,5,10,13,15,10,5,16,8};//7
        int[] nums = {1,2,3,4,5,6,7,8,9};//7
        int r = wiggleMaxLength(nums);
        System.out.println(r);

    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int n = 0;
        int i = 0;
        int index = 0;
        int j = 0;
        boolean b1 = false;
//        boolean b2 = false;
        while (j < nums.length) {
            if (nums[index] == nums[i]) {
                index++;
                j++;
                continue;
            } else if (nums[index] == nums[j]) {
                b1 = true;
                j++;
                continue;
            }
            if ((nums[index] - nums[i]) * (nums[j] - nums[index]) < 0) {
//                b2=true;
                n++;
                i = index;
                index = j;
                j++;
            } else {
                index++;
                j++;
            }
        }
//        return !b1 ?  1 : (!b2 ? 2 :n+2 );
        return !b1 ? 1 : n + 2;
    }
}
