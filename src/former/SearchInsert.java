public class SearchInsert {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
//        int target = 5;
//        int target = 2;
//        int target = 7;
        int target = 0;
        int r = searchInsert(nums,target);
        System.out.println(r);

    }
    public static int searchInsert(int[] nums, int target) {
        /*
        很简单，直接循环吧，想要优化的话使用一个叫二分查找之类的吧
         */
        int index =0 ;
        for (int i = 0; i < nums.length ; i++) {
            if(target >nums[i]){
                index++;
            }
            else {
                return index;
            }
        }
        return index;
    }
}
