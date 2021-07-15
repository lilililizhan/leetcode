package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    /*
    采用递归的思想，每多一个数字就调用一次，在原来的列表基础上乘以3

    官方解答涉及到了回溯的算法，看不懂没细看
     */
    public static void main(String[] args) {
        List<String > s = Arrays.asList("abd","cds");
        char c ='5';
//        List<String> r =LC(s,c);
//        System.out.println(r.toString());
        String st ="2";
        List<String> r = letterCombinations(st);
        System.out.println(r.toString());

    }
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
        List<String> r =new ArrayList<>();
        if(digits.length()==0)return r;
        int index = digits.charAt(0) -'2';

        for (int i = 0; i < dict.get(index).length(); i++) {
            r.add(String.valueOf(dict.get(index).charAt(i)));
        }
        for (int i = 1; i < digits.length(); i++) {
            r = LC(r,dict,digits.charAt(i));
        }
        return r;
    }
    public static List<String> LC(List<String> list, List<String> dict, char c){
        List<String> r =new ArrayList<>();
        String s = dict.get((int)(c-'2'));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                String stemp = list.get(i);
                stemp = stemp+s.charAt(j);
                r.add(stemp);
            }
        }
        return r;
    }
}
