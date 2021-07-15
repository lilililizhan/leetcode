package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class reconstructQueue {
    /*
    假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
    每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，
    其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

   输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
   输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

   从身高最高的开始排列，但是问题的关键是如何插队，参照排序算法，能不能原地修改，排序算法是int类型，不太行吧，
   （完蛋，几种经典的排序算法都不记得了）
   从第一个位置开始比较，看插入的位置是否满足，如何插入呢，，，，
   二维数组不能进行排序，
   先手动对数组进行排序，然后输出,
   或者直接对原数组原地进行排序,不太可靠，如[5,0],[7,0],[4,4],[7,1],这时插入[6,1],要在[4,4]前还是后呢，
   如果不原地修改的话，容易出错，因为要有临时变量int[],引用类型，算了多层循环，仿照冒泡排序吧,
   感觉这种想法不行啊，因为还要记录前面大于它的个数，
   我不会了，太复杂了，看答案吧，
   我太笨了好难过啊，一上午一道题没刷出来，
   答案看不懂，先跳过吧，

   答案还自己写了一个比较器，
   完全不会，看答案吧

     */
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ans =reconstructQueue3(people);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }

    }
    public static int[][] reconstructQueue(int[][] people) {
        ArrayList<int[][]> rlist = new ArrayList<>();
        int[] temp = new int[2];
        for (int i = 0; i < people.length; i++) {


        }


        return null;
    }
    public static int[][] reconstructQueue3(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                else return o2[1]-o1[1];
            }
        });
        int[][] ans = new int[people.length][];
        for (int[] person:people
             ) {
            int space = person[1]+1;
            for (int i = 0; i < people.length; i++) {
                if(ans[i]==null){
                    space--;
                    if(space==0){
                        ans[i]=person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public static int[][] reconstructQueue2(int[][] people, int[] max, int index) {
        int temp = index;
        for (int i = index; i < people.length; i++) {
            if(people[i][0]>people[temp][0]){
                temp = i;
            }
        }
        for (int i = temp; i >=0; i--) {

        }



        return null;
    }
}
