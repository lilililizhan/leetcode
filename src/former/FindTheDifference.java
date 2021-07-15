import java.util.Arrays;

public class FindTheDifference {
    public static void main(String[] args) {
//        String s = "abcd";
//        String t = "abcde";

//        String s = "";
//        String t = "y";

        String s = "ae";
        String t = "aea";
        char r = findTheDifference(s,t);
        System.out.println(r);

    }
    public static char findTheDifference(String s, String t) {
        /*
        字符串排序，然后一个一个对比？
            先转换为数组，然后排序
        注意原来为空的情况
         */
        if(s.length() ==0){
            return t.charAt(0);
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        boolean boo =false;
        for (int i = 0; i < sc.length; i++) {
            if(sc[i] !=tc[i]){
                boo = true;
                return tc[i];
            }
        }
        if(boo ==false){
            return tc[tc.length-1];
        }
        return 0;
    }
}
