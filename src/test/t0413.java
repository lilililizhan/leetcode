package test;

import java.util.ArrayList;
import java.util.Collections;

public class t0413 {
    /*
    堆积木，积木上层的长和宽需要大于下层，给出一个二维数组[[1,2], [3,4],[5,6],[7,8]],
    问最高能搭多少层

    找最大值吗？每次找到之后要移出，
    分别记下长的最大值，编号，宽的最大值，编号
    不能继续搭建的条件是，长和宽的最大值不是同一个，如果这种情况，则找较小的积木，
    可不可以直接对二维的进行操作呢，不分成一维的，算了,
    循环的次数有点多啊，

    是否应该从较小值开始判断？？但应该是一样情况吧

     */
    public static void main(String[] args) {

    }
    public static int t(int[][] size){
        ArrayList<int[]> si = new ArrayList<>();
        for (int i = 0; i < size.length; i++) {
            si.add(size[i]);
        }
        int height = 0;
        boolean flag  =true;
        int lmax;
        int wmax;
        int lindex;
        int windex;
        while(si.size()!=0) {
            //每次循环初始化
            //这里应该要保
            lmax = 0;
            wmax = 0;
            lindex = 0;
            windex = 0;
            for (int i = 0; i < si.size(); i++) {
                lmax = lmax>si.get(i)[0] ? lmax:si.get(i)[0];
                lindex = lmax>si.get(i)[0] ? lindex:i;
                wmax = wmax>si.get(i)[1] ? wmax :si.get(i)[1];
                windex = wmax>si.get(i)[1] ? windex :i;
            }
            if(lindex == windex){
                si.remove(lindex);
                height++;
            }
            //长和宽最大不一致的情况，两个不能共存，取一个，取哪个？？，先随机
            else {

            }
        }

        return height;
    }
}
