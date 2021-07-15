package jianzhiOffer.easy;

import java.util.ArrayList;

public class LastRemaining {
    /*
    while循环
    取模操作
    涉及到数组元素的删除，arraylist

    时间5%，空间16%

    官方并没有把它当作环的问题：
    首先，长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列。
    那么，我们可以递归地求解 f(n - 1, m)，就可以知道对于剩下的 n - 1 个元素，最终会留下第几个元素，
    我们设答案为 x = f(n - 1, m)。
    由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。
    当我们知道了 f(n - 1, m) 对应的答案 x 之后，我们也就可以知道，
    长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。
    因此有 f(n, m) = (m % n + x) % n = (m + x) % n。

   相当于f(n-1,m)先移动了m%n？？？？？？不懂
     */
    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
        System.out.println(lastRemaining(10,17));

    }
    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num.add(i);
        }
        int temp = -1;
        while (num.size()>1){
            temp = (temp+m)%num.size();
//            System.out.println(num.get(temp));
            num.remove(temp);
            temp--;
        }
        return num.get(0);
    }
}
