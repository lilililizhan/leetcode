package sort;

public class SelectSort {
    public static void main(String[] args) {
//        int[] nums = {5,2,3,1};
        int[] nums = {5,1,1,2,0,0};
        selectSort(nums);
        for (int s:nums
        ) {
            System.out.println(s);
        }
//        System.out.println(sortArray(nums).toString());

    }
    public static int[] selectSort(int[] nums){
        /*
        使用选择排序
        使用冒泡排序时间复杂度过高，使用选择排序竟然通过了
         */
        int minindex;
        int min;
        int temp;
        for (int i = 0; i < nums.length-1; i++) {
            minindex = i;
            min = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<min){
                    minindex = j;
                    min = nums[j];
                }
            }
            if(minindex!=i){
                temp = nums[i];
                nums[i]=min;
                nums[minindex]=temp;
            }
        }
        return nums;

    }
}

