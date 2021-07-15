package backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {
    /*
    第3题，middle，感觉像是动态规划
    有点印象，好像是什么KMP算法之类的

    第986/987出错，测试用例很长

    官方使用滑动窗口，通过hashset来保存是否有重复元素，
    那我可以用hsahMap来保存字符的位置，
    滑动窗口可以在一个循环内一直滑动


    修改后，依然是986/987出错

    感觉方法二和官方的方法三没差太多，时间复杂度都是1，难道是因为map的复杂度比较高吗
    方法二和方法三没差啊，
     */
    public static void main(String[] args) {
        String[] strs = {"abcabcbb","bbbbb","pwwkew","","au","dvdf","nfpdmpi","abba"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]+"   "+lengthOfLongestSubstring3(strs[i]));
        }
//        System.out.println(strs[7]+"   "+lengthOfLongestSubstring2(strs[7]));

    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)return s.length();
        int[][] dp  = new int[s.length()][s.length()];
        int maxlen = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] =1;
        }
        int i = 0;
        int j =1;
        while(i<s.length()){
            while (j<s.length()){
                int index = s.substring(i,j).indexOf(s.charAt(j)+"");
                if(index ==-1){
                    dp[i][j] = dp[i][j-1]+1;
                    maxlen = Math.max(dp[i][j],maxlen);
                    j++;
                }
                else {
                    i = index+i+1;
                    dp[i][j] = j-i+1;
                    maxlen = Math.max(dp[i][j],maxlen);
                    j++;
                    i--;
                    break;
                }
                if(j==s.length())return Math.max(dp[i][j-1],maxlen);
            }
            i++;
        }

        return maxlen;
    }

    public static int lengthOfLongestSubstring2(String s){
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxlen =0;
        while(i<s.length()){
            while(j<s.length()){
                int index = map.getOrDefault(s.charAt(j),-1);
                if(index ==-1){
                    map.put(s.charAt(j),j);
                }
                else {
                    maxlen = Math.max(maxlen,j-i);
                    for (int k = i; k < index; k++) {
                        map.put(s.charAt(k),-1);
                    }
                    i = index+1;
                    map.put(s.charAt(j),j);
                }
                j++;
            }
            maxlen = Math.max(maxlen,j-i);
            i++;

        }
        return maxlen;
    }
    public static int lengthOfLongestSubstring3(String s){
        Set<Character> set = new HashSet<>();
        int maxlen =0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i !=0){
                set.remove(s.charAt(i-1));
            }
            while(j<s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            maxlen = Math.max(maxlen,j-i);
        }
        return maxlen;
    }

    public int lengthOfLongestSubstring4(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

}
