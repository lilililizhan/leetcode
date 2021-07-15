package sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
//        int[] nums = {5, 1, 1, 2, 0, 0};
        insertSort(nums);
        for (int s : nums
        ) {
            System.out.println(s);
        }
//        System.out.println(sortArray(nums).toString());

    }

    public static int[] insertSort(int[] nums) {
        /*
        使用选择排序
        使用冒泡排序时间复杂度过高，使用选择排序竟然通过了
        注意插入排序，单层的while循环就够了，插入的时候从后往前判断
         */
        int temp;//存储临时变量
        int tvalue;
//        for (int i = 1; i < nums.length; i++) {//i为顺序确定的下界
//            tvalue = nums[i];
//            for (int j = 0; j < i + 1; j++) {
//                if (tvalue>= nums[j]){
//                    continue;
//                }
//                else {
//                    temp = nums[j];
//                    nums[j] = tvalue;
//                    tvalue = temp;
//                    nums[i] = temp;
//                }
//            }
//        }
//        for (int i = 1; i < nums.length; i++) {//i为顺序确定的下界
//            tvalue = nums[i];
//            for (int j = i-1; j >=0; j--) {
//                if (tvalue< nums[j]) {
//                    nums[j+1] = nums[j];
//                    if(j ==0) {
//                        nums[j] = tvalue;
//                    }
//                }
//                else {
//                    nums[j+1]=tvalue;
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            int index = i-1;
            int value = nums[i];
            while (index>=0 && nums[index]>value){
                nums[index+1] = nums[index];
                index--;
            }
            if(index+1 != i){
                nums[index+1] = value;
            }
        }
        return nums;
    }
}
