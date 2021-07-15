import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
//        int val = 3;
//        int[] nums = {2};
//        int val = 3;

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));

    }
    public static int removeElement(int[] nums, int val) {
        /*
        数组的内容是不可修改的，对数组进行修改需要新建一个数组
        故使用集合，因包含重复元素，故选list.remove
        先对数组排序，再转为list,再删除

        对数组中的元素进行重排序
         */
        Arrays.sort(nums);
        int start = -1;
        boolean s = false;
        int end =  nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < val){
                continue;
            }
            if(nums[i] == val && (s ==false)){
                start = i;
                System.out.println("start:"+start);
                s = true;
            }
            if(nums[i]> val){
                end = i-1;
                System.out.println("end:"+end);
                break;
            }
        }
        int len =0;
        if(start == -1){
            len = nums.length;
        }
        else {
            len = end <nums.length ? nums.length -(end-start)-1:nums.length -(end-start);
        }

        int[] copy = new int[len];
        if (start ==-1){
            return nums.length;
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if(i<start){
                    copy[i] = nums[i];
                }
                else if(i >end){
                    copy[i-(end-start+1)] = nums[i];
                }
                else {
                    continue;
                }
            }
//        nums = copy.clone();
            System.out.println("------");
            for (int i = 0; i < len; i++) {
                nums[i] = copy[i];
                System.out.println(nums[i]);

            }
            System.out.println("----------");
        }

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != val){
//                list.add(nums[i]);
//                System.out.println(nums[i]);
//            }
//        }
//        nums = Arrays.asList(list);

        return copy.length;
    }
}
