package jianzhiOffer.dp;

public class MaxSubArray {
    /*
    难度竟然是简单，不敢相信，
    时间复杂度是o(n)，
    之前似乎遇到过类似的，
    思路：从两端开始，寻找>=0的数，判断该片数组是否保留
         递归或者迭代，先试下递归吧
         这种思路是不行的，如[5,-3,1,-9,2,4,10],这种情况-9就得留着了，

    while循环的时候注意数组越界
    [-1]的结果是-1，
    难道要一位一位的判断吗，重新写吧
    感觉这题有点像动态规划，[-1,-2]又出错了

    [-2,1,-3,4,-1,2,1,-5,4]接着错，我不写了，看答案，动态规划
    彻底放弃，看答案
     */
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int [] nums = {1};
//        int [] nums = {0};
//        int [] nums = {-2,1};
//        int [] nums = {-1,-2};
//        int [] nums = {-1};
        int r = maxSubArray(nums);
        System.out.println(r);
    }
    public static int maxSubArray(int[] nums) {
        return maxSubArray3(nums,0,0,nums.length-1,nums.length-1);
    }

    public static int maxSubArray2(int[] nums,int left,int l,int right,int r) {
        while(left< nums.length && nums[left]<=0){
            left++;
            l++;
        }
        while(right>=0 && nums[right]<=0){
            right--;
            r--;
        }
        while(l<nums.length && nums[l] >=0)l++;
        if(l<nums.length && qsum(nums,left,l)<=0)left=l;
        while(r>=0 && nums[r] >=0)r--;
        if(r>=0 && qsum(nums,r,right)<=0) right =r;
        if(l>= r ) return qsum(nums,left,right);
        else return maxSubArray2(nums,left,l,right,r);
    }

    public static int maxSubArray3(int[] nums,int left,int l,int right,int r) {
        if(left >= right)return nums[left];
//        if(left< nums.length && nums[left]<=0){
//            left++;
//            l++;
//        }
//        if(right>=0 && nums[right]<=0){
//            right--;
//            r--;
//        }
        if(l<nums.length-1)l++; //这里的l每次移动一位，考虑到负数的情况
        if(l<nums.length && qsum(nums,left,l)<=0)left=l;
        if(r>=1)r--;
        if(r>=0 && qsum(nums,r,right)<=0) right =r;
        if(l >= r ) return qsum(nums,left,right);
//        else if(l>r)return Math.max(qsum(nums,left,l),qsum(nums,r,right));
        else return maxSubArray3(nums,left,l,right,r);
    }
    public static int qsum(int[] num,int i,int j){
        int sum = num[i];
        for (int k = i+1; k <=j ; k++) {
            sum += num[k];
        }
        return sum;
    }
}
