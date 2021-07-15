public class MinNumber {
    public static void main(String[] args) {
//        int[] nums = {10,2};
//        int[] nums = {3,30,34,5,9};
        int[] nums = {999999998,999999997,999999999};
//        System.out.println(compare(3,30));
        System.out.println(minNumber(nums));

    }
    public static String minNumber(int[] nums) {
        /*
        最初的想法是一步一步比较第一位，第二位的大小，
        后面想，使用插入排序的思想，但排序的规则自己定
        排序规则：ab>ba,则b放a前面，如330>303
         */
        int index;
        int value;
        for (int i = 1; i < nums.length; i++) {
            index = i-1;
            value = nums[i];
            while (index>=0 && compare(value,nums[index])){
                nums[index+1] = nums[index];
                index--;
            }
            if(index+1 != i){
                nums[index+1]=value;
            }
        }
        String r ="";
        for (int i:nums
             ) {
            r = r+i;
            System.out.println(i);

        }
        return r;

    }
    public static boolean compare(int a, int b){
        String s1 = a+""+b;
        String s2 = b+""+a;
//        System.out.println(s1);
        long i1 = Long.parseLong(s1);
        long i2 = Long.parseLong(s2);
//        long i1 = Integer.parseInt(s1);
//        long i2 = Integer.parseInt(s2);
        if(i1<=i2){
            return true;
        }
        else {
            return false;
        }
    }
}
