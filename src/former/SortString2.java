import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortString2 {
    public static void main(String[] args) {
//        String s = "aabbbcca";
//        String s = "aaaabbbbcccc";
//        String s = "leetcode";
//        String s = "rat";
//        String s = "gggggg";
        String s = "spo";
        sortString(s);
    }

    public static String sortString(String s) {
        /*
        不会用数组及列表，换一种思路，直接求最大最小值
        最大值（数组，最大值上线)
        最小值（数组，最小值下线）
        函数前先排序
         */

        char[]  sarr;
        sarr = s.toCharArray();
        Arrays.sort(sarr);
        List<Character> slis = new ArrayList<>();
        for (int i = 0; i < sarr.length; i++) {
            slis.add(sarr[i]);
        }

//        System.out.println(slis.size());
        for (int i = 0; i < slis.size(); i++) {
            System.out.print(slis.get(i)+"  ");
        }
        System.out.println(" ");

//        System.out.println(mindelete(slis,'a'));
//        System.out.println(maxdelete(slis,'c'));

//        System.out.println(minDelete(slis));
//        System.out.println(maxDelete(slis));
        List<Character> sr = new ArrayList<>();
        while(slis.size()>0){
            sr.addAll(minDelete(slis));
            if(slis.size()>0){
                sr.addAll(maxDelete(slis));
            }
        }
//        System.out.println("---------");
        StringBuilder sb = new StringBuilder();
        System.out.println(sr.toString());
        for (int i = 0; i < sr.size(); i++) {
//            System.out.print(sr.get(i)+"  ");
            sb.append(sr.get(i));
        }
        System.out.println(sb);
//        String str = String.join( "--",(CharSequence) sr);
        return sb.toString();

    }

    public static List<Character> minDelete(List<Character> slis){
        List<Character> stemp = new ArrayList<>();
        char min = 'A';
//        stemp.add(min);
        int i = 0;
//        slis.remove(i);
        do {
            if (slis.get(i) > min) {
                min = slis.get(i);
                stemp.add(min);
                slis.remove(i);
            }
            else {
                i++;
            }
        }while(i<slis.size());
        return stemp;
    }
    public static List<Character> maxDelete(List<Character> slis){
        List<Character> stemp = new ArrayList<>();
        char min = 'A';
//        stemp.add(min);
        int i = 0;
//        slis.remove(i);
        do {
            if (slis.get(i) > min) {
                min = slis.get(i);
                stemp.add(0,min);
                slis.remove(i);
            }
            else {
                i++;
            }
        }while(i<slis.size());
        return stemp;
    }

//    public static List<Character> maxDelete(List<Character> slis){
//        List<Character> stemp = new ArrayList<>();
//        char max = slis.get(slis.size()-1);
//        stemp.add(max);
//        int i = slis.size()-1;
////        int i = -1;
////        System.out.println(slis.get(-1));
//        slis.remove(i);
//        do {
//            if (slis.get(i) < max) {
//                max = slis.get(i);
//                stemp.add(max);
//                slis.remove(i);
//            }
//            else {
//                i--;
//            }
//        }while(i>=0);
//        return stemp;
//    }
//    public static List<Character> mindelete(List<Character> slis, char min){
//        for (int i = 0; i < slis.size(); i++) {
//            if(slis.get(i)>min){
//                slis.remove(i);
//                break;
//            }
//        }
//        return slis;
//    }
//    public static List<Character> maxdelete(List<Character> slis, char max){
//        for (int i = slis.size()-1; i >= 0; i--) {
//            if(slis.get(i)<max){
//                slis.remove(i);
//                break;
//            }
//        }
//        return slis;
//    }

}
