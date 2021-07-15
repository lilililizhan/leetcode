public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7}; //49
//        int[] height = {4,3,2,1,4};  //16
//        int[] height = {1,2,1};  //2
        int area =maxArea(height);
        System.out.println(area);
    }

    public static int maxArea(int[] height) {
        /*
        实际上是一个两数相乘的结果，高度和宽度
        最笨的方法：遍历
            宽度为两个之间的距离
            高度为两个值之间的较小值
        优化：首先固定第一个数start，第二个数依次往后
                首先找到剩余数中最大的值，计算容量
                    数组很难找最大值，所以end在后移时，判断与下一个值的大小，小于下一个值，直接后移
                    若最大值小于等于start的值，
                    若最大值大于sart的值，
                接着计算最大值后面的并比较
             在进行start循环时，若新的小于等于前一个，则直接跳过
         */
        int area =0;
        int w = 0 ;
        int h = 0;
        for (int i = 0; i < height.length-1; i++) {
            if(i>0){
                if(height[i]<=height[i-1]){
                    continue;
                }
            }
            for (int j = i+1; j < height.length; j++) {
                if(j <height.length-1){
                    if(height[j]<=height[j+1]){
                        continue;
                    }
                }
                w = j-i;
                h =Math.min(height[i],height[j]);
                if(w*h>area){
                    area = w*h;
                }
            }
        }
        return area;
    }

    public static int maxArea2(int[] height) {
        int area =0;
        int w = 0 ;
        int h = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                w = j-i;
                h =Math.min(height[i],height[j]);
                if(w*h>area){
                    area = w*h;
                }
            }
        }
        return area;
    }


}
