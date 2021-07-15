public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] str = new String[]{"flower","flow","flight"};
//        String[] str = new String[]{"cdog","cracecar","car"};
//        String[] str = new String[]{"dog","racecar","car"};
//        String[] str = new String[]{};
//        String[] str = new String[]{"aa","aa"};
//        String[] str = new String[]{"a"};
//        String[] str = new String[]{"a","b"};
        String[] str = new String[]{""};
        String r = longestCommonPrefix(str

        );
        System.out.println(r);

    }
    public static String longestCommonPrefix(String[] strs){
//        int len = strs.length;
//        定义最大匹配的索引位置
        int ind = 0;
//        确定字符串的最小长度
        if (strs.length ==0){
            return "";
        }
        int len_min =strs[0].length();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length()<len_min){
                len_min = strs[i].length();
            }
        }
//       定义变量，判断while循环的终止
        boolean b =true;
        int k =0;
        char c;
        while(b && len_min !=0 && k<len_min){
            c = strs[0].charAt(k);
            for (int i = 1; i < strs.length; i++) {
                if (c != strs[i].charAt(k)){
                    b = false;
                    break;
                }
            }
            if(b)
            {
            k = k +1;}
        }
        if(k==0){
            return "";
        }
//        else if ( k == len_min){
//            return strs[0].substring(0, k );
//        }
        else {
            return strs[0].substring(0, k );
        }
    }
}
