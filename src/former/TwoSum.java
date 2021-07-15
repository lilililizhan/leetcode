import java.util.MissingFormatArgumentException;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] r =twoSum(nums,target);
//        System.out.println(r);
//        System.out.println(twoSum(nums,target));
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);

        }

    }
    public static int[] twoSum(int[] nums, int target){
        int start =0;
        int end = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (end !=0){
                break;
            }
            for (int j = i+1; j < nums.length; j++){
                if ((nums[i]+nums[j]) == target){
                    start = i;
                    end = j;
                    break;
                }
            }
        }
        return new int[]{start, end};
//        int[] arr = new int[]{start,end};
//        return arr;
    }
}
