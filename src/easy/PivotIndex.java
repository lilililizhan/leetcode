package easy;

public class PivotIndex {
    /*
    不像是简单的难度啊，数组的最大长度是10000，最常规的循环方法肯定不行，
    而且，相加时索引值不参与运算，所以sum/2的方法也行不通
    遍历两遍就够了，
    sumL，cur，sumR的值随着index的移动而变化，当出现sumL = sumR时即跳出

    官方的解题思路更好，sumL*2+cur = sum，代码阅读起来更清晰
     */
    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, 2,3};
//        int[] nums = {2,1,-1};
        int[] nums = {0, 0, 0, 0, 1};
        int r = pivotIndex(nums);
        System.out.println(r);

    }
    public static int pivotIndex(int[] nums) {
        if(nums.length==0)return -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int index = -1;
        int sumL = 0;
//        int cur = 0;
        int sumR  = sum-nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if(sumL == sumR)
            {
                index = i;
                break;
            }
            else {
                sumL += nums[i];
                sumR -= nums[i+1];
            }
        }
        if(index==-1){
            if(sum-nums[nums.length-1]==0)index=nums.length-1;
        }
        return index;

    }
}
