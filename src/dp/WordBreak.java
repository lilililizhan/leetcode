package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    /*
    动态规划的middle题，
    一点也看不出来是动态规划，
    简单的匹配问题吗？
    感觉，像是会有aaa,aa,a的这种类型，先按最简单的情况来吧，
    在wordDict中遍历，对字符串进行减少，
    递归或者迭代，迭代吧，

    "cars"
    ["car","ca","rs"]问题果然出来了，需要使用递归了

    用了递归的方法，最后有一个，超出时间限制

    试一试动态规划算法,时间79%，空间67%，开心啊
    官方的解答看不懂啊
     */
    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1  = Arrays.asList(new String[]{"leet", "code"});

        String s2 = "applepenapple";
        List<String> wordDict2  = Arrays.asList(new String[]{"apple", "pen"});

        String s3 = "catsandog";
        List<String> wordDict3  = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});

        String s4 = "cars";
        List<String> wordDict4  = Arrays.asList(new String[]{"car","ca","rs"});
        ArrayList<String> slist = new ArrayList<>();
        slist.add(s1);//true
        slist.add(s2);//true
        slist.add(s3);//false
        slist.add(s4);//true
        ArrayList<List<String>>  wlist= new ArrayList<>();
        wlist.add(wordDict1);
        wlist.add(wordDict2);
        wlist.add(wordDict3);
        wlist.add(wordDict4);
        for (int i = 0; i < 4; i++) {
            System.out.println(wordBreak3(slist.get(i),wlist.get(i)));
        }
//        boolean r = wordBreak2(s4,wordDict4);
//        System.out.println(r);

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        boolean res = false;
        int len = 0;
        boolean f = true;
        while(f && sb.length() !=0) {
            f = false;
            for (int i = 0; i < wordDict.size(); i++) {
                len = wordDict.get(i).length();
                if (len <= sb.length() && sb.substring(0, len).equals(wordDict.get(i))) {
                    sb.delete(0, len);
                    f = true;
                    break;
                }
            }
        }
        return sb.length() ==0 ? true:false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        if(sb.length() ==0)return true;
        boolean res = false;
        int len = 0;
        boolean f2 = false;
        for (int i = 0; i < wordDict.size(); i++) {
            len = wordDict.get(i).length();
            if (len <= sb.length() && sb.substring(0, len).equals(wordDict.get(i))) {
                String sbtemp = new String();
                sbtemp = sb.substring(len);
                if(wordBreak2(sbtemp,wordDict)){
                    f2 = true;
                }
            }
        }

        return f2;
    }


    //使用一个数组，保存每一位的访问情况
    public static boolean wordBreak3(String s, List<String> wordDict){
        boolean[] bool = new boolean[s.length()];
        int len =0;
        String stemp;
        for (int i = -1; i < s.length(); i++) {
            if(i==-1 || bool[i] ==true){
                for (int j = 0; j < wordDict.size(); j++) {
                    stemp = wordDict.get(j);
                    len = stemp.length();
                    if(i+len < s.length() && s.substring(i+1,i+len+1).equals(stemp)){
                        bool[i+len] =true;
                    }
                }
            }

        }
        return bool[s.length()-1];
    }

}
