package test;

import java.util.*;

public class t0404 {
    /*
    美团，
     */
    public static void main(String[] args) {
        String s = "aabc";
        char[] str = s.toCharArray();
        List<ArrayList<Character>> ans  = subsets(str);
        System.out.println(ans);

    }
    static List<Character> t = new ArrayList<>();
    static List<ArrayList<Character>> ans = new ArrayList<>();

    public static List<ArrayList<Character>> subsets(char[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, char[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Character>(t));
            return;
        }

        if(! t.contains(nums[cur])) {
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
        else {
//            dfs(cur + 1, nums);
//            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }

    }

    public static int count(int[] f){
        int x = 1;//横着有几份
        int y = 1;//竖着有几份
        int num = 1;
        //t = 0,横着切，t =1,竖着切
        for (int i = 0; i < f.length; i++) {
            if(f[i] ==0){
                x++;
                num += y;
            }
            else {
                y++;
                num +=x;
            }
        }

        return num;
    }

}