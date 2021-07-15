package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckPossibility {
    /*
    非递减数列，递增或相等，
    循环判断，改变一个后，继续判断
    改变时，改为和前一个值相等就可以了,不能和后一个相等，这样有更多需要，可以和后一个相等
    {3,4,2,3}为一个易错点，将4换为2，但此时3>2,所以正序时修改后面的，但是这样的话{4，2，3}的结果不正确，

    我觉得我需要换个思路，判断有几个拐点，{3，4，2，6}和{3，4，2，3}用拐点判断，不合理
    交换的时候保证前后是正序的即可，如{3，4，2，6}，4<6,需要对首尾特殊处理

    要考虑到两种情况，按前面的改或按后面的改，
    时间复杂度99%，空间复杂度74%
    这个题不是很简单啊

    官方解法一:首先得出结论，只能有一个nums[i]>nums[i+1],然后将其修改为前一个数或后一个数，修改后进行判断
    优化方案：首先将i修改为i+1,若不满足，则将i+1修改为i,再下一轮循环中判断是否满足，
    反正，只有两种修改方法，i改为i+1 或i+1改为i

    官方下面的那个动图解答，不是很懂
    一个简单题花了一个小时，唉
     */
    public static void main(String[] args) {
        int[] nums0 ={4,2,3};
        int[] nums1 ={4,2,1};
        int[] nums2 ={3,4,2,3};
        int[] nums3 ={3,1};
        int[] nums4 ={5,7,1,8};
        int[] nums5 ={-1,4,2,3};//true
        ArrayList<int[]> list = new ArrayList<>();
        list.add(nums0);
        list.add(nums1);
        list.add(nums2);
        list.add(nums3);
        list.add(nums4);
        list.add(nums5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i))+"  "+checkPossibility(list.get(i)));
        }
//        boolean b = checkPossibility(nums5);
//        System.out.println(b);

    }
    public static boolean checkPossibility(int[] nums) {
//        if(nums.length<3)return true;
        int k = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>nums[i+1]){
                if(i==0){
                    k++;
                    continue;
                }
                if(k !=0)return false;
                else {
                    if(nums[i]<nums[i+2] || nums[i-1]<= nums[i+1]){
                        k++;
                        continue;
                    }
                    else return false;
                }
            }
        }
        if(k!=0 && nums[nums.length-2]>nums[nums.length-1])return false;
        return true;
    }
}
