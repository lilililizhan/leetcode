package greedy;

public class canJump {
    /*
    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

    top100,第55题，难度middle,贪心算法，

    可以用dp吗？由于该题只限制了最长步数，只要不含0，就一定能跳到，0是做最后一个的话，也没问题，
    问题转化为能不能跳过0，要看0(i)和j，位置，i-j<[j]即可，
    这也不是贪心算法啊，又不是尽可能的往前跑，啊不对，就是尽可能的往前跑，
    还是贪心算法

     [2,5,0,0]出错，可以到0的时候向后退，但什么时候是头呢，陷入死循环，比如[2,1,0,0]
     尝试一下最初的想法,这样也不对，如果有多个0，也不需要每个0都访问到，
     难道只能用dp吗???
     感觉只需要记住每次的最大位置就可以了，每次更新最大位置，对对关键点在这里，
     [0]，返回true
     时间22%，空间27%，感觉这个想法很nice了，咋还这么低呢，
     官方想法一致啊，咋就83%，空间44%，详见方法5
     */
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};//true
//        int[] nums = {3, 2, 1, 0, 4};//false
//        int[] nums = {2,5,0,0};//true
        int[] nums = {0};//true
        boolean r = canJump4(nums);
        System.out.println(r);

    }

    public static boolean canJump(int[] nums) {
        int index = 0;
        while (index < nums.length - 1) {
            index += nums[index];
            if (index < nums.length - 1 && nums[index] == 0) {
                return false;
            }

        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) continue;
            else if (nums[i] == 0) {
                int j = i;
                boolean btemp = false;
                while (j >= 0) {
                    if (nums[j] > (i - j)) {
                        btemp = true;
                        break;
                    }
                }
                if (!btemp) return false;
            }
        }
        return true;
    }

    public static boolean canJump4(int[] nums) {
        if(nums[0]==0 && nums.length>1)return false;
        int maxindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxindex >= i){
                if(i+nums[i]>=nums.length)return true;
                else maxindex = Math.max(maxindex,i+nums[i]);
            }
            else return false;
        }
        return true;
    }
//官方解法，不明白差性能在那里，我感觉我能更快跳出循环，不懂
    public boolean canJump5(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
