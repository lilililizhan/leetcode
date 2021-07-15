package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
//        int[] nums = {5,1,1,2,0,0};
        sortArray(nums);
        for (int s:nums
             ) {
            System.out.println(s);
        }
//        System.out.println(sortArray(nums).toString());

    }
    public static int[] sortArray(int[] nums) {
        /*
        使用冒泡排序
        即使经过优化，算法仍然超出时间限制
         */
        int temp;
        boolean b = false;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j]>nums[j+1]){
                    b= true;
                    temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            if(!b){
                break;
            }
            else {
                b = false;
            }
        }
        return nums;
    }
}
