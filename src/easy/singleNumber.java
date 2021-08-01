package easy;

import java.util.ArrayList;
import java.util.List;

/*
136,只出现一次的数字，简单
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

暴力法：map统计个数，
实际应该进行二进制的异或操作，但是我不会
 */
public class singleNumber {
    public static void main(String[] args) {
        int[] n1 = {2,2,1};
        int[] n2 = {4,1,2,1,2};
        List<int []> intlist = new ArrayList<>();
        intlist.add(n1);
        intlist.add(n2);
        for (int i = 0; i < intlist.size(); i++) {
            System.out.println(singleNumber(intlist.get(i)));
        }
    }
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
