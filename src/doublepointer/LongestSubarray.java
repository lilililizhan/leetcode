package doublepointer;

public class LongestSubarray {
    /*
    不知道为什么是二分查找的标签，不懂，数组也不是有序的啊，还是需要两个指针，似乎做过类似的题
    两个指针指向头尾，标记最大值和最小值，每新加入一个数，则进行判断，
   如[8]->[8,2]，不符合，则从2重新开始,这种想法是不对的，确实做过一样思路的题，还是做错了，感觉是双指针问题

   我选择放弃了，
   不是双指针而是滑动窗口，看不懂先放弃了

   有双指针解法，但还是用到了Deque,暂时先放弃
     */
    public static void main(String[] args) {
//        int[] nums = {8,2,4,7};
//        int limit = 4;

        int[] nums = {10,1,2,4,7,2};
        int limit = 5;

        int r = longestSubarray(nums,limit);
        System.out.println(r);

    }

    //放弃
    public static int longestSubarray(int[] nums, int limit) {
        if (limit <0)return 0;
        int maxlen = 0;
        int templen =1;
        int start =0,end =0;
        int max=nums[0],min = nums[0];
        while (start < nums.length && end<nums.length){
            if(nums[end]<=max && nums[end]>=min){
                templen++;
                end++;
            }
            else {
                if(nums[end] >max) {
                    max=nums[end];
                }
                else if(nums[end]<min) {
                    min=nums[end];
                }
                if(max-min >limit){
                    templen = end-start;
                    maxlen = templen>maxlen?templen:maxlen;
                    templen=1;
                    start ++;
                    end++;
                    max = min =nums[end];
                }
            }

            end++;
        }
        return maxlen;
    }
    public static int longestSubarray2(int[] nums, int limit) {
        if (limit <0)return 0;
        int maxlen = 0;
        int templen =1;
        int start =0,end =0;
        int max=nums[0],min = nums[0];

        while (start < nums.length && end<nums.length){
            if(nums[end] >max) {
                max=nums[end];
                if(max-min >limit){
                    maxlen = templen>maxlen?templen:maxlen;
                    templen=1;
                    start = end;
                    max = min =nums[end];
                }
            }
            else if(nums[end]<min) {
                min=nums[end];
                if(max-min >limit){
                    maxlen = templen>maxlen?templen:maxlen;
                    templen=1;
                    start = end;
                    max = min =nums[end];
                }
            }
            else {
                templen++;
            }
            end++;
        }
        return maxlen;
    }


}

