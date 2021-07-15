package jianzhiOffer.easy;

public class MinArray {
    /*
    又是一个做过的题,
    找到拐点值，二分查找法
    不同的是，允许有相同数字
    还会有{1，3，5}的情况，先判断是否正序
    还会有{3，3，1，3}的情况，这个没法判断是否是正序了
    直接暴力排序，返回n[0],时间25%，空间31%
    考虑一下{3，3，1，3}如何处理，
    还有{1，3，3}，这次真的不知道如何处理了

    还是没有记住二分查找应该怎么做，
     */
    public static void main(String[] args) {
//        int[] numbers = {3,4,5,1,2};
//        int[] numbers = {2,2,2,0,1};
//        int[] numbers = {1,3,5};
        int[] numbers = {3,3,1,3};
        int r = minArray(numbers);
        System.out.println(r);

    }
    public static int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length-1;
        int middle;
        if (numbers[start] <= numbers[(start+end)/2] && numbers[(start+end)/2]< numbers[end])return numbers[start];
        while (start < end-1){
            middle = (start+end)/2;
            if(numbers[start]<=numbers[(start+middle)/2] && numbers[(start+middle)/2]<=numbers[middle]){
                start = middle;
            }//当(start+middle)/2 == start时，start+1 = middle,+1=end,
            else end = middle;
        }
        return numbers[start]<numbers[end]?numbers[start]:numbers[end];

    }
}
