public class SearchRange {
    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
//        int target =8;

//        int[] nums = {5,7,7,8,8,10};
//        int target =6;

        int[] nums = {};
        int target =0;
        searchRange(nums,target);

    }
    public static int[] searchRange(int[] nums, int target) {
        /*
        基础实现：直接循环进行判断
        其他：是否可以直接通过查找
         */
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if(start ==-1 && nums[i]==target){
                start = i;
            }
            if(nums[i] ==target){
                end =i;
            }
        }
        int[] index= {start,end};
        System.out.println(start+"---"+end);
        return index;

    }
}
