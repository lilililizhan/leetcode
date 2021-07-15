public class Search {
    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int num =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<target){
                continue;
            }
            else if(nums[i]==target){
                num++;
            }
            else {
                break;
            }
        }
        return num;
    }
}
