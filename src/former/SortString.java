import java.util.*;

public class SortString {
    public static void main(String[] args) {
        String s = "aabbbcca";
        sortString(s);
    }
    public static String sortString(String s) {
        //a97 z122
//        System.out.println('z'+1); 123
        /*思路：定义方法一：找最大值并删除，返回
        方法二：找最小值并删除，返回
        结束条件：所有字符串都被选择

        思路二：可不可以先排序并分组，依次添加直至为空
        */
        char[]  slist;
        slist = s.toCharArray();
        Arrays.sort(slist);

        Set<Character> set = new HashSet<>();
        for(int i=0;i<slist.length;i++){
            set.add(slist[i]);
        }
        System.out.println((set.size()));


//        ArrayList<List> sarr = new ArrayList[set.size()];
        //创建List数组
        List<Character> lis[]=new ArrayList[set.size()];
        //初始化list数组
        for (int i = 1; i < lis.length; i++) {
            lis[i]=new ArrayList<Character>();
        }
        System.out.println(lis[0]);
//        lis[0].add('a');
//        char start = 'A';
//        int index = -1;
////        List temp = new ArrayList<>();
//        for (int i = 0; i < slist.length; i++) {
//            if(slist[i] != start){
//                index++;
//                lis[0].add('a');
//                System.out.println("---------");
//                lis[index].add(slist[i]);
//                System.out.println(lis[index]+"--------");
////                temp.clear();
////                temp.add(slist[i]);
//                start = slist[i];
//            }
//            else {
//                lis[index].add(slist[i]);
////                temp.add(slist[i]);
//            }
//        }
//        for (int i = 0; i < lis.length; i++) {
//            System.out.println(lis[i]);
//
//        }
//        System.out.println(temp+"----------");
//        sarr.add(temp);
//        System.out.println(sarr.toString());
//
//
//        System.out.println(sarr.get(1));
//
//        for (int i = 0; i < sarr.size(); i++) {
//            System.out.println(i+":  "+ sarr.get(i));
//        }
        return null;
    }
    public static String min(char[] list){

        return null;
    }
}
