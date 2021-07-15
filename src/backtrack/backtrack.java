package backtrack;

import java.util.*;

public class backtrack {
    /*
    回溯算法，剑指offer38,middle,
    最后得个数为n!个，元素为3的话，个数为6
    感觉也不算是回溯，个数确定，就n个数，n重循环，好吧还是挺复杂的，
    先将字符串变为数组，如何确定数组内的顺序呢，迭代中如何确保一个元素不会取两次，
    对a b c ,先取abc作为起始字符，接着对 bc  ac  ab  进行迭代的操作，但问题是要维护 bc数组，
    而且，path要进行回溯，避免对path的改变，
    同时使用一个set维护索引，并对索引进行回溯的操作，

    aab 出错，结果只有三个，将List改为set
    如果是对算法进行改进，比较难，因为不是简单的不能重复
    明明测试用例可以通过，但提交后就不通过，
    官方使用了一个swap函数，对字符的位置进行交换，且当已遍历的set中有某字符时，跳过，交换后记得交换回来，函数中用到了 index
    第二种方法和我的一样，连参数都一样，但我的就是不通过，用人家的就可以通过，时间5%，空间10%，为什么呢
    哦我把static变量放函数里就通过了，不懂

    尝试一下那种swap的算法吧,注意是对数组进行原地修改的，这个比较厉害
     */
    public static void main(String[] args) {
//        String s ="abc";
        String s ="aab";
        String[] r = permutation(s);
        System.out.println(Arrays.toString(r));
    }

    static char[] c;
//    static List<String> res = new ArrayList<>();
    static HashSet<String> res = new HashSet<>();
//    static Deque<Character> path = new ArrayDeque<>();
    static StringBuilder path = new StringBuilder();
    static Deque<Integer> index = new ArrayDeque<>();
    public static String[] permutation(String s) {
        c = s.toCharArray();
        int len = s.length();
        permutation2(len,s,res,path,index);
        return res.toArray(new String[0]);
    }
    public static void permutation2(int len,String s, HashSet<String> res, StringBuilder path, Deque<Integer> index) {
        if(path.length()== len){

//            res.add(new String(String.valueOf(path)));
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if( !index.contains(i)){
                path.append(s.charAt(i));
                index.add(i);
                permutation2(len,s,res,path,index);
                path.deleteCharAt(path.length()-1);
                index.removeLast();
            }
        }

    }

    public void permutation3(int len,int in,String s, HashSet<String> res, StringBuilder path, Deque<Integer> index) {
        if(in == len-1){

//            res.add(new String(String.valueOf(path)));
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = in; i < s.length(); i++) {
            if( !set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                swap(i,in);
                permutation3(len,in+1,s,res,path,index);
                swap(i,in);
            }
        }

    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
