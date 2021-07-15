package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

//这道题没有完全解决
public class leastInterval {
/*
    给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
    任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
    然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

    你需要计算完成所有任务所需要的 最短时间 。
    输入：tasks = ["A","A","A","B","B","B"], n = 2
    输出：8
    解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
         在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。

    完全没有做过类似的题，
    首先执行数量最多的类型，其次执行数量第二多的类型，并判断是否可以执行，
    对每一个类型，要存储当前数量及冷却时间，使用Map<char,int[]>来存储，
    要及时对map中的数据进行修改

    使用map太复杂了，使用两个数组吧，一个保存个数，一个保存冷却时间，数组的长度为26，单26好像也太长了，
    时间5%，空间69%，数组一点也不方便，还是用map吧
    用map一直出错，官方的解答一是一样的思路，但代码没看懂，解答二是直接套用公式



 */
    public static void main(String[] args) {
//        char[] tasks = {'A','A','A','B','B','B','B'};//10
//        char[] tasks = {'A','A','A','B','B','B'};//8
////        char[] tasks = {'A','A','B','B','B'};//7
//        int n = 2;

        char[] tasks = {'A','A','A','B','B','B'};//6
//        int n = 0;

//        char[] tasks ={'A','A','A','A','A','A','B','C','D','E','F','G'};//16
//        char[] tasks ={'A','B','A'};//4
        int  n = 2;

        int r = leastInterval0(tasks,n);
        System.out.println(r);

    }

    public static int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);
        ArrayList<Integer> numlist = new ArrayList<>();
        ArrayList<Integer> timelist = new ArrayList<>();
        char c = tasks[0];
        int num =1;
        for (int i = 1; i < tasks.length; i++) {
            if(tasks[i]==c)num++;
            else{
                numlist.add(num);
                timelist.add(0);
                c = tasks[i];
                num =1;
            }
        }
        numlist.add(num);
        timelist.add(0);
        int timesum = 0;
        int index = -1;
        int maxnum = numlist.get(0);
        int m = 0;
        while(maxnum !=0){
            //以下是一轮操作
            maxnum = -1;
            index = -1;
            m=0;
            for (int i = 0; i < numlist.size(); i++) {
                m = Math.max(m,numlist.get(i));
            }
            if(m==0)break;
            for (int i = 0; i < numlist.size(); i++) {
                if(timelist.get(i) ==0 && numlist.get(i)>maxnum && numlist.get(i)>0){
                    index = i;
                    maxnum = numlist.get(i);
                }
            }
            for (int i = 0; i < numlist.size(); i++) {
                if(i == index){
                    timelist.set(i,n);
                    numlist.set(i,numlist.get(i)-1);
                }
                else timelist.set(i,timelist.get(i)==0 ? 0:timelist.get(i)-1);
            }
            timesum++;
        }
//        System.out.println(numlist);
//        System.out.println(timelist);

        return timesum;
    }
    public static int leastInterval0(char[] tasks, int n) {
        Arrays.sort(tasks);
        HashMap<Character,int[]> map = new HashMap();
        int[] temp = new int[2];
        for (int i = 0; i < tasks.length; i++) {
            if(map.containsKey(tasks[i])){
                temp  = map.get(tasks[i]);
                temp[0] +=1;
                map.put(tasks[i],temp);
            }
            else {
                temp = new int[2];
                temp[0] =1;
                map.put(tasks[i],temp);
            }
        }
        int time = 0;
        char chartemp = ' ';
        int maxn  = 0;
        while (!map.isEmpty()){
            maxn =-1;
            for (char key: map.keySet()
                 ) {

                if( map.get(key)[1]==0  && map.get(key)[0]>maxn){
                    maxn = map.get(key)[0];
                    chartemp = key;
                }

            }
            Iterator it = map.keySet().iterator();
            for (char key: map.keySet()
                 ) {
                if(key == chartemp)map.put(key,new int[]{map.get(key)[0]-1,n});
                else map.put(key,new int[]{map.get(key)[0],map.get(key)[1]>0 ? map.get(key)[1]-1 : 0});
                if(map.get(key)[0]==0){
//                    map.remove(key);
                    map.keySet().remove(key);
                }

            }
            time++;

        }
//        for (Character key: map.keySet()
//             ) {
//            System.out.println(Arrays.toString(map.get(key)));
//        }
//        System.out.println(map);

        return time;
    }
}
