package easy;

public class longestCommonPrefix {
    /*
    题号14，easy,我不信
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    输入：strs = ["flower","flow","flight"]
    输出："fl"

    开始16：30
    用sb来存储变量，对每一个字符串进行遍历和判断，但不知道复杂度如何，
    两层循环，
    []出错
    时间84%，空间29%，
    结束16：39

    官方：横向扫描、纵向扫描、分治、二分查找，
    二分查找看不懂啥意思，二分查找时间会快一些，但会出错吧，就是前面有不一致的，后面的都一致，
    不会出错，从前面开始匹配，确实会快一些


    看了看自己之前的代码，还是有进步的
     */
    public static void main(String[] args) {
        String[] str1 = {"flower","flow","flight"};
        String[] str2 = {"dog","racecar","car"};
        String[][] str ={str1,str2};
        for (int i = 0; i < str.length; i++) {
            System.out.println(longestCommonPrefix(str[i]));
        }
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0)return new String();
        StringBuilder sb  = new StringBuilder();
        int index  = 0;
        char c;
        for (int i = 0; i < strs[0].length(); i++) {
            c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(index >= strs[j].length())return sb.toString();
                if(c != strs[j].charAt(index))return sb.toString();
            }
            sb.append(c);
            index++;


        }
        return sb.toString();
    }

}
