package middle;

public class FindMin {
    /*
    该题是search的基础，判断是否有序只需看是否是升序即可，不用使用(statr -middle)*(middle-end)>0进行判断
    注意：只需判断start和middle的大小，即可判断该段是否升序，因为若start<middle<end,则改数组即为有序数组，故start<middle 和middle<end必有一个不满足
     */
    public static void main(String[] args) {
//                int[] nums = new int[]{4,5,6,7,0,1,2};
//        int[] nums = new int[]{4,5,6,7,0,1,2,3};
//        int[] nums = new int[]{4,5,6,7,1,2,3};
//        int[] nums = new int[]{7,0,1,2,3,4,5,6};
//        int[] nums = new int[]{11,13,15,17};
        int[] nums = new int[]{2,3,1};
        int r = findMin(nums);
        System.out.println(r);
    }
    public static int findMin(int[] nums) {
        int start = 0;
        int end  = nums.length-1;
        int middle;
        if(nums.length ==1)return nums[0];
        if(nums.length==2)return nums[0]<nums[1]?nums[0]:nums[1];
        while(end-start>1){
            middle = (start+end)/2;
            if(nums[start]<nums[middle]){//不可能相等，因为end-start>1
                start = middle;
            }
            else end = middle;
        }
        if(end == nums.length-1 && nums[start]<nums[end])return nums[0];
        return nums[end];//注意这里，return end即可。
//        return nums[start]<=nums[end]?nums[start]:nums[end];

    }
}
