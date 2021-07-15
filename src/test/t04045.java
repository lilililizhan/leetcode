package test;

public class t04045 {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};

    }
    public static  int max(int[] num){
        int maxtemp = 0;
        int sumtemp  =0;
        for (int i = 0; i < num.length; i++) {
            sumtemp += num[i];
            maxtemp = Math.max(maxtemp,sumtemp);
        }
        return maxtemp;
    }
}
